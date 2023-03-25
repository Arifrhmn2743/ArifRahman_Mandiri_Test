package com.example.arifrahman_mandiri_test_movie_app.movieList

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {  @GET("discover/movie")
fun getPopularMovies(
    @Query("api_key") apiKey: String = "65bb2a8516d1b49ea33a97dfbe4cef41",
    @Query("page") page: Int,
    @Query("with_genres") with_genres: Int
): Call<GetMovieResponse>
}