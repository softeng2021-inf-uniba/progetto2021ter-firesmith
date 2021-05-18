package it.uniba.main;

/**
 * Class Type: <<boundary>> *
 * Responsabilities: Classe che contiene tutti i vari messaggi rivolti all'utente
 */


public class Messaggi {

    public static void Help() {
        System.out.println("\n┌───────────────────────────┒"
                + "\n│     Dama Help Center      │"
                + "\n└───────────────────────────┘"
                + "\n ⓘ Benvenuto in Dama, il gioco tradizionale per 2 giocatori\n"
                + "\nEcco un elenco dei comandi che puoi eseguire:"
                + "\n ♢ Nuova Partita (gioca)"
                + "\n ♢ Abbandona (abbandona)"
                + "\n ♢ Esci (esci)"
                + "\n ♢ Mostrare la damiera con numerazione (numeri)"
                + "\n ♢ Mostrare la damiera con i pezzi (damiera)"
                + "\n ♢ Mostrare il tempo di gioco (tempo)"
                + "\n");
    }

    public static void MsgUscita() {
        System.out.println("\n\n \uD83D\uDEAA Uscita dal gioco...");
    }

    public static void MsgTornaMenu() {
        System.out.println("\n\n ↩ Ritorno al menù... \n");
    }

    public static void MsgErroreIns() {
        System.out.println("\n\n ⚠ Comando non valido \n");
    }

    public static void MsgInfoPartita() {
        System.out.println("\n\n \uD83D\uDCA1 Nessuna partita in corso, inizia una nuova partita (gioca)\n");
    }

    public static void MsgInfoPartitaDamiera() {
        System.out.println("\n\n \uD83D\uDCA1 Per mostrare la damiera con i pezzi, inizia una nuova partita (gioca)\n");
    }

    public static void MsgErrorePartita() {
        System.out.println("\n \uD83D\uDCA1 La partita è già in corso!");
    }

    public static void MsgBiancoAbbandona() {
        System.out.println("\n\n ⚑ Il Bianco abbandona la partita, il Nero vince ✌\n");
    }

    public static void MsgNeroAbbandona() {
        System.out.println("\n\n ⚑ Il Nero abbandona la partita, il Bianco vince ✌\n");
    }

    public static void MsgMossaEffettuata() {
        System.out.println("Presa Effettuata\n");
    }

    public static void MsgSpostamentoEffettuato() {
        System.out.println("Spostamento Effettuato\n");
    }

    public static void MsgMenuBianco() {
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

    public static void MsgMenuNero() {
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

    public static void MsgSpostamento() {
        System.out.println("Sto effettuando uno spostamento...");
    }

    public static void MsgPresa() {
        System.out.println("Sto effettuando una presa...");
    }
}
