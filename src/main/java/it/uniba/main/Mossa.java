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
    private boolean isValid;

    public void setPosizione1(int posizione1) { this.posizione1 = posizione1; }
    public void setPosizione2(int posizione2) { this.posizione2 = posizione2; }
    public void setPosizione3(int posizione3) {this.posizione3 = posizione3; }
    public void setValid(boolean isValid) { this.isValid = isValid; }

    public int getPosizione1() { return posizione1; }
    public int getPosizione2() { return posizione2; }
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
    public void PresaSempliceWhite(Damiera damiera){

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.CercaRiga(posizione1);
        int x2 = damiera.CercaRiga(posizione2);

        int y1 = damiera.CercaColonna(posizione1);
        int y2 = damiera.CercaColonna(posizione2);

        //viene creata una 3a variabile che ha doppia coordinata y in quanto deve considerare i due casi in cui la presa venga effettuata a sx o dx. La casella individuata da x4 e y4 rappresenta la casella "di mezzo" fra quella in pos1 e quella in pos2
        int x4 = x2 - 1;
        int y4_1 = y2 - 1;
        int y4_2 = y2 + 1;

        //controllo anti-eccezione ArrayOutOfBounds
        if(y2 == 0) {
            y4_1 = 2;
        }

        System.out.println("posizione1: " + x1 + "," + y1 + "\nposizione2: " + x2 + "," + y2);

        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 > x1) {
            if ((x2 == x1 + 2) && (y2 == y1 + 2 || y2 == y1 - 2)) {
                if (damiera.DamieraPedine[x2][y2].getBlank() && !damiera.DamieraPedine[x1][y1].getBlank()) {

                    if ((!damiera.DamieraPedine[x4][y4_1].getBlank() || (!damiera.DamieraPedine[x4][y4_2].getBlank()))) {

                        //vengono settati i vari flag in modo da ricostruire graficamente la situazione
                        damiera.DamieraPedine[x1][y1].setBlank(true);
                        damiera.DamieraPedine[x2][y2].setBlank(false);
                        damiera.DamieraPedine[x2][y2].setWhite(true);


                        //1° caso: la presa viene effettuatta a sx rispetto alla casella iniziale (y4 = y2 - 1)
                        if(!damiera.DamieraPedine[x4][y4_1].getBlank() && !damiera.DamieraPedine[x4][y4_1].getWhite()) {
                            damiera.DamieraPedine[x4][y4_1].setBlank(true);
                            damiera.DamieraPedine[x4][y4_1].setWhite(true);
                            isValid = true;

                        }
                        //2° caso: la presa viene effettuatta a dx rispetto alla casella iniziale (y4 = y2+1)
                        else if (!damiera.DamieraPedine[x4][y4_2].getBlank() &&!damiera.DamieraPedine[x4][y4_2].getWhite()) {
                            damiera.DamieraPedine[x4][y4_2].setBlank(true);
                            damiera.DamieraPedine[x4][y4_2].setWhite(true);
                            isValid = true;

                        }

                        //damiera.StampaDamieraPedine();

                    } else {
                        System.out.println("Mossa non valida, riprovare: ");
                    }
                }else {
                    System.out.println("Mossa non valida, riprovare: ");
                }
            } else {
                System.out.println("Mossa non valida, riprovare: ");
            }
        } else {
            System.out.println("Mossa non valida, riprovare: ");
        }
    }

    //Metodo che si occupa di effettuare una presa per il nero
    public void PresaSempliceBlack(Damiera damiera) {

        //qui vengono cercate le coordinate corrispondenti alle posizioni fornite dall'utente
        int x1 = damiera.CercaRiga(posizione1);
        int x2 = damiera.CercaRiga(posizione2);

        int y1 = damiera.CercaColonna(posizione1);
        int y2 = damiera.CercaColonna(posizione2);

        //viene creata una 3a variabile che ha doppia coordinata y in quanto deve considerare i due casi in cui la presa venga effettuata a sx o dx. La casella individuata da x3 e y3 rappresenta la casella "di mezzo" fra quella in pos1 e quella in pos2
        int x4 = x2 + 1;
        int y4_2 = y2 + 1;
        int y4_1 = y2 - 1;

        //controllo anti-eccezione ArrayOutOfBounds
        if(y2 == 0) {
            y4_1 = 2;
        }

        System.out.println("posizione1: " + x1 + "," + y1 + "\nposizione2: " + x2 + "," + y2);

        //vengono effettuati una serie di controlli per controllare che le pedine vengano spostate solo "dall'alto verso il basso" (bianco) e che la (casella in) pos2 disti dalla (casella in) pos1 esattemente 2
        if (x2 < x1) {
            if ((x2 == x1 - 2) && (y2 == y1 - 2 || y2 == y1 + 2)) {
                if (damiera.DamieraPedine[x2][y2].getBlank() && !damiera.DamieraPedine[x1][y1].getBlank()) {

                    if ((!damiera.DamieraPedine[x4][y4_1].getBlank() || (!damiera.DamieraPedine[x4][y4_2].getBlank()))) {

                        //vengono settati i vari flag in modo da ricostruire graficamente la situazione
                        damiera.DamieraPedine[x1][y1].setBlank(true);
                        damiera.DamieraPedine[x2][y2].setBlank(false);
                        damiera.DamieraPedine[x2][y2].setWhite(false);

                        //1° caso: la presa viene effettuatta a sx rispetto alla casella iniziale (y4 = y2 - 1)
                        if(!damiera.DamieraPedine[x4][y4_1].getBlank() && damiera.DamieraPedine[x4][y4_1].getWhite()) {
                            damiera.DamieraPedine[x4][y4_1].setBlank(true);
                            damiera.DamieraPedine[x4][y4_1].setWhite(false);
                            isValid = true;

                        }
                        //2° caso: la presa viene effettuatta a dx rispetto alla casella iniziale (y4 = y2 + 1)
                        else if (!damiera.DamieraPedine[x4][y4_2].getBlank() && damiera.DamieraPedine[x4][y4_2].getWhite()) {
                            damiera.DamieraPedine[x4][y4_2].setBlank(true);
                            damiera.DamieraPedine[x4][y4_2].setWhite(false);
                            isValid = true;
                        }

                        //damiera.StampaDamieraPedine();

                    } else {
                        System.out.println("Mossa non valida, riprovare: ");
                    }
                }else {
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
    public void PresaMultiplaWhite(Damiera damiera){

        //la presa multipla è una concatenazione di due prese semplici
        PresaSempliceWhite(damiera);

        int x3 = damiera.CercaRiga(posizione3);
        int y3 = damiera.CercaColonna(posizione3);

        System.out.println("posizione3: " + x3 + "," + y3 + " posizione: " + posizione3);

        setPosizione1(posizione2);
        setPosizione2(posizione3);

        PresaSempliceWhite(damiera);
    }

    //Metodo che si occupa di effettuare una presa multipla per il nero
    public void PresaMultiplaBlack(Damiera damiera) {

        //la presa multipla è una concatenazione di due prese semplici
        PresaSempliceBlack(damiera);

        int x3 = damiera.CercaRiga(posizione3);
        int y3 = damiera.CercaColonna(posizione3);

        System.out.println("posizione3: " + x3 + "," + y3);

        setPosizione1(posizione2);
        setPosizione2(posizione3);

        PresaSempliceBlack(damiera);
    }

}