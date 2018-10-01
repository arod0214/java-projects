
public class Square {
	private LineSegment ls1;
	private LineSegment ls2;	
	
	public Square(LineSegment ls1, LineSegment ls2) throws LineSegmentsNotPerpendicularException, LineSegmentsNotAdjacentException, LineSegmentsUnequalException {
		if (!ls1.isPerpendicularTo(ls2)) {
			throw new LineSegmentsNotPerpendicularException("These line segments are not perpendicular. Cannot build a square.");
		}

		if (!ls1.oneCommonEndpoint(ls2)) {
			throw new LineSegmentsNotAdjacentException("These line segments are not adjacent. Cannot build a square.");
		}
		if (ls1.length() != ls2.length()) {
			throw new LineSegmentsUnequalException("These line segments are unequal. Cannot build a square.");
		}
		this.ls1 = ls1;
		this.ls2 = ls2;

	}

	public LineSegment getLs1() {
		return ls1;
	}
	
	public LineSegment getLs2() {
		return ls2;
	}

	public double area() {
		return Math.pow(this.ls1.length(),2);
	}
	
	public double perimeter() {
		return this.ls1.length()*4;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean answer = false;
		if ((obj instanceof Square)) {
		}
		Square sq = (Square) obj;
		if((this.ls1.length()==sq.getLs1().length()) && (this.ls2.length()==sq.getLs2().length())) {
			answer = true;
		}
		else if ((this.ls2.length() == sq.getLs1().length()) && (this.ls1.length() == sq.getLs2().length())) {
			answer = true;
		}else {
			answer = false;
		}
		return answer;
	}


	@Override
	public String toString() {
		return "Square = " + this.ls1 + " and " + this.ls2;
	}
	
	
}
