import com.example.eschatondecktraker.data.CultistCardBase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Assert.assertNotEquals
import org.junit.jupiter.api.Test

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
