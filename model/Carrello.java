import java.util.ArrayList;
import java.util.List;

// Classe Carrello
public class Carrello {
    private List<Prenotazione> prenotazioni;
    private int totale;

    public Carrello() {
        prenotazioni = new ArrayList<>();
        totale = 0;
    }

    public boolean isPagato() {
        // Implementazione della logica per verificare se il carrello è stato pagato
        // Ritorna true se il carrello è stato pagato, altrimenti false
    }

    public int quantoDaSaldare() {
        // Implementazione della logica per calcolare l'importo da saldare nel carrello
        // Ritorna l'importo da saldare come un intero
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