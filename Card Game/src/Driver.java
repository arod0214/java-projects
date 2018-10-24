
public class Driver {

	public static void main(String[] args) {
		Deck d = new Deck();
		int num = 1;
		
		
		while (true) {
			try {
				Card c = d.deal();
				System.out.println(num++ + " = " + c);
			} catch (DeckIsEmptyException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				d.reset();
				System.out.println();
				System.out.println();
			} catch (Exception e) {
				System.out.println("OMG Something wrong!!!");
				System.out.println(e.getMessage());
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
	
}
