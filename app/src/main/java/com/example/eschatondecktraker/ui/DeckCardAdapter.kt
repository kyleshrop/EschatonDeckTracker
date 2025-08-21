package com.example.eschatondecktraker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.databinding.ItemDeckCardBinding

class DeckCardAdapter(
    private val cards: MutableList<Card>,
    private val onCardClick: (Card) -> Unit
) : RecyclerView.Adapter<DeckCardAdapter.ViewHolder>() {
    
    private var disabledCards = mutableSetOf<Card>()
    
    fun setDisabledCards(cards: Set<Card>) {
        disabledCards = cards.toMutableSet()
        notifyDataSetChanged()
    }
    
    fun updateCardOwnership(ownedCards: List<Card>) {
        // Update the ownership status of cards in the adapter
        for (i in cards.indices) {
            val card = cards[i]
            val isOwned = ownedCards.any { it.monsterName == card.monsterName }
            if (card.isOwned != isOwned) {
                cards[i] = card.copy(isOwned = isOwned)
            }
        }
        notifyDataSetChanged()
    }
    
    inner class ViewHolder(private val binding: ItemDeckCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(card: Card) {
            val cardName = when {
                card.cultistName != null -> card.cultistName.name.replace("_", " ")
                card.monsterName != null -> card.monsterName.name.replace("_", " ")
                else -> "Unknown"
            }
            
            binding.tvCardName.text = cardName
            
            // Only show cost for cultist cards, not monster cards
            if (card.cost != null) {
                binding.tvCardCost.text = "Cost: ${card.cost.value}"
            } else {
                binding.tvCardCost.text = ""
            }
            
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
            
            binding.tvCardStats.text = stats.joinToString("\n")
            
            // Set card image based on card name
            val resourceName = card.getImageName()
            val resourceId = binding.root.context.resources.getIdentifier(
                resourceName, "drawable", binding.root.context.packageName
            )
            if (resourceId != 0) {
                binding.ivCardImage.setImageResource(resourceId)
            }
            
            // Apply gray overlay if disabled
            val isDisabled = disabledCards.contains(card)
            binding.ivCardImage.alpha = if (isDisabled) 0.5f else 1.0f
            binding.root.isClickable = !isDisabled
            
            if (!isDisabled) {
                binding.root.setOnClickListener { onCardClick(card) }
            }
        }
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDeckCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cards[position])
    }
    
    override fun getItemCount() = cards.size
}