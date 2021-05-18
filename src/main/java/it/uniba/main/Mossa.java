package it.uniba.main;

/**
 * Class Type: <<Control>>
 * Responsabilities: Classe che si occupa di effettuare tutti i movimenti delle pedine per ciascun giocatore
 */

public class Mossa {

    private int posizione1;
    private int posizione2;
    private int posizione3;
    private int posizione4;
    private boolean isValid;

    public void setPosizione1(int posizione1) {
        this.posizione1 = posizione1;
    }

    public void setPosizione2(int posizione2) {
        this.posizione2 = posizione2;
    }

    public void setPosizione3(int posizione3) {
        this.posizione3 = posizione3;
    }

    public void setPosizione4(int posizione4) {
        this.posizione4 = posizione4;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
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

    public Mossa(int posizione1, int posizione2) {
        this.posizione1 = posizione1;
        this.posizione2 = posizione1;
        this.isValid = false;
    }

    //Metodo che si occupa di far muovere le pedine del giocatore bianco
    public void SpostamentoSempliceNero(Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);

        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 1
        if (x2 > x1) {
            if ((x2 == x1 + 1) &&  // q
                    (y2 == y1 + 1 ||
                            y2 == y1 - 1)) {

                //qui viene controllata che la casella iniziale sia effettivamente occupata da una pedina (bianca) e quella di arrivo sia vuota
                if (damiera.getDamieraPedine(x2, y2).getBlank() &&
                        !damiera.getDamieraPedine(x1, y1).getBlank() && damiera.getDamieraPedine(x1, y1).getWhite()) {

                    //vengono settati i vari flag in modo da ricostruire graficamente la situazione
                    damiera.getDamieraPedine(x1, y1).setBlank(true);
                    damiera.getDamieraPedine(x2, y2).setBlank(false);
                    damiera.getDamieraPedine(x2, y2).setWhite(true);

                    isValid = true;

                    if (getPosizione2() > 28 && getPosizione2() <= 32) {
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
    public void SpostamentoSempliceBianco(Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);


        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 1
        if (x2 < x1) {
            if ((x2 == x1 - 1) &&
                    (y2 == y1 + 1 ||
                            y2 == y1 - 1)) {

                //qui viene controllata che la casella iniziale sia effettivamente occupata da una pedina (nera) e quella di arrivo sia vuota
                if (damiera.getDamieraPedine(x2, y2).getBlank() &&
                        !damiera.getDamieraPedine(x1, y1).getBlank() && !damiera.getDamieraPedine(x1, y1).getWhite()) {

                    //vengono settati i vari flag in modo da ricostruire graficamente la situazione
                    damiera.getDamieraPedine(x1, y1).setBlank(true);
                    damiera.getDamieraPedine(x2, y2).setBlank(false);
                    damiera.getDamieraPedine(x2, y2).setWhite(false);
                    isValid = true;

                    if (getPosizione2() >= 1 && getPosizione2() <= 4) {
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
    public boolean PresaSempliceBlack(Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);


        int x4 = x2 - 1;


        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 > x1) {
            if ((x2 == x1 + 2) && (y2 == y1 + 2 || y2 == y1 - 2)) {
                if (damiera.getDamieraPedine(x2, y2).getBlank() && !damiera.getDamieraPedine(x1, y1).getBlank()) {

                    //1° caso, DESTRA: la presa viene effettuatta a DESTRA rispetto alla casella iniziale (y4 = y2 - 1)
                    if (y2 > y1 && !damiera.getDamieraPedine(x4, (y2 - 1)).getBlank() && !damiera.getDamieraPedine(x4, (y2 - 1)).getWhite() && !damiera.getDamieraPedine(x4, (y2 - 1)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 - 1)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 - 1)).setWhite(true);

                        isValid = true;

                        if (getPosizione2() > 28 && getPosizione2() <= 32) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                    }
                    //2° caso, SINISTRA: la presa viene effettuatta a sx rispetto alla casella iniziale (y4 = y2 + 1)
                    else if (y2 < y1 && !damiera.getDamieraPedine(x4, (y2 + 1)).getBlank() && !damiera.getDamieraPedine(x4 ,(y2 + 1)).getWhite()) {

                        damiera.getDamieraPedine(x1 ,y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(true);

                        damiera.getDamieraPedine(x4, (y2 + 1)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 + 1)).setWhite(true);

                        isValid = true;

                        if (getPosizione2() > 28 && getPosizione2() <= 32) {
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
    public boolean PresaSempliceWhite(Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.cercaRiga(posizione1);
        int x2 = damiera.cercaRiga(posizione2);

        int y1 = damiera.cercaColonna(posizione1);
        int y2 = damiera.cercaColonna(posizione2);

        //viene creata una 3a variabile che ha doppia coordinata y in quanto deve considerare i due casi in cui la presa venga effettuata a sx o dx. La casella individuata da x3 e y3 rappresenta la casella "di mezzo" fra quella in pos1 e quella in pos2
        int x4 = x2 + 1;


        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 < x1) {
            if ((x2 == x1 - 2) && (y2 == y1 - 2 || y2 == y1 + 2)) {
                if (damiera.getDamieraPedine(x2, y2).getBlank() && !damiera.getDamieraPedine(x1, y1).getBlank()) {

                    //1° caso, DESTRA: la presa viene effettuatta a dx rispetto alla casella iniziale (y4 = y2 - 1)
                    if (y2 > y1 && !damiera.getDamieraPedine(x4, (y2 - 1)).getBlank() && damiera.getDamieraPedine(x4, (y2 - 1)).getWhite() && !damiera.getDamieraPedine(x4, (y2 - 1)).getDama()) {

                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(false);

                        damiera.getDamieraPedine(x4, (y2 - 1)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 - 1)).setWhite(false);

                        isValid = true;

                        if (getPosizione2() >= 1 && getPosizione2() <= 4) {
                            damiera.getDamieraPedine(x2, y2).setDama(true);
                        }

                    }
                    //2° caso, SINISTRA: la presa viene effettuatta a sx rispetto alla casella iniziale (y4 = y2 + 1)
                    else if (y2 < y1 && !damiera.getDamieraPedine(x4, (y2 + 1)).getBlank() && damiera.getDamieraPedine(x4, (y2 + 1)).getWhite() && !damiera.getDamieraPedine(x4, (y2 + 1)).getDama()) {
                        damiera.getDamieraPedine(x1, y1).setBlank(true);
                        damiera.getDamieraPedine(x2, y2).setBlank(false);
                        damiera.getDamieraPedine(x2, y2).setWhite(false);

                        damiera.getDamieraPedine(x4, (y2 + 1)).setBlank(true);
                        damiera.getDamieraPedine(x4, (y2 + 1)).setWhite(false);

                        isValid = true;

                        if (getPosizione2() >= 1 && getPosizione2() <= 4) {
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

    //Metodo che si occupa di effettuare una presa per il bianco: è una concatenazione di due prese semplici
    public void PresaMultiplaBlack(Damiera damiera) {

        Damiera DamieraCopia = new Damiera(damiera);

        //salvo le posizioni poichè verranno sovrascritte con la damiera di copia
        int pos1 = getPosizione1();
        int pos2 = getPosizione2();
        int pos3 = getPosizione3();


        //se la presa provata nella damiera di prova è valida, allora la eseguo su quella originale
        if (PresaMultiplaBlackProva(DamieraCopia)) {

            //1a PRESA
            setPosizione1(pos1);
            setPosizione2(pos2);

            PresaSempliceBlack(damiera);


            //2a PRESA
            setPosizione1(posizione2);
            setPosizione2(posizione3);

            PresaSempliceBlack(damiera);

            if (posizione4 != 0) {
                //3a PRESA
                setPosizione1(pos3);
                setPosizione2(posizione4);

                PresaSempliceBlack(damiera);
            }
        }
    }

    //Metodo che si occupa di effettuare una presa multipla per il nero
    public void PresaMultiplaWhite(Damiera damiera) {

        Damiera DamieraCopia = new Damiera(damiera);

        //salvo le posizioni poichè verranno sovrascritte con la damiera di copia
        int pos1 = getPosizione1();
        int pos2 = getPosizione2();
        int pos3 = getPosizione3();

        //se la presa provata nella damiera di prova è valida, allora la eseguo su quella originale
        if (PresaMultiplaWhiteProva(DamieraCopia)) {

            //1a PRESA
            setPosizione1(pos1);
            setPosizione2(pos2);

            PresaSempliceWhite(damiera);

            //2a PRESA
            setPosizione1(posizione2);
            setPosizione2(posizione3);

            PresaSempliceWhite(damiera);

            if (posizione4 != 0) {
                //3a PRESA
                setPosizione1(pos3);
                setPosizione2(posizione4);

                PresaSempliceWhite(damiera);

            }

        }
    }

    public boolean PresaMultiplaBlackProva(Damiera DamieraCopia) { //PROVA

        boolean prova = false;
        boolean prova1 = PresaSempliceBlack(DamieraCopia);
        boolean prova2 = false;
        boolean prova3 = false;

        if (prova1) {

            setPosizione1(posizione2);
            setPosizione2(posizione3);

            prova2 = PresaSempliceBlack(DamieraCopia);
            if (prova2) {

                prova = true;
                if (posizione4 != 0) {
                    setPosizione1(posizione3);
                    setPosizione2(posizione4);
                    prova3 = PresaSempliceBlack(DamieraCopia);
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

    public boolean PresaMultiplaWhiteProva(Damiera DamieraCopia) { //PROVA

        boolean prova = false;
        boolean prova1 = PresaSempliceWhite(DamieraCopia);
        boolean prova2 = false;
        boolean prova3 = false;

        if (prova1) {

            setPosizione1(posizione2);
            setPosizione2(posizione3);

            prova2 = PresaSempliceWhite(DamieraCopia);
            if (prova2) {

                prova = true;
                if (posizione4 != 0) {
                    setPosizione1(posizione3);
                    setPosizione2(posizione4);
                    prova3 = PresaSempliceWhite(DamieraCopia);
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