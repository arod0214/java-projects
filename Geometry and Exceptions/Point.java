
public class Point {
	private double x;
	private double y;
	
	private static int numberOfPoints;
	
	
	// constructor
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		numberOfPoints++;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public static int getNumberOfPoints() {
		return numberOfPoints;
	}
	
	
	public void setX(double x) {
		this.x = x;
	}
	
	
	public void setY(double y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		boolean answer = false;

		if (obj instanceof Point) {
			Point p = (Point) obj;
			
			if ((this.x == p.getX()) && (this.y == p.getY())) {
				answer = true;
			}
		}
		
		return answer;
	}

	@Override
	public String toString() {
		String s = "(" + this.x + ", " + this.y + ")";
		return s;
	}
	
	

}
