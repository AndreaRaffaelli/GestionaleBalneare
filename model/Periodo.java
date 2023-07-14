package modello;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Periodo implements Comparable<Periodo> {
	private LocalDate inizio;
	private LocalDate fine;
	private static List<Periodo> cache;

	private Periodo(LocalDate inizio, LocalDate fine) {
		super();
		if (inizio.isBefore(fine)) {
			this.inizio = inizio;
			this.fine = fine;
		} else {
			this.inizio = inizio;
			this.fine = inizio;
		}
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

	@Override
	public int compareTo(Periodo that) {
		if (this.inizio.isBefore(that.inizio)) {
			return -1;
		} else if (this.inizio.isAfter(that.inizio)) {
			return 1;
		} else {
			// Le date di inizio sono uguali, confronta le date di fine
			return this.fine.compareTo(that.fine);
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Periodo that = (Periodo) obj;
		return this.inizio.equals(that.inizio) && this.fine.equals(that.fine);
	}

	public int quantiGiorni() {
		long giorni = ChronoUnit.DAYS.between(inizio, fine);
		return Math.toIntExact(giorni);
	}
}
