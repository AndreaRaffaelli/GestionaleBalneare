package modello;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

public class PosizioneNonPrenotabile extends Posizione {

	public PosizioneNonPrenotabile(int numero) {
		super(numero);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isOccupato(Periodo periodo) {
		return true;
	}

	@Override
	public Prenotazione getPrenotazioneBy(LocalDate data) {
		return null;
	}

	@Override
	public boolean addPrenotazione(Periodo periodo, Prenotazione prenotazione) {
		return false;
	}

	public void removePrenotazione(Periodo periodo) {
	}

	@Override
	public String toString() {

		return "Posizione Non Prenotabile numero: "+ super.getNumero();
	}
}
