package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Matchdetail(
    @SerializedName("Equation")
    @Expose
    val equation: String,

    @SerializedName("Match")
    @Expose
    val match: Match,

    @SerializedName("Officials")
    @Expose
    val officials: Officials,

    @SerializedName("Player_Match")
    @Expose
    val playerMatch: String,

    @SerializedName("Result")
    @Expose
    val result: String,

    @SerializedName("Series")
    @Expose
    val series: Series,

    @SerializedName("Status")
    @Expose
    val status: String,

    @SerializedName("Status_Id")
    @Expose
    val statusId: String,

    @SerializedName("Team_Away")
    @Expose
    val teamAway: String,

    @SerializedName("Team_Home")
    @Expose
    val teamHome: String,

    @SerializedName("Tosswonby")
    @Expose
    val tossWonBy: String,

    @SerializedName("Venue")
    @Expose
    val venue: Venue,

    @SerializedName("Weather")
    @Expose
    val weather: String,

    @SerializedName("Winmargin")
    @Expose
    val winMargin: String,

    @SerializedName("Winningteam")
    @Expose
    val winningTeam: String
)