import java.util.*;

// Classe Posizione
public class Posizione {
    private int numero;
    private Map<Periodo, Prenotazione> prenotazioni;

    public Posizione(int numero) {
        this.numero = numero;
        prenotazioni = new TreeMap<>();
    }

    public boolean isOccupato(Date data) {
        // Implementazione della logica per verificare se la posizione è occupata nella data specificata
        // Ritorna true se la posizione è occupata, altrimenti false
    }

    public Prenotazione getPrenotazioneBy(Date data) {
        // Implementazione della logica per ottenere la prenotazione per la data specificata
        // Ritorna l'oggetto Prenotazione o null se non è presente una prenotazione per quella data
    }

    public void addPrenotazione(Periodo periodo, Prenotazione prenotazione) {
        // Aggiunge una prenotazione alla posizione per il periodo specificato
        prenotazioni.put(periodo, prenotazione);
    }

    public void removePrenotazione(Periodo periodo) {
        // Rimuove la prenotazione dalla posizione per il periodo specificato
        prenotazioni.remove(periodo);
    }
}
