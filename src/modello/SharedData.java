package modello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SharedData {
    private static Map<Periodo, Prenotazione> prenotazioni = new HashMap<>();
    private static List<Cliente> clienti = new ArrayList<>();
    private static List<Posizione> posizioni = new ArrayList<>();

    public static synchronized Map<Periodo, Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public static synchronized void setPrenotazioni(Map<Periodo, Prenotazione> prenotazioni) {
        SharedData.prenotazioni = prenotazioni;
    }

    public static synchronized void addPrenotazione(Periodo periodo, Prenotazione prenotazione) {
        prenotazioni.put(periodo, prenotazione);
    }

    public static synchronized List<Cliente> getClienti() {
        return clienti;
    }

    public static synchronized void setClienti(List<Cliente> clienti) {
        SharedData.clienti = clienti;
    }

    public static synchronized List<Posizione> getPosizioni() {
        return posizioni;
    }

    public static synchronized void setPosizioni(List<Posizione> posizioni) {
        SharedData.posizioni = posizioni;
    }
}
