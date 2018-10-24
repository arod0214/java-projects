
public class Card {

	public final static int CLUBS = 0;
	public final static int DIAMONDS = 1;
	public final static int HEARTS = 2;
	public final static int SPADES = 3;
	
	public final static int FIRST_SUIT = CLUBS;
	public final static int LAST_SUIT = SPADES;
	
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	public final static int ACE = 14;
	
	public final static int FIRST_VALUE = 2;
	public final static int LAST_VALUE = ACE;
	
	/***********************************************/
	
	private int suit;
	private int value;
	
	/***********************************************/
	
	public Card(int suit, int value) {
		this.suit = suit;
		this.value = value;
	}

	public int getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}

	public String getSuitAsString() {
		String s;
		
		switch (this.suit) {
		case Card.CLUBS:
			s = "Clubs";
			break;
		case Card.DIAMONDS:
			s = "Diamonds";
			break;
		case Card.HEARTS:
			s = "Hearts";
			break;
		case Card.SPADES:
			s = "Spades";
			break;
		default:
			s = "Invalid Suit";
			break;
		}
		
		return s;
	}
	
	public String getValueAsString() {
		String s;
		
		switch (this.value) {
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			s = "" + this.value;
			break;
		case 11:
			s = "Jack";
			break;
		case 12:
			s = "Queen";
			break;
		case 13:
			s = "King";
			break;
		case 14:
			s = "Ace";
			break;
		default:
			s = "Invalid Value";
			break;
		}
		
		return s;
	}
	
	@Override
	public String toString() {
		return getValueAsString() + " of " + getSuitAsString() ;
	}
	
	
	
	
}
