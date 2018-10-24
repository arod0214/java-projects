
public class Driver {

	public static void main(String[] args) {
		MyArray<String> mas = new MyArray<String>(20);
		
		try {
			mas.addElement("String 1");

		} catch (ArrayIsFullException e) {
			
		}
		
		MyArray<Integer> mai = new MyArray<Integer>(10);
		
		try {
			mai.addElement(new Integer(6));
		} catch (ArrayIsFullException e) {
			
		}
	}

}
