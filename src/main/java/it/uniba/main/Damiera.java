package it.uniba.main;

/**
 * Class Type: <<Entity>>
 * Responsabilities: Classe che rappresenta la damiera su cui si basa il gioco.
 */


public class Damiera {

    static final int RIGHE = 8;
    static final int COLONNE = 8;
    // Questa damiera viene usata per calcol le coord delle pedine da spostare
    static final int[][] PosizioniPedine = new int[][]{
            {1, 0, 2, 0, 3, 0, 4, 0},
            {0, 5, 0, 6, 0, 7, 0, 8},
            {9, 0, 10, 0, 11, 0, 12, 0},
            {0, 13, 0, 14, 0, 15, 0, 16},
            {17, 0, 18, 0, 19, 0, 20, 0},
            {0, 21, 0, 22, 0, 23, 0, 24},
            {25, 0, 26, 0, 27, 0, 28, 0},
            {0, 29, 0, 30, 0, 31, 0, 32}
    };

    // Alloca la memoria per una damiera fatta di oggetti Pedine
    public Pedina[][] damieraPedine = new Pedina[RIGHE][COLONNE];

    public Damiera() {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {

                damieraPedine[i][j] = new Pedina(i, j);

                // isValid = true, se la pedina sta su un numero
                // isValid = false, se la pedina sta su uno 0
                if (PosizioniPedine[i][j] != 0) {
                    damieraPedine[i][j].setValid(true);
                } else {
                    damieraPedine[i][j].setValid(false);
                }

                // isBlank = true, se la pedine non esiste (non ha valore)
                // isBlank = false, se la pedina esiste (ha valore)
                // Le pedine bianche stanno dalla posizione 1 alla posizione 12
                if (PosizioniPedine[i][j] > 0 && PosizioniPedine[i][j] <= 12) {
                    damieraPedine[i][j].setWhite(true);
                    damieraPedine[i][j].setBlank(false);
                } else {
                    // Tra la posizione 13 e 21 non ci sono pedine
                    if (PosizioniPedine[i][j] >= 13 && PosizioniPedine[i][j] < 21) {
                        damieraPedine[i][j].setWhite(false);
                        damieraPedine[i][j].setBlank(true);
                    } else {
                        // Le pedine nere stanno dalla posizione 21 alla posizione 32
                        if (PosizioniPedine[i][j] >= 21 && PosizioniPedine[i][j] <= 32) {
                            damieraPedine[i][j].setWhite(false);
                            damieraPedine[i][j].setBlank(false);
                        }
                    }
                }
            }
        }
    }

    // copy constructor
    public Damiera(Damiera other) {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {

                damieraPedine[i][j] = new Pedina(i, j);

                // isValid = true, se la pedina sta su un numero
                // isValid = false, se la pedina sta su uno 0
                damieraPedine[i][j].setValid(other.damieraPedine[i][j].getValid());

                // isBlank = true, se la pedine non esiste (non ha valore)
                // isBlank = false, se la pedina esiste (ha valore)
                // Le pedine bianche stanno dalla posizione 1 alla posizione 12
                if (PosizioniPedine[i][j] > 0 && PosizioniPedine[i][j] <= 12) {
                    damieraPedine[i][j].setWhite(other.damieraPedine[i][j].getWhite());
                    damieraPedine[i][j].setBlank(other.damieraPedine[i][j].getBlank());
                } else {
                    // Tra la posizione 13 e 21 non ci sono pedine
                    if (PosizioniPedine[i][j] >= 13 && PosizioniPedine[i][j] < 21) {
                        damieraPedine[i][j].setWhite(other.damieraPedine[i][j].getWhite());
                        damieraPedine[i][j].setBlank(other.damieraPedine[i][j].getBlank());
                    } else {
                        // Le pedine nere stanno dalla posizione 21 alla posizione 32
                        if (PosizioniPedine[i][j] >= 21 && PosizioniPedine[i][j] <= 32) {
                            damieraPedine[i][j].setWhite(other.damieraPedine[i][j].getWhite());
                            damieraPedine[i][j].setBlank(other.damieraPedine[i][j].getBlank());
                        }
                    }
                }
            }
        }
    }

    // Stampa la matrice che contiene la posizione delle pedine
    public void StampaPosizioniPedine() {

        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┒");
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (PosizioniPedine[i][j] != 0) {
                    if (PosizioniPedine[i][j] > 0 && PosizioniPedine[i][j] < 10) {
                        System.out.print("│ " + PosizioniPedine[i][j] + "  ");
                    } else {
                        System.out.print("│ " + PosizioniPedine[i][j] + " ");
                    }
                } else {
                    System.out.print("│    ");
                }
            }
            System.out.print("│");
            System.out.println();
            if (i != RIGHE - 1) {
                System.out.println("├────┼────┼────┼────┼────┼────┼────┼────┤");
            } else {
                System.out.println("└────┴────┴────┴────┴────┴────┴────┴────┘");
            }
        }
    }

    // Stampa la damiera con le pedine del colore bianco o nero
    public void StampaDamieraPedine() {

        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┒");
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {

                boolean PedinaBianca = damieraPedine[i][j].getWhite();
                boolean PedinaEsistente = damieraPedine[i][j].getValid();
                boolean PedinaVuota = damieraPedine[i][j].getBlank();
                boolean Dama = damieraPedine[i][j].getDama();

                if (PedinaEsistente && !PedinaVuota) {
                    if (PedinaBianca) {
                        if (Dama) {
                            System.out.print("│ \u26C3  ");
                        } else {
                            System.out.print("│ ⛂  ");
                        }
                    } else {
                        if (Dama) {
                            System.out.print("│ \u26C1  ");
                        } else {
                            System.out.print("│ ⛀  ");
                        }
                    }
                } else {
                    System.out.print("│    ");
                }

            }

            System.out.print("│");
            System.out.println();

            if (i != RIGHE - 1) {
                System.out.println("├────┼────┼────┼────┼────┼────┼────┼────┤");
            } else {
                System.out.println("└────┴────┴────┴────┴────┴────┴────┴────┘");
            }
        }
    }

    public int CercaRiga(int pos) {
        int riga = 0;
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (PosizioniPedine[i][j] == pos) {
                    riga = i;
                }
            }
        }
        return riga;
    }

    public int CercaColonna(int pos) {
        int colonna = 0;
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (PosizioniPedine[i][j] == pos) {
                    colonna = j;
                }
            }
        }
        return colonna;
    }
}