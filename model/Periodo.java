package modello;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Periodo {
	private LocalDate inizio;
	private LocalDate fine;
	private static List<Periodo> cache;

	private Periodo(LocalDate inizio, LocalDate fine) {
		super();
		this.inizio = inizio;
		this.fine = fine;
	}

	public LocalDate getInizio() {
		return inizio;
	}

	public LocalDate getFine() {
		return fine;
	}

	public boolean contains(LocalDate date) {
		if (this.inizio.isBefore(date) && this.fine.isAfter(date)) {
			return true;
		} else
			return false;
	}

	public boolean overlap(Periodo periodo) {
		if (this.contains(periodo.getInizio()) || this.contains(periodo.getFine()) || periodo.contains(this.inizio)
				|| periodo.contains(this.fine)) {
			return true;
		} else
			return false;
	}

	public static Periodo nuovoPeriodo(LocalDate inizio, LocalDate fine) {
		if (Periodo.cache == null) {
			Periodo.cache = new ArrayList<Periodo>();
		}
		for (var p : Periodo.cache) {
			if (p.getInizio().equals(inizio) && p.getFine().equals(fine)) {
				return p;
			}
		}
		Periodo p = new Periodo(inizio, fine);
		Periodo.cache.add(p);
		return p;
	}

	@Override
	public String toString() {
		return "Periodo [inizio=" + inizio + ", fine=" + fine + "]";
	}

}
