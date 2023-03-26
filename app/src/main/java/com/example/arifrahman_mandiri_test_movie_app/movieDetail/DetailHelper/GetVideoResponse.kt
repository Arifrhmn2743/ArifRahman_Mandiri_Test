package com.example.arifrahman_mandiri_test_movie_app.movieDetail.DetailHelper

import com.google.gson.annotations.SerializedName

data class GetVideoResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("results") val results: List<MovieTrailer>
)
