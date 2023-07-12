import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Classe Prenotazione
public class Prenotazione {
    private boolean pagato;
    private int costo;
    private Date dataInizio;
    private Date dataFine;
    private List<Oggetto> oggetti;

    public Prenotazione() {
        oggetti = new ArrayList<>();
    }

    public boolean isSaldoEffettuato() {
        // Implementazione della logica per verificare se il saldo è stato effettuato
        // Ritorna true se il saldo è stato effettuato, altrimenti false
    }

    public int getCosto() {
        // Implementazione della logica per calcolare il costo della prenotazione
        // Ritorna il costo come un intero
    }

    public void addOggetto(Oggetto oggetto) {
        // Aggiunge un oggetto alla prenotazione
        oggetti.add(oggetto);
    }

    public void removeOggetto(Oggetto oggetto) {
        // Rimuove un oggetto dalla prenotazione
        oggetti.remove(oggetto);
    }
}