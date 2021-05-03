package it.uniba.main;

public class Pedina {
    private static boolean isWhite;
    private int posRiga;
    private int posColonna;

    private boolean eBianco;
    private boolean eNero;

    private boolean isValid;
    private boolean isDama;
    private boolean isBlank;

    // Costruttore pedina
    public Pedina(int posRiga, int posColonna) {
        this.posRiga = posRiga;
        this.posColonna = posColonna;
    }

    // Metodi set
    public void setPosRiga(int posRiga) {
        this.posRiga = posRiga;
    }

    public void setPosColonna(int posColonna) {
        this.posColonna = posColonna;
    }

    public void setDama(boolean dama) {
        isDama = dama;
    }

    public static void setIsWhite(boolean isWhite) {
        Pedina.isWhite = isWhite;
    }

    public void seteBianco(boolean eBianco) {
        this.eBianco = eBianco;
    }

    public void seteNero(boolean eNero) {
        this.eNero = eNero;
    }

    public void setBlank(boolean blank) {
        isBlank = blank;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }



    // Metodi get
    public static boolean getIsWhite() {
        return isWhite;
    }

    public boolean iseBianco() {
        return eBianco;
    }

    public boolean getValid() {
        return isValid;
    }

    public boolean getBlank() {
        return isBlank;
    }

    public boolean iseNero() {
        return eNero;
    }

    public boolean isDama() {
        return isDama;
    }

    public int getPosRiga() {
        return posRiga;
    }

    public int getPosColonna() {
        return posColonna;
    }
}
