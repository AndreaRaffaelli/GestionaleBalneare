package modello;

import java.util.Map;

// Classe Tariffario
public class Tariffario implements ITariffario {
	private int[][] grioniFascePrezzo;
	private Map<String, Integer> meseSconto;
	private boolean metodoDiCalcolo;

	public Tariffario(int[][] grioniFascePrezzo, Map<String, Integer> meseSconto) {
		this.grioniFascePrezzo = grioniFascePrezzo;
		this.meseSconto = meseSconto;
	}

	@Override
	public int getPrezzo(Periodo periodo) {
		return 5 * periodo.quantiGiorni();
	}
}
