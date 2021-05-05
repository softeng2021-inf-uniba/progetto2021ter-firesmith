package it.uniba.main;

import java.util.*;

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
    public void setPedineMangiate(int valore) { PedineMangiate += valore; }

    public String getColore() { return Colore; }
    public long getTempo() { return Tempo; }
    public void getCronologiaMosse() {
        ListIterator<String> CronoMosse = CronologiaMosse.listIterator();
        while (CronoMosse.hasNext()){
            System.out.println(CronoMosse.next());
        }}
    public int getPedineMangiate() { return PedineMangiate; }
}
