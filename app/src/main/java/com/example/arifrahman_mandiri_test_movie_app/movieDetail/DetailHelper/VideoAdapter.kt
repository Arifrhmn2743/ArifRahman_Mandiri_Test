package com.example.arifrahman_mandiri_test_movie_app.movieDetail.DetailHelper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.arifrahman_mandiri_test_movie_app.R
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView


class VideoAdapter (
    private var trailer:List<MovieTrailer>
        ):RecyclerView.Adapter<VideoAdapter.VideoViewHolder>()
{
    class VideoViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val video:YouTubePlayerView=itemView.findViewById(R.id.videoView2)
        fun bind(movieTrailer: MovieTrailer) {
            video.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = movieTrailer.key
                    youTubePlayer.cueVideo(videoId,0f)
                }
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view =LayoutInflater
            .from(parent.context)
            .inflate(R.layout.video_item,parent,false)
        return VideoViewHolder(view)
    }

    override fun getItemCount(): Int =trailer.size

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(trailer[position])
    }
fun updateVideo(trailer: List<MovieTrailer>){
        this.trailer=trailer
    notifyDataSetChanged()
}

}