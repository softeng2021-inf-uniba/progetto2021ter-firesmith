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

    public static boolean SpostamentoSempliceWhite(int pos1, int pos2, Damiera damiera) {
        boolean mossaValida = true;


        int x1 = Mossa.ottieniCoordX(pos1);
        int y1 = Mossa.ottieniCoordY(pos1);

        int x2 = Mossa.ottieniCoordX(pos2);
        int y2 = Mossa.ottieniCoordY(pos2);

        System.out.println("pos1: " + x1 + "," + y1 + "\npos2: " + x2 + "," + y2);

        if (x2 > x1) {
            if ((x2 == x1 + 1) && (y2 == y1 + 1 || y2 == y1 - 1)) {
                if(damiera.damieraPezzi[x2][y2].getBlank() && !damiera.damieraPezzi[x1][y1].getBlank()) {

                    damiera.damieraPezzi[x1][y1].setBlank(true);
                    damiera.damieraPezzi[x2][y2].setBlank(false);
                    damiera.damieraPezzi[x2][y2].seteBianco(true);

                    damiera.StampaPezzi();
                }else {
                    System.out.println("Mossa non valida, riprovare: ");
                    mossaValida = false;
                }
            } else {
                System.out.println("Mossa non valida, riprovare: ");
                mossaValida = false;
            }
        } else {
            System.out.println("Mossa non valida, riprovare: ");
            mossaValida = false;
        }
        return mossaValida;
    }

    public static boolean SpostamentoSempliceBlack(int pos1, int pos2, Damiera damiera) {
        boolean mossaValida = true;


        int x1 = Mossa.ottieniCoordX(pos1);
        int y1 = Mossa.ottieniCoordY(pos1);

        int x2 = Mossa.ottieniCoordX(pos2);
        int y2 = Mossa.ottieniCoordY(pos2);

        System.out.println("pos1: " + x1 + "," + y1 + "\npos2: " + x2 + "," + y2);

        if (x2 < x1) {
            if ((x2 == x1 - 1) && (y2 == y1 - 1 || y2 == y1 + 1)) {

                damiera.damieraPezzi[x1][y1].setBlank(true);
                damiera.damieraPezzi[x2][y2].setBlank(false);
                damiera.damieraPezzi[x2][y2].seteNero(true);

                damiera.StampaPezzi();
            } else {
                System.out.println("Mossa non valida, riprovare: ");
                mossaValida = false;
            }
        } else {
            System.out.println("Mossa non valida, riprovare: ");
            mossaValida = false;
        }
        return mossaValida;
    }
}






