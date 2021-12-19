package com.example.waves.ui.music

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.waves.model.album.Album
import com.example.waves.model.music.IMusicService
import com.example.waves.model.music.MusicService

class MusicViewModel: ViewModel() {
    val albumsLiveData = MutableLiveData<List<Album>>()
    private val model: IMusicService = MusicService()

    fun getAlbums(){
        albumsLiveData.value = model.getAlbums()
    }
}