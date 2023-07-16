package modello;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// Classe Posizione
public class Posizione {
    private int numero;
    private Map<Periodo, Prenotazione> prenotazioni;

    public Posizione(int numero) {
        this.numero = numero;
        prenotazioni = new TreeMap<Periodo, Prenotazione>();
    }

    public int getNumero() {
		return numero;
	}

	public boolean isOccupato(Periodo periodo) {
    	Set<Periodo> periodi = prenotazioni.keySet();
    	for ( var p : periodi ) {
    		if(p.overlap(periodo) ) {
    			return true;
    		}
    	}
    	return false;
    }

    public Prenotazione getPrenotazioneBy(LocalDate data) {
    	Set<Periodo> periodi = prenotazioni.keySet();
    	for ( var p : periodi ) {
    		if(p.contains(data)) {
    			return prenotazioni.get(p);
    		}
    	}
    	return null;
    }

    public boolean addPrenotazione(Periodo periodo, Prenotazione prenotazione) {
    	if(this.isOccupato(periodo))
    		return false;
        prenotazioni.put(periodo, prenotazione);
        return true;
    }

    public void removePrenotazione(Periodo periodo) {
        prenotazioni.remove(periodo);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Posizione numero: ").append(numero).append("\n");
        
        for (Map.Entry<Periodo, Prenotazione> entry : prenotazioni.entrySet()) {
            Periodo periodo = entry.getKey();
            Prenotazione prenotazione = entry.getValue();
            
            sb.append("Periodo: ").append(periodo).append("\n");
            sb.append("Prenotazione: ").append(prenotazione).append("\n");
        }
        
        return sb.toString();
    }
}
