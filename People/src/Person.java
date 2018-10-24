
public class Person {
	
	private static int numberOfPeople = 0;
	
	private String firstName;
	private String lastName;
	
	private int height;
	
	private int birthMonth;
	private int birthDay;
	private int birthYear;
	
	public Person(String firstName, String lastName, int height, int birthMonth, int birthDay, int birthYear) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.height = height;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;
		this.birthYear = birthYear;
		
		numberOfPeople++;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public static int getNumberOfPeople() {
		return numberOfPeople;
	}
	public int getBirthMonth() {
		return birthMonth;
	}
	public int getBirthDay() {
		return birthDay;
	}
	public int getBirthYear() {
		return birthYear;
	}
	
	@Override
	public String toString() {
		return "First Name  = " + this.firstName + "\n" +
			   "Last Name   = " + this.lastName + "\n" +
			   "Height      = " + this.height + "\n" +
			   "Birth Month = " + this.birthMonth + "\n" +
			   "Birth Day   = " + this.birthDay + "\n" +
			   "Birth Year  = " + this.birthYear + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		boolean answer = false;
		
		if (obj instanceof Person) {
			Person p = (Person) obj;
			
			answer = this.firstName.equals(p.getFirstName()) &&
					 this.lastName.equals(p.getLastName()) &&
					 this.height == p.getHeight() &&
					 this.birthDay == p.getBirthDay() &&
					 this.birthMonth == p.getBirthMonth() &&
					 this.birthYear == p.getBirthYear();
		}
		
		return answer;
	}
	
	
	

}
