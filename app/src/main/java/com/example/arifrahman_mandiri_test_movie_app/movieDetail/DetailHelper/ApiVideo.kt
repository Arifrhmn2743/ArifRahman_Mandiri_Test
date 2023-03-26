package com.example.arifrahman_mandiri_test_movie_app.movieDetail.DetailHelper

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiVideo {
    @GET("movie/{movie_id}/videos")
    fun getVideo(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = "65bb2a8516d1b49ea33a97dfbe4cef41",
        @Query("language") language: String="en-US"
    ): Call<GetVideoResponse>

}