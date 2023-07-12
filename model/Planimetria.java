import java.util.HashMap;
import java.util.Map;

// Classe Planimetria
public class Planimetria {
    private int colonne;
    private int righe;
    private Map<Integer, Posizione> posizioni;
    private static Planimetria instance;

    private Planimetria() {
        posizioni = new HashMap<>();
    }

    public static Planimetria getInstance() {
        if (instance == null) {
            instance = new Planimetria();
        }
        return instance;
    }

    public Posizione getPosizione(int id) {
        // Implementazione per ottenere la posizione con l'id specificato
        // Ritorna l'oggetto Posizione o null se non è presente una posizione con quell'id
    }

    public void setNonPrenotabile(int id) {
        // Imposta la posizione con l'id specificato come non prenotabile
    }

    public boolean setMappa() {
        // Implementazione per impostare la mappa della planimetria
        // Ritorna true se l'operazione ha avuto successo, altrimenti false
    }

    public int getId(Coordinate coordinate) {
        // Implementazione per ottenere l'id della posizione in base alle coordinate
        // Ritorna l'id della posizione o un valore speciale per indicare che la posizione non esiste
    }

    // Altri metodi e attributi della classe Planimetria

    // Classe Coordinate
    private class Coordinate {
        private int x;
        private int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Metodi getter e setter per x e y
    }
}

