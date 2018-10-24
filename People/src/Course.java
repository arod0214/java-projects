
public class Course {

	private String department;
	private int number;
	private int credits;
	private int hours;
	
	public Course(String department, int number, int credits, int hours) {
		super();
		this.department = department;
		this.number = number;
		this.credits = credits;
		this.hours = hours;
	}
	

	@Override
	public String toString() {
		return this.department + "-" + this.number + " Credits = " + this.credits + " Hours = " + this.hours;
	}
	
}
