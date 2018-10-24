import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class RandomStringPanel extends JPanel {
	
	private String message;
	private Font f1, f2, f3, f4, f5;
	
	
	public RandomStringPanel() {
		this(null);
	}
 	
	public RandomStringPanel(String message) {
		if (message == null) {
			this.message = "Default Message";
		} else {
			this.message = message; 
		}
		
		f1 = new Font("Serif", Font.BOLD, 14);
		f2 = new Font("SansSerif", Font.BOLD+Font.ITALIC, 24);
		f3 = new Font("Monospaced", Font.PLAIN, 30);
		f4 = new Font("Dialog", Font.PLAIN, 36);
		f5 = new Font("Serif", Font.ITALIC, 48);
		
		setBackground(Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int width = getWidth();
		int height = getHeight();
		
		for ( int i = 0 ; i < 15 ; i++ ) {
			int fontNum = (int) (Math.random() * 5) + 1;
			
			switch (fontNum) {
			case 1:
				g.setFont(f1);
				break;
			case 2:
				g.setFont(f2);
				break;
			case 3:
				g.setFont(f3);
				break;
			case 4:
				g.setFont(f4);
				break;
			case 5:
				g.setFont(f5);
				break;
			}
			
			float hue = (float) Math.random();
			g.setColor(Color.getHSBColor(hue, 1.0F, 1.0F));
			
			int x, y;
			
			x = -50 + (int) (Math.random()*(width+40));
			y = (int) (Math.random()*(height+20));
			
			g.drawString(this.message, x, y);
		}
	}
}
