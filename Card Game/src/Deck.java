
public class Deck {

	private Card[] deck = new Card[52];
	
	private int numCards;
	
	public Deck() {
		int index = 0;
		for ( int suit = Card.FIRST_SUIT ; suit <= Card.LAST_SUIT ; suit++ ) {
			for ( int value = Card.FIRST_VALUE ; value <= Card.LAST_VALUE ; value++ ) {
				Card card = new Card(suit, value);
				this.deck[index] = card;
				index++;
			}
		}
		
		this.numCards = 52;
	}
	
	
	public void shuffle() {
		for ( int cur = 0 ; cur < this.numCards ; cur++ ) {
			int rand = (int) (Math.random() * (this.numCards));
			
			Card temp = this.deck[cur];
			this.deck[cur] = this.deck[rand];
			this.deck[rand] = temp;
		}
	}
	
	
	
	
	public Card deal() throws DeckIsEmptyException {
		if (this.numCards > 0) {
			this.shuffle();
			Card c = this.deck[this.numCards - 1];
			this.numCards--;
			
//			if ((c.getSuit() == Card.CLUBS) && (c.getValue() == 2)) {
//				throw new Exception("You drew the lowest card in the deck");/
//			}
			
			
			
			return c;
		} else {
			throw new DeckIsEmptyException("No More Cards In Deck");
		}
		
	}
	
	
	
	public void reset() {
		this.numCards = 52;
	}
	

	@Override
	public String toString() {
		String s = new String();
		for ( int i = 0 ; i < deck.length ; i++ ) {
			s = s + this.deck[i] + "\n";
		}
		return s;
	}
	
	
	
	
	
	
}
