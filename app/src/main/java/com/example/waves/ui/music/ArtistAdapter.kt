package com.example.waves.ui.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waves.R
import com.example.waves.model.music.artists.Artist

class ArtistAdapter (private val artists: List<Artist>) : RecyclerView.Adapter<ArtistAdapter.RecyclerHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerHolder {
        return RecyclerHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_artists_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.setArtist(artists[position])
    }

    override fun getItemCount() = artists.size

    class RecyclerHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun setArtist(artist: Artist){
            view.findViewById<AppCompatTextView>(R.id.textView).text = artist.name
            Glide.with(view.context).load(artist.image.last().text).into(view.findViewById(R.id.imageView))
        }
    }
}