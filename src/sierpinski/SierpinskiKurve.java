package sierpinski;

import java.util.ArrayList;

/**
 * Dies ist die Klasse des Projekts SierpinskiKurve, welche die Schritte der Kurve fuer eine bestimmte Laenge berechnet.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class SierpinskiKurve {
	
	/**Liste der Richtungshaken*/
	private ArrayList<Character> directions = new ArrayList<Character>();
	
	public SierpinskiKurve(int gene) {
		directions.add('a');
		directions.add('a');
		for(int i=0;i<gene;i++) {
			nextGeneration();
		}
	}
	
	/**
	 * Diese Methode macht aus der aktuellen SierpinskiKurve die naechste Generation einer SierpinskiKurve.
	 */
	private void nextGeneration() {
		for(int i=0;i<directions.size();i++) {
			switch(directions.get(i)) {
			case 'a':
				directions.set(i, 'a');
				directions.add(i+1,'b');
				directions.add(i+2,'a');
				directions.add(i+3,'b');
				break;
			case 'b':
				directions.set(i, 'b');
				directions.add(i+1,'b');
				directions.add(i+2,'a');
				directions.add(i+3,'b');
				break;
			}
			i+=3;
		}
	}

	public ArrayList<Character> getDirections() {
		return directions;
	}
}