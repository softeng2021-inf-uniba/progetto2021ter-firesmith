package it.uniba.main;

public class Messaggi {

    // Metodo che mostra informazioni sui comandi disponibili
    public static void Help() {
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
                + "\n ♢ Mostrare il tempo di gioco (tempo)" +
                "\n");
    }

    public static void MsgUscita() {
        System.out.println("\n \uD83D\uDEAA Uscita dal gioco...");
    }

    public static void MsgInserimentoSbagliato() {
        System.out.println("\n ⚠ Comando non valido \n");
    }
}
