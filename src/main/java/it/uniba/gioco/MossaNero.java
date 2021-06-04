package it.uniba.gioco;

import it.uniba.strumenti.Costante;
import it.uniba.tavolo.Damiera;

/**
 * <h1>Classe che effettua le mosse per il giocatore Nero.</h1><br>
 * <b>Class Type:</b> &#60; Control &#62; <br><br>
 * <b>Responsabilities:</b> <br>
 * <p><b>Knows:</b>
 *     <ul>
 *     <li> Le posizioni delle caselle sulle quali effettuare le mosse </li>
 *     <li> L'effettiva validit&#224; di una mossa </li>
 *     </ul> <br>
 * <b>Does:</b>
 *     <ul>
 *     <li> Permette all'utente di inserire la mossa
 *     ed effettuare lo spostamento,
 *     le prese semplici o le prese multiple;</li>
 *     <li>Controlla la validit&#224; delle mosse inserite.</li>
 *     </ul>
 *
 * @author Gruppo Firesmith
 */
public class MossaNero extends Mossa {

    /**
     * Costruttore della classe MossaNero che richiama quello della superclasse.
     *
     * @param pos1 casella d'inizio
     * @param pos2 casella d'arrivo
     */
    public MossaNero(final int pos1, final int pos2) {
        super(pos1, pos2);
    }

    /**
     * Metodo che gestisce lo spostamento delle pedine del giocatore nero.
     *
     * @param damiera Damiera utilizzata durante la partita in corso
     * @return booleano che indica se la mossa è valida
     */
    public boolean spostamentoSemplice(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti
        //alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(getPosizione1());
        int x2 = damiera.cercaRiga(getPosizione2());

        int y1 = damiera.cercaColonna(getPosizione1());
        int y2 = damiera.cercaColonna(getPosizione2());

        //vengono effettuati una serie di controlli per controllare che
        //le pedine vengano spostate solo "dall'alto verso il basso" (bianco)
        //e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 1
        if (x2 > x1) {
            if ((x2 == x1 + Costante.UNO)
                    && (y2 == y1 + Costante.UNO
                    || y2 == y1 - Costante.UNO)) {

                //qui viene controllata che la casella iniziale sia effett.
                //occupata da una pedina (bianca) e quella di arrivo sia vuota
                if (damiera.getDamieraPedine(x2, y2).getBlank()
                        && !damiera.getDamieraPedine(x1, y1).getBlank()
                        && !damiera.getDamieraPedine(x1, y1).getWhite()) {

                    //vengono settati i vari flag in modo da ricostruire
                    //graficamente la situazione
                    damiera.getDamieraPedine(x1, y1).setBlank(true);
                    damiera.getDamieraPedine(x2, y2).setBlank(false);
                    damiera.getDamieraPedine(x2, y2).setWhite(false);

                    setValid(true);

                    if (getPosizione2() > Costante.POS_VENTOTTO
                            && getPosizione2() <= Costante.POS_TRENTADUE) {
                        damiera.getDamieraPedine(x2, y2).setDama(true);
                    }

                } else {
                    setValid(false);
                }
            } else {
                setValid(false);
            }
        } else {
            setValid(false);
        }
        return getValid();
    }

    /**
     * Metodo che gestisce la presa semplice delle pedine
     * del giocatore nero.
     * <ul>
     *     <li><code>true</code>, la presa &#232; valida;</li>
     *     <li><code>false</code>, la presa non &#232; valida.</li>
     * </ul>
     *
     * @param damiera Damiera utilizzata durante la partita in corso
     * @return booleano che indica se la mossa è valida
     */
    public boolean presaSemplice(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle
        //posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(getPosizione1());
        int x2 = damiera.cercaRiga(getPosizione2());

        int y1 = damiera.cercaColonna(getPosizione1());
        int y2 = damiera.cercaColonna(getPosizione2());

        int x4 = x2 - Costante.UNO;

        //vengono effettuati una serie di controlli per controllare che
        //le pedine vengano spostate solo "dall'alto verso il basso"
        // (bianco) e che la (casella in) pos2 disti dalla (casella in)
        // pos1 esattemente 2
        if (x2 > x1) {
            if ((x2 == x1 + Costante.DUE)
                    && (y2 == y1 + Costante.DUE || y2 == y1 - Costante.DUE)) {
                if (damiera.getDamieraPedine(x2, y2).getBlank() && !damiera.getDamieraPedine(x1, y1).getBlank()) {

                    //1Â° caso, DESTRA: la presa viene effettuatta a DESTRA
                    //rispetto alla casella iniziale (y4 = y2 - 1)
                    if (y2 > y1 && !damiera.getDamieraPedine(x4, (y2 - Costante.UNO)).getBlank()
                            && damiera.getDamieraPedine(x4, (y2 - Costante.UNO)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 - Costante.UNO)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(false);

                        damiera.getDamieraPedine(x4, (y2 - Costante.UNO)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 - Costante.UNO)).setWhite(false);

                        setValid(true);

                        if (getPosizione2() > Costante.POS_VENTOTTO
                                && getPosizione2() <= Costante.POS_TRENTADUE) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                        //2Â° caso, SINISTRA: la presa viene effettuatta a sx
                        //rispetto alla casella iniziale (y4 = y2 + 1)
                    } else if (y2 < y1 && !damiera.getDamieraPedine(x4, (y2 + Costante.UNO)).getBlank()
                            && damiera.getDamieraPedine(x4, (y2 + Costante.UNO)).getWhite()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 + Costante.UNO)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 + Costante.UNO)).setWhite(true);

                        setValid(true);

                        if (getPosizione2() > Costante.POS_VENTOTTO
                                && getPosizione2() <= Costante.POS_TRENTADUE) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                    }
                } else {
                    setValid(false);
                }
            } else {
                setValid(false);
            }
        } else {
            setValid(false);
        }
        return getValid();
    }
}
