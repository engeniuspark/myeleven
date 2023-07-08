package com.example.myeleven.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("Id")
    @Expose
    val id: String,
    @SerializedName("Name")
    @Expose
    val name: String,
    @SerializedName("Status")
    @Expose
    val status: String,
    @SerializedName("Tour")
    @Expose
    val tour: String,
    @SerializedName("Tour_Name")
    @Expose
    val tourName: String
)