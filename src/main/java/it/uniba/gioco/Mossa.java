package it.uniba.gioco;

import it.uniba.tavolo.Damiera;

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

public abstract class Mossa {
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
    private boolean isPresaTripla;

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

    public void setPresaTripla(final boolean isPresaTripla) {
        this.isPresaTripla = isPresaTripla;
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
     * dell'utente in caso di presa multipla
     */
    public int getPosizione3() {
        return posizione3;
    }
    /**
     * Fornisce la posizione di destinazione (o transitoria)
     * della pedina dopo una presa multipla.
     * @return Posizione della 4a casella nella mossa
     * dell'utente in caso di presa multipla
     */
    public int getPosizione4() {
        return posizione4;
    }

    /**
     * Imposta il flag {@link Mossa#isPresaTripla}.
     * @return isPresaTripla della mossa.
     */
    public boolean getPresaTripla() {
        return isPresaTripla;
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
     * Metodo astratto che viene implementato dalle sottoclassi mossaBianco e mossaNero
     * @param damiera la quale viene modificata
     * @return getValid() che indica se la mossa e' valida
     */
    public abstract boolean spostamentoSemplice(final Damiera damiera);

    /**
     * Metodo astratto che viene implementato dalle sottoclassi mossaBianco e mossaNero
     * @param damiera la quale viene modificata
     * @return getValid() che indica se la mossa e' valida
     */
    public abstract boolean presaSemplice(final Damiera damiera);

    /**
     * Metodo che gestisce la presa multipla delle pedine del giocatore bianco.<br>
     * Viene simulata su una copia della damiera, e se il metodo
     * {@link Mossa#presaMultiplaProva} ritorna:
     * <ul>
     *     <li><code>true</code>, la presa &#232; valida e sar&#224; eseguita;</li>
     *     <li><code>false</code>, altrimenti.</li>
     * </ul>
     * <br>
     * Si tratta di una concatenazione di due prese semplici.
     *
     * @param damiera Damiera utilizzata durante la partita in corso
     */
    public boolean presaMultipla(final Damiera damiera) {

        Damiera damieraCopia = new Damiera(damiera);

        //salvo le posizioni poichÃ¨ verranno sovrascritte
        //con la damiera di copia
        int pos1 = getPosizione1();
        int pos2 = getPosizione2();
        int pos3 = getPosizione3();

        //se la presa provata nella damiera di prova Ã¨ valida,
        //allora la eseguo su quella originale
        if (presaMultiplaProva(damieraCopia)) {

            //1a PRESA
            setPosizione1(pos1);
            setPosizione2(pos2);

            presaSemplice(damiera);

            //2a PRESA
            setPosizione1(getPosizione2());
            setPosizione2(getPosizione3());

            presaSemplice(damiera);

            if (getPosizione4() != 0) {
                //3a PRESA
                setPosizione1(pos3);
                setPosizione2(getPosizione4());

                presaSemplice(damiera);

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
    public boolean presaMultiplaProva(final Damiera damieraCopia) {
        boolean prova = false;
        boolean prova1 = presaSemplice(damieraCopia);
        boolean prova2;
        boolean prova3;

        if (prova1) {

            setPosizione1(getPosizione2());
            setPosizione2(getPosizione3());

            prova2 = presaSemplice(damieraCopia);

            if (prova2) {
                prova = true;
                if (getPosizione4() != 0) {
                    setPosizione1(getPosizione3());
                    setPosizione2(getPosizione4());
                    prova3 = presaSemplice(damieraCopia);
                    prova = prova3;
                }
            } else {
                prova = false;
            }
        }
        return prova;
    }
}
