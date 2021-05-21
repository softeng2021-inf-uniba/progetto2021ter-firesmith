package it.uniba.main;

/**
 * <h1>Classe che effettua le mosse delle pedine.</h1><br>
 * <b>Class Type:</b> &#60; Control &#62; <br><br>
 * <b>Responsabilities:</b> <br>
 *      <p><b>Knows:</b></p> <br>
 *      <b>Does:</b>
 *          <ul>
 *          <li> Permette all'utente di inserire la mossa
 *          ed effettuare lo spostamento,
 *          le prese semplici o le prese multiple;</li>
 *          <li>Controlla la validit&#224; delle mosse inserite.</li>
 *          </ul>
 *
 * @author Gruppo Firesmith
 */


public class Mossa {
    /** Posizione della pedina da spostare per effettuare una mossa. */
    private int posizione1;
    /** Posizione in cui deve essere spostata la pedina iniziale. */
    private int posizione2;
    /** Posizione in cui deve essere spostata la pedina iniziale
     * in seguito ad una presa doppia. */
    private int posizione3;
    /** Posizione in cui deve essere spostata la pedina iniziale
     * in seguito ad una presa tripla.*/
    private int posizione4;
    /** Definisce se la mossa effettuata (spostamento, presa semplice,
     * presa multipla) &#232; consentita dalle regole.*/
    private boolean isValid;

    //Costanti numeriche
    // posizioni
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    public static final int POS_VENTOTTO = 28;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    public static final int POS_TRENTADUE = 32;
    // valori numerici
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    public static final int ONE = 1;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    public static final int TWO = 2;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    public static final int FOUR = 4;

    /**
     * Imposta la posizione iniziale della pedina
     * in {@link Mossa#posizione1}.
     * @param pos1 Posizione iniziale della pedina
     */
    public void setPosizione1(final int pos1) {
        this.posizione1 = pos1;
    }

    /**
     * Imposta la posizione finale della pedina in
     * {@link Mossa#posizione2} in seguito ad uno spostamento
     * o ad una presa semplice.
     * @param pos2 Posizione finale della pedina spostata
     */
    public void setPosizione2(final int pos2) {
        this.posizione2 = pos2;
    }

    /**
     * Imposta la posizione finale della pedina in
     * {@link Mossa#posizione3} in seguito ad una presa multipla doppia.
     * @param pos3 Posizione finale della pedina spostata
     */
    public void setPosizione3(final int pos3) {
        this.posizione3 = pos3;
    }

    /**
     * Imposta la posizione iniziale della pedina in
     * {@link Mossa#posizione4} in seguito ad una presa multipla tripla.
     * @param pos4 Posizione finale della pedina spostata
     */
    public void setPosizione4(final int pos4) {
        this.posizione4 = pos4;
    }

    /**
     * Fornisce la posizione della pedina che inizia la mossa.
     * @return Posizione iniziale della pedina
     */
    public int getPosizione1() {
        return posizione1;
    }

    /**
     * Fornisce la posizione di destinazione della pedina
     * dopo la mossa.
     * @return Posizione finale della pedina
     */
    public int getPosizione2() {
        return posizione2;
    }

    /**
     * Fornisce la posizione di destinazione (o transitoria)
     * della pedina dopo una presa multipla.
     * @return Posizione della 3a casella nella mossa
     * dell'utente in caso di presa semplice
     */
    public int getPosizione3() {
        return posizione3;
    }

    /**
     * Imposta il flag {@link Mossa#isValid}.
     * @param valid Validit&#224; della mossa
     */
    public void setValid(final boolean valid) {
        this.isValid = valid;
    }

    /**
     * Controlla se una mossa inserita &#232; valida oppure no.
     * <ul>
     *     <li><code>true</code>, se la mossa &#232; valida;</li>
     *     <li><code>false</code>, se la mossa non &#232; valida.</li>
     * </ul>
     * @return Validit&#224; della mossa inserita
     */
    public boolean getValid() {
        return isValid;
    }

    //TODO Costruttore PARAMETRIZZATO mai utilizzato

    /**
     * Assegna il valore di {@link Mossa#posizione1} e {@link Mossa#posizione2}.
     * @param pos1 Posizione iniziale della pedina da muovere
     * @param pos2 Posizione finale in cui deve andare la pedina
     */
    public Mossa(final int pos1, final int pos2) {
        this.posizione1 = pos1;
        this.posizione2 = pos2;
        this.isValid = false;
    }

    /**
     * Metodo che gestisce lo spostamento delle pedine del giocatore nero.
     * @param damiera Damiera utilizzata durante la partita in corso
     */
    public boolean spostamentoSempliceNero(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti
        //alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);

        //vengono effettuati una serie di controlli per controllare che
        //le pedine vengano spostate solo "dall'alto verso il basso" (bianco)
        //e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 1
        if (x2 > x1) {
            if ((x2 == x1 + 1)
                    && (y2 == y1 + 1
                    || y2 == y1 - 1)) {

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

                    if (getPosizione2() > POS_VENTOTTO
                            && getPosizione2() <= POS_TRENTADUE) {
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
     * Metodo che gestisce lo spostamento delle pedine del giocatore bianco.
     * @param damiera Damiera utilizzata durante la partita in corso
     */
    public boolean spostamentoSempliceBianco(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle
        //posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);


        //vengono effettuati una serie di controlli per controllare che
        // le pedine vengano spostate solo "dall'alto verso il basso" (bianco)
        // e che la (casella in) pos2 disti dalla (casella in) pos1 esatt 1
        if (x2 < x1) {
            if ((x2 == x1 - ONE)
                    && (y2 == y1 + ONE
                    || y2 == y1 - ONE)) {

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

                    if (getPosizione2() >= ONE && getPosizione2() <= FOUR) {
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
     * @param damiera Damiera utilizzata durante la partita in corso
     * @return Validit&#224; della presa semplice
     */
    public boolean presaSempliceBlack(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle
        //posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);

        int x4 = x2 - 1;

        //vengono effettuati una serie di controlli per controllare che
        //le pedine vengano spostate solo "dall'alto verso il basso"
        // (bianco) e che la (casella in) pos2 disti dalla (casella in)
        // pos1 esattemente 2
        if (x2 > x1) {
            if ((x2 == x1 + TWO)
                    && (y2 == y1 + TWO || y2 == y1 - TWO)) {
                if (damiera.getDamieraPedine(x2, y2).getBlank() && !damiera.getDamieraPedine(x1, y1).getBlank()) {

                    //1° caso, DESTRA: la presa viene effettuatta a DESTRA
                    //rispetto alla casella iniziale (y4 = y2 - 1)
                    if (y2 > y1 && !damiera.getDamieraPedine(x4, (y2 - ONE)).getBlank()
                            && damiera.getDamieraPedine(x4, (y2 - ONE)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 - ONE)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(false);

                        damiera.getDamieraPedine(x4, (y2 - ONE)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 - ONE)).setWhite(false);

                        setValid(true);

                        if (getPosizione2() > POS_VENTOTTO
                                && getPosizione2() <= POS_TRENTADUE) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                        //2° caso, SINISTRA: la presa viene effettuatta a sx
                        //rispetto alla casella iniziale (y4 = y2 + 1)
                    } else if (y2 < y1 && !damiera.getDamieraPedine(x4, (y2 + ONE)).getBlank()
                            && !damiera.getDamieraPedine(x4, (y2 + ONE)).getWhite()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 + ONE)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 + ONE)).setWhite(true);

                        setValid(true);

                        if (getPosizione2() > POS_VENTOTTO
                                && getPosizione2() <= POS_TRENTADUE) {
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

    /**
     * Metodo che gestisce la presa semplice delle pedine
     * del giocatore bianco.
     * <ul>
     *     <li><code>true</code>, la presa &#232; valida;</li>
     *     <li><code>false</code>, la presa non &#232; valida.</li>
     * </ul>
     * @param damiera Damiera utilizzata durante la partita in corso
     * @return Validit&#224; della presa semplice
     */
    public boolean presaSempliceWhite(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);

        //viene creata una 3a variabile che ha doppia coordinata y
        // in quanto deve considerare i due casi in cui la presa
        // venga effettuata a sx o dx.
        //La casella individuata da x3 e y3 rappresenta la casella "di mezzo"
        //fra quella in pos1 e quella in pos2
        int x4 = x2 + 1;

        //vengono effettuati una serie di controlli per controllare che
        //le pedine vengano spostate solo "dall'alto verso il basso" (bianco)
        //e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 < x1) {
            if ((x2 == x1 - TWO) && (y2 == y1 - TWO || y2 == y1 + TWO)) {
                if (damiera.getDamieraPedine(x2, y2).getBlank()
                        && !damiera.getDamieraPedine(x1, y1).getBlank()) {

                    //1° caso, DESTRA: la presa viene effettuatta a dx
                    //rispetto alla casella iniziale (y4 = y2 - 1)
                    if (y2 > y1 && !damiera.getDamieraPedine(x4, (y2 - ONE)).getBlank()
                            && !damiera.getDamieraPedine(x4, (y2 - ONE)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 - ONE)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 - 1)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 - 1)).setWhite(true);

                        setValid(true);

                        if (getPosizione2() >= ONE && getPosizione2() <= FOUR) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                        //2° caso, SINISTRA: la presa viene effettuatta a sx
                        //rispetto alla casella iniziale (y4 = y2 + 1)
                    } else if (y2 < y1
                            && !damiera.getDamieraPedine(x4, (y2 + ONE)).getBlank()
                            && !damiera.getDamieraPedine(x4, (y2 + ONE)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 + ONE)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 + ONE)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 + ONE)).setWhite(true);

                        setValid(true);

                        if (getPosizione2() >= ONE && getPosizione2() <= FOUR) {
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

    /**
     * Metodo che gestisce la presa multipla delle pedine del giocatore nero.<br>
     * Viene simulata su una copia della damiera, e se il metodo
     * {@link Mossa#presaMultiplaBlackProva} ritorna:
     * <ul>
     *     <li><code>true</code>, la presa &#232; valida e sar&#224; eseguita;</li>
     *     <li><code>false</code>, altrimenti.</li>
     * </ul>
     * <br>
     * Si tratta di una concatenazione di due prese semplici.
     *
     * @param damiera Damiera utilizzata durante la partita in corso
     */
    public boolean presaMultiplaBlack(final Damiera damiera) {

        Damiera damieraCopia = new Damiera(damiera);

        //salvo le posizioni poichè verranno sovrascritte con
        //la damiera di copia
        int pos1 = getPosizione1();
        int pos2 = getPosizione2();
        int pos3 = getPosizione3();


        //se la presa provata nella damiera di prova è valida,
        //allora la eseguo su quella originale
        if (presaMultiplaBlackProva(damieraCopia)) {

            //1a PRESA
            setPosizione1(pos1);
            setPosizione2(pos2);

            presaSempliceBlack(damiera);


            //2a PRESA
            setPosizione1(posizione2);
            setPosizione2(posizione3);

            presaSempliceBlack(damiera);

            if (posizione4 != 0) {
                //3a PRESA
                setPosizione1(pos3);
                setPosizione2(posizione4);

                presaSempliceBlack(damiera);
            }
        }
        return isValid;
    }

    /**
     * Metodo che gestisce la presa multipla delle pedine del giocatore bianco.<br>
     * Viene simulata su una copia della damiera, e se il metodo
     * {@link Mossa#presaMultiplaWhiteProva} ritorna:
     * <ul>
     *     <li><code>true</code>, la presa &#232; valida e sar&#224; eseguita;</li>
     *     <li><code>false</code>, altrimenti.</li>
     * </ul>
     * <br>
     * Si tratta di una concatenazione di due prese semplici.
     *
     * @param damiera Damiera utilizzata durante la partita in corso
     */
    public boolean presaMultiplaWhite(final Damiera damiera) {

        Damiera damieraCopia = new Damiera(damiera);

        //salvo le posizioni poichè verranno sovrascritte
        //con la damiera di copia
        int pos1 = getPosizione1();
        int pos2 = getPosizione2();
        int pos3 = getPosizione3();

        //se la presa provata nella damiera di prova è valida,
        //allora la eseguo su quella originale
        if (presaMultiplaWhiteProva(damieraCopia)) {

            //1a PRESA
            setPosizione1(pos1);
            setPosizione2(pos2);

            presaSempliceWhite(damiera);

            //2a PRESA
            setPosizione1(posizione2);
            setPosizione2(posizione3);

            presaSempliceWhite(damiera);

            if (posizione4 != 0) {
                //3a PRESA
                setPosizione1(pos3);
                setPosizione2(posizione4);

                presaSempliceWhite(damiera);

            }

        }
        return getValid();
    }

    /**
     * Metodo di prova che simula la presa multipla del giocatore nero.<br>
     * Viene simulata la prima presa, e se valida viene
     * simulata la successiva.
     * <ul>
     *     <li><code>true</code>, la simulazione della presa &#232; valida;</li>
     *     <li><code>false</code>, la simulazione della presa non &#232; valida.</li>
     * </ul>
     * @param damieraCopia Copia della damiera utilizzata durante la partita
     * @return Validit&#224; della presa multipla
     */
    public boolean presaMultiplaBlackProva(final Damiera damieraCopia) {

        boolean prova = false;
        boolean prova1 = presaSempliceBlack(damieraCopia);
        boolean prova2 = false;
        boolean prova3 = false;

        if (prova1) {

            setPosizione1(posizione2);
            setPosizione2(posizione3);

            prova2 = presaSempliceBlack(damieraCopia);
            if (prova2) {

                prova = true;
                if (posizione4 != 0) {
                    setPosizione1(posizione3);
                    setPosizione2(posizione4);
                    prova3 = presaSempliceBlack(damieraCopia);
                    if (prova3) {
                        prova = true;
                    } else {
                        prova = false;
                    }
                }
            } else {
                prova = false;
            }
        }
        return prova;
    }

    /**
     * Metodo di prova che simula la presa multipla del giocatore bianco.<br>
     * Viene simulata la prima presa, e se valida viene simulata la successiva.
     * <ul>
     *     <li><code>true</code>, la simulazione della presa multupla &#232; valida;</li>
     *     <li><code>false</code>, la simulazione della presa multipla non &#232; valida.</li>
     * </ul>
     * @param damieraCopia Copia della damiera utilizzata durante la partita
     * @return Validit&#224; della presa multipla
     */
    public boolean presaMultiplaWhiteProva(final Damiera damieraCopia) { //PROVA

        boolean prova = false;
        boolean prova1 = presaSempliceWhite(damieraCopia);
        boolean prova2 = false;
        boolean prova3 = false;

        if (prova1) {

            setPosizione1(posizione2);
            setPosizione2(posizione3);

            prova2 = presaSempliceWhite(damieraCopia);
            if (prova2) {

                prova = true;
                if (posizione4 != 0) {
                    setPosizione1(posizione3);
                    setPosizione2(posizione4);
                    prova3 = presaSempliceWhite(damieraCopia);
                    if (prova3) {
                        prova = true;
                    } else {
                        prova = false;
                    }
                }
            } else {
                prova = false;
            }
        }
        return prova;
    }
}
