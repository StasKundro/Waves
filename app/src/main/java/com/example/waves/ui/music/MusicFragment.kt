package com.example.waves.ui.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.waves.R
import com.example.waves.model.album.Album
import kotlinx.android.synthetic.main.fragment_music.view_albums

class MusicFragment: Fragment() {
    private val viewModel = MusicViewModel()
    private lateinit var adapter: AlbumAdapter
    private var albums = mutableListOf<Album>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = AlbumAdapter(albums)
        view_albums.adapter = adapter

        viewModel.getAlbums()

        subscribeOnLiveData()
    }
    private fun subscribeOnLiveData(){
        viewModel.albumsLiveData.observe(viewLifecycleOwner){
            albums.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

}