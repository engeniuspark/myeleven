package com.example.myeleven.adapters

import android.app.Activity
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myeleven.R
import com.example.myeleven.models.Player

class PlayerAdapter(private val players: List<Player>, private val activity: Activity) : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val player = players[position]
        holder.bind(player)

        holder.itemView.setOnClickListener {
            // Show the dialog to display batting and bowling style
            showPlayerDialog(player,activity)
        }

    }

    override fun getItemCount(): Int {
        return players.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(player: Player) {
            if (player.isKeeper && player.isCaptain){
                itemView.findViewById<TextView>(R.id.text_player_name).text = "${player.fullName} (c & wk)"
            }else if (player.isCaptain ) {
                itemView.findViewById<TextView>(R.id.text_player_name).text = "${player.fullName} (c)"
            }else if (player.isKeeper){
                itemView.findViewById<TextView>(R.id.text_player_name).text = "${player.fullName} (wk)"
            }else{
                itemView.findViewById<TextView>(R.id.text_player_name).text = player.fullName
            }
        }
    }

    private fun showPlayerDialog(player: Player, activity: Activity) {
        val dialog = Dialog(activity)
        dialog.setContentView(R.layout.dialog_player_info)

        val tvPlayerInfo = dialog.findViewById<TextView>(R.id.tvPlayerInfo)

        val tvBattingStyle = dialog.findViewById<TextView>(R.id.tvBattingStyle)
        val tvBattingAvg = dialog.findViewById<TextView>(R.id.tvBattingAvg)
        val tvStrikeRate = dialog.findViewById<TextView>(R.id.tvStrikeRate)
        val tvRuns = dialog.findViewById<TextView>(R.id.tvRuns)

        val tvBowlingStyle = dialog.findViewById<TextView>(R.id.tvBowlingStyle)
        val tvBowlingAvg = dialog.findViewById<TextView>(R.id.tvBowlingAvg)
        val tvEconomyRate = dialog.findViewById<TextView>(R.id.tvEconomyRate)
        val tvWickets = dialog.findViewById<TextView>(R.id.tvWickets)

        tvPlayerInfo.text = "${player.fullName}"

        tvBattingStyle.text = player.batting.style
        tvBattingAvg.text = player.batting.average
        tvStrikeRate.text = player.batting.strikeRate
        tvRuns.text = player.batting.runs

        tvBowlingStyle.text = player.bowling.style
        tvBowlingAvg.text = player.bowling.average
        tvEconomyRate.text = player.bowling.economyRate
        tvWickets.text = player.bowling.wickets

        dialog.show()

    }

}
