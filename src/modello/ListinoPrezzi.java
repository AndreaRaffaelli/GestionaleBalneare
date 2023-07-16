package modello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Classe ListinoPrezzi
public class ListinoPrezzi {
	private Map<Oggetto, ITariffario> associazioni;
	private List<Observer> observers;
	private static ListinoPrezzi instance;

	private ListinoPrezzi() {
		associazioni = new HashMap<Oggetto, ITariffario>();
		observers = new ArrayList<Observer>();
	}

	public static ListinoPrezzi getInstance() {
		if (instance == null) {
			instance = new ListinoPrezzi();
		}
		return instance;
	}

	public boolean aggiungiTariffario(Oggetto oggetto, ITariffario tariffario) {
		this.associazioni.put(oggetto, tariffario);
		this.notifyObservers();
		return true;
	}

	public boolean removeTariffario(Oggetto oggetto) {
		this.associazioni.remove(oggetto);
		return true;
	}

	public boolean updateTariffario(Oggetto oggetto, ITariffario nuovo) {
		if (this.associazioni.put(oggetto, nuovo) == null)
			return false;
		this.notifyObservers();
		return true;
	}

	public boolean addObserver(Observer observer) {
		// Aggiunge un observer al listino prezzi
		return observers.add(observer);
	}

	public boolean removeObserver(Observer observer) {
		// Rimuove un observer dal listino prezzi
		return observers.remove(observer);
	}

	/***
	 * Notifica gli observer di un cambiamento nel listino prezzi
	 */
	private void notifyObservers() {
	    for (Observer observer : observers) {
	    	observer.update(this.associazioni.get(observer.getOggetto()));
	    }
	}

}
