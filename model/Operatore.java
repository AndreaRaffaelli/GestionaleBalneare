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

    public boolean isBloccato() {
        return bloccato;
    }

    public void setBloccato(boolean bloccato) {
        this.bloccato = bloccato;
    }
}
