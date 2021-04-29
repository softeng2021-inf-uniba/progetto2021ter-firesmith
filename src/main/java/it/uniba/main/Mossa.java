package it.uniba.main;

public class Mossa {
    private static int Riga;
    private static int Colonna;
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

    public static int ottieniCoordX(int x) {

        Riga = Damiera.RicercaX(x);

        return Riga;
    }

    public static int ottieniCoordY(int y) {

        Colonna = Damiera.RicercaY(y);

        return Colonna;
    }

    /*
    Damiera 32 caselle
    Ogni pedina conosce il suo colore
        Va fatto un controllo sul flag della Pedina per capire dove deve andare
    Le prime 3 righe in alto sono inizialmente del Bianco
        Possono solo spostarsi su caselle di valore maggiore
    Le ultime 3 righe in basso sono inizialmente del Nero
        Possono solo spostarsi su caselle di valore minore
     */

   public static void SpostamentoSemplice(int pos1, int pos2) {
       int x1 = Mossa.ottieniCoordX(pos1);
       int y1 = Mossa.ottieniCoordY(pos2);

        System.out.println(x1 + "" + y1);
        // se i dati inseriti sono corretti
        // imposta Riga come nuova riga della Pedina
        // imposta Colonna come nuova colonna della Pedina
        // aggiorna la Damiera in Partita
        // return isValid a Partita per controllo

    }
}



