package it.uniba.main;


/**
 * Class Type: <<Entity>>
 * Responsabilities: Classe che rappresenta genericamente le pedine di gioco.
 */

public class Pedina {

    // isWhite = true, se la pedina è bianca
    // isWhite = false, se la pedina è nera
    // isValid = true, se la pedina è in una casella valida
    // isValid = false, se la pedina è in una casella non valida
    // isBlank = true, se la pedina occupa una casella
    // isBlank = false, se la pedina non occupa una casella
    private int posRiga;
    private int posColonna;
    private boolean isWhite;
    private boolean isValid;
    private boolean isBlank;
    private boolean isDama;

    public Pedina(final int riga, final int colonna) {
        this.posRiga = riga;
        this.posColonna = colonna;
    }

    public void setRiga(final int riga) {
        this.posRiga = riga;
    }

    public void setColonna(final int colonna) {
        this.posColonna = colonna;
    }

    public void setWhite(final boolean white) {
        this.isWhite = white;
    }

    public void setValid(final boolean valid) {
        this.isValid = valid;
    }

    public void setBlank(final boolean blank) {
        this.isBlank = blank;
    }

    public void setDama(final boolean dama) {
        this.isDama = dama;
    }

    public int getRiga() {
        return posRiga;
    }

    public int getColonna() {
        return posColonna;
    }

    public boolean getWhite() {
        return isWhite;
    }

    public boolean getValid() {
        return isValid;
    }

    public boolean getBlank() {
        return isBlank;
    }

    public boolean getDama() {
        return isDama;
    }
}