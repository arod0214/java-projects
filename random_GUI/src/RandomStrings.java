import javax.swing.JFrame;

public class RandomStrings {

	public static void main(String[] args) {
		JFrame window = new JFrame("Fun With Strings");
		
		RandomStringPanel content = new RandomStringPanel("Java!");
		window.setContentPane(content);

		RepaintOnClick listener = new RepaintOnClick();
		content.addMouseListener(listener);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocation(120, 70);
		window.setSize(450, 350);
		window.setVisible(true);
	}

}
