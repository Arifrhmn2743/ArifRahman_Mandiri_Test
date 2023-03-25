package com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper

import com.google.gson.annotations.SerializedName

data class GetGenreResponse(
    @SerializedName("genres") val genres: List<Genre>,
)
