import java.util.HashMap;
import java.util.Map;

// Classe ListinoPrezzi
public class ListinoPrezzi {
    private Map<Oggetto, ITariffario> associazioni;
    private List<Observer> observers;
    private static ListinoPrezzi instance;

    private ListinoPrezzi() {
        associazioni = new HashMap<>();
        observers = new ArrayList<>();
    }

    public static ListinoPrezzi getInstance() {
        if (instance == null) {
            instance = new ListinoPrezzi();
        }
        return instance;
    }

    public boolean aggiungiTariffario(Oggetto oggetto, ITariffario tariffario) {
        // Implementazione per aggiungere il tariffario all'oggetto nel listino prezzi
        // Ritorna true se l'operazione ha avuto successo, altrimenti false
    }

    public boolean removeTariffario(Oggetto oggetto) {
        // Implementazione per rimuovere il tariffario dall'oggetto nel listino prezzi
        // Ritorna true se l'operazione ha avuto successo, altrimenti false
    }

    public boolean updateTariffario(Oggetto oggetto, ITariffario nuovo) {
        // Implementazione per aggiornare il tariffario dell'oggetto nel listino prezzi
        // Ritorna true se l'operazione ha avuto successo, altrimenti false
    }

    public boolean addObserver(Observer observer) {
        // Aggiunge un observer al listino prezzi
        return observers.add(observer);
    }

    public boolean removeObserver(Observer observer) {
        // Rimuove un observer dal listino prezzi
        return observers.remove(observer);
    }

    private void notifyObservers() {
        // Notifica gli observer di un cambiamento nel listino prezzi
    }

    // Classe Observer
    public interface Observer {
        void update();
    }
}
