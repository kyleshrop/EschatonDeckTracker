package com.example.eschatondecktraker.data

class PlayerDeck private constructor() {
    private val ownedCards: MutableList<Card> = mutableListOf()
    
    init {
        // Add starting cards (7 Initiates as in the base game)
        repeat(7) {
            val initiateCard = CultistCardBase.create(CultistCardBase.CultistName.Initiate)
            ownedCards.add(initiateCard.copy(isOwned = true, isDrawn = false))
        }
    }
    
    companion object {
        @Volatile
        private var INSTANCE: PlayerDeck? = null
        
        fun getInstance(): PlayerDeck {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: PlayerDeck().also { INSTANCE = it }
            }
        }
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