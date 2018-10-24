public class Line {
	private double slope;
	private double yIntercept;
	
	public Line(double slope, double yIntercept) {
		this.slope = slope;
		this.yIntercept = yIntercept;
	}
	
	public Line(Point p1, Point p2) {
		double dy = p2.getY() - p1.getY();
		double dx = p2.getX() - p1.getX();
		
		this.slope = dy/dx;
		
		this.yIntercept = (p1.getY() - this.slope * p1.getX());
	}

	public double getSlope() {
		return slope;
	}

	public void setSlope(double slope) {
		this.slope = slope;
	}

	public double getyIntercept() {
		return yIntercept;
	}

	public void setyIntercept(double yIntercept) {
		this.yIntercept = yIntercept;
	}
	
	public boolean isParallelTo(Line line) {
		double slope2 = line.getSlope();
		double yIntercept2 = line.getyIntercept();
		
		return (slope == slope2) && (yIntercept != yIntercept2);
	}
		
	public boolean isPerpendicularTo(Line line) {
		double slope2 = line.getSlope();
		
		return slope == -(1/slope2);
	}
	
	public Point intersection(Line line) {
		if ((!this.equals(line)) && (!this.isParallelTo(line))) {
			
			double xi = (line.yIntercept - this.yIntercept) / (this.slope - line.slope);
			double yi = this.slope * xi + this.yIntercept;
			Point pi = new Point(xi,yi);
		
		return pi;
		}
		return null;
	}
		
	
	public boolean pointIsOnTheLine(Point p) {
		boolean answer = false;
		if (p.getY() == (this.slope * p.getX() + this.yIntercept)) {
			answer = true;
			
		}
		
		else {
			answer = false;	
				
		}
				
		return answer;
	}
	
	public void updateLine(Point p1, Point p2) {
		double dy = p2.getY() - p1.getY();
		double dx = p2.getX() - p1.getX();
		
		this.slope = dy/dx;
		
		this.yIntercept = (p1.getY() - this.slope * p1.getX());		
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean answer = false;

		if (obj instanceof Line) {
			Line l = (Line) obj;
			
			if ((this.slope == l.getSlope()) && (this.yIntercept == l.getyIntercept())) {
				answer = true;
			}
		}
		
		return answer;
	}

	@Override
	public String toString() {
		return "Y = " + this.slope + " * X + " + this.yIntercept;
	}
	
	
	
}
