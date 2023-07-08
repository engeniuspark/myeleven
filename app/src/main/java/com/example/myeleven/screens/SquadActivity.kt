package com.example.myeleven.screens

import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myeleven.R
import com.example.myeleven.adapters.PlayerAdapter
import com.example.myeleven.models.Team
import com.example.myeleven.viewmodels.SquadViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SquadActivity : AppCompatActivity() {

    private lateinit var viewModel: SquadViewModel
    private lateinit var playerAdapter: PlayerAdapter
    private var teamsData: Map<String, Team> = mapOf()
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squad)

        val toolbar = findViewById<Toolbar>(R.id.squadtoolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.title = getString(R.string.squads)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val gson = Gson()
        val json: String? = intent.getStringExtra("hashMapExtra")
        teamsData = gson.fromJson(json, object : TypeToken<HashMap<String, Team>>() {}.type)

        val teamList: List<Team> = teamsData.values.toList()
        val firstTeam: Team? = if (teamList.isNotEmpty()) teamList[0] else null
        val secondTeam: Team? = if (teamList.size > 1) teamList[1] else null


        // Set up RecyclerView
        recyclerView =  findViewById(R.id.recycler_players)
        recyclerView.layoutManager = LinearLayoutManager(this)
        playerAdapter = PlayerAdapter(firstTeam?.players?.values?.toList() ?: emptyList(),this)
        recyclerView.adapter = playerAdapter


        // Set up the radio group listener to apply filters
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group_filter)
        (radioGroup.getChildAt(0) as RadioButton).text = firstTeam?.fullName
        (radioGroup.getChildAt(1) as RadioButton).text = secondTeam?.fullName
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio_team_a -> applyFilter(firstTeam)
                R.id.radio_team_b -> applyFilter(secondTeam)
            }
        }
    }

    private fun applyFilter(selectedTeam: Team?) {
        selectedTeam?.let { Log.e("applyFilter", it.fullName) }
        playerAdapter = PlayerAdapter(selectedTeam?.players?.values?.toList() ?: emptyList(), this)
        recyclerView.adapter = playerAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        // Handle the back button press event here
        onBackPressed()
        return true
    }

}
