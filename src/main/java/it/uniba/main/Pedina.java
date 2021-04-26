package it.uniba.main;

public class Pedina {
    private int posRiga;
    private int posColonna;
    private static boolean isWhite;
    private boolean isValid;
    private boolean isDama = false;

    public Pedina(int posRiga, int posColonna, boolean isWhite, boolean isValid) {
        this.posRiga = posRiga;
        this.posColonna = posColonna;
        this.isWhite = isWhite;
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

    public void setGiocatore(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public static boolean getGiocatore() { return isWhite; }

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
