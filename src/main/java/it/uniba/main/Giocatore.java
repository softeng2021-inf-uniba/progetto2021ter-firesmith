package it.uniba.main;


/**
 * <h2>Classe che gestice il giocatore.</h2>
 * <b>Class Type:</b> &#60; Entity  &#62; <br><br>
 * <b>Responsabilities:</b><br>
 * <b>Knows:</b>
 * <ul>
 *     <li> Colore del Giocatore; </li>
 *     <li> Tempo; </li>
 *     <li> Colore del Giocatore; </li>
 * </ul>
 * <b>Does:</b>
 * <ul>
 *     <li> Possiede la damiera numerata; </li>
 *     <li> Dispone i pezzi sulla damiera per iniziare la partita; </li>
 *     <li> Permette all'utente di visualizzare la damiera con i pezzi; </li>
 *     <li> Permette all'utente di visualizzare la damiera numerata; </li>
 *     <li> Permette di ricavare la riga e la colonna di una pedina
 *     in una determinata posizione; </li>
 * </ul>
 *
 * @author Gruppo Firesmith
 */

public class Giocatore {
    /** Rappresenta il colore della pedina e del giocatore. */
    private String colore;
    /** Rappresenta il tempo passato nel turno del giocatore. */
    private long tempo;
    /** Rappresenta il numero di pedine mangiate. */
    private int pedineMangiate;

    /**
     * Imposta il colore del giocatore.
     *
     * @param col Colore attribuito al nuovo giocatore
     */
    public void setColore(final String col) {
        colore = col;
    }

    /**
     * Imposta il tempo trascorso dall'inizio del turno del giocatore.
     *
     * @param t Tempo del turno del giocatore
     */
    public void setTempo(final long t) {
        tempo = t;
    }

    /**
     * Imposta il numero di pedine mangiate dal giocatore.
     *
     * @param valore Numero pedine mangiate
     */
    public void setPedineMangiate(final int valore) {
        pedineMangiate += valore;
    }

    // Methods
    /**
     * Fornisce il colore del giocatore:
     * <ul>
     *     <li>'bianco', se il giocatore &#224; bianco;</li>
     *     <li>'nero', se il giocatore &#224; nero.</li>
     * </ul>
     *
     * @return Colore del giocatore
     */
    public String getColore() {
        return colore;
    }

    /**
     * Fornisce il tempo del giocatore.
     *
     * @return Tempo del giocatore
     */
    public long getTempo() {
        return tempo;
    }

    /**
     * Fornisce il numero delle pedine mangiate dal giocatore.
     *
     * @return Numero pedine mangiate
     */
    public int getPedineMangiate() {
        return pedineMangiate;
    }
}
