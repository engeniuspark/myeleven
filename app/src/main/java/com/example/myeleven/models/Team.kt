package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("Name_Full")
    @Expose
    val fullName: String,
    @SerializedName("Name_Short")
    @Expose
    val shortName: String,
    @SerializedName("Players")
    @Expose
    val players: Map<String, Player>
)