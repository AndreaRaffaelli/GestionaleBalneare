package modello;

import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Prenotazione
public class Prenotazione {
	private int costo;
	private int quantoPagato;
	private Periodo periodo;
	private List<Oggetto> oggetti;

	public Prenotazione() {
		oggetti = new ArrayList<>();
		costo = 0;
		quantoPagato = 0;
	}

	public boolean isSaldoEffettuato() {
		return (quantoPagato == costo) ? true : false;
	}

	/**
	 * Paga il conto della prenotazione, totale o in parte
	 * 
	 * @param quantita soldi che vengono pagati
	 * @return resto da dare
	 */
	public int pagaConto(int quantita) {
		int result = 0;
		if ((costo - quantoPagato) > quantita) {
			quantoPagato += quantita;
			result = 0;
		} else {
			quantoPagato += quantita;
			result = quantoPagato - costo;
		}

		return result;
	}

	public int getCosto() {
		if (this.costo != 0)
			return this.costo;
		int result = 0;
		for (var o : this.oggetti) {
			result += o.getPrezzo(this.periodo);
		}
		this.costo = result;
		return result;
	}

	/***
	 * aggiunge un oggetto alla posizione e aggioran il costo
	 */
	public void addOggetto(Oggetto oggetto) {
		oggetti.add(oggetto);
		this.costo += oggetto.getPrezzo(periodo);
	}

	/***
	 * Rimuove un oggetto alla posizione e aggioran il costo
	 */
	public void removeOggetto(Oggetto oggetto) {
		oggetti.remove(oggetto);
		this.costo -= oggetto.getPrezzo(periodo);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Periodo: ").append(periodo).append("\n");

		sb.append("Oggetti: \n");
		for (Oggetto oggetto : oggetti) {
			sb.append(oggetto).append("\n");
		}

		int mancanteDaPagare = costo - quantoPagato;
		sb.append("Mancante da pagare: ").append(mancanteDaPagare).append("\n");

		return sb.toString();
	}

	public int getPagato() {
		return this.quantoPagato;
	}
}