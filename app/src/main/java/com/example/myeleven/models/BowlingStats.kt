package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BowlingStats(
    @SerializedName("Style")
    @Expose
    val style: String,
    @SerializedName("Average")
    @Expose
    val average: String,
    @SerializedName("Economyrate")
    @Expose
    val economyRate: String,
    @SerializedName("Wickets")
    @Expose
    val wickets: String
)
