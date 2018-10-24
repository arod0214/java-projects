
public class Test {

	public static void main(String[] args) {
		Student s1 = new Student("Sameh", "Fakhouri", 73, 11, 19, 1953, 2356783);
		Student s2 = new Student("John", "Smith", 80, 11, 19, 2001, 43245456);
		Student s3 = new Student("Sameh", "Fakhouri", 73, 11, 19, 1953, 2356783);
		
		System.out.println("S1 = " + s1);
		System.out.println("S2 = " + s2);
 		
		System.out.println("s1 == s2 is " + s1.equals(s2));
		System.out.println("s1 == s3 is " + s1.equals(s3));
		
		
		Course c1 = new Course("CMP", 326, 4, 4);
		Course c2 = new Course("MAT", 172, 4, 4);
		Course c3 = new Course("CIS", 211, 3, 4);
		Course c4 = new Course("BIO", 313, 4, 4);
		Course c5 = new Course("ENG", 212, 3, 3);
		Course c6 = new Course("ANT", 444, 3, 3);
		
		s1.addCourse(c1);
		s1.addCourse(c2);
		
		s2.addCourse(c1);
		s2.addCourse(c2);
		s2.addCourse(c3);
		s2.addCourse(c4);
		s2.addCourse(c5);
		s2.addCourse(c6);

		
		System.out.println("S1 = " + s1);
		System.out.println("S2 = " + s2);

	}

}
