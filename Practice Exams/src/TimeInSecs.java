import java.util.Scanner;
public class TimeInSecs {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter number of hours:");
		int h = scnr.nextInt();
		System.out.println("Enter number of minutes");
		int m = scnr.nextInt();
		int s = (h *60)*60 + m*60;
		
		System.out.println("Seconds = " + s);
		scnr.close();
		

	}

	
	
}
