package com.example.eschatondecktraker.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.databinding.ItemDeckCardBinding

class DeckCardAdapter(
    private val cards: List<Card>,
    private val onCardClick: (Card) -> Unit
) : RecyclerView.Adapter<DeckCardAdapter.ViewHolder>() {
    
    private var disabledCards = mutableSetOf<Card>()
    
    fun setDisabledCards(cards: Set<Card>) {
        disabledCards = cards.toMutableSet()
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
            
            val cost = card.cost?.value ?: 0
            binding.tvCardCost.text = "Cost: $cost"
            
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