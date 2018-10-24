
public class Test {

	public static void main(String[] args) {
		Point origin = new Point(0, 0);
		Point p1 = new Point(1,1);
		Point p2 = new Point(1,1);
		Point p3 = new Point(0,0);
		Point p4 = p1;
		
		System.out.println("origin = " + origin);
		origin.setX(5.0);
		origin.setY(19.4);;
		System.out.println("origin = " + origin);
		
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		System.out.println("p3 = " + p3);
		System.out.println("p4 = " + p4);
		
		
		
		System.out.println("the number of points = " + Point.getNumberOfPoints());
		
		
		if (p1.equals(p2)) {
			System.out.println("p1 is equal to p2");
		} else {
			System.out.println("p1 is not equal to p2");
		}
		
		if (p1.equals(p4)) {
			System.out.println("p1 is equal to p4");
		} else {
			System.out.println("p1 is not equal to p4");
		}
		
		
	}

}
