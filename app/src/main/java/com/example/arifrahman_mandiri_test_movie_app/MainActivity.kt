package com.example.arifrahman_mandiri_test_movie_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.arifrahman_mandiri_test_movie_app.movieList.Movie
import com.example.arifrahman_mandiri_test_movie_app.movieList.MoviesAdapter
import com.example.arifrahman_mandiri_test_movie_app.movieList.MoviesRepository

class MainActivity : AppCompatActivity() {
    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMoviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        popularMovies = findViewById(R.id.popular_movies)
        popularMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
        popularMoviesAdapter = MoviesAdapter(listOf())
        popularMovies.adapter = popularMoviesAdapter

        MoviesRepository.getPopularMovies(onError = ::onError, onSuccess = ::onPopularMoviesFetched)
    }

    private fun onPopularMoviesFetched(list: List<Movie>) {
        popularMoviesAdapter.updateMovies(list)

    }

    private fun onError() {
        Toast.makeText(this, getString(R.string.error_fetch_movies), Toast.LENGTH_SHORT).show()
    }
}