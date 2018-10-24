import java.util.Scanner;

public class CharSwap {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please enter a string");
		String s = scnr.next();
		char[] c = new char[s.length()];
		for(int i=0; i < s.length(); i+=2) {
			c[i]=s.charAt(i+1);
			c[i+1] = s.charAt(i);
		}

		StringBuilder newS = new StringBuilder();
		newS.append(c);
		System.out.println("Output:" + newS.toString());


		scnr.close();


	}


}


