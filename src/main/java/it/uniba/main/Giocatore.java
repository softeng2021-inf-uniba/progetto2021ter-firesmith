package it.uniba.main;

import java.util.ArrayList;

/** <<entity>> */

/*
     Oggetto Giocatore
     - String Colore
     - long Tempo
     - ArrayList<String> CronologiaMosse
     - int PedineMangiate
 */

public class Giocatore {

    // Colore = "bianco" oppure "nero" #FIXME in ENUM
    private String Colore;
    private long Tempo;
    private ArrayList<String> CronologiaMosse = new ArrayList<String>();
    private int PedineMangiate;

    public void setColore(String Colore) { this.Colore = Colore; }
    public void setTempo(long Tempo) { this.Tempo = Tempo; }
    public void setCronologiaMosse(String mossa) { CronologiaMosse.add(mossa); }
    public void setPedineMangiate() { PedineMangiate++; }

    public String getColore() { return Colore; }
    public long getTempo() { return Tempo; }
    public void getCronologiaMosse() { System.out.print(CronologiaMosse); }
    public int getPedineMangiate() { return PedineMangiate; }
}
