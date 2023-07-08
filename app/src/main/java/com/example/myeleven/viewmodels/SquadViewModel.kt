package com.example.myeleven.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myeleven.models.MatchInfo
import com.example.myeleven.models.PlayerOldObject
import com.example.myeleven.network.NetworkClient.apiService
import kotlinx.coroutines.launch


class SquadViewModel : ViewModel() {
//    private val _players = MutableLiveData<List<PlayerOldObject>>()
    private val _matchInfo = MutableLiveData<MatchInfo>()
    val matchInfo: LiveData<MatchInfo> get() = _matchInfo

    // Function to fetch squad details from API
    fun fetchSquadDetails() {
        // Implement your API request logic here and update the LiveData variable
        viewModelScope.launch {
            try {
                val response = apiService.getTeamPlayersForMatch()
                if (response.isSuccessful) {
                    val matchInfo = response.body()
                    _matchInfo.value = matchInfo

                    /*val players = response.body().teams
                    _players.value = players*/
                } else {
                    // Handle API error response
                    Log.e("ERROR","Api not responding")
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }


            /*val playersResponse = listOf(
                Player("Player A", "Batsman", "Right-handed", "Right-arm medium", false, false),
                Player("Player B", "Bowler", "Right-handed", "Left-arm medium", false, false),
                Player("Player C", "Batsman", "Left-handed", "Right-arm off-break", true, false),
                Player("Player D", "Batsman", "Right-handed", "Right-arm medium", false, true)
            )

            _players.value = playersResponse*/
        }
    }
}
