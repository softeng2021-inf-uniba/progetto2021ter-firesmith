package it.uniba.main;

/*
    Oggetto Mossa
     - int posizione1
     - int posizione2
     - boolean isValid
 */
public class Mossa {

    private int posizione1;
    private int posizione2;
    private int posizione3;
    private int posizione4;
    private boolean isValid;

    public void setPosizione1(int posizione1) { this.posizione1 = posizione1; }
    public void setPosizione2(int posizione2) { this.posizione2 = posizione2; }
    public void setPosizione3(int posizione3) {this.posizione3 = posizione3; }
    public void setPosizione4(int posizione4) {this.posizione4 = posizione4; }
    public void setValid(boolean isValid) { this.isValid = isValid; }

    public int getPosizione1() { return posizione1; }
    public int getPosizione2() { return posizione2; }
    public int getPosizione3() { return posizione3; }
    public boolean getValid() { return isValid; }

    public Mossa(int posizione1, int posizione2) {
        this.posizione1 = posizione1;
        this.posizione2 = posizione1;
        this.isValid = false;
    }

    //Metodo che si occupa di far muovere le pedine del giocatore bianco
    public void SpostamentoSempliceBianco(Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.CercaRiga(posizione1);
        int x2 = damiera.CercaRiga(posizione2);

        int y1 = damiera.CercaColonna(posizione1);
        int y2 = damiera.CercaColonna(posizione2);

        System.out.println("posizione1: " + x1 + "," + y1 + "\nposizione2: " + x2 + "," + y2);

        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 1
        if (x2 > x1) {
            if ((x2 == x1 + 1) &&  // q
                    (y2 == y1 + 1 ||
                            y2 == y1 - 1)) {

                //qui viene controllata che la casella iniziale sia effettivamente occupata da una pedina (bianca) e quella di arrivo sia vuota
                if (damiera.DamieraPedine[x2][y2].getBlank() &&
                        !damiera.DamieraPedine[x1][y1].getBlank()) {

                    //vengono settati i vari flag in modo da ricostruire graficamente la situazione
                    damiera.DamieraPedine[x1][y1].setBlank(true);
                    damiera.DamieraPedine[x2][y2].setBlank(false);
                    damiera.DamieraPedine[x2][y2].setWhite(true);
                    isValid = true;

                    damiera.StampaDamieraPedine();

                } else {
                    System.out.println("Mossa non valida, riprovare: ");
                }
            } else {
                System.out.println("Mossa non valida, riprovare: ");
            }
        } else {
            System.out.println("Mossa non valida, riprovare: ");
        }
    }

    //Metodo che si occupa di far muovere le pedine del giocatore nero
    public void SpostamentoSempliceNero(Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.CercaRiga(posizione1);
        int x2 = damiera.CercaRiga(posizione2);

        int y1 = damiera.CercaColonna(posizione1);
        int y2 = damiera.CercaColonna(posizione2);

        System.out.println("posizione1: " + x1 + "," + y1 + "\nposizione2: " + x2 + "," + y2);

        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 1
        if (x2 < x1) {
            if ((x2 == x1 - 1) &&
                    (y2 == y1 + 1 ||
                            y2 == y1 - 1)) {

                //qui viene controllata che la casella iniziale sia effettivamente occupata da una pedina (nera) e quella di arrivo sia vuota
                if (damiera.DamieraPedine[x2][y2].getBlank() &&
                        !damiera.DamieraPedine[x1][y1].getBlank()) {

                    //vengono settati i vari flag in modo da ricostruire graficamente la situazione
                    damiera.DamieraPedine[x1][y1].setBlank(true);
                    damiera.DamieraPedine[x2][y2].setBlank(false);
                    damiera.DamieraPedine[x2][y2].setWhite(false);
                    isValid = true;

                    damiera.StampaDamieraPedine();

                } else {
                    System.out.println("Mossa non valida, riprovare: ");
                }
            } else {
                System.out.println("Mossa non valida, riprovare: ");
            }
        } else {
            System.out.println("Mossa non valida, riprovare: ");
        }
    }

    //Metodo che si occupa di effettuare una presa per il bianco
    public boolean PresaSempliceWhite(Damiera damiera){

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.CercaRiga(posizione1);
        int x2 = damiera.CercaRiga(posizione2);

        int y1 = damiera.CercaColonna(posizione1);
        int y2 = damiera.CercaColonna(posizione2);


        int x4 = x2 - 1;


        System.out.println("posizione1: " + x1 + "," + y1 + "\nposizione2: " + x2 + "," + y2);

        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 > x1) {
            if ((x2 == x1 + 2) && (y2 == y1 + 2 || y2 == y1 - 2)) {
                if (damiera.DamieraPedine[x2][y2].getBlank() && !damiera.DamieraPedine[x1][y1].getBlank()) {

                        //1° caso, DESTRA: la presa viene effettuatta a DESTRA rispetto alla casella iniziale (y4 = y2 - 1)
                        if(y2 > y1 && !damiera.DamieraPedine[x4][y2-1].getBlank() && !damiera.DamieraPedine[x4][y2-1].getWhite()) {

                            damiera.DamieraPedine[x1][y1].setBlank(true);
                            damiera.DamieraPedine[x2][y2].setBlank(false);
                            damiera.DamieraPedine[x2][y2].setWhite(true);

                            damiera.DamieraPedine[x4][y2-1].setBlank(true);
                            damiera.DamieraPedine[x4][y2-1].setWhite(true);

                            System.out.println("y2-1: "+ damiera.DamieraPedine[x4][y2-1].getBlank() + " | " + x4 + ", " + (y2-1));

                            isValid = true;

                        }
                        //2° caso, SINISTRA: la presa viene effettuatta a sx rispetto alla casella iniziale (y4 = y2 + 1)
                        else if (y2 < y1 && !damiera.DamieraPedine[x4][y2+1].getBlank() &&!damiera.DamieraPedine[x4][y2+1].getWhite()) {

                            damiera.DamieraPedine[x1][y1].setBlank(true);
                            damiera.DamieraPedine[x2][y2].setBlank(false);
                            damiera.DamieraPedine[x2][y2].setWhite(true);

                            damiera.DamieraPedine[x4][y2+1].setBlank(true);
                            damiera.DamieraPedine[x4][y2+1].setWhite(true);

                            System.out.println("y2+1: "+ damiera.DamieraPedine[x4][y2+1].getBlank() + " | " + x4 + ", " + (y2+1));
                            isValid = true;

                        }
                }else {
                    System.out.println("Mossa non valida, riprovare: ");
                    isValid = false;
                }
            } else {
                System.out.println("Mossa non valida, riprovare: ");
                isValid = false;
            }
        } else {
            System.out.println("Mossa non valida, riprovare: ");
            isValid = false;
        }
        return isValid;
    }

    //Metodo che si occupa di effettuare una presa per il nero
    public boolean PresaSempliceBlack(Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.CercaRiga(posizione1);
        int x2 = damiera.CercaRiga(posizione2);

        int y1 = damiera.CercaColonna(posizione1);
        int y2 = damiera.CercaColonna(posizione2);

        //viene creata una 3a variabile che ha doppia coordinata y in quanto deve considerare i due casi in cui la presa venga effettuata a sx o dx. La casella individuata da x3 e y3 rappresenta la casella "di mezzo" fra quella in pos1 e quella in pos2
        int x4 = x2 + 1;

        System.out.println("posizione1: " + x1 + "," + y1 + "\nposizione2: " + x2 + "," + y2);

        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 < x1) {
            if ((x2 == x1 - 2) && (y2 == y1 - 2 || y2 == y1 + 2)) {
                if (damiera.DamieraPedine[x2][y2].getBlank() && !damiera.DamieraPedine[x1][y1].getBlank()) {

                        //1° caso, DESTRA: la presa viene effettuatta a dx rispetto alla casella iniziale (y4 = y2 - 1)
                        if(y2 > y1 && !damiera.DamieraPedine[x4][y2-1].getBlank() && damiera.DamieraPedine[x4][y2-1].getWhite()) {

                            damiera.DamieraPedine[x1][y1].setBlank(true);
                            damiera.DamieraPedine[x2][y2].setBlank(false);
                            damiera.DamieraPedine[x2][y2].setWhite(false);

                            damiera.DamieraPedine[x4][y2-1].setBlank(true);
                            damiera.DamieraPedine[x4][y2-1].setWhite(false);

                            System.out.println("y2-1: "+damiera.DamieraPedine[x4][y2-1].getBlank()  + " | " + x4 + ", " + (y2-1));

                            isValid = true;

                        }
                        //2° caso, SINISTRA: la presa viene effettuatta a sx rispetto alla casella iniziale (y4 = y2 + 1)
                        else if (y2 < y1 && !damiera.DamieraPedine[x4][y2+1].getBlank() && damiera.DamieraPedine[x4][y2+1].getWhite()) {
                            damiera.DamieraPedine[x1][y1].setBlank(true);
                            damiera.DamieraPedine[x2][y2].setBlank(false);
                            damiera.DamieraPedine[x2][y2].setWhite(false);

                            damiera.DamieraPedine[x4][y2+1].setBlank(true);
                            damiera.DamieraPedine[x4][y2+1].setWhite(false);
                            System.out.println("y2+1: "+damiera.DamieraPedine[x4][y2+1].getBlank() + " | " + x4 + ", " + (y2+1));
                            isValid = true;
                        }
                }else {
                    System.out.println("Mossa non valida, riprovare: ");
                    isValid = false;
                }
            } else {
                System.out.println("Mossa non valida, riprovare: ");
                isValid = false;
            }
        } else {
            System.out.println("Mossa non valida, riprovare: ");
            isValid = false;
        }
        return isValid;
    }

    //Metodo che si occupa di effettuare una presa per il bianco: è una concatenazione di due prese semplici
    public void PresaMultiplaWhite(Damiera damiera){

        Damiera DamieraCopia = new Damiera(damiera);

        //salvo le posizioni poichè verranno sovrascritte con la damiera di copia
        int pos1 = getPosizione1();
        int pos2 = getPosizione2();
        int pos3 = getPosizione3();

        System.out.println("'GIUSTE' pos1= " + pos1 + "pos2: " + pos2 + "pos3: " + pos3 );

        //se la presa provata nella damiera di prova è valida, allora la eseguo su quella originale
        if(PresaMultiplaWhiteProva(DamieraCopia)) {

            //1a PRESA
            setPosizione1(pos1);
            setPosizione2(pos2);
            System.out.println("PRESA1: pos1= " + pos1 + "pos2: " + pos2);
            PresaSempliceWhite(damiera);

            System.out.println("PRESA1: pos1= " + pos1 + "pos2: " + pos2);

            //2a PRESA
            setPosizione1(posizione2);
            setPosizione2(posizione3);

            System.out.println("PRESA1: posizione2= " + posizione2 + "posizione3: " + posizione3);
            PresaSempliceWhite(damiera);

            System.out.println("PRESA1: posizione2= " + posizione2 + "posizione3: " + posizione3);
            if(posizione4 != 0) {
                //3a PRESA
                setPosizione1(pos3);
                setPosizione2(posizione4);

                System.out.println("PRESA1: pos3= " + pos3 + "posizione4: " + posizione4);

                PresaSempliceWhite(damiera);

                System.out.println("PRESA1: pos3= " + pos3 + "posizione4: " + posizione4);
            }

        } else {
            System.out.println("Presa multipla non valida");
        }

    }

    //Metodo che si occupa di effettuare una presa multipla per il nero
    public void PresaMultiplaBlack(Damiera damiera) {

        Damiera DamieraCopia = new Damiera(damiera);

        //salvo le posizioni poichè verranno sovrascritte con la damiera di copia
        int pos1 = getPosizione1();
        int pos2 = getPosizione2();
        int pos3 = getPosizione3();

        //se la presa provata nella damiera di prova è valida, allora la eseguo su quella originale
        if(PresaMultiplaBlackProva(DamieraCopia)) {

            //1a PRESA
            setPosizione1(pos1);
            setPosizione2(pos2);
            System.out.println("PRESA1: pos1= " + pos1 + "pos2: " + pos2);
            PresaSempliceBlack(damiera);

            System.out.println("PRESA1: pos1= " + pos1 + "pos2: " + pos2);

            //2a PRESA
            setPosizione1(posizione2);
            setPosizione2(posizione3);

            System.out.println("PRESA1: posizione2= " + posizione2 + "posizione3: " + posizione3);
            PresaSempliceBlack(damiera);

            System.out.println("PRESA1: posizione2= " + posizione2 + "posizione3: " + posizione3);
            if(posizione4 != 0) {
                //3a PRESA
                setPosizione1(pos3);
                setPosizione2(posizione4);

                System.out.println("PRESA1: pos3= " + pos3 + "posizione4: " + posizione4);

                PresaSempliceBlack(damiera);

                System.out.println("PRESA1: pos3= " + pos3 + "posizione4: " + posizione4);
            }

        } else {
            System.out.println("Presa multipla non valida");
        }
    }

    public boolean PresaMultiplaWhiteProva(Damiera DamieraCopia){ //PROVA

        boolean prova = false;
        boolean prova1 = PresaSempliceWhite(DamieraCopia);
        boolean prova2 = false;
        boolean prova3 = false;

        if(prova1) {
            System.out.println("PRIMA MOSSA VALIDA" + prova1);

            setPosizione1(posizione2);
            setPosizione2(posizione3);

            prova2 = PresaSempliceWhite(DamieraCopia);
            if(prova2) {
                System.out.println("SECONDA MOSSA VALIDA" + prova2);
                prova = true;
                if(posizione4 != 0) {
                    setPosizione1(posizione3);
                    setPosizione2(posizione4);
                    prova3 = PresaSempliceWhite(DamieraCopia);
                    if(prova3){
                        prova = true;
                    }
                    else {
                        prova = false;
                    }
                }
            }
            else {
                System.out.println("SECONDA MOSSA NON VALIDA" + prova2);
                prova = false;
            }
        } else {
            System.out.println("PRIMA MOSSA NON VALIDA" + prova1);
        }

        return prova;
    }

    public boolean PresaMultiplaBlackProva(Damiera DamieraCopia){ //PROVA

        boolean prova = false;
        boolean prova1 = PresaSempliceBlack(DamieraCopia);
        boolean prova2 = false;
        boolean prova3 = false;

        int x3 = DamieraCopia.CercaRiga(posizione3);
        int y3 = DamieraCopia.CercaColonna(posizione3);

        if(prova1) {
            System.out.println("PRIMA MOSSA VALIDA" + prova1);

            setPosizione1(posizione2);
            setPosizione2(posizione3);

            prova2 = PresaSempliceBlack(DamieraCopia);
            if(prova2) {
                System.out.println("SECONDA MOSSA VALIDA" + prova2);
                prova = true;
                if(posizione4 != 0) {
                    setPosizione1(posizione3);
                    setPosizione2(posizione4);
                    prova3 = PresaSempliceBlack(DamieraCopia);
                    if(prova3){
                        prova = true;
                    }
                    else {
                        prova = false;
                    }
                }
            }
            else {
                System.out.println("SECONDA MOSSA NON VALIDA" + prova2);
                prova = false;
            }
        } else {
            System.out.println("PRIMA MOSSA NON VALIDA" + prova1);
        }

        return prova;
    }

}