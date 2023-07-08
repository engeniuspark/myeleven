package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Match(
    @SerializedName("Code")
    @Expose
    val code: String,

    @SerializedName("Date")
    @Expose
    val date: String,

    @SerializedName("Daynight")
    @Expose
    val dayNight: String,

    @SerializedName("Id")
    @Expose
    val id: String,

    @SerializedName("League")
    @Expose
    val league: String,

    @SerializedName("Livecoverage")
    @Expose
    val liveCoverage: String,

    @SerializedName("Number")
    @Expose
    val number: String,

    @SerializedName("Offset")
    @Expose
    val offset: String,

    @SerializedName("Time")
    @Expose
    val time: String,

    @SerializedName("Type")
    @Expose
    val type: String
)