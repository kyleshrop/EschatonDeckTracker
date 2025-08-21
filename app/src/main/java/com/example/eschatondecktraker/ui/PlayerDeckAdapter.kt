package com.example.eschatondecktraker.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.databinding.ItemPlayerCardBinding

class PlayerDeckAdapter(
    private val onCardClick: (Card) -> Unit
) : RecyclerView.Adapter<PlayerDeckAdapter.ViewHolder>() {
    
    private var cards = listOf<Card>()
    
    fun updateCards(newCards: List<Card>) {
        cards = newCards
        notifyDataSetChanged()
    }
    
    inner class ViewHolder(private val binding: ItemPlayerCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            val cardName = when {
                card.cultistName != null -> card.cultistName.name.replace("_", " ")
                card.monsterName != null -> card.monsterName.name.replace("_", " ")
                else -> "Unknown"
            }
            
            binding.tvCardName.text = cardName
            
            val stats = buildString {
                append("Z:${card.zeal.value} ")
                append("D:${card.divination.value} ")
                append("I:${card.influence.value} ")
                append("A:${card.aggression.value}")
                if (card.scour != null && card.scour.value > 0) {
                    append(" S:${card.scour.value}")
                }
                if (card.inspire.value > 0) {
                    append(" In:${card.inspire.value}")
                }
                if (card.pointValue.value > 0) {
                    append(" PV:${card.pointValue.value}")
                }
            }
            binding.tvCardStats.text = stats
            
            binding.tvCardStatus.text = if (card.isDrawn) "Drawn" else "Available"
            binding.tvCardStatus.setTextColor(if (card.isDrawn) Color.GRAY else Color.GREEN)
            
            // Set card image based on card name
            val resourceName = card.getImageName()
            val resourceId = binding.root.context.resources.getIdentifier(
                resourceName, "drawable", binding.root.context.packageName
            )
            if (resourceId != 0) {
                binding.ivCardImage.setImageResource(resourceId)
            }
            
            // Apply gray overlay if drawn
            binding.ivCardImage.alpha = if (card.isDrawn) 0.5f else 1.0f
            
            binding.root.setOnClickListener { onCardClick(card) }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPlayerCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cards[position])
    }
    
    override fun getItemCount() = cards.size
}