package p1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Barry Al-Jawari
 *
 */

public class Viewer extends JPanel implements Observer {
	private JLabel lblIcon = new JLabel();
	private IconManager icon;
	
	public Viewer(IconManager iconManager, int width, int height) {
		setLayout(new FlowLayout(FlowLayout.CENTER));
		lblIcon.setOpaque(true);
		add(lblIcon);
		setPreferredSize(new Dimension(width,height));
		this.icon = iconManager;
		this.icon.addObserver(this);

	
	}
	
	public void setIcon(Icon icon) {
		lblIcon.setIcon(icon);
	}

	public void update(Observable o, Object obj) {
		Icon icon = (Icon)obj;
		setIcon(icon);
	}
}
