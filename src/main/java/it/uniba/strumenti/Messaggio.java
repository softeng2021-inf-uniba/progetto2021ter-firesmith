package it.uniba.strumenti;

/**
 * <h2>Classe che contiene tutti i vari messaggi rivolti all'utente.</h2>
 * <b>Class Type:</b> &#60; boundary &#62; <br><br>
 * <b>Responsabilities:</b><br>
 * <b>Knows:</b>
 * <b>Does:</b>
 * <ul>
 *     <li>Visualizza i vari menu;</li>
 *     <li>Visualizza messaggi di errore;</li>
 *     <li>Visualizza messaggi di avviso;</li>
 *     <li>Visualizza messaggi di informazione.</li>
 * </ul>
 *
 * @author Gruppo Firesmith
 */


public final class Messaggio {

    /** Costruttore della classe.*/
    private Messaggio() {
    }

    /**
     * Messaggio iniziale rivolto all'utente.
     * @return nullstring
     */
    public static String benvenuto() {
        System.out.print("┌─────────────────────────────────┒"
                + "\n│ Dama Italiana by Team Firesmith │"
                + "\n└─────────────────────────────────┘"
                + "\nScrivere un comando:"
                + "\n\n ♢ --help | -h | help"
                + "\n ♢ gioca"
                + "\n ♢ numeri"
                + "\n ♢ damiera"
                + "\n ♢ tempo"
                + "\n ♢ esci"
                + "\n\n➤ ");
        return null;
    }
    /** Mostra all'utente le informazioni sul programma.
     * @return nullstring
     */
    public static String aiuto() {
        System.out.println("\n┌───────────────────────────┒"
                + "\n│     Dama Help Center      │"
                + "\n└───────────────────────────┘"
                + "\n ⓘ Benvenuto in Dama, il gioco tradizionale"
                + " per 2 giocatori\n"
                + "\nEcco un elenco dei comandi che puoi eseguire:"
                + "\n ♢ Nuova Partita (gioca)"
                + "\n ♢ Abbandona (abbandona)"
                + "\n ♢ Esci (esci)"
                + "\n ♢ Mostrare la damiera con numerazione (numeri)"
                + "\n ♢ Mostrare la damiera con i pezzi (damiera)"
                + "\n ♢ Mostrare il tempo di gioco (tempo)"
                + "\n ♢ Mostrare le mosse effettuate (mosse)"
                + "\n ♢ Mostrare le prese effettuate (prese)"
                + "\n");
        return null;
    }

    /** Messaggio di uscita dal programma.
     * @return nullstring */
    public static String uscita() {
        System.out.println("\n \uD83D\uDEAA Uscita dal gioco...");
        return null;
    }

    /** Messaggio di informazione di ritorno al menu.
     * @return nullstring */
    public static String menu() {
        System.out.println("\n ↩ Ritorno al menù... \n");
        return null;
    }

    /** Messaggio di errore inserimento comando.
     * @return nullstring */
    public static String inserimento() {
        System.out.println("\n ⚠ Comando non valido \n");
        return null;
    }

    /** Messaggio di avviso di partita non in corso.
     * @return nullstring */
    public static String partita() {
        System.out.println("\n \uD83D\uDCA1 Nessuna partita in corso,"
                + " inizia una nuova partita (gioca)\n");
        return null;
    }

    /** Messaggio di avviso di stampa damiera con partita non in corso.
     * @return nullstring */
    public static String damiera() {
        System.out.println("\n \uD83D\uDCA1 Per mostrare la damiera con "
                + "i pezzi, inizia una nuova partita (gioca)\n");
        return null;
    }

    /** Messaggio di errore di partita gi&#224; in corso.
     * @return nullstring*/
    public static String errorePartita() {
        System.out.println("\n \uD83D\uDCA1 La partita è già in corso!");
        return null;
    }

    /** Messaggio di informazione di abbandono partita
     * da parte del giocatore bianco.
     * @return nullstring */
    public static String biancoAbbandona() {
        System.out.println("\n ⚑ Il Bianco abbandona la partita,"
                + " il Nero vince ✌\n");
        return null;
    }

    /** Messaggio di informazione di abbandono partita
     * da parte del giocatore bianco.
     * @return nullstring */
    public static String neroAbbandona() {
        System.out.println("\n ⚑ Il Nero abbandona la partita,"
                + " il Bianco vince ✌\n");
        return null;
    }

    /** Messaggio di informazione di presa effettuata.
     * @return nullstring*/
    public static String presaOk() {
        System.out.println("Presa Effettuata\n");
        return null;
    }

    /** Messaggio di informazione di spostamento effettuato.
     * @return nullstring */
    public static String spostamentoOk() {
        System.out.println("Spostamento Effettuato\n");
        return null;
    }

    /** Menu del turno del giocatore bianco.
     * @return nullstring*/
    public static String menuBianco() {
        System.out.print("┌───────────────────────┒"
                + "      \n│ Menù Giocatore Bianco │"
                + "\n└───────────────────────┘"
                + "\nScrivere un comando:"
                + "\n\n ♢ --help | -h | help"
                + "\n ♢ numeri"
                + "\n ♢ damiera"
                + "\n ♢ abbandona"
                + "\n ♢ tempo"
                + "\n ♢ 'spostamento' (es. 9-13)"
                + "\n ♢ 'presa semplice' (es. 5x14)"
                + "\n ♢ 'presa multipla' (es. 2x9x18 o 2x9x18x25)"
                + "\n ♢ prese"
                + "\n ♢ mosse"
                + "\n ♢ esci"
                + "\n\n➤ ");
        return null;
    }

    /** Menu del giocatore nero.
     * @return nullstring*/
    public static String menuNero() {
        System.out.print("┌──────────────────────┒"
                + "      \n│ Menù Giocatore Nero  │"
                + "\n└──────────────────────┘"
                + "\nScrivere un comando:"
                + "\n\n ♢ --help | -h | help"
                + "\n ♢ numeri"
                + "\n ♢ damiera"
                + "\n ♢ abbandona"
                + "\n ♢ tempo"
                + "\n ♢ 'spostamento' (es. 13-9)"
                + "\n ♢ 'presa semplice' (es. 18x9)"
                + "\n ♢ 'presa multipla' (es. 18x9x2 o 25x18x9x2)"
                + "\n ♢ prese"
                + "\n ♢ mosse"
                + "\n ♢ esci"
                + "\n\n➤ ");
        return null;
    }

    /** Messaggio di informazione di riconoscimento dello spostamento.
     * @return nullstring*/
    public static String spostamento() {
        System.out.println("\nSto effettuando uno spostamento...");
        return null;
    }

    /** Messaggio di informazione di riconoscimento della presa.
     * @return nullstring */
    public static String presa() {
        System.out.println("\nSto effettuando una presa...");
        return null;
    }

    /** Messaggio di informazione di validità della mossa.
     * @return nullstring */
    public static String nonValida() {
        System.out.println("⚠ Mossa non valida");
        return null;
    }
}
