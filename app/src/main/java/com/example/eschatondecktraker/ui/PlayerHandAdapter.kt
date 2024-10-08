package com.example.eschatondecktraker.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.eschatondecktraker.R

import com.example.eschatondecktraker.data.Card



class PlayerHandAdapter(
    private val cards: List<Card>
) : RecyclerView.Adapter<PlayerHandAdapter.CardViewHolder>() {

    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cardName: TextView = view.findViewById(R.id.card_name)
        val cardAttributes: TextView = view.findViewById(R.id.card_attributes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]

        holder.cardName.text = when {
            card.cultistName != null -> card.cultistName.toString()
            card.monsterName != null -> card.monsterName.toString()
            else -> "Unknown"
        }

        val cardDetails = StringBuilder()
        cardDetails.append("Zeal: ${card.zeal.value}\n")
        cardDetails.append("Divination: ${card.divination.value}\n")
        cardDetails.append("Influence: ${card.influence.value}\n")
        cardDetails.append("Aggression: ${card.aggression.value}\n")
        cardDetails.append("Scour: ${card.scour?.value ?: "N/A"}\n")
        cardDetails.append("Inspire: ${card.inspire.value}\n")
        cardDetails.append("PointValue: ${card.pointValue1?.value}")


        holder.cardAttributes.text = cardDetails.toString()
    }

    override fun getItemCount(): Int {
        return cards.size
    }
}

