package com.example.eschatondecktraker.data

import android.content.Context
import android.content.SharedPreferences

class PlayerDeck private constructor(private val context: Context? = null) {
    private val ownedCards: MutableList<Card> = mutableListOf()
    
    init {
        // Add starting cards based on draft mode setting
        if (!isDraftMode()) {
            addDefaultStartingCards()
        }
    }
    
    companion object {
        @Volatile
        private var INSTANCE: PlayerDeck? = null
        private const val PREFS_NAME = "EschatonDeckTrackerPrefs"
        private const val KEY_DRAFT_MODE = "draft_mode"
        
        fun getInstance(context: Context? = null): PlayerDeck {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: PlayerDeck(context).also { INSTANCE = it }
            }
        }
    }
    
    private fun isDraftMode(): Boolean {
        return context?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            ?.getBoolean(KEY_DRAFT_MODE, false) ?: false
    }
    
    private fun addDefaultStartingCards() {
        // Add starting cards (3 Initiates, 3 Fanatics, 1 Acolyte)
        repeat(3) {
            val initiateCard = CultistCardBase.create(CultistCardBase.CultistName.Initiate)
            ownedCards.add(initiateCard.copy(isOwned = true, isDrawn = false))
        }
        repeat(3) {
            val fanaticCard = CultistCardBase.create(CultistCardBase.CultistName.Fanatic)
            ownedCards.add(fanaticCard.copy(isOwned = true, isDrawn = false))
        }
        val acolyteCard = CultistCardBase.create(CultistCardBase.CultistName.Acolyte)
        ownedCards.add(acolyteCard.copy(isOwned = true, isDrawn = false))
    }
    
    fun addCard(card: Card) {
        val newCard = card.copy(isOwned = true, isDrawn = false)
        ownedCards.add(newCard)
    }
    
    fun removeCard(card: Card) {
        ownedCards.remove(card)
    }
    
    fun getAllCards(): List<Card> = ownedCards.toList()
    
    fun getAvailableCards(): List<Card> = ownedCards.filter { !it.isDrawn }
    
    fun getDrawnCards(): List<Card> = ownedCards.filter { it.isDrawn }
    
    fun drawCard(card: Card) {
        ownedCards.find { it == card }?.isDrawn = true
    }
    
    fun reshuffleAll() {
        ownedCards.forEach { it.isDrawn = false }
    }
    
    fun clearDeck() {
        ownedCards.clear()
        // Add starting cards back based on draft mode setting
        if (!isDraftMode()) {
            addDefaultStartingCards()
        }
    }
    
    fun getTotalStats(): CardStats {
        val availableCards = getAvailableCards()
        return CardStats(
            zeal = availableCards.sumOf { it.zeal.value },
            divination = availableCards.sumOf { it.divination.value },
            influence = availableCards.sumOf { it.influence.value },
            aggression = availableCards.sumOf { it.aggression.value },
            scour = availableCards.sumOf { it.scour?.value ?: 0 },
            inspire = availableCards.sumOf { it.inspire.value },
            pointValue = availableCards.sumOf { it.pointValue.value },
            totalCards = availableCards.size
        )
    }
    
    fun getAverageStats(): AverageCardStats {
        val availableCards = getAvailableCards()
        val totalCards = availableCards.size.toDouble()
        
        return if (totalCards > 0) {
            AverageCardStats(
                zeal = availableCards.sumOf { it.zeal.value } / totalCards,
                divination = availableCards.sumOf { it.divination.value } / totalCards,
                influence = availableCards.sumOf { it.influence.value } / totalCards,
                aggression = availableCards.sumOf { it.aggression.value } / totalCards,
                scour = availableCards.sumOf { it.scour?.value ?: 0 } / totalCards,
                inspire = availableCards.sumOf { it.inspire.value } / totalCards
            )
        } else {
            AverageCardStats(0.0, 0.0, 0.0, 0.0, 0.0, 0.0)
        }
    }
}

data class CardStats(
    val zeal: Int,
    val divination: Int,
    val influence: Int,
    val aggression: Int,
    val scour: Int,
    val inspire: Int,
    val pointValue: Int,
    val totalCards: Int
)

data class AverageCardStats(
    val zeal: Double,
    val divination: Double,
    val influence: Double,
    val aggression: Double,
    val scour: Double,
    val inspire: Double
)