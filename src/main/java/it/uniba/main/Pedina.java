package it.uniba.main;


/** Class Type: <<Entity>>
 *  Responsabilities: Classe che rappresenta genericamente le pedine di gioco
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

    public Pedina(int posRiga, int posColonna) {
        this.posRiga = posRiga;
        this.posColonna = posColonna;
    }

    public void setRiga(int posRiga) { this.posRiga = posRiga; }
    public void setColonna(int posColonna) { this.posColonna = posColonna; }
    public void setWhite(boolean isWhite) { this.isWhite = isWhite; }
    public void setValid(boolean isValid) { this.isValid = isValid; }
    public void setBlank(boolean isBlank) { this.isBlank = isBlank; }

    public int getRiga() { return posRiga; }
    public int getColonna() { return posColonna; }
    public boolean getWhite() { return isWhite; }
    public boolean getValid() { return isValid; }
    public boolean getBlank() { return isBlank; }
}