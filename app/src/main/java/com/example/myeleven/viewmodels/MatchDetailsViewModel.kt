package com.example.myeleven.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myeleven.models.MatchInfo
import com.example.myeleven.network.NetworkClient
import kotlinx.coroutines.launch

class MatchDetailsViewModel : ViewModel() {
    private val _matchInfo = MutableLiveData<MatchInfo>()
    val matchInfo: LiveData<MatchInfo> get() = _matchInfo

    // Function to fetch match details from API
    fun fetchMatchDetails() {
        // Implement your API request logic here and update the LiveData variable
        viewModelScope.launch {
            try {
                val response = NetworkClient.apiService.getTeamPlayersForMatch()
                if (response.isSuccessful) {
                    val matchInfo = response.body()
                    _matchInfo.value = matchInfo

                } else {
                    // Handle API error response
                    Log.e("ERROR","Api not responding")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }


    /*private val _teamNames = MutableLiveData<String>()
    val teamNames: LiveData<String> get() = _teamNames

    private val _dateTime = MutableLiveData<String>()
    val dateTime: LiveData<String> get() = _dateTime

    private val _venue = MutableLiveData<String>()
    val venue: LiveData<String> get() = _venue

    // Function to fetch match details from API
    fun fetchMatchDetails() {
        // Implement your API request logic here and update the LiveData variables
        val teamNamesResponse = "INDIA vs NEW ZEALAND"
        val dateTimeResponse = "July 7, 2023 - 8:00 PM"
        val venueResponse = "Stadium XYZ"

        _teamNames.value = teamNamesResponse
        _dateTime.value = dateTimeResponse
        _venue.value = venueResponse
    }*/
}
