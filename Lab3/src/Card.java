
public class Card {
	
	private int VALUE;
	private String RANK;
	private String SUIT;
	
	public Card(String suit, String rank, int value) {
		RANK = rank;
		SUIT = suit;
		VALUE = value;
	}
	public String getSuit() {
		return SUIT;
	}
	public String getRank() {
		return RANK;
	}
	public int getValue() {
		return VALUE;
	}
}
