package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MatchInfo(

    @SerializedName("Matchdetail")
    @Expose
    val matchDetail : Matchdetail,

    @SerializedName("Teams")
    @Expose
    val teams: Map<String, Team>
)
