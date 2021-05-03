package it.uniba.main;

/*
    Oggetto Mossa
     - int posizione1
     - int posizione2
     - boolean isValid
 */
public class Mossa {

    private int posizione1;
    private int posizione2;
    private boolean isValid;

    public void setPosizione1(int posizione1) { this.posizione1 = posizione1; }
    public void setPosizione2(int posizione2) { this.posizione2 = posizione2; }
    public void setValid(boolean isValid) { this.isValid = isValid; }

    public int getPosizione1() { return posizione1; }
    public int getPosizione2() { return posizione2; }
    public boolean getValid() { return isValid; }

    public Mossa(int posizione1, int posizione2) {
        this.posizione1 = posizione1;
        this.posizione2 = posizione1;
        this.isValid = false;
    }
}