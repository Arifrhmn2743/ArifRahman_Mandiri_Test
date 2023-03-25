package com.example.arifrahman_mandiri_test_movie_app.listGenre.genreHelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.arifrahman_mandiri_test_movie_app.R


class GenreAdapter (
    private var genre: List<Genre>
) : RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.genre_item, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
      holder.movieName.text=genre.get(position).name
    }

    override fun getItemCount(): Int = genre.size



    fun updateGenre(genre: List<Genre>) {
        this.genre = genre
        notifyDataSetChanged()
    }

    inner class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val movieName: TextView = itemView.findViewById(R.id.genre_tv)



    }
}