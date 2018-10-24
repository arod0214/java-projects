
public class Test {

	public static void doSomething(SumInterface si) {
		System.out.println("sum = " + si.sum(5, 4));
	}

	public static void doAnotherThing(DiffInterface di) {
		System.out.println("diff = " + di.diff(5, 4));
	}

	public static void main(String[] args) {
		Summer summer = new Summer();

		System.out.println("sum = " + summer.sum(8, 9));
		System.out.println("diff = " + summer.diff(18, 7));

		doSomething(summer);
		doAnotherThing(summer);
	}

}
