public class Cliente {
    private String nome;
    private String cognome;
    private String telefono;
    private String note;
    private Carrello carrello;

    public Cliente() {
        carrello = new Carrello();
    }

    public void setNote(String note) {
        this.note = note;
    }

    // Metodi getter e setter per gli attributi nome, cognome, telefono e note

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }
}
