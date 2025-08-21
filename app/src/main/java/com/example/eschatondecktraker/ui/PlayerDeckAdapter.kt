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
            
            // Display stats that have values > 0 (and scour only if not null)
            val stats = mutableListOf<String>()
            
            if (card.zeal.value > 0) {
                stats.add("Zeal: ${card.zeal.value}")
            }
            if (card.divination.value > 0) {
                stats.add("Divination: ${card.divination.value}")
            }
            if (card.influence.value > 0) {
                stats.add("Influence: ${card.influence.value}")
            }
            if (card.aggression.value > 0) {
                stats.add("Aggression: ${card.aggression.value}")
            }
            if (card.scour?.value != null && card.scour.value > 0) {
                stats.add("Scour: ${card.scour.value}")
            }
            if (card.inspire.value > 0) {
                stats.add("Inspire: ${card.inspire.value}")
            }
            if (card.pointValue.value > 0) {
                stats.add("Point Value: ${card.pointValue.value}")
            }
            
            binding.tvCardStats.text = stats.joinToString(" | ")
            
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