import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawShapes {

	private static HelloWorldDisplay displayPanel;
	private static JButton okButton;
	
	private static class HelloWorldDisplay extends JPanel {
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Color c1 = new Color(95, 34, 216);
			g.setColor(c1);
			g.drawLine(100, 100, 300, 300);
			g.drawRect(300, 300, 100, 40);
			g.drawOval(150, 200, 50, 20);
			g.drawOval(150, 300, 100, 100);
			g.drawRoundRect(300, 200, 50, 40, 6, 6);
			g.fillRect(300, 400, 100, 40);
			c1 = new Color(244, 72, 66);
			g.setColor(c1);
			g.drawRect(300, 400, 100, 40);
		}
	}
	
	private static class ButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
				System.exit(0);
		}
	}
	
	
	
	public static void main(String[] args) {
		displayPanel = new HelloWorldDisplay();
		okButton = new JButton("Exit");
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
