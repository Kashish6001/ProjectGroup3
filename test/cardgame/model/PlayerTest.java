package cardgame.model;

import org.junit.Test;               
import static org.junit.Assert.*;   

public class PlayerTest {

    // GOOD CASE: Normal hand under 21
    @Test
    public void testGoodCase_totalBelow21() {
        Player player = new Player("Test");
        player.addCard(new Card(Suit.HEARTS, Value.TEN));
        player.addCard(new Card(Suit.CLUBS, Value.SIX));
        // 10 + 6 = 16
        assertEquals(16, player.calculateHandValue());
    }

    // BAD CASE: Hand goes over 21 (no Ace to save)
    @Test
    public void testBadCase_bust() {
        Player player = new Player("Test");
        player.addCard(new Card(Suit.HEARTS, Value.TEN));
        player.addCard(new Card(Suit.SPADES, Value.NINE));
        player.addCard(new Card(Suit.DIAMONDS, Value.FOUR));
        // 10 + 9 + 4 = 23 → bust
        assertTrue(player.calculateHandValue() > 21);
    }

    // BOUNDARY CASE: Exactly 21 with Ace + 10
    @Test
    public void testBoundaryCase_blackjack() {
        Player player = new Player("Test");
        player.addCard(new Card(Suit.HEARTS, Value.ACE));
        player.addCard(new Card(Suit.CLUBS, Value.JACK));
        // 11 + 10 = 21
        assertEquals(21, player.calculateHandValue());
    }

    // BOUNDARY CASE: Ace adjustment needed (11 → 1)
    @Test
    public void testBoundaryCase_aceAdjustment() {
        Player player = new Player("Test");
        player.addCard(new Card(Suit.HEARTS, Value.ACE));
        player.addCard(new Card(Suit.CLUBS, Value.NINE));
        player.addCard(new Card(Suit.SPADES, Value.THREE));
        // 11 + 9 + 3 = 23 → Adjusted to 1 + 9 + 3 = 13
        assertEquals(13, player.calculateHandValue());
    }
}
