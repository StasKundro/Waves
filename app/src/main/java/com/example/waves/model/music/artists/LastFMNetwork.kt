package com.example.waves.model.music.artists

import com.example.waves.model.music.artists.ArtistsService

interface LastFMNetwork {
    fun getArtistsService(): ArtistsService
}