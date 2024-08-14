package com.example.eschatondecktraker

import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.data.MonsterCardBase
import kotlin.random.Random

class NeutralDeck {
    private val deck: MutableList<Card> = mutableListOf()

    init {
        // Add all unique MonsterCards to the deck
        for (monsterName in MonsterCardBase.MonsterName.values()) {
            val card = MonsterCardBase.create(monsterName)
            deck.add(card)
        }
        shuffle()
    }

    // Shuffle the deck
    private fun shuffle() {
        deck.shuffle()
    }

    // Draw a random card from the deck
    fun drawCard(): Card? {
        return if (deck.isNotEmpty()) {
            val randomIndex = Random.nextInt(deck.size)  // Generate a random index within the bounds of the deck
            deck.removeAt(randomIndex)
        } else {
            null  // Return null if the deck is empty
        }
    }
}
