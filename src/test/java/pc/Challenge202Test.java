package pc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.SortedMap;

import org.junit.Before;
import org.junit.Test;

import pc.Challenge202.HandRank;

public class Challenge202Test {
    Challenge202 c;
    @Before
    public void setUp() throws Exception {
        c = new Challenge202();
    }

    @Test
    public void testHighestCardWhite() {
        String[] hands = new String[] { "2H", "3D", "5S", "9C", "KD", "2C", "3H", "4S", "8C", "AH" };
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.HIGH_CARD,bh.lastKey());
        assertEquals(HandRank.HIGH_CARD,wh.lastKey());
        assertEquals("White wins", c.compareHands(bh, wh));
    }

    @Test
    public void testFullHouseBeatsFlush() {
        String [] hands = new String [] {"2H", "4S", "4C", "2D", "4H", "2S", "8S", "AS", "QS", "3S"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.FULL_HOUSE,bh.lastKey());
        assertEquals(HandRank.FLUSH,wh.lastKey());
        assertEquals("Black wins", c.compareHands(bh, wh));
    }

    @Test
    public void testPairsOneBetter() {
        String [] hands = new String [] {"2H", "4S", "5C", "2D", "4H", "2D", "8S", "AC", "2S", "8D"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.TWO_PAIRS,bh.lastKey());
        assertEquals(HandRank.TWO_PAIRS,wh.lastKey());
        assertEquals("White wins", c.compareHands(bh, wh));
    }
    
    @Test
    public void testPairTie() {
        String [] hands = new String [] {"2H", "8S", "AC", "2D", "8H", "2D", "8S", "KC", "2S", "8D"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.TWO_PAIRS,bh.lastKey());
        assertEquals(HandRank.TWO_PAIRS,wh.lastKey());
        assertEquals("Black wins", c.compareHands(bh, wh));
    }

    @Test
    public void testNextHightestCard() {
        String [] hands = new String [] {"2H", "3D", "5S", "9C", "KD", "2C", "3H", "4S", "8C", "KH"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.HIGH_CARD,bh.lastKey());
        assertEquals(HandRank.HIGH_CARD,wh.lastKey());
        assertEquals("Black wins", c.compareHands(bh, wh));
    }

    @Test
    public void testHightestCardTie() {
        String [] hands = new String [] {"2H", "3D", "5S", "9C", "KD", "2D", "3H", "5C", "9S", "KH"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.HIGH_CARD,bh.lastKey());
        assertEquals(HandRank.HIGH_CARD,wh.lastKey());
        assertEquals("Tie", c.compareHands(bh, wh));
    }

    @Test
    public void testTwoStraights() {
        String [] hands = new String [] {"2H", "3D", "4S", "5C", "6D", "3D", "4H", "5C", "6S", "7H"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.STRAIGHT,bh.lastKey());
        assertEquals(HandRank.STRAIGHT,wh.lastKey());
        assertEquals("White wins", c.compareHands(bh, wh));
    }

    @Test
    public void testTwoFlushes() {
        String [] hands = new String [] {"2H", "4H", "6H", "8H", "10H", "3D", "4D", "5D", "6D", "AD"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.FLUSH,bh.lastKey());
        assertEquals(HandRank.FLUSH,wh.lastKey());
        assertEquals("White wins", c.compareHands(bh, wh));
    }
    
    @Test
    public void testStraightFlushFlush() {
        String [] hands = new String [] {"3D", "4D", "5D", "6D", "7D", "2H", "4H", "6H", "8H", "10H"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.STRAIGHT_FLUSH,bh.lastKey());
        assertEquals(HandRank.FLUSH,wh.lastKey());
        assertEquals("Black wins", c.compareHands(bh, wh));
    }
    
    @Test
    public void testFours() {
        String [] hands = new String [] {"3D", "3C", "3H", "3S", "7D", "4D", "4C", "4H", "4S", "8D"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.FOUR_OF_A_KIND,bh.lastKey());
        assertEquals(HandRank.FOUR_OF_A_KIND,wh.lastKey());
        assertEquals("White wins", c.compareHands(bh, wh));
    }
    
    @Test
    public void testFourBeatsThree() {
        String [] hands = new String [] {"3D", "3C", "3H", "7S", "7D", "4D", "4C", "4H", "4S", "8D"};
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        assertEquals(HandRank.FULL_HOUSE,bh.lastKey());
        assertEquals(HandRank.FOUR_OF_A_KIND,wh.lastKey());
        assertEquals("White wins", c.compareHands(bh, wh));
    }
}
