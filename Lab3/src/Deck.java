import java.util.*;
public class Deck {
	private String SUITS[] = {"Diamonds", "Hearts", "Spades", "Clubs"};
	private String RANKS[] = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	//private int VALUE[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
	/**
	 * revised card values for blackjack. default card values are listed above in
	 * the first VALUE array.
	 */
	private int VALUE[] = {11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	private Stack<Card> DECK = new Stack<Card>();
	
	public Deck() {
		for(int i = 0; i < SUITS.length; i++) {
			for(int o = 0; o < RANKS.length; o++) {
				Card tempCard = new Card(SUITS[i], RANKS[o], VALUE[o]);
				DECK.push(tempCard);
			}
		}
	}
	public void Shuffle() throws EmptyStackException{
		Random rand = new Random();
		Card tempDeck[] = new Card[52];
		for(int i = 0; i < 52; i++) {
			tempDeck[i] = DECK.pop();
		}
		for(int o = 0; o < 52; o++) {
			int r = o +rand.nextInt(52 - o);
			Card temp = tempDeck[r];
			tempDeck[r] = tempDeck[o];
			tempDeck[o] = temp;
		}
		for(int i = 0; i < 52; i++) {
			DECK.push(tempDeck[i]);
		}
	}
	public Card deal() {
		return DECK.pop();
	}
	public int cardCount() {
		int count = DECK.size();
		return count;
	}
}
