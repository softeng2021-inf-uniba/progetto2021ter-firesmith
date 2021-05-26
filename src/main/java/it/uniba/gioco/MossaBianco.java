package it.uniba.gioco;

import it.uniba.strumenti.Costanti;
import it.uniba.tavolo.Damiera;

public class MossaBianco extends Mossa {

    public MossaBianco(int pos1, int pos2) {
        super(pos1, pos2);
    }

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

    public boolean presaMultiplaProva(final Damiera damieraCopia) { //PROVA

        boolean prova = false;
        boolean prova1 = presaSemplice(damieraCopia);
        boolean prova2 = false;
        boolean prova3 = false;

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

