package modello;


import java.util.HashMap;
import java.util.Map;

//Ho aggiunto setPeriodo getPeriodo e modificato la mappa degli oggetti


// Classe Prenotazione
public class Prenotazione {
	private int costo;
	private int quantoPagato;
	private Periodo periodo;
	private Map<Oggetto, Integer> oggetti;

	public Prenotazione() {
		oggetti = new HashMap<>();
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
		for (Map.Entry<Oggetto, Integer> o : this.oggetti.entrySet()) {
			result += o.getKey().getPrezzo(this.periodo)*o.getValue();
		}
		this.costo = result;
		return result;
	}

	/***
	 * aggiunge un oggetto alla posizione e aggioran il costo
	 */
	public void addOggetto(Oggetto oggetto, int quantita) {
		oggetti.put(oggetto, quantita);
		this.costo += oggetto.getPrezzo(periodo)*quantita;
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

		for (Map.Entry<Oggetto, Integer> o : this.oggetti.entrySet()) {
			sb.append(o.getKey()+" quantita: "+o.getValue()).append("\n");

		}

		int mancanteDaPagare = costo - quantoPagato;
		sb.append("Mancante da pagare: ").append(mancanteDaPagare).append("\n");

		return sb.toString();
	}

	public int getPagato() {
		return this.quantoPagato;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Periodo getPeriodo() {
		return periodo;
	}
	
}