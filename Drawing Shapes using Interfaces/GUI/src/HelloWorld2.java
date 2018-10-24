import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HelloWorld2 {

	private static class HelloWorldDisplay extends JPanel {
		private String text = "Hello World!!";

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Color c1 = new Color(95, 34, 216);
			g.setColor(c1);
			g.drawString(text, 20 , 30);
			c1 = new Color(200, 14, 63);
			g.setColor(c1);
			g.drawLine(100, 100, 300, 300);
			g.drawRect(300, 300, 100, 40);
			g.drawString("WOW", 320, 320);
		}
	}

	
	private static class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	
	
	public static void main(String[] args) {
		HelloWorldDisplay displayPanel = new HelloWorldDisplay();

		JButton okButton = new JButton("OK");
		ButtonHandler listener = new ButtonHandler();
		okButton.addActionListener(listener);
		
		JPanel content = new JPanel();
		content.setLayout(new BorderLayout());
		content.add(displayPanel, BorderLayout.CENTER);
		content.add(okButton, BorderLayout.SOUTH);
		
		
		JFrame window = new JFrame("GUI 2");
		window.setContentPane(content);
		window.setSize(500, 500);
		window.setLocation(300, 300);
		window.setVisible(true);
		
	}

}
