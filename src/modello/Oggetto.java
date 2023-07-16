package modello;

import java.util.Date;
import java.time.Period;

// Classe Oggetto
public class Oggetto {
    private String nome;
    private int quantita;
    private ITariffario tariffario;

    public Oggetto(String nome, int quantita, ITariffario tariffario) {
		super();
		this.nome = nome;
		this.quantita = quantita;
		this.tariffario = tariffario;
	}

	public Oggetto(String nome, int quantita) {
		super();
		this.nome = nome;
		this.quantita = quantita;
	}

	public int getPrezzo(Periodo periodo) {
        return tariffario.getPrezzo(periodo);
    }

    public void setTariffario(ITariffario tariffario) {
        // Imposta il tariffario per l'oggetto
        this.tariffario = tariffario;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public ITariffario getTariffario() {
		return tariffario;
	}

	@Override
	public String toString() {
		return "Oggetto [nome=" + nome + ", quantita=" + quantita + ", tariffario=" + tariffario + "]";
	}
    
}