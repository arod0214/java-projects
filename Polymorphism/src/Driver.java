
public class Driver {
	
	public static void show (A a) {
		
	}
	
	public static void show (B b) {
		
	}
	
	public static void show (C c) {
		
	}
	
	public static void show (Object o) {
		
		if (o instanceof A) {
			A a = (A) o;
			System.out.println(a.getLength());
		} else if (o instanceof B) {
			B b = (B) o;
			System.out.println(b.getLength());
		} else if (o instanceof C) {
			C c = (C) o;
		}
		
		System.out.println(o);
	}
	
	

	public static void main(String[] args) {

		A a1, a2;
		
		a1 = new A("a1", "Cyan", 5);
		a2 = new A("a2", "Blue", 7);
		
		System.out.println(a1);
		System.out.println(a2);
		
		
		
		B b1, b2;
		
		b1 = new B("b1", "Red", 9, 3);
		b2 = new B("b2", "Purple", 11, 6);
		
		System.out.println(b1);
		System.out.println(b2);
		
		
		C c1, c2;
		
		c1 = new C("c1", "Yellow", 13, 4, 2);
		c2 = new C("c2", "Grey", 17, 9, 4);
		
		System.out.println(c1);
		System.out.println(c2);

		
		
		
		Object o1 = new Object();
		Object o2 = new Object();

		System.out.println(o1);
		System.out.println(o2);

		
		o1 = a1;
		
		System.out.println(o1);
		
		
		o1 = b2;
		
		System.out.println(o1);
		
		show(o1);
	}

}
