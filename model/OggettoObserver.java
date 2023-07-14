package modello;

// Classe OggettoObserver
public class OggettoObserver implements Observer {

	private Oggetto oggetto;

	public OggettoObserver(Oggetto oggetto) {
		this.oggetto = oggetto;
	}

	public Oggetto getOggetto() {
		return oggetto;
	}

	@Override
	public void update(ITariffario tariffario) {
		// Implementazione dell'aggiornamento dell'oggetto con il nuovo tariffario
		oggetto.setTariffario(tariffario);
	}
}
