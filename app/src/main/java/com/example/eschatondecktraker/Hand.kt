import com.example.eschatondecktraker.data.Card

import kotlin.random.Random

class Hand {
    val cultistCardsInHand: MutableList<Card> = mutableListOf()
    val monsterCardsInHand: MutableList<Card> = mutableListOf()

    fun addCultistCard(card: Card) {
        cultistCardsInHand.add(card)
    }


    fun addRandomMonsterCard() {
        val monsterDeck: MutableList<Card> = mutableListOf()
        val randomIndex = Random.nextInt(monsterDeck.size)
        val card = monsterDeck.removeAt(randomIndex)
        monsterCardsInHand.add(card)
    }


    fun removeCultistCard(card: Card): Boolean {
        return cultistCardsInHand.remove(card)
    }

    fun removeMonsterCard(card: Card): Boolean {
        return monsterCardsInHand.remove(card)
    }

    fun showHand(): List<Card> {
        return cultistCardsInHand + monsterCardsInHand
    }

    fun clearHand() {
        cultistCardsInHand.clear()
        monsterCardsInHand.clear()
    }

    fun handSize(): Int {
        return cultistCardsInHand.size + monsterCardsInHand.size
    }
}
