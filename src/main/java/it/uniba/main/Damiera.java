package it.uniba.main;

/**
 * <h2>Classe che rappresenta la damiera su cui si basa il gioco.</h2>
 * <b>Class Type:</b> &#60; Entity  &#62; <br><br>
 * <b>Responsabilities:</b><br>
 * <b>Knows:</b>
 * <ul>
 *     <li> Riga e colonna della posizione di una pedina</li>
 * </ul>
 * <b>Does:</b>
 * <ul>
 *     <li> Possiede la damiera numerata</li>
 *     <li> Dispone i pezzi sulla damiera per iniziare la partita</li>
 *     <li> Permette all'utente di visualizzare la damiera con i pezzi</li>
 *     <li> Permette all'utente di visualizzare la damiera numerata</li>
 *     <li> Permette di ricavare la riga e la colonna di una pedina
 *     in una determinata posizione</li>
 * </ul>
 *
 * @author Gruppo Firesmith
 */

public class Damiera {
    /** Numero massimo delle caselle disposte sulla riga. */
    static final int RIGHE = 8;
    /** Numero massimo delle caselle disposte sulla colonna. */
    static final int COLONNE = 8;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    static final int POS_ZERO = 0;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    static final int POS_DIECI = 10;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    static final int POS_DODICI = 12;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    static final int POS_TREDICI = 13;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    static final int POS_VENTUNO = 21;
    /** Costante utilizzata per il controllo della posizione delle pedine. */
    static final int POS_TRENTADUE = 32;

    /** Damiera che viene usata per calcolare le coordinate
     * delle pedine da spostare. */
    static final int[][] POSIZIONI_PEDINE = new int[][]{
            {1, 0, 2, 0, 3, 0, 4, 0},
            {0, 5, 0, 6, 0, 7, 0, 8},
            {9, 0, 10, 0, 11, 0, 12, 0},
            {0, 13, 0, 14, 0, 15, 0, 16},
            {17, 0, 18, 0, 19, 0, 20, 0},
            {0, 21, 0, 22, 0, 23, 0, 24},
            {25, 0, 26, 0, 27, 0, 28, 0},
            {0, 29, 0, 30, 0, 31, 0, 32}
    };

    /** Alloca la memoria per una damiera fatta di oggetti Pedine. */
    private Pedina[][] damieraPedine = new Pedina[RIGHE][COLONNE];

    /**
     * Permette di ricavare la pedina attraverso le coordinate fornite.
     * @param riga Valore della coordinata x
     * @param colonna Valore della coordinata y
     * @return Pedina presente nella posizione fornita
     */
    public Pedina getDamieraPedine(final int riga, final int colonna) {
        return damieraPedine[riga][colonna];
    }

    /** Costruttore della damiera con le pedine bianche e nere
     * in posizione iniziale. */
    public Damiera() {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {

                damieraPedine[i][j] = new Pedina(i, j);

                // isValid = true, se la pedina sta su un numero
                // isValid = false, se la pedina sta su uno 0
                if (POSIZIONI_PEDINE[i][j] != 0) {
                    damieraPedine[i][j].setValid(true);
                } else {
                    damieraPedine[i][j].setValid(false);
                }

                // isBlank = true, se la pedine non esiste (non ha valore)
                // isBlank = false, se la pedina esiste (ha valore)
                // Le pedine bianche stanno dalla posizione 1 alla posizione 12
                if (POSIZIONI_PEDINE[i][j] > POS_ZERO
                        && POSIZIONI_PEDINE[i][j] <= POS_DODICI) {
                    damieraPedine[i][j].setWhite(false);
                    damieraPedine[i][j].setBlank(false);
                } else {
                    // Tra la posizione 13 e 21 non ci sono pedine
                    if (POSIZIONI_PEDINE[i][j] >= POS_TREDICI
                            && POSIZIONI_PEDINE[i][j] < POS_VENTUNO) {
                        damieraPedine[i][j].setWhite(false);
                        damieraPedine[i][j].setBlank(true);
                    } else {
                        // Le pedine nere stanno dalla posizione 21
                        // alla posizione 32
                        if (POSIZIONI_PEDINE[i][j] >= POS_VENTUNO
                                && POSIZIONI_PEDINE[i][j] <= POS_TRENTADUE) {
                            damieraPedine[i][j].setWhite(true);
                            damieraPedine[i][j].setBlank(false);
                        }
                    }
                }
            }
        }
    }

    /**
     * Crea un costruttore copia che simula la presa multipla in {@link Mossa}.
     * @param other Damiera della partita in corso
     */
    public Damiera(final Damiera other) {
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {

                damieraPedine[i][j] = new Pedina(i, j);

                // isValid = true, se la pedina sta su un numero
                // isValid = false, se la pedina sta su uno 0
                damieraPedine[i][j].getValid();

                // isBlank = true, se la pedine non esiste (non ha valore)
                // isBlank = false, se la pedina esiste (ha valore)
                // Le pedine bianche stanno dalla posizione 1 alla posizione 12
                if (POSIZIONI_PEDINE[i][j] > POS_ZERO
                        && POSIZIONI_PEDINE[i][j] <= POS_DODICI) {
                    damieraPedine[i][j].setWhite(
                            other.damieraPedine[i][j].getWhite());
                    damieraPedine[i][j].setBlank(
                            other.damieraPedine[i][j].getBlank());
                } else {
                    // Tra la posizione 13 e 21 non ci sono pedine
                    if (POSIZIONI_PEDINE[i][j] >= POS_TREDICI
                            && POSIZIONI_PEDINE[i][j] < POS_VENTUNO) {
                        damieraPedine[i][j].setWhite(
                                other.damieraPedine[i][j].getWhite());
                        damieraPedine[i][j].setBlank(
                                other.damieraPedine[i][j].getBlank());
                    } else {
                        // Le pedine nere stanno dalla posizione 21
                        // alla posizione 32
                        if (POSIZIONI_PEDINE[i][j] >= POS_VENTUNO
                                && POSIZIONI_PEDINE[i][j] <= POS_TRENTADUE) {
                            damieraPedine[i][j].setWhite(
                                    other.damieraPedine[i][j].getWhite());
                            damieraPedine[i][j].setBlank(
                                    other.damieraPedine[i][j].getBlank());
                        }
                    }
                }
            }
        }
    }

    /** Stampa la damiera con i numeri delle posizioni delle pedine. */
    public void stampaPosizioniPedine() {

        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┒");
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (POSIZIONI_PEDINE[i][j] != 0) {
                    if (POSIZIONI_PEDINE[i][j] > 0
                            && POSIZIONI_PEDINE[i][j] < POS_DIECI) {
                        System.out.print("│ " + POSIZIONI_PEDINE[i][j] + "  ");
                    } else {
                        System.out.print("│ " + POSIZIONI_PEDINE[i][j] + " ");
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

    /** Stampa la damiera con le pedine di colore bianco e nero
     * in formato Unicode. */
    public void stampaDamieraPedine() {

        System.out.println("┌────┬────┬────┬────┬────┬────┬────┬────┒");
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {

                boolean pedinaBianca = damieraPedine[i][j].getWhite();
                boolean pedinaEsistente = damieraPedine[i][j].getValid();
                boolean pedinaVuota = damieraPedine[i][j].getBlank();
                boolean dama = damieraPedine[i][j].getDama();

                if (pedinaEsistente && !pedinaVuota) {
                    if (pedinaBianca) {
                        if (dama) {
                            System.out.print("│ \u26C3  ");
                        } else {
                            System.out.print("│ ⛂  ");
                        }
                    } else {
                        if (dama) {
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

    /**
     * Cerca la riga corrispondente alla posizione scelta dall'utente.
     * @param pos Posizione della pedina presa in input
     * @return Coordinata x corrispondente alla posizione della pedina
     */
    public int cercaRiga(final int pos) {
        int riga = 0;
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (POSIZIONI_PEDINE[i][j] == pos) {
                    riga = i;
                }
            }
        }
        return riga;
    }
    /**
     * Cerca la colonna corrispondente alla posizione scelta dall'utente.
     * @param pos Posizione della pedina presa in input
     * @return Coordinata y corrispondente alla posizione della pedina
     */
    public int cercaColonna(final int pos) {
        int colonna = 0;
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (POSIZIONI_PEDINE[i][j] == pos) {
                    colonna = j;
                }
            }
        }
        return colonna;
    }
}
