package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("Position")
    @Expose
    val position: String,
    @SerializedName("Name_Full")
    @Expose
    val fullName: String,
    @SerializedName("Iscaptain")
    @Expose
    val isCaptain: Boolean,
    @SerializedName("Iskeeper")
    @Expose
    val isKeeper: Boolean,
    @SerializedName("Batting")
    @Expose
    val batting: BattingStats,
    @SerializedName("Bowling")
    @Expose
    val bowling: BowlingStats
)
