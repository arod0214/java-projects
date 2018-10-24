import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RepaintOnClick implements MouseListener {

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Component source = (Component) e.getSource();
		source.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
