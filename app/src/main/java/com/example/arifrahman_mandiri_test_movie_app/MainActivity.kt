package com.example.arifrahman_mandiri_test_movie_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper.Genre
import com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper.GenreAdapter
import com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper.GenreRepository
import com.example.arifrahman_mandiri_test_movie_app.movieDetail.*
import com.example.arifrahman_mandiri_test_movie_app.movieList.Movie
import com.example.arifrahman_mandiri_test_movie_app.movieList.MoviesAdapter
import com.example.arifrahman_mandiri_test_movie_app.movieList.MoviesRepository

class MainActivity : AppCompatActivity() {
    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    private lateinit var popularMoviesLayoutMgr: LinearLayoutManager
    private var popularMoviesPage = 1
    private lateinit var genreMovies: RecyclerView
    private lateinit var genreAdapter: GenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        popularMovies = findViewById(R.id.popular_movies)


        popularMoviesLayoutMgr = LinearLayoutManager(
            this,
            LinearLayoutManager.HORIZONTAL,
            false
        )
        popularMovies.layoutManager = popularMoviesLayoutMgr
//        genreMovies = findViewById(R.id.list_genre)
//        genreMovies.layoutManager = LinearLayoutManager(
//            this,
//            LinearLayoutManager.VERTICAL,
//            false
//        )
//        genreAdapter= GenreAdapter(listOf())
//        genreMovies.adapter=genreAdapter

        popularMoviesAdapter = MoviesAdapter(mutableListOf()) { movie -> showMovieDetails(movie) }
        popularMovies.adapter = popularMoviesAdapter

        getPopularMovies()

        MoviesRepository.getPopularMovies(onError = ::onError, onSuccess = ::onPopularMoviesFetched)
//        GenreRepository.getGenre(onError = ::onError, onSuccess = ::onGenreMoviesFetched)
    }

    private fun onPopularMoviesFetched(list: List<Movie>) {
        popularMoviesAdapter.appendMovies(list)
        attachPopularMoviesOnScrollListener()
    }

    private fun attachPopularMoviesOnScrollListener() {
        popularMovies.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = popularMoviesLayoutMgr.itemCount
                18
                val visibleItemCount = popularMoviesLayoutMgr.childCount
                val firstVisibleItem = popularMoviesLayoutMgr.findFirstVisibleItemPosition()
                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    popularMovies.removeOnScrollListener(this)
                    popularMoviesPage++
                    getPopularMovies()
                } }
        }) }
//    private fun onGenreMoviesFetched(list: List<Genre>) {
//        genreAdapter.updateGenre(list)
//
//    }

    private fun getPopularMovies() {
        MoviesRepository.getPopularMovies(
            popularMoviesPage,
            ::onPopularMoviesFetched,
            ::onError
        ) }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
    }

    private fun showMovieDetails(movie: Movie) {
        val intent = Intent(this, MovieDetails::class.java)
        intent.putExtra(MOVIE_BACKDROP, movie.backdropPath)
        intent.putExtra(MOVIE_POSTER, movie.posterPath)
        intent.putExtra(MOVIE_TITLE, movie.title)
        intent.putExtra(MOVIE_RATING, movie.rating)
        intent.putExtra(MOVIE_RELEASE_DATE, movie.releaseDate)
        intent.putExtra(MOVIE_OVERVIEW, movie.overview)
        startActivity(intent)
    }
}