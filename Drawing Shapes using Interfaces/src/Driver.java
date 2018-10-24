
public class Driver {
	
	
	public static void show(DrawInterface di) {
		di.draw();
	}

	public static void main(String[] args) {
		Square s1 = new Square();
		Rectangle r1 = new Rectangle();

		show(r1);
		show(s1);
		
		RoundedRectangle rr = new RoundedRectangle();
	}

}
