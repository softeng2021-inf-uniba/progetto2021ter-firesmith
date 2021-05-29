package it.uniba.gioco;

import it.uniba.strumenti.Costanti;
import it.uniba.tavolo.Damiera;

/**
 * <h1>Classe che effettua le mosse per il giocatore bianco.</h1><br>
 * <b>Class Type:</b> &#60; Control &#62; <br><br>
 * <b>Responsabilities:</b> <br>
 * <p><b>Knows:</b>
 *     <ul>
 *     <li> Le posizioni delle caselle sulle quali effettuare le mosse </li>
 *     <li> L'effettiva validit&#224; di una mossa </li>
 *     </ul> <br>
 *     <b>Does:</b>
 *         <ul>
 *         <li> Permette all'utente di inserire la mossa
 *         ed effettuare lo spostamento,
 *         le prese semplici o le prese multiple;</li>
 *         <li>Controlla la validit&#224; delle mosse inserite.</li>
 *         </ul>
 *
 * @author Gruppo Firesmith
 */
public class MossaBianco extends Mossa {
    /**
     * Costruttore che richiama quello della sua superclasse.
     *
     * @param pos1 casella d'inizio
     * @param pos2 casella d'arrivo
     */
    public MossaBianco(int pos1, int pos2) {
        super(pos1, pos2);
    }

    /**
     * Metodo che gestisce lo spostamento delle pedine del giocatore bianco.
     *
     * @param damiera Damiera utilizzata durante la partita in corso
     */
    public boolean spostamentoSemplice(final Damiera damiera) {
        //qui vengono cercate le coordinate corrispondenti alle
        //posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(getPosizione1());
        int x2 = damiera.cercaRiga(getPosizione2());

        int y1 = damiera.cercaColonna(getPosizione1());
        int y2 = damiera.cercaColonna(getPosizione2());

        //vengono effettuati una serie di controlli per controllare che
        // le pedine vengano spostate solo "dall'alto verso il basso" (bianco)
        // e che la (casella in) pos2 disti dalla (casella in) pos1 esatt 1
        if (x2 < x1) {
            if ((x2 == x1 - Costanti.UNO)
                    && (y2 == y1 + Costanti.UNO
                    || y2 == y1 - Costanti.UNO)) {

                //qui viene controllata che la casella iniz sia effett. occupata
                // da una pedina (nera) e quella di arrivo sia vuota
                if (damiera.getDamieraPedine(x2, y2).getBlank()
                        && !damiera.getDamieraPedine(x1, y1).getBlank()
                        && damiera.getDamieraPedine(x1, y1).getWhite()) {

                    //vengono settati i vari flag in modo da ricostruire
                    //graficamente la situazione
                    damiera.getDamieraPedine(x1, y1).setBlank(true);
                    damiera.getDamieraPedine(x2, y2).setBlank(false);
                    damiera.getDamieraPedine(x2, y2).setWhite(true);
                    setValid(true);

                    if (getPosizione2() >= Costanti.UNO && getPosizione2() <= Costanti.QUATTRO) {
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
     * del giocatore bianco.
     * <ul>
     *     <li><code>true</code>, la presa &#232; valida;</li>
     *     <li><code>false</code>, la presa non &#232; valida.</li>
     * </ul>
     *
     * @param damiera Damiera utilizzata durante la partita in corso
     * @return Validit&#224; della presa semplice
     */
    public boolean presaSemplice(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(getPosizione1());
        int x2 = damiera.cercaRiga(getPosizione2());

        int y1 = damiera.cercaColonna(getPosizione1());
        int y2 = damiera.cercaColonna(getPosizione2());

        //viene creata una 3a variabile che ha doppia coordinata y
        // in quanto deve considerare i due casi in cui la presa
        // venga effettuata a sx o dx.
        //La casella individuata da x3 e y3 rappresenta la casella "di mezzo"
        //fra quella in pos1 e quella in pos2
        int x4 = x2 + Costanti.UNO;

        //vengono effettuati una serie di controlli per controllare che
        //le pedine vengano spostate solo "dall'alto verso il basso" (bianco)
        //e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 < x1) {
            if ((x2 == x1 - Costanti.DUE) && (y2 == y1 - Costanti.DUE || y2 == y1 + Costanti.DUE)) {
                if (damiera.getDamieraPedine(x2, y2).getBlank()
                        && !damiera.getDamieraPedine(x1, y1).getBlank()) {

                    //1Â° caso, DESTRA: la presa viene effettuatta a dx
                    //rispetto alla casella iniziale (y4 = y2 - 1)
                    if (y2 > y1 && !damiera.getDamieraPedine(x4, (y2 - Costanti.UNO)).getBlank()
                            && !damiera.getDamieraPedine(x4, (y2 - Costanti.UNO)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 - Costanti.UNO)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 - Costanti.UNO)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 - Costanti.UNO)).setWhite(true);

                        setValid(true);

                        if (getPosizione2() >= Costanti.UNO && getPosizione2() <= Costanti.QUATTRO) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                        //2Â° caso, SINISTRA: la presa viene effettuatta a sx
                        //rispetto alla casella iniziale (y4 = y2 + 1)
                    } else if (y2 < y1
                            && !damiera.getDamieraPedine(x4, (y2 + Costanti.UNO)).getBlank()
                            && !damiera.getDamieraPedine(x4, (y2 + Costanti.UNO)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 + Costanti.UNO)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 + Costanti.UNO)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 + Costanti.UNO)).setWhite(true);

                        setValid(true);

                        if (getPosizione2() >= Costanti.UNO && getPosizione2() <= Costanti.QUATTRO) {
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

