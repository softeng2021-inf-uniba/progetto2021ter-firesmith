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

public class Damiera {

    final static int RIGHE = 8;
    final static int COLONNE = 8;
    final static int[][] damiera = new int[][]{
            {1, 0, 2, 0, 3, 0, 4, 0},
            {0, 5, 0, 6, 0, 7, 0, 8},
            {9, 0, 10, 0, 11, 0, 12, 0},
            {0, 13, 0, 14, 0, 15, 0, 16},
            {17, 0, 18, 0, 19, 0, 20, 0},
            {0, 21, 0, 22, 0, 23, 0, 24},
            {25, 0, 26, 0, 27, 0, 28, 0},
            {0, 29, 0, 30, 0, 31, 0, 32}
    };

    private Pedina[][] damieraPezzi = new Pedina[RIGHE][COLONNE];

    public Damiera() {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {

                damieraPezzi[i][j] = new Pedina(i, j);

                if (damiera[i][j] != 0) {
                    damieraPezzi[i][j].setValid(true);
                } else {
                    damieraPezzi[i][j].setValid(false);
                }

                if (damiera[i][j] > 0 && damiera[i][j] <= 12) {
                    damieraPezzi[i][j].seteBianco(true);
                    damieraPezzi[i][j].seteNero(false);

                } else if (damiera[i][j] >= 21 && damiera[i][j] <= 32) {
                    damieraPezzi[i][j].seteBianco(false);
                    damieraPezzi[i][j].seteNero(true);

                } else if (damiera[i][j] >= 13 && damiera[i][j] < 21) {
                    damieraPezzi[i][j].setBlank(true);
                }
            }
        }
    }

    public void StampaNumeri() {

        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┒");
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (damiera[i][j] != 0) {
                    if (damiera[i][j] > 0 && damiera[i][j] < 10) {
                        System.out.print("│ " + damiera[i][j] + "  ");
                    } else {
                        System.out.print("│ " + damiera[i][j] + " ");
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

    /*public void StampaPezzi() {
        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┒");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (damiera[i][j] != 0) {
                    if (damiera[i][j] > 0 && damiera[i][j] <= 12) {
                        System.out.print("│ ⛀  ");
                    } else {
                        if (damiera[i][j] >= 13 && damiera[i][j] < 21) {
                            System.out.print("│    ");
                        } else {
                            if (damiera[i][j] >= 21 && damiera[i][j] <= 32) {
                                System.out.print("│ ⛂  ");
                            }
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
    }*/

    public void StampaPezzi() {

        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┒");
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                boolean PedinaBianca = damieraPezzi[i][j].iseBianco();
                boolean PedinaEsistente = damieraPezzi[i][j].getValid();
                boolean PedinaVuota = damieraPezzi[i][j].getBlank();

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
}
