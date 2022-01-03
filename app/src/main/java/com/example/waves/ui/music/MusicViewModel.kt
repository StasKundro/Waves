package com.example.waves.ui.music

import androidx.lifecycle.*
import com.example.waves.model.music.IMusicService
import com.example.waves.model.music.MusicService
import com.example.waves.model.music.artists.Artist
import com.example.waves.model.music.artists.ArtistsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MusicViewModel : ViewModel(), LifecycleEventObserver {
    val artistsLiveData = MutableLiveData<List<Artist>>()

    private val model: IMusicService = MusicService()

    private var artistsService: ArtistsService? = null

    fun setArtistsService(service: ArtistsService){
        this.artistsService = service
    }

    private fun getArtists() {
        viewModelScope.launch(Dispatchers.IO) {
            val artists = artistsService?.getTopArtists()?.artists?.artist ?: listOf()
            artistsLiveData.postValue(artists)
        }
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_CREATE) getArtists()
    }
}