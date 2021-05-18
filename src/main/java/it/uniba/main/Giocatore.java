package it.uniba.main;

/**
 * Class Type: <<Entity>> *
 * Responsabilities: Classe che rappresenta il giocatore
 * partecipante alla partita. *
 */


public class Giocatore {

    // colore = "bianco" oppure "nero" #FIXME in ENUM
    private String colore;
    private long tempo;
    private int pedineMangiate;

    public void setColore(final String col) {
        colore = col;
    }

    public void setTempo(final long t) {
        tempo = t;
    }

    public void setPedineMangiate(final int valore) {
        pedineMangiate += valore;
    }

    public String getColore() {
        return colore;
    }

    public long getTempo() {
        return tempo;
    }

    public int getPedineMangiate() {
        return pedineMangiate;
    }
}
