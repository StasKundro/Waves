package com.example.waves.ui.music

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.waves.R
import com.example.waves.model.music.artists.Artist
import com.example.waves.model.music.artists.LastFMNetwork
import com.example.waves.model.music.artists.LastFMNetworkImpl
import kotlinx.android.synthetic.main.fragment_music.view_albums

class MusicFragment: Fragment() {
    private val viewModel = MusicViewModel()
    private lateinit var adapter: ArtistAdapter
    private var artists = mutableListOf<Artist>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArtistAdapter(artists)
        view_albums.adapter = adapter

        val lastFMNetwork = LastFMNetworkImpl.getInstance() as LastFMNetwork
        viewModel.setArtistsService(lastFMNetwork.getArtistsService())
        lifecycle.addObserver(viewModel)

//        viewModel.getAlbums()

        subscribeOnLiveData()
    }
    private fun subscribeOnLiveData(){
        viewModel.artistsLiveData.observe(viewLifecycleOwner){
            artists.clear()
            artists.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

}