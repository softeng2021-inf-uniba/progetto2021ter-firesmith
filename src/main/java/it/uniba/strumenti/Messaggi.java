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


public final class Messaggi {

    /** Costruttore della classe.*/
    private Messaggi() {
    }
    public static void benvenuto() {
        System.out.print("┌─────────────────────────────────┒"
                + "\n│ Dama Italiana by Team Firesmith │"
                + "\n└─────────────────────────────────┘"
                + "\nScrivere un comando:"
                + "\n\n ♢ --help | -h"
                + "\n ♢ gioca"
                + "\n ♢ numeri"
                + "\n ♢ damiera"
                + "\n ♢ tempo"
                + "\n ♢ esci"
                + "\n\n➤ ");
    }
    /** Mostra all'utente le informazioni sul programma. */
    public static void aiuto() {
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
                + "\n");
    }

    /** Messaggio di uscita dal programma. */
    public static void uscita() {
        System.out.println("\n\n \uD83D\uDEAA Uscita dal gioco...");
    }

    /** Messaggio di informazione di ritorno al menu. */
    public static void menu() {
        System.out.println("\n\n ↩ Ritorno al menù... \n");
    }

    /** Messaggio di errore inserimento comando. */
    public static void inserimento() {
        System.out.println("\n\n ⚠ Comando non valido \n");
    }

    /** Messaggio di avviso di partita non in corso. */
    public static void partita() {
        System.out.println("\n\n \uD83D\uDCA1 Nessuna partita in corso,"
                + " inizia una nuova partita (gioca)\n");
    }

    /** Messaggio di avviso di stampa damiera con partita non in corso. */
    public static void damiera() {
        System.out.println("\n\n \uD83D\uDCA1 Per mostrare la damiera con "
                + "i pezzi, inizia una nuova partita (gioca)\n");
    }

    /** Messaggio di errore di partita gi&#224; in corso. */
    public static void errorePartita() {
        System.out.println("\n \uD83D\uDCA1 La partita è già in corso!");
    }

    /** Messaggio di informazione di abbandono partita
     * da parte del giocatore bianco. */
    public static void biancoAbbandona() {
        System.out.println("\n\n ⚑ Il Bianco abbandona la partita,"
                + " il Nero vince ✌\n");
    }

    /** Messaggio di informazione di abbandono partita
     * da parte del giocatore bianco. */
    public static void neroAbbandona() {
        System.out.println("\n\n ⚑ Il Nero abbandona la partita,"
                + " il Bianco vince ✌\n");
    }

    /** Messaggio di informazione di presa effettuata. */
    public static void presaOk() {
        System.out.println("Presa Effettuata\n");
    }

    /** Messaggio di informazione di spostamento effettuato. */
    public static void spostamentoOk() {
        System.out.println("Spostamento Effettuato\n");
    }

    /** Menu del turno del giocatore bianco. */
    public static void menuBianco() {
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
    }

    /** Menu del giocatore nero. */
    public static void menuNero() {
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
    }

    /** Messaggio di informazione di riconoscimento dello spostamento. */
    public static void spostamento() {
        System.out.println("Sto effettuando uno spostamento...");
    }

    /** Messaggio di informazione di riconoscimento della presa. */
    public static void presa() {
        System.out.println("Sto effettuando una presa...");
    }

    /** Messaggio di informazione di validità della mossa. */
    public static void nonValida() {
        System.out.println(" ⚠ Mossa non valida");
    }
}
