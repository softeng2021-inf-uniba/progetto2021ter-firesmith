package it.uniba.main;

public class Pedina {
    private int posRiga;
    private int posColonna;
    private int giocatore;
    private boolean isValid;
    private boolean isDama = false;

    public Pedina(int posRiga, int posColonna, int giocatore, boolean isValid) {
        this.posRiga = posRiga;
        this.posColonna = posColonna;
        this.giocatore = giocatore;
        this.isValid = isValid;
    }

    public void setPosRiga(int posRiga) {
        this.posRiga = posRiga;
    }

    public void setPosColonna(int posColonna) {
        this.posColonna = posColonna;
    }

    public void setDama(boolean dama) {
        isDama = dama;
    }

    public void setGiocatore(int giocatore) {
        this.giocatore = giocatore;
    }

    public int getPosRiga() {
        return posRiga;
    }

    public int getPosColonna() {
        return posColonna;
    }

    public boolean isDama() {
        return isDama;
    }

}
