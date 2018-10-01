
public class Test {
	public static void main (String[] args) {
		BubbleSort bs = new BubbleSort();
		Integer [] a = new Integer[] {10,9,300,29,12,3,54};
		
		bs.sort(a);
		for(int i = 0; i < a.length; i++) {
	       System.out.println("Element at index " + i + ": "+ a[i]);
	    }
	}
	
}
