package it.uniba.main;

import java.util.*;

/** Class Type: <<Entity>> *
 *  Responsabilities: Classe che rappresenta il giocatore partecipante alla partita *
 */



public class Giocatore {

    // Colore = "bianco" oppure "nero" #FIXME in ENUM
    private String Colore;
    private long Tempo;
    private int PedineMangiate;

    public void setColore(String Colore) { this.Colore = Colore; }
    public void setTempo(long Tempo) { this.Tempo = Tempo; }
    public void setPedineMangiate(int valore) { PedineMangiate += valore; }

    public String getColore() { return Colore; }
    public long getTempo() { return Tempo; }
    public int getPedineMangiate() { return PedineMangiate; }
}
