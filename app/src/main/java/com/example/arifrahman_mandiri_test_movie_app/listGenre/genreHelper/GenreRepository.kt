package com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper


import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object GenreRepository {

    private val api: ApiGenre


    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiGenre::class.java)
    }
    fun getGenre(onSuccess: (genre: List<Genre>) -> Unit,
                 onError: () -> Unit){

        api.getGenre()
            .enqueue(object :Callback<GetGenreResponse>{

                override fun onResponse(
                    call: Call<GetGenreResponse>,
                    response: Response<GetGenreResponse>

                ) {

                    if (response.isSuccessful) {
                        val responseBody = response.body()

                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.genres)
                            Log.d("Repository", "genre: ${responseBody.genres}")
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                        Log.e("Repository", "onFailure")
                    }
                }

                override fun onFailure(call: Call<GetGenreResponse>, t: Throwable) {
                    Log.e("Repository", "onFailure", t)
                }
            })
    }
}