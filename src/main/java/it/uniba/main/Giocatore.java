package it.uniba.main;

public class Giocatore {
    private String Colore;
    private long Tempo;
    private int CronologiaMosse; // deve essere un array/buffer
    private int PedineMangiate;

    public void setColore(String colore) {
        Colore = colore;
    }

    public void setTempo(long tempo) {
        Tempo = tempo;
    }

    public void setCronologiaMosse(int cronologiaMosse) {
        CronologiaMosse = cronologiaMosse;
    }

    public void setPedineMangiate(int pedineMangiate) {
        PedineMangiate = pedineMangiate;
    }

    public String getColore() { return Colore; }
    public long getTempo() { return Tempo; }
    public int getCronologiaMosse() { return CronologiaMosse; }
    public int getPedineMangiate() { return PedineMangiate; }
}
