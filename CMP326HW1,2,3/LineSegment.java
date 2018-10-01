public class LineSegment extends Line {
	
	private Point p1;
	private Point p2;

	public LineSegment(Point p1, Point p2) {
		super(p1, p2);
		this.p1 = p1;
		this.p2 = p2;
	}

	public Point getP1() {
		return p1;
	}

	public void setP1(Point p1) {
		this.p1 = p1;
	}

	public Point getP2() {
		return p2;
	}

	public void setP2(Point p2) {
		this.p2 = p2;
	}

	public boolean pointIsOnLineSegment(Point p) {
		boolean answer = false;
		if (super.pointIsOnTheLine(p)) {
			if ((p1.getX() <= p.getX()) && (p.getX() <= p2.getX()) && (p.getY() <= p2.getY()) && (p1.getY() <= p.getY())) {
				answer = true;
			}
			else {
				answer = false;
			}
		}
		else {
			answer = false;
		}
		
		return answer;
	}
	
	
	@Override
	public Point intersection(Line line) {

		if (super.intersection(line) != null) {

			Point cross = super.intersection(line);

			if (((cross.getX() >= this.getP1().getX()) && (cross.getX() <= this.getP2().getX()))
					|| ((cross.getX() <= this.getP1().getX()) && (cross.getX() >= this.getP2().getX()))) {

				return cross;
			}
		}

		return null;

	}


	public Point intersection(LineSegment lineSegment) {
		Point p = super.intersection(lineSegment);
		if (p!=null) {
			if(!pointIsOnLineSegment(p)){
				p = null; 
			}
			else {
				return p;
			}
		}
		else {
			return null;
		}
		
		return p;
	}
	
	public boolean oneCommonEndpoint(LineSegment lineSegment) {
		boolean answer = false;
		if (!this.equals(lineSegment)) { //line segments are the same
			answer = false;
			if (this.p1.equals(lineSegment.getP1()) || (this.p2.equals(lineSegment.getP2())) || (this.p2.equals(lineSegment.getP1())) || (this.p1.equals(lineSegment.getP2()))) {
				answer = true;
		}}
		return answer;
	}
	
	public double length() {
		double hor = java.lang.Math.abs(p1.getX()-p2.getX());
		double vert = java.lang.Math.abs(p1.getY() - p2.getY());
		double len = java.lang.Math.sqrt(Math.pow(hor, 2) + Math.pow(vert, 2));
		return len;
	}
	
	public Point midpoint() {
		double xi = (p1.getX()+p2.getX())/2;
		double yi = (p1.getY()+p2.getY())/2;
		Point xy = new Point(xi,yi);
		return xy;
	}
		
	@Override
	public boolean equals(Object obj) {
		boolean answer = false;
		if ((obj instanceof LineSegment)) {
		}
		LineSegment line = (LineSegment) obj;
		if (this.p1.equals(line.getP1()) && this.p2.equals(line.getP2())) {
			answer = true;
		}
		else if (this.p2.equals(line.getP1()) && this.p1.equals(line.getP2())) {
			answer = true;
		}else {
			answer = false;
		}
		return answer;
	}

		

	@Override
	public String toString() {
		return this.p1 + "-----" + this.p2;
	}

}
