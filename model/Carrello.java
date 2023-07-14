package modello;

import java.util.ArrayList;
import java.util.List;

// Classe Carrello
public class Carrello {
	private List<Prenotazione> prenotazioni;
	private int totale;

	public Carrello() {
		prenotazioni = new ArrayList<Prenotazione>();
		totale = 0;
	}

	public boolean isPagato() {
		boolean result = true;
		for (var p : prenotazioni) {
			if (p.isSaldoEffettuato() == false) {
				result = false;
				break;
			}
		}
		return result;
	}

	public int quantoDaSaldare() {
		int result = 0;
		for (var p : prenotazioni) {
			if (p.isSaldoEffettuato() == false) {
				result += p.getCosto() - p.getPagato();
			}
		}
		return result;
	}

	public void addPrenotazione(Prenotazione prenotazione) {
		// Aggiunge una prenotazione al carrello
		prenotazioni.add(prenotazione);
		totale += prenotazione.getCosto();
	}

	public void removePrenotazione(Prenotazione prenotazione) {
		// Rimuove una prenotazione dal carrello
		prenotazioni.remove(prenotazione);
		totale -= prenotazione.getCosto();
	}
	
}