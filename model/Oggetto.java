import java.util.Date;
import java.time.Period;

// Classe Oggetto
public class Oggetto {
    private String nome;
    private int quantita;
    private ITariffario tariffario;

    public int getPrezzo(Period periodo) {
        // Implementazione della logica per ottenere il prezzo dell'oggetto per il periodo specificato
        // Ritorna il prezzo come un intero
    }

    public void setTariffario(ITariffario tariffario) {
        // Imposta il tariffario per l'oggetto
        this.tariffario = tariffario;
    }
}