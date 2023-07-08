package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("Id")
    @Expose
    val id: String,
    @SerializedName("Name")
    @Expose
    val name: String
)