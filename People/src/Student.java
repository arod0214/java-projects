
public class Student extends Person {

	private int emplid;
	private Course[] courses = new Course[5];
	private int numberOfCourses;

	public Student(String firstName, String lastName, int height, int birthMonth, int birthDay, int birthYear, int emplid) {
		super(firstName, lastName, height, birthMonth, birthDay, birthYear);
		this.emplid = emplid;
		this.numberOfCourses = 0;
	}
	
	public void addCourse(Course course) {
		if (this.numberOfCourses < this.courses.length) {
			this.courses[numberOfCourses] = course;
			numberOfCourses++;
			System.out.println("Name = " + super.getFirstName() + " Number Of Courses = " + this.numberOfCourses);
		} else {
			System.out.println("Unable to add course " + course + " Student already has 5 courses");
		}
	}

	
	
	
	public int getEmplid() {
		return emplid;
	}

	@Override
	public boolean equals(Object obj) {
		boolean answer = super.equals(obj);
		
		if (answer && obj instanceof Student) {
			Student s = (Student) obj;
			
			answer = this.emplid == s.getEmplid();
		}
		
		
		return answer;
	}

	@Override
	public String toString() {
		String s = super.toString();
		
		s = s + "emplid    = " + this.emplid + "\n";
		
		for ( int i = 0 ; i < this.numberOfCourses ; i++ ) {
			s = s + this.courses[i] + "\n";
		}
		
		return s;
	}
	
	
	
	
	
}
