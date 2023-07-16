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

		Oggetto o = new Oggetto("Ombrellone", 100);
		Oggetto l = new Oggetto("lettino", 300);
		Oggetto s = new Oggetto("sdraio", 70);
		Oggetto r = new Oggetto("regista", 25);
		oggetti = (List<Oggetto>) Arrays.asList(o, s, l, r);

		Prenotazione p = new Prenotazione();
		p.addOggetto(getOggetto("Ombrellone"));
		p.addOggetto(getOggetto("Lettino"));
		p.addOggetto(getOggetto("Lettino"));
		p.setPeriodo(Periodo.nuovoPeriodo(LocalDate.of(2023, 7, 17), LocalDate.of(2023, 7, 23)));

		Prenotazione p1 = new Prenotazione();
		p1.addOggetto(getOggetto("Ombrellone"));
		p1.addOggetto(getOggetto("Lettino"));
		p1.addOggetto(getOggetto("Lettino"));
		p1.addOggetto(getOggetto("Sdraio"));
		p1.setPeriodo(Periodo.nuovoPeriodo(LocalDate.of(2023, 7, 17), LocalDate.of(2023, 7, 23)));

		Prenotazione p2 = new Prenotazione();
		p2.addOggetto(getOggetto("Ombrellone"));
		p2.addOggetto(getOggetto("Lettino"));
		p2.addOggetto(getOggetto("Regista"));
		p2.setPeriodo(Periodo.nuovoPeriodo(LocalDate.of(2023, 7, 17), LocalDate.of(2023, 7, 23)));

		Planimetria planimetria = Planimetria.getInstance();
		int id = planimetria.getId(4, 1);
		Posizione pos = planimetria.getPosizione(id);
		pos.addPrenotazione(p.getPeriodo(), p);
		id = planimetria.getId(6, 1);
		pos = planimetria.getPosizione(id);
		pos.addPrenotazione(p1.getPeriodo(), p1);

		id = planimetria.getId(4, 2);
		pos = planimetria.getPosizione(id);
		pos.addPrenotazione(p2.getPeriodo(), p2);

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
}
