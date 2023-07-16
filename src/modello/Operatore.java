package modello;

// Classe Operatore
public class Operatore {
    private String nome;
    private String cognome;
    private String username;
    private boolean bloccato;

    public Operatore(String nome, String cognome, String username, boolean bloccato) {
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.bloccato = bloccato;
    }


    public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getUsername() {
		return username;
	}
	
    public boolean isBloccato() {
        return bloccato;
    }
    
	public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }


	@Override
	public String toString() {
		return "Operatore [nome=" + nome + ", cognome=" + cognome + ", username=" + username + ", bloccato=" + bloccato
				+ "]";
	}
	
}
