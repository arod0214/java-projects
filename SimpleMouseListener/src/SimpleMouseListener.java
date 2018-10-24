import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JApplet;
import javax.swing.JPanel;

public class SimpleMouseListener extends JApplet implements MouseListener, MouseMotionListener {

	Display display;
	int mouseX, mouseY;
	String modifierKeys = "";
	String eventType = null;
	
	
	public class Display extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
			g.drawRect(1, 1, getSize().width - 3, getSize().height - 3);
			g.setColor(Color.red);
			if (eventType == null) {
				return; // nothing to do
			}
			g.drawString("Mouse Event Type = " + eventType, 6, 18);
			if (modifierKeys.length() > 0) {
				g.drawString("Modifer Keys     = " + modifierKeys, 6, 34);
			}
			g.setColor(Color.black);
			g.drawString("(" + mouseX + ", " + mouseY + ")", 6, 50);
		}
	}
	
	void setInfo(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		modifierKeys = "";
		if (e.isShiftDown()) {
			modifierKeys += "Shift ";
		}
		if (e.isControlDown()) {
			modifierKeys += "Control ";
		}
		if (e.isAltDown()) {
			modifierKeys += "Alt ";
		}
		if (e.isMetaDown()) {
			modifierKeys += "Meta "; 
		}
		display.repaint();
	}
	
	
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		eventType = " Mouse Dragged";
		setInfo(e);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		eventType = " Mouse Moved";
		setInfo(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		eventType = "Mouse Clicked";
		setInfo(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		eventType = "Mouse Pressed";
		setInfo(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		eventType = "Mouse Released";
		setInfo(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		eventType = "Mouse Entered";
		setInfo(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		eventType = "Mouse Exited";
		setInfo(e);
	}

	
	
	
	
	
	
	public void init() {
		display = new Display();
		setContentPane(display);
		display.setBackground(Color.yellow);
		display.addMouseListener(this);
		display.addMouseMotionListener(this);
	}

}
