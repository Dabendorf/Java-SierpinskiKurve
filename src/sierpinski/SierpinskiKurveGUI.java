package sierpinski;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Dies ist die Zeichenklasse des Projekts SierpinskiKurve, welche die Kurve graphisch darstellt.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class SierpinskiKurveGUI {
	
	/**Programmfenster*/
	private JFrame frame1 = new JFrame("Sierpinski-Kurve");
	/**Laenge der Linien*/
	private int linelength = 5;
	/**Objekt der SierpinskiKurveKlasse*/
	private SierpinskiKurve sk;
	/**X-Koordinate des Zeichenpunkts*/
	int x;
	/**Y-Koordinate des Zeichenpunkts*/
	int y;
	/**Richtung des Zeichenstifts*/
	int dir;
	/**JPanel, auf welchem die Kurve dargestellt wird*/
	private JPanel painter = new JPanel() {
		@Override
	    public void paintComponent(Graphics g) {
			x = 670;
			y = 20;
			dir = 0;//0 oben, 90 rechts, etc.
			for(char c:sk.getDirections()) {
				switch(c) {
				case 'a':
					for(int i=0;i<2;i++) {
						dir -= 90;
						if(dir==-90) {
							dir = 270;
						}
						paintSwitcher(g);
					}
					break;
				case 'b':
					for(int i=0;i<2;i++) {
						dir += 90;
						if(dir==360) {
							dir = 0;
						}
						paintSwitcher(g);
					}
					dir -= 90;
					if(dir==-90) {
						dir = 270;
					}
					paintSwitcher(g);
					break;
				}
			}
	    }
	};
	
	/**
	 * Diese Methode zeichnet die Linien abhaengig vom aktuellen Drehungswinkel.
	 * @param g GraphicsObject des JPanels
	 */
	private void paintSwitcher(Graphics g) {
		switch(dir) {
		case 0: g.drawLine(x, y, x, y-=linelength); break;
		case 90: g.drawLine(x, y, x+=linelength, y); break;
		case 180: g.drawLine(x, y, x, y+=linelength); break;
		case 270: g.drawLine(x, y, x-=linelength, y); break;
		}
	}
	
	public SierpinskiKurveGUI() {
		sk = new SierpinskiKurve(6);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setPreferredSize(new Dimension(720,720));
		//frame1.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame1.setResizable(false);
		
		Container cp = frame1.getContentPane();
		cp.setLayout(new GridLayout(1,1));
		cp.add(painter);
		
		frame1.pack();
		frame1.setLocationRelativeTo(null);
		frame1.setVisible(true);
	}

	public static void main(String[] args) {
		new SierpinskiKurveGUI();
	}
}