package it.uniba.tavolo;


/**
 * <h2>Classe che gestisce le pedine.</h2>
 * <b>Class type:</b> &#60; Entity &#62; <br><br>
 * <b>Responsibilities:</b><br>
 * <b>Knows:</b>
 * <ul>
 * <li>Coordinate della pedina</li>
 * </ul>
 * <b>Does:</b>
 * <ul>
 * <li>Controlla il colore della pedina</li>
 * <li>Controlla se la pedina &#232; una dama</li>
 * <li>Controlla se la pedina occupa una casella</li>
 * <li>Controlla se la pedina &#232; in una casella valida</li>
 * </ul>
 *
 * @author Gruppo Firesmith
 */


public class Pedina {
    // isValid = true, se la pedina è in una casella valida
    // isValid = false, se la pedina è in una casella non valida
    // isBlank = true, se la pedina occupa una casella
    // isBlank = false, se la pedina non occupa una casella
    /** Rappresenta la riga della pedina. */
    private int posRiga;
    /** Rappresenta la colonna della pedina. */
    private int posColonna;
    /** Definisce il colore di una pedina. */
    private boolean isWhite;
    /** Definisce la validit&#224; della casella della damiera. */
    private boolean isValid;
    /** Definisce se una casella &#232; occupata o no. */
    private boolean isBlank;
    /** Definisce se una pedina &#232; una dama o meno. */
    private boolean isDama;

    /**
     * Costruttore della classe Pedina.
     * @param riga coordinata x
     * @param colonna coordinata y
     */
    public Pedina(final int riga, final int colonna) {
        this.posRiga = riga;
        this.posColonna = colonna;
    }

    /**
     * Imposta il valore della riga.
     *
     * @param riga Valore da assegnare a {@link Pedina#posRiga}
     */
    public void setRiga(final int riga) {
        this.posRiga = riga;
    }

    /**
     * Imposta il valore della colonna.
     *
     * @param colonna Valore da assegnare a {@link Pedina#posColonna}
     */
    public void setColonna(final int colonna) {
        this.posColonna = colonna;
    }

    /**
     * Imposta il flag {@link Pedina#isWhite} della pedina a
     * <code>true</code> se la pedina &#232; bianca.
     * @param white Indica se la pedina &#232; bianca o no
     */
    public void setWhite(final boolean white) {
        this.isWhite = white;
    }

    /**
     * Imposta il flag {@link Pedina#isValid} della pedina a
     * <code>true</code> se la casella &#232; valida.
     *  @param valid Indica se la casella &#232; valida o no
     */
    public void setValid(final boolean valid) {
        this.isValid = valid;
    }

    /**
     * Imposta il flag {@link Pedina#isBlank} della pedina a
     * <code>true</code> se la casella &#232; vuota.
     * @param blank Indica se la casella &#232; vuota o no
     */
    public void setBlank(final boolean blank) {
        this.isBlank = blank;
    }

    /**
     * Imposta il flag {@link Pedina#isDama} della pedina a
     * <code>true</code> se essa &#232; diventata dama.
     * @param dama Indica se la pedina &#232; dama o no
     */
    public void setDama(final boolean dama) {
        this.isDama = dama;
    }

    /** Fornisce il valore della posizione
     * della riga di una pedina.
     * @return Coordinata x della pedina */
    public int getRiga() {
        return posRiga;
    }

    /** Fornisce il valore della posizione
     * della colonna di una pedina.
     * @return Coordinata y della pedina */
    public int getColonna() {
        return posColonna;
    }

    /**
     * Fornisce il colore della pedina:
     * <ul>
     *     <li><code>true</code>, la pedina &#232; bianca;</li>
     *     <li><code>false</code>, la pedina &#232; nera.</li>
     * </ul>
     * @return Colore della pedina
     */
    public boolean getWhite() {
        return isWhite;
    }

    /**
     * Fornisce la validità della casella della damiera:
     * <ul>
     *     <li><code>true</code>, la casella &#232; valida;</li>
     *     <li><code>false</code>, altrimenti.</li>
     * </ul>
     * @return Validit&#224; della casella
     */
    public boolean getValid() {
        return isValid;
    }

    /**
     * Fornisce lo stato della casella della damiera:
     * <ul>
     *     <li><code>true</code>, la casella non &#232; occupata;</li>
     *     <li><code>false</code>, la casella &#232; occupata da una pedina.</li>
     * </ul>
     * @return Occupazione della casella
     */
    public boolean getBlank() {
        return isBlank;
    }

    /**
     * Fornisce il tipo di pedina:
     * <ul>
     *     <li><code>true</code>, la pedina &#232; una dama;</li>
     *     <li><code>false</code>, la pedina &#232; normale.</li>
     * </ul>
     * @return Tipo di pedina
     */
    public boolean getDama() {
        return isDama;
    }
}
