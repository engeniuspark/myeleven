package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BattingStats(
    @SerializedName("Style")
    @Expose
    val style: String,
    @SerializedName("Average")
    @Expose
    val average: String,
    @SerializedName("Strikerate")
    @Expose
    val strikeRate: String,
    @SerializedName("Runs")
    @Expose
    val runs: String
)
