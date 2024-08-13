import com.example.eschatondecktraker.data.CultistCardBase
import com.example.eschatondecktraker.data.MonsterCardBase
import kotlin.random.Random

class Hand {
    val cultistCardsInHand: MutableList<CultistCardBase.Card> = mutableListOf()
    val monsterCardsInHand: MutableList<MonsterCardBase.Card> = mutableListOf()

    fun addCultistCard(card: CultistCardBase.Card) {
        cultistCardsInHand.add(card)
    }


    fun addRandomMonsterCard() {
        val monsterDeck: MutableList<MonsterCardBase.Card> = mutableListOf()
            val randomIndex = Random.nextInt(monsterDeck.size)
            val card = monsterDeck.removeAt(randomIndex)
            monsterCardsInHand.add(card)
    }


    fun removeCultistCard(card: CultistCardBase.Card): Boolean {
        return cultistCardsInHand.remove(card)
    }

    fun removeMonsterCard(card: MonsterCardBase.Card): Boolean {
        return monsterCardsInHand.remove(card)
    }

    fun showHand(): List<Any> {
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
