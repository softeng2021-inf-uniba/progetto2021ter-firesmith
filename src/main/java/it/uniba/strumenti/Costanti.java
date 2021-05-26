package it.uniba.strumenti;

public class Constanti {
    private Constanti() {

    }

    // damiera
    public static final int RIGHE = 8;
    public static final int COLONNE = 8;

    // posizioni
    public static final int POS_ZERO = 0;
    public static final int POS_UNO = 1;
    public static final int POS_DUE = 2;
    public static final int POS_TRE = 3;
    public static final int POS_QUATTRO = 4;
    public static final int POS_DIECI = 10;
    public static final int POS_DODICI = 12;
    public static final int POS_TREDICI = 13;
    public static final int POS_VENTUNO = 21;
    public static final int POS_VENTOTTO = 28;
    public static final int POS_TRENTADUE = 32;

    // tempo
    public static final int MINUTO = 60;
    public static final long INSECOND = 1000;

    /** Espressione regex che controlla se la mossa
     * effettuata &#232; uno spostamento. */
    public static final String SPOSTAMENTO = "\\d{1,2}[-]{1}\\d{1,2}";
    /** Espressione regex che controlla se la mossa
     * effettuata &#232; una presa semplice. */
    public static final String PRESA_S = "\\d{1,2}[x]{1}\\d{1,2}";
    /** Espressione regex che controlla se la mossa
     * effettuata &#232; una presa multipla. */
    public static final String PRESA_M =
            "\\d{1,2}[x]{1}\\d{1,2}([x]{1}\\d{1,2}){1,2}";
}
