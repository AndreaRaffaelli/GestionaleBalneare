// Classe Record
public class Record {
    private Operatore operatore;
    private String azione;

    public Record(Operatore operatore, String azione) {
        this.operatore = operatore;
        this.azione = azione;
    }

    @Override
    public String toString() {
        return "Operatore: " + operatore.toString() + ", Azione: " + azione;
    }
}
