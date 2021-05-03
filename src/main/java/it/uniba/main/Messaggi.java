package it.uniba.main;

/** <<boundary>> */

/*
    Metodi classe Messaggi
     - Help()
     - MsgUscita()
     - MsgTornaMenu()
     - MsgErroreIns()
     - MsgInfoPartita()
     - MsgInfoPartitaDamiera()
     - MsgErrorePartita()
     - MsgBiancoAbbandona()
     - MsgNeroAbbandona()
     - MsgInizioPartita()
     - MsgSpostamento()
     - MsgPresa()
 */
public class Messaggi {

    public void Help() {
        System.out.println("\n┌───────────────────────────┒"
                +  "\n│     Dama Help Center      │"
                +  "\n└───────────────────────────┘"
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

    public void MsgUscita() {
        System.out.println("\n \uD83D\uDEAA Uscita dal gioco...");
    }

    public void MsgTornaMenu() {
        System.out.println("\n ↩ Ritorno al menù... \n");
    }

    public void MsgErroreIns() {
        System.out.println("\n ⚠ Comando non valido \n");
    }

    public void MsgInfoPartita() {
        System.out.println("\n \uD83D\uDCA1 Nessuna partita in corso, inizia una nuova partita (gioca)\n");
    }

    public void MsgInfoPartitaDamiera() {
        System.out.println("\n \uD83D\uDCA1 Per mostrare la damiera con i pezzi, inizia una nuova partita (gioca)\n");
    }

    public void MsgErrorePartita() {
        System.out.println("\n \uD83D\uDCA1 La partita è già in corso!");
    }

    public void MsgBiancoAbbandona() {
        System.out.println("\n ⚑ Il Bianco abbandona la partita, il Nero vince ✌\n");
    }

    public void MsgNeroAbbandona() {
        System.out.println("\n ⚑ Il Nero abbandona la partita, il Bianco vince ✌\n");
    }

    public void MsgInizioPartita() {
        System.out.print("\n ⚔ Iniziando una nuova partita... ⚔ \n" +
                "\nScegli il giocatore: " +
                "\n ♦ Bianco" +
                "\n ♢ Nero" +
                "\n➤ ");
    }

    public void MsgSpostamento() {
        System.out.println("Sto effettuando uno spostamento...");
    }

    public void MsgPresa() {
        System.out.println("Sto effettuando una presa...");
    }
}
