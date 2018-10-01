
public class Rectangle {
		private LineSegment ls1;
		private LineSegment ls2;

		public Rectangle(LineSegment ls1, LineSegment ls2) throws LineSegmentsNotPerpendicularException, LineSegmentsNotAdjacentException {
			if (ls1.isPerpendicularTo(ls2)) {
				if (ls1.oneCommonEndpoint(ls2)) {
					this.ls1 = ls1;
					this.ls2 = ls2;
				}
				else {
					throw new LineSegmentsNotAdjacentException("These line segments are not adjacent. Cannot build a rectangle.");
				}
				
			} else {
				throw new LineSegmentsNotPerpendicularException("These line segments are not perpendicular. Cannot build a rectangle.");
			}
		}

		public double area() {
			return this.ls1.length() * this.ls2.length();
		}
		
		public double perimeter() {
			return this.ls1.length()*2 + this.ls2.length()*2;
		}
		
		public LineSegment getLs1() {
			return ls1;
		}

		public LineSegment getLs2() {
			return ls2;
		}

		@Override
		public boolean equals(Object obj) {
			boolean answer = false;
			if ((obj instanceof Rectangle)) {
			}
			Rectangle rec = (Rectangle) obj;
			if((this.ls1.length()==rec.getLs1().length()) && (this.ls2.length()==rec.getLs2().length())) {
				answer = true;
			}
			else {
				answer = false;
			}
			return answer;
		}

		@Override
		public String toString() {
			return "Rectangle = " + this.ls1 + " and " + this.ls2;
		}
		
		
}
