package it.uniba.main;

/**
 * Class Type: <<Control>>
 * Responsabilities: Classe che si occupa di effettuare
 * tutti i movimenti delle pedine per ciascun giocatore.
 */

public class Mossa {

    private int posizione1;
    private int posizione2;
    private int posizione3;
    private int posizione4;
    private boolean isValid;

    //Costanti numeriche
    // posizioni
    public static final int POS_VENTOTTO = 28;
    public static final int POS_TRENTADUE = 32;
    // valori numerici
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int FOUR = 4;

    public void setPosizione1(final int pos1) {
        this.posizione1 = pos1;
    }

    public void setPosizione2(final int pos2) {
        this.posizione2 = pos2;
    }

    public void setPosizione3(final int pos3) {
        this.posizione3 = pos3;
    }

    public void setPosizione4(final int pos4) {
        this.posizione4 = pos4;
    }

    public void setValid(final boolean valid) {
        this.isValid = valid;
    }

    public int getPosizione1() {
        return posizione1;
    }

    public int getPosizione2() {
        return posizione2;
    }

    public int getPosizione3() {
        return posizione3;
    }

    public boolean getValid() {
        return isValid;
    }

    //TODO Costruttore PARAMETRIZZATO mai utilizzato
    public Mossa(final int pos1, final int pos2) {
        this.posizione1 = pos1;
        this.posizione2 = pos2;
        this.isValid = false;
    }

    //Metodo che si occupa di far muovere le pedine del giocatore bianco
    public void spostamentoSempliceNero(final Damiera damiera) {

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
                        && damiera.getDamieraPedine(x1, y1).getWhite()) {

                    //vengono settati i vari flag in modo da ricostruire
                    //graficamente la situazione
                    damiera.getDamieraPedine(x1, y1).setBlank(true);
                    damiera.getDamieraPedine(x2, y2).setBlank(false);
                    damiera.getDamieraPedine(x2, y2).setWhite(true);

                    isValid = true;

                    if (getPosizione2() > POS_VENTOTTO
                            && getPosizione2() <= POS_TRENTADUE) {
                        damiera.getDamieraPedine(x2, y2).setDama(true);
                    }

                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
    }

    //Metodo che si occupa di far muovere le pedine del giocatore nero
    public void spostamentoSempliceBianco(final Damiera damiera) {

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
                        && !damiera.getDamieraPedine(x1, y1).getWhite()) {

                    //vengono settati i vari flag in modo da ricostruire
                    //graficamente la situazione
                    damiera.getDamieraPedine(x1, y1).setBlank(true);
                    damiera.getDamieraPedine(x2, y2).setBlank(false);
                    damiera.getDamieraPedine(x2, y2).setWhite(false);
                    isValid = true;

                    if (getPosizione2() >= ONE && getPosizione2() <= FOUR) {
                        damiera.getDamieraPedine(x2, y2).setDama(true);
                    }

                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
    }

    //Metodo che si occupa di effettuare una presa per il bianco
    public boolean presaSempliceBlack(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle
        //posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);


        int x4 = x2 - 1;


        //vengono effettuati una serie di controlli per controllare che
        //le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 > x1) {
            if ((x2 == x1 + TWO) && (y2 == y1 + TWO || y2 == y1 - TWO)) {
                if (damiera.getDamieraPedine(x2, y2).getBlank() && !damiera.getDamieraPedine(x1, y1).getBlank()) {

                    //1° caso, DESTRA: la presa viene effettuatta a DESTRA
                    //rispetto alla casella iniziale (y4 = y2 - 1)
                    if (y2 > y1 && !damiera.getDamieraPedine(x4, (y2 - ONE)).getBlank()
                            && !damiera.getDamieraPedine(x4, (y2 - ONE)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 - ONE)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 - ONE)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 - ONE)).setWhite(true);

                        isValid = true;

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

                        isValid = true;

                        if (getPosizione2() > POS_VENTOTTO
                                && getPosizione2() <= POS_TRENTADUE) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                    }
                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        return isValid;
    }

    //Metodo che si occupa di effettuare una presa per il nero
    public boolean presaSempliceWhite(final Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);

        //viene creata una 3a variabile che ha doppia coordinata y in quanto
        //deve considerare i due casi in cui la presa venga effettuata a sx o dx.
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
                            && damiera.getDamieraPedine(x4, (y2 - ONE)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 - ONE)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(false);

                        damiera.getDamieraPedine(x4, (y2 - 1)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 - 1)).setWhite(false);

                        isValid = true;

                        if (getPosizione2() >= ONE && getPosizione2() <= FOUR) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                        //2° caso, SINISTRA: la presa viene effettuatta a sx
                        //rispetto alla casella iniziale (y4 = y2 + 1)
                    } else if (y2 < y1
                            && !damiera.getDamieraPedine(x4, (y2 + ONE)).getBlank()
                            && damiera.getDamieraPedine(x4, (y2 + ONE)).getWhite()
                            && !damiera.getDamieraPedine(x4, (y2 + ONE)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(false);

                        damiera.getDamieraPedine(x4, (y2 + ONE)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 + ONE)).setWhite(false);

                        isValid = true;

                        if (getPosizione2() >= ONE && getPosizione2() <= FOUR) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }
                    }
                } else {
                    isValid = false;
                }
            } else {
                isValid = false;
            }
        } else {
            isValid = false;
        }
        return isValid;
    }

    //Metodo che si occupa di effettuare una presa per il bianco:
    //è una concatenazione di due prese semplici
    public void presaMultiplaBlack(final Damiera damiera) {

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
    }

    //Metodo che si occupa di effettuare una presa multipla per il nero
    public void presaMultiplaWhite(final Damiera damiera) {

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
    }

    public boolean presaMultiplaBlackProva(final Damiera damieraCopia) { //PROVA

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