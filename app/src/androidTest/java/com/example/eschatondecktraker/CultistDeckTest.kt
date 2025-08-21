import com.example.eschatondecktraker.data.CultistCardBase
import org.junit.Assert.*
import org.junit.Test

class CultistDeckTest {

    @Test
    fun testCardCreation() {
        val initCard = CultistCardBase.create(CultistCardBase.CultistName.Initiate)
        assertEquals(CultistCardBase.CultistName.Initiate, initCard.cultistName)
        assertNotNull(initCard)
    }

    @Test
    fun testDeckCreation() {
        val deck = CultistDeck()
        assertEquals(14, deck.remainingCards())
    }

    @Test
    fun testDeckShuffle() {
        val deck = CultistDeck()
        val firstCardPreShuffle = deck.dealCard()
        deck.shuffle()
        val firstCardPostShuffle = deck.dealCard()
        assertNotEquals(firstCardPreShuffle, firstCardPostShuffle)
    }
}
