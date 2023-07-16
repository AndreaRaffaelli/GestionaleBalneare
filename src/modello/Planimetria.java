package modello;

import java.util.HashMap;
import java.util.Map;

//Ho aggiunto setPosizione

// Classe Planimetria
public class Planimetria {
	private int colonne;
	private int righe;
	private Map<Integer, Posizione> posizioni;
	private static Planimetria instance;

	private Planimetria() {
		posizioni = new HashMap<Integer, Posizione>();
	}

	public static Planimetria getInstance() {
		if (instance == null) {
			instance = new Planimetria();
		}
		return instance;
	}

	public Posizione getPosizione(int id) {
		if (id < 0 || id > righe * colonne) {
			return this.posizioni.get(id);
		} else
			return null;
	}

	public void setPosizione(int id, Posizione p) {
		if (id > 0 && id < righe * colonne) {
			this.posizioni.put(id, p);
		}
	}

	/***
	 *  Imposta che una cella non è prenotabile. Se viene chiesto di ottenere quella cella
	 *  viene restituito PosizioneNonPrenotabile, che estende Posizione
	 * 
	 */
	public boolean setNonPrenotabile(int id) {
		if (this.posizioni.containsKey(id)) {
			return false;
		}
		this.posizioni.put(id, new PosizioneNonPrenotabile(id));
		return true;
	}

	/***
	 * Implementazione per impostare la mappa della planimetria Ritorna true se
	 * l'operazione ha avuto successo, altrimenti false Lettura XML
	 */
	public boolean setMappa() {
		return true;
	}

	/***
	 * Implementazione per ottenere l'id della posizione in base alle coordinate
	 * Ritorna l'id della posizione o un valore speciale per indicare che la //
	 * posizione non esiste
	 */
	public int getId(int x, int y) {
		if (x < 0 || x > this.righe) {
			return -1;
		}
		if (y < 0 || y > this.colonne)
			return -1;
		else
			return righe * colonne;

	}

	// Altri metodi e attributi della classe Planimetria

}
