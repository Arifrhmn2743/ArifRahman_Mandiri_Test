package com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
)
