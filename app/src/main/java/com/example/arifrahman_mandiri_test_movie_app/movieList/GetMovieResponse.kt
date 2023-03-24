package com.example.arifrahman_mandiri_test_movie_app.movieList

import com.google.gson.annotations.SerializedName

data class GetMovieResponse(@SerializedName("page") val page: Int,
                            @SerializedName("results") val movies: List<Movie>,
                            @SerializedName("total_pages") val pages: Int)
