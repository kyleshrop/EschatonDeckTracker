import com.example.eschatondecktraker.data.Card
import com.example.eschatondecktraker.data.CultistCardBase

class CultistDeck {
    private val cards: MutableList<Card> = mutableListOf()

    init {
        for (cultistName in CultistCardBase.CultistName.values()) {
            val card = CultistCardBase.create(cultistName)
            cards.add(card)
        }
        shuffle()
    }

    fun shuffle() {
        cards.shuffle()
    }

    fun dealCard(): Card? {
        return if (cards.isNotEmpty()) cards.removeAt(0) else null
    }

    // Function to return a card at a specific index
    fun getCardAtIndex(index: Int): Card {
        if (index < 0 || index >= cards.size) {
            throw IndexOutOfBoundsException("Index $index is out of bounds for deck size ${cards.size}")
        }
        return cards[index]
    }


    fun remainingCards(): Int {
        return cards.size
    }
}
