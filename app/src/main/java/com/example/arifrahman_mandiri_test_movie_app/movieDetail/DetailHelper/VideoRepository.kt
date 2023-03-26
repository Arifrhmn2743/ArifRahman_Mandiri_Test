package com.example.arifrahman_mandiri_test_movie_app.movieDetail.DetailHelper

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object VideoRepository {
    private val apiVideo:ApiVideo

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiVideo = retrofit.create(ApiVideo::class.java)
    }

    fun getVideoTrailer(
        movieId: Int, language: String,
        onSuccess: (movies: List<MovieTrailer>) -> Unit,
        onError: () -> Unit
    ){
       apiVideo.getVideo(movieId=movieId).enqueue(object :  Callback<GetVideoResponse>{
           override fun onResponse(
               call: Call<GetVideoResponse>,
               response: Response<GetVideoResponse>
           ) {
               if (response.isSuccessful){
                   val responseBody = response.body()
                   if (responseBody!=null){
                       onSuccess.invoke(responseBody.results)
                   }else{
                       onError.invoke()
                   }
               }else{
                   onError.invoke()
               }
           }

           override fun onFailure(call: Call<GetVideoResponse>, t: Throwable) {
              onError.invoke()
           }

       })

    }
}