package com.example.waves.model.music.artists

import com.google.gson.annotations.SerializedName

data class ArtistsResponse(
    @SerializedName("artists") val artists: Artists
)