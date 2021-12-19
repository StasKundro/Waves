package com.example.waves.ui.music

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.waves.R
import com.example.waves.model.album.Album

class AlbumAdapter(private val albums: MutableList<Album>): RecyclerView.Adapter<AlbumAdapter.RecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_albums_item, parent, false)
        return RecyclerHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerHolder, position: Int) {
        holder.setAlbum(albums[position])
    }

    override fun getItemCount() = albums.size


    class RecyclerHolder(private val view: View): RecyclerView.ViewHolder(view){
        fun setAlbum(album: Album){
            view.findViewById<AppCompatTextView>(R.id.textView).text = album.name
            Glide.with(view.context).load(album.imageUrl).into(view.findViewById(R.id.imageView))
        }
    }
}