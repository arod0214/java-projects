import java.util.Locale;
import java.util.Scanner;

public class HighLow {

	public static Deck deck;
	
	public static int score;
	
	
	public static void showCard(Card c) {
		System.out.println("Card = " + c);
	}
	
	
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		deck = new Deck();
		score = 0;
		
		Card nextCard = null;
		Card curCard = null;

		while (true) {
			try {
				if (nextCard == null) {
					curCard = deck.deal();
					showCard(curCard);
				} else {
					curCard = nextCard;
				}
				
				String line;
				char guess;
				do {
					System.out.println("Next Card H or L: ");
					line = scnr.nextLine();
					line = line.toUpperCase(Locale.US);
					guess = line.charAt(0);
				} while ((guess != 'H') && (guess != 'L'));
				
				nextCard = deck.deal();
				showCard(nextCard);
				
				if (nextCard.getValue() > curCard.getValue()) {
					if (guess == 'H') {
						score++;
						System.out.println("Correct!!");
						System.out.println("Score = " + score);
						continue;
					} else {
						break;
					}
				} else if (nextCard.getValue() < curCard.getValue()) {
					if (guess == 'L') {
						score++;
						System.out.println("Correct!!");
						System.out.println("Score = " + score);
						continue;
					} else {
						break;
					}
				} else {
					if (nextCard.getSuit() > curCard.getSuit()) {
						if (guess == 'H') {
							score++;
							System.out.println("Correct!!");
							System.out.println("Score = " + score);
							continue;
						} else {
							break;
						}
					} else if (nextCard.getSuit() < curCard.getSuit()) {
						if (guess == 'L') {
							score++;
							System.out.println("Correct!!");
							System.out.println("Score = " + score);
							continue;
						} else {
							break;
						}
					} else {
						break;
					}
				}
			} catch (DeckIsEmptyException e) {
				deck.reset();
			}
		}
		
		System.out.println("Game Over");
		System.out.println("Score = " + score);
		
		
		scnr.close();
	}

}
