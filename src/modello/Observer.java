package modello;

// Interfaccia Observer
public interface Observer {
	/***
	 * Aggiorna il riferimento al tariffario per l'oggetto osservato
	 */
	void update(ITariffario tariffario);

	Oggetto getOggetto();
}
