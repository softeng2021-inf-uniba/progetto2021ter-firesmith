package it.uniba.main;

public class Mossa {
    private int Riga;
    private int Colonna;
    private char TipoMossa;
    private boolean isValid;

    public Mossa(int Riga, int Colonna, char TipoMossa) {
        this.Riga = Riga;
        this.Colonna = Colonna;
        this.TipoMossa = TipoMossa;
    }

    public int getRiga() {
        return Riga;
    }

    public void setRiga(int riga) {
        Riga = riga;
    }

    public int getColonna() {
        return Colonna;
    }

    public void setColonna(int colonna) {
        Colonna = colonna;
    }

    public char getTipoMossa() {
        return TipoMossa;
    }

    public void setTipoMossa(char tipoMossa) {
        TipoMossa = tipoMossa;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }


    /*
    Damiera 32 caselle
    Ogni pedina conosce il suo colore
        Va fatto un controllo sul flag della Pedina per capire dove deve andare
    Le prime 3 righe in alto sono inizialmente del Bianco
        Possono solo spostarsi su caselle di valore maggiore
    Le ultime 3 righe in basso sono inizialmente del Nero
        Possono solo spostarsi su caselle di valore minore

            {B,null,B,0,B,0,B,0},
            {0,B,0,B,0,B,0,B},
            {B,0,B,0,B,0,B,0},
            {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},
            {0,N,0,N,0,N,0,N},
            {N,0,N,0,N,0,N,0},
            {0,N,0,N,0,N,0,N}

            {1,0,2,0,3,0,4,0},
            {0,5,0,6,0,7,0,8},
            {9,0,10,0,11,0,12,0},
            {0,13,0,14,0,15,0,16},
            {17,0,18,0,19,0,20,0},
            {0,21,0,22,0,23,0,24},
            {25,0,26,0,27,0,28,0},
            {0,29,0,30,0,31,0,32}

            1x5 11205
            10x14 1012014
            22x18 2212018

            1 int x char 5 int
    */

    public boolean SpostamentoSemplice(int Riga, int Colonna, char TipoMossa) {
        if (TipoMossa == '-' && Riga <= 8 && Colonna <= 8) {
            return isValid = true;
        } else {
            return isValid = false;
        }
        // se i dati inseriti sono corretti
        // imposta Riga come nuova riga della Pedina
        // imposta Colonna come nuova colonna della Pedina
        // aggiorna la Damiera in Partita
        // return isValid a Partita per controllo
    }
}



