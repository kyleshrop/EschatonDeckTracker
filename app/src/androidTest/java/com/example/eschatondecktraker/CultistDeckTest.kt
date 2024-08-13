import com.example.eschatondecktraker.data.CultistCardBase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertNotEquals
import org.junit.jupiter.api.Test

class CultistDeckTest {

    @Test
    fun testCardCreation() {
        // Test individual card creation
        val initCard = CultistCardBase.Card.create(CultistCardBase.CultistName.Initiate)
        assertEquals(CultistCardBase.CultistName.Initiate, initCard.cultistName)
        assertNotNull(initCard)
    }

    @Test
    fun testDeckCreation() {
        // Ensure the deck is correctly initialized with all card types
        val deck = CultistDeck()
        assertEquals(14, deck.remainingCards())  // Assuming there are 14 unique CultistNames
    }

    @Test
    fun testDeckShuffle() {
        // Ensure that shuffling the deck results in a different order
        val deck = CultistDeck()
        val firstCardPreShuffle = deck.dealCard()
        deck.shuffle()
        val firstCardPostShuffle = deck.dealCard()
        assertNotEquals(firstCardPreShuffle, firstCardPostShuffle)
    }

    @Test
    fun testDealCard() {
        // Ensure dealing a card reduces the deck size
        val deck = CultistDeck()
        val initialSize = deck.remainingCards()
        deck.dealCard()
        assertEquals(initialSize - 1, deck.remainingCards())
    }

    //Instantiate Cultist Cards
    val initiateCard = CultistCardBase.Card.create(CultistCardBase.CultistName.Initiate)
    val acolyteCard = CultistCardBase.Card.create(CultistCardBase.CultistName.Acolyte)
    val thrallCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Thrall)
    val fanaticCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Fanatic)
    val seerCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Seer)
    val supplicantCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Supplicant)
    val zealotCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Zealot)
    val discipleCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Disciple)
    val magusCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Magus)
    val marauderCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Marauder)
    val heraldCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Herald)
    val templarCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Templar)
    val pontiffCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Pontiff)
    val archonCard= CultistCardBase.Card.create(CultistCardBase.CultistName.Archon)
}
