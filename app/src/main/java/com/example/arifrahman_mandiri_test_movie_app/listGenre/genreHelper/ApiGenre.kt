package com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiGenre {
    @GET("/genre/movie/list")
    fun getGenre(
        @Query("api_key") apiKey: String = "65bb2a8516d1b49ea33a97dfbe4cef41",
        @Query("language") lang: String = "en-US"
    ): Call<GetGenreResponse>
}