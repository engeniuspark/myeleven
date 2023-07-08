package com.example.myeleven.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.myeleven.R
import com.example.myeleven.models.Team
import com.example.myeleven.viewmodels.MatchDetailsViewModel
import com.google.gson.Gson

class MatchDetailsActivity : AppCompatActivity() {

    private lateinit var viewModel: MatchDetailsViewModel
    private var teamsData: Map<String, Team> = mapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_details)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = getString(R.string.app_name)
        viewModel = ViewModelProvider(this)[MatchDetailsViewModel::class.java]

        // Fetch match details
        viewModel.fetchMatchDetails()

        // Observe match details LiveData and update the UI
        viewModel.matchInfo.observe(this) { matchInfo ->

            teamsData = matchInfo.teams
            val teamNames: List<String> = matchInfo.teams.values.map { it.fullName }

            val teamList: List<Team> = matchInfo.teams.values.toList()
            val firstTeam: Team? = if (teamList.isNotEmpty()) teamList[0] else null
            val secondTeam: Team? = if (teamList.size > 1) teamList[1] else null

            findViewById<TextView>(R.id.tvTeam1ShortName).text = "${firstTeam?.shortName}"
            findViewById<TextView>(R.id.tvTeam1FullName).text = "${firstTeam?.fullName}"

            findViewById<TextView>(R.id.tvTeam2ShortName).text = "${secondTeam?.shortName}"
            findViewById<TextView>(R.id.tvTeam2FullName).text = "${secondTeam?.fullName}"

            findViewById<TextView>(R.id.tvDate).text = "Date: ${matchInfo.matchDetail.match.date} "
            findViewById<TextView>(R.id.tvTime).text = "Time: ${matchInfo.matchDetail.match.time}"

            findViewById<TextView>(R.id.tvMatchDetail).text =
                "${firstTeam?.fullName} vs ${secondTeam?.fullName}"
            findViewById<TextView>(R.id.tvVenue).text = "${matchInfo.matchDetail.venue.name}"
        }

        // Handle click on the "View Team Players" button
        findViewById<Button>(R.id.btnGoToSquad).setOnClickListener {
            // Perform the navigation to the Team Players screen
            navigateToTeamPlayers()
        }
    }

    private fun navigateToTeamPlayers() {
        // Implement the logic to navigate to the Team Players screen
        // You can start a new activity or use a navigation component
        val intent = Intent(this, SquadActivity::class.java)
        intent.putExtra("hashMapExtra", Gson().toJson(teamsData))
        startActivity(intent)
    }

}
