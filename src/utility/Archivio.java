package utility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modello.Cliente;
import modello.Oggetto;
import modello.Periodo;
import modello.Planimetria;
import modello.Posizione;
import modello.Prenotazione;
import modello.Tariffario;

// Ho modificato il costruttore e aggiunto initialize

public class Archivio {
	private static List<Prenotazione> prenotazioni;
	private static List<Cliente> clienti;
	private static List<Oggetto> oggetti;
	private static Planimetria planimetria;
	private static Archivio archivio;

	public static Archivio getInstace() {
		if (Archivio.archivio == null) {
			Archivio.archivio = new Archivio();
		}
		return Archivio.archivio;
	}

	private Archivio() {
		super();
		prenotazioni = new ArrayList<Prenotazione>();
		clienti = new ArrayList<Cliente>();
		planimetria = Planimetria.getInstance();
		initialize();

	}

	private void initialize() {

		planimetria.setPosizione(4, new Posizione(4));
		planimetria.setPosizione(6, new Posizione(6));
		planimetria.setPosizione(8, new Posizione(8));


		Tariffario t = new Tariffario(null, null);
		Oggetto o = new Oggetto("Ombrellone", 100);
		o.setTariffario(t);
		Oggetto l = new Oggetto("Lettino", 300);
		l.setTariffario(t);
		Oggetto s = new Oggetto("Sdraio", 70);
		s.setTariffario(t);
		Oggetto r = new Oggetto("Regista", 25);
		r.setTariffario(t);
		oggetti = (List<Oggetto>) Arrays.asList(o, s, l, r);

		Prenotazione p = new Prenotazione();
		p.setPeriodo(Periodo.nuovoPeriodo(LocalDate.of(2023, 7, 17), LocalDate.of(2023, 7, 23)));
		p.addOggetto(getOggetto("Ombrellone"),1);
		p.addOggetto(getOggetto("Lettino"),2);
		// p.addOggetto(getOggetto("Lettino"));

		Prenotazione p1 = new Prenotazione();
		p1.setPeriodo(Periodo.nuovoPeriodo(LocalDate.of(2023, 7, 17), LocalDate.of(2023, 7, 23)));
		p1.addOggetto(getOggetto("Ombrellone"),1);
		p1.addOggetto(getOggetto("Lettino"),2);
		// p1.addOggetto(getOggetto("Lettino"));
		p1.addOggetto(getOggetto("Sdraio"),1);

		Prenotazione p2 = new Prenotazione();
		p2.setPeriodo(Periodo.nuovoPeriodo(LocalDate.of(2023, 7, 17), LocalDate.of(2023, 7, 23)));
		p2.addOggetto(getOggetto("Ombrellone"),1);
		p2.addOggetto(getOggetto("Lettino"),1);
		p2.addOggetto(getOggetto("Regista"),1);

		int id = planimetria.getId(4, 1);
		Posizione pos = planimetria.getPosizione(id);
		pos.addPrenotazione(p.getPeriodo(), p);
		planimetria.setPosizione(id, pos);

		id = planimetria.getId(6, 1);
		pos = planimetria.getPosizione(id);
		pos.addPrenotazione(p1.getPeriodo(), p1);
		planimetria.setPosizione(id, pos);


		id = planimetria.getId(4, 2);
		pos = planimetria.getPosizione(id);
		pos.addPrenotazione(p2.getPeriodo(), p2);
		planimetria.setPosizione(id, pos);


	}

	public static List<Oggetto> getOggetti() {
		return oggetti;
	}

	public static synchronized Oggetto getOggetto(String oggetto) {
		for (var o : oggetti) {
			if (o.getNome().equalsIgnoreCase(oggetto)) {
				o.setQuantita(o.getQuantita() - 1);
				return o;
			}
		}
		return null;
	}

	public static synchronized void releaseOggetto(Oggetto oggetto) {
		if (oggetti.contains(oggetto)) {
			oggetto.setQuantita(oggetto.getQuantita() + 1);
		} else
			System.out.println("Errore: comparso oggetto non identitficato " + oggetto);
	}


	//Aggiunte da fare

	public static Planimetria getPlanimetria() {
		return planimetria;
	}

	public static synchronized void addPrenotazione(Prenotazione prenotazione) {
		prenotazioni.add(prenotazione);
	}
}
