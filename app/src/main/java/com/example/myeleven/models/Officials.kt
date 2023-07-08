package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Officials(
    @SerializedName("Referee")
    @Expose
    val referee: String,

    @SerializedName("Umpires")
    @Expose
    val umpires: String
)