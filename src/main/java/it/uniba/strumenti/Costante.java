package it.uniba.strumenti;

/**
 * <h1>Classe che contiene tutte le costanti utilizzate nel programma.</h1><br>
 * <b>Class Type:</b> &#60; Boundary &#62; <br><br>
 * <b>Responsabilities:</b> <br>
 * <b>Knows:</b> <br>
 *     <ul>
 *         <li> Una serie di costanti che vengono utilizzate
 *         da alcune classi </li>
 *     </ul>
 * <b>Does:</b>
 *
 * @author Gruppo Firesmith
 */
public final class Costante {

    /**
     * Costruttore vuoto.
     */
    private Costante() {
    }

    /**
     * Numero massimo delle caselle disposte sulla riga.
     */
    public static final int RIGHE = 8;
    /**
     * Numero massimo delle caselle disposte sulla colonna.
     */
    public static final int COLONNE = 8;

    /**
     * Costante utilizzata per il controllo della posizione delle pedine.
     */
    public static final int ZERO = 0;
    /**
     * Costante anche utilizzata per il controllo della posizione delle pedine.
     */
    public static final int UNO = 1;
    /**
     * Costante anche utilizzata per il controllo della posizione delle pedine.
     */
    public static final int DUE = 2;
    /**
     * Costante anche utilizzata per il controllo della posizione delle pedine.
     */
    public static final int TRE = 3;
    /**
     * Costante anche utilizzata per il controllo della posizione delle pedine.
     */
    public static final int QUATTRO = 4;
    /**
     * Costante utilizzata per il controllo della posizione delle pedine.
     */
    public static final int POS_DIECI = 10;
    /**
     * Costante utilizzata per il controllo della posizione delle pedine.
     */
    public static final int POS_DODICI = 12;
    /**
     * Costante utilizzata per il controllo della posizione delle pedine.
     */
    public static final int POS_TREDICI = 13;
    /**
     * Costante utilizzata per il controllo della posizione delle pedine.
     */
    public static final int POS_VENTUNO = 21;
    /**
     * Costante utilizzata per il controllo della posizione delle pedine.
     */
    public static final int POS_VENTOTTO = 28;
    /**
     * Costante utilizzata per il controllo della posizione delle pedine.
     */
    public static final int POS_TRENTADUE = 32;

    /**
     * Costante utilizzata per il calcolo del tempo.
     */
    public static final long MINUTO = 60;
    /**
     * Costante utilizzata per il calcolo del tempo.
     */
    public static final long INSECOND = 1000;

    /**
     * Espressione regex che controlla se la mossa
     * effettuata &#232; uno spostamento.
     */
    public static final String SPOSTAMENTO = "\\d{1,2}[-]{1}\\d{1,2}";
    /**
     * Espressione regex che controlla se la mossa
     * effettuata &#232; una presa semplice.
     */
    public static final String PRESA_S = "\\d{1,2}[x]{1}\\d{1,2}";
    /**
     * Espressione regex che controlla se la mossa
     * effettuata &#232; una presa multipla.
     */
    public static final String PRESA_M =
            "\\d{1,2}[x]{1}\\d{1,2}([x]{1}\\d{1,2}){1,2}";
}
