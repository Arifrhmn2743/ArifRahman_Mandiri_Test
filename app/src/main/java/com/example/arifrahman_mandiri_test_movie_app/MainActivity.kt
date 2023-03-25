package com.example.arifrahman_mandiri_test_movie_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper.Genre
import com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper.GenreAdapter
import com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper.GenreRepository
import com.example.arifrahman_mandiri_test_movie_app.movieList.Movie
import com.example.arifrahman_mandiri_test_movie_app.movieList.MoviesAdapter
import com.example.arifrahman_mandiri_test_movie_app.movieList.MoviesRepository

class MainActivity : AppCompatActivity() {
    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter
    private lateinit var genreMovies: RecyclerView
    private lateinit var genreAdapter: GenreAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        popularMovies = findViewById(R.id.popular_movies)
        popularMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
//        genreMovies = findViewById(R.id.list_genre)
//        genreMovies.layoutManager = LinearLayoutManager(
//            this,
//            LinearLayoutManager.VERTICAL,
//            false
//        )
//        genreAdapter= GenreAdapter(listOf())
//        genreMovies.adapter=genreAdapter
        popularMoviesAdapter = MoviesAdapter(listOf())
        popularMovies.adapter = popularMoviesAdapter

        MoviesRepository.getPopularMovies(onError = ::onError, onSuccess = ::onPopularMoviesFetched)
//        GenreRepository.getGenre(onError = ::onError, onSuccess = ::onGenreMoviesFetched)
    }

    private fun onPopularMoviesFetched(list: List<Movie>) {
        popularMoviesAdapter.updateMovies(list)

    }
//    private fun onGenreMoviesFetched(list: List<Genre>) {
//        genreAdapter.updateGenre(list)
//
//    }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
    }
}