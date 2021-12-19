package com.example.waves.model.music

import com.example.waves.model.album.Album

interface IMusicService {
    fun getAlbums():List<Album>
}