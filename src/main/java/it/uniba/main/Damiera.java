/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

/**
 *
 * @author utente
 */

/*
    Metodi classe Damiera
     - Damiera()
     - StampaPosizioniPedine()
     - StampaDamieraPedine()
     - CercaRiga()
     - CercaColonna()
 */
public class Damiera {

    final static int RIGHE = 8;
    final static int COLONNE = 8;
    // Questa damiera viene usata per calcolare le coordinate delle pedine da spostare
    final static int[][] PosizioniPedine = new int[][] {
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
    public Pedina[][] DamieraPedine = new Pedina[RIGHE][COLONNE];

    public Damiera() {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {

                DamieraPedine[i][j] = new Pedina(i, j);

                // isValid = true, se la pedina sta su un numero
                // isValid = false, se la pedina sta su uno 0
                if (PosizioniPedine[i][j] != 0) {
                    DamieraPedine[i][j].setValid(true);
                } else {
                    DamieraPedine[i][j].setValid(false);
                }

                // isBlank = true, se la pedine non esiste (non ha valore)
                // isBlank = false, se la pedina esiste (ha valore)
                // Le pedine bianche stanno dalla posizione 1 alla posizione 12
                if (PosizioniPedine[i][j] > 0 && PosizioniPedine[i][j] <= 12) {
                    DamieraPedine[i][j].setWhite(true);
                    DamieraPedine[i][j].setBlank(false);
                } else {
                    // Tra la posizione 13 e 21 non ci sono pedine
                    if (PosizioniPedine[i][j] >= 13 && PosizioniPedine[i][j] < 21) {
                        DamieraPedine[i][j].setWhite(false);
                        DamieraPedine[i][j].setBlank(true);
                    } else {
                        // Le pedine nere stanno dalla posizione 21 alla posizione 32
                        if (PosizioniPedine[i][j] >= 21 && PosizioniPedine[i][j] <= 32) {
                            DamieraPedine[i][j].setWhite(false);
                            DamieraPedine[i][j].setBlank(false);
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

                boolean PedinaBianca = DamieraPedine[i][j].getWhite();
                boolean PedinaEsistente = DamieraPedine[i][j].getValid();
                boolean PedinaVuota = DamieraPedine[i][j].getBlank();

                if (PedinaEsistente && !PedinaVuota) {
                    if (PedinaBianca) {
                        System.out.print("│ ⛀  ");
                    } else {
                        System.out.print("│ ⛂  ");
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