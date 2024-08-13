package com.example.eschatondecktraker


import com.example.eschatondecktraker.data.MonsterCardBase
import kotlin.random.Random

class NeutralDeck {
    private val deck: MutableList<MonsterCardBase.Card> = mutableListOf()

    init {
        // Add all unique MonsterCards to the deck
        for (monsterName in MonsterCardBase.MonsterName.values()) {
            val card = MonsterCardBase.Card.create(monsterName)
            deck.add(card)
        }
    }

    // Shuffle the deck
    private fun shuffle() {
        deck.shuffle()
    }

    // Draw a card from the deck
    fun drawCard(): MonsterCardBase.Card? {
        if (deck.isNotEmpty()) {
            val randomIndex = Random.nextInt(deck.size)  // Generate a random index within the bounds of the deck
            shuffle()
            return deck.removeAt(randomIndex)  // Remove the card at the random index and return it
        }
        return null  // Return null if the deck is empty
    }
}
