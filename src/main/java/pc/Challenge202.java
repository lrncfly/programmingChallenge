package pc;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import pc.Card.Rank;
import pc.Card.Suit;

public class Challenge202 {

    public static void main(String[] args) {
        String[] hands = new String[] { "2H", "3D", "5S", "9C", "KD", "2C", "3H", "4S", "8C", "AH" };

        Challenge202 c = new Challenge202();
        SortedMap<HandRank, List<Card>> bh = c.evaluateHand(Arrays.copyOfRange(hands, 0, 5));
        SortedMap<HandRank, List<Card>> wh = c.evaluateHand(Arrays.copyOfRange(hands, 5, hands.length));
        String winner = c.compareHands(bh, wh);
        System.out.println(winner);
    }

    SortedMap<HandRank, List<Card>> evaluateHand(String[] cardsAsStrings) {
        SortedMap<Card.Suit, List<Card>> cardsBySuit = Collections.synchronizedSortedMap(new TreeMap<>());
        SortedMap<Card.Rank, List<Card>> cardsByValue = Collections.synchronizedSortedMap(new TreeMap<>());
        SortedMap<HandRank, List<Card>> cardsByRank = Collections.synchronizedSortedMap(new TreeMap<>());
        List<Card> cards = new LinkedList<>();
        for (String card : cardsAsStrings) {
            Rank value = Rank.byShortString(card.substring(0, card.length() - 1));
            Suit suit = Suit.byShortString(card.substring(card.length() - 1, card.length()));
            Card c = new Card(value, suit);
            cards.add(c);
            if (!cardsByValue.containsKey(value))
                cardsByValue.put(value, new LinkedList<>());
            cardsByValue.get(value).add(c);
            if (!cardsBySuit.containsKey(suit))
                cardsBySuit.put(suit, new LinkedList<>());
            cardsBySuit.get(suit).add(c);
        }

        if (cardsBySuit.keySet().size() == 1) {
            // one suit means straight flush or flush
            if (isStraight(cardsByValue)) {
                if (!cardsByRank.containsKey(HandRank.STRAIGHT_FLUSH))
                    cardsByRank.put(HandRank.STRAIGHT_FLUSH, new LinkedList<>());
                cardsByRank.get(HandRank.STRAIGHT_FLUSH).addAll(cards);
            }
            if (!cardsByRank.containsKey(HandRank.FLUSH))
                cardsByRank.put(HandRank.FLUSH, new LinkedList<>());
            cardsByRank.get(HandRank.FLUSH).addAll(cards);
        }
        if (cardsByValue.keySet().size() == 5) {
            // five different ranked cards is either a straight or high card
            if (isStraight(cardsByValue)) {
                if (!cardsByRank.containsKey(HandRank.STRAIGHT))
                    cardsByRank.put(HandRank.STRAIGHT, new LinkedList<>());
                cardsByRank.get(HandRank.STRAIGHT).addAll(cards);
            } else {
                if (!cardsByRank.containsKey(HandRank.HIGH_CARD))
                    cardsByRank.put(HandRank.HIGH_CARD, new LinkedList<>());
                cardsByRank.get(HandRank.HIGH_CARD).addAll(cards);
            }
        }
        for (Rank r : cardsByValue.keySet()) {
            if (cardsByValue.get(r).size() == 4) {
                if (!cardsByRank.containsKey(HandRank.FOUR_OF_A_KIND))
                    cardsByRank.put(HandRank.FOUR_OF_A_KIND, new LinkedList<>());
                cardsByRank.get(HandRank.FOUR_OF_A_KIND).addAll(cardsByValue.get(r));
            } else if (cardsByValue.get(r).size() == 3) {
                if (!cardsByRank.containsKey(HandRank.THREE_OF_A_KIND))
                    cardsByRank.put(HandRank.THREE_OF_A_KIND, new LinkedList<>());
                cardsByRank.get(HandRank.THREE_OF_A_KIND).addAll(cardsByValue.get(r));
            } else if (cardsByValue.get(r).size() == 2) {
                if (!cardsByRank.containsKey(HandRank.PAIR))
                    cardsByRank.put(HandRank.PAIR, new LinkedList<>());
                cardsByRank.get(HandRank.PAIR).addAll(cardsByValue.get(r));
            } else if (cardsByValue.get(r).size() == 1) {
                if (!cardsByRank.containsKey(HandRank.HIGH_CARD))
                    cardsByRank.put(HandRank.HIGH_CARD, new LinkedList<>());
                cardsByRank.get(HandRank.HIGH_CARD).addAll(cardsByValue.get(r));
            }
        }

        if (cardsByRank.containsKey(HandRank.THREE_OF_A_KIND) && cardsByRank.containsKey(HandRank.PAIR)) {
            if (!cardsByRank.containsKey(HandRank.FULL_HOUSE))
                cardsByRank.put(HandRank.FULL_HOUSE, new LinkedList<>());
            cardsByRank.get(HandRank.FULL_HOUSE).addAll(cards);
        }
        if (cardsByRank.containsKey(HandRank.PAIR) && cardsByRank.get(HandRank.PAIR).size() == 4) {
            if (!cardsByRank.containsKey(HandRank.TWO_PAIRS))
                cardsByRank.put(HandRank.TWO_PAIRS, new LinkedList<>());
            cardsByRank.get(HandRank.TWO_PAIRS).addAll(cardsByRank.get(HandRank.PAIR));
        }

        return cardsByRank;
    }

    private boolean isStraight(Map<Rank, List<Card>> cardsByValue) {
        if (cardsByValue.size() < 5)
            return false;
        Rank[] cards = cardsByValue.keySet().toArray(new Rank[5]);
        Arrays.sort(cards);
        if (cards[4].getRankValue() - cards[0].getRankValue() == 4)
            return true;
        return false;
    }

    public String compareHands(SortedMap<HandRank, List<Card>> bh, SortedMap<HandRank, List<Card>> wh) {
        String winner = "Tie";
        int comparisson = 0;
        while (comparisson == 0 && bh.size() > 0 && wh.size() > 0) {
            comparisson = bh.lastKey().compareTo(wh.lastKey());
            if (comparisson > 0) {
                winner = "Black wins";
                break;
            } else if (comparisson < 0) {
                winner = "White wins";
                break;
            }
            else {
                comparisson = compareCards(bh.get(bh.lastKey()), wh.get(wh.lastKey()));
                if (comparisson > 0) {
                    winner = "Black wins";
                    break;
                } else if (comparisson < 0) {
                    winner = "White wins";
                    break;
                }
                bh.remove(bh.lastKey());
                wh.remove(wh.lastKey());
            }
        }
        return winner;
    }

    private int compareCards(List<Card> bh, List<Card> wh) {
        int comparison = 0;
        for (int i = bh.size() -1; i >=0; i --) {
            comparison = bh.get(i).compareTo(wh.get(i));
            if (comparison != 0)
                break;
        }
        return comparison;
    }

    enum HandRank {
        HIGH_CARD,
        PAIR,
        TWO_PAIRS,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH
    };
}

class Card implements Comparable<Card> {
    public enum Rank {
        DEUCE("2", 2),
        THREE("3", 3),
        FOUR("4", 4),
        FIVE("5", 5),
        SIX("6", 6),
        SEVEN("7", 7),
        EIGHT("8", 8),
        NINE("9", 9),
        TEN("10", 10),
        JACK("J", 11),
        QUEEN("Q", 12),
        KING("K", 13),
        ACE("A", 14);

        private static Map<String, Rank> map = new HashMap<>();

        static {
            for (Rank r : Rank.values()) {
                map.put(r.rank, r);
            }
        }
        private String rank;
        private int rankValue;

        Rank(String rank, int value) {
            this.rank = rank;
            this.rankValue = value;
        }

        int getRankValue() {
            return this.rankValue;
        }

        public static Rank byShortString(String rank) {
            return map.get(rank);
        }
    }

    public enum Suit {
        CLUBS("C"), DIAMONDS("D"), HEARTS("H"), SPADES("S");
        private static Map<String, Suit> map = new HashMap<>();

        static {
            for (Suit r : Suit.values()) {
                map.put(r.suit, r);
            }
        }

        private String suit;

        Suit(String suit) {
            this.suit = suit;
        }

        public static Suit byShortString(String suit) {
            return map.get(suit);
        }
    }

    private final Rank rank;
    private final Suit suit;

    Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank rank() {
        return rank;
    }

    public Suit suit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int compareTo(Card o) {
        return this.rank.rankValue - o.rank.rankValue;
    }
}
