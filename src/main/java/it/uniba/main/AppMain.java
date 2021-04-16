package it.uniba.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

// import it.uniba.sotorrent.GoogleDocsUtils;
// disattivato per problemi di compilazione
/**
 * The main class for the project. It must be customized to meet the project
 * assignment specifications.
 *
 * <b>DO NOT RENAME</b>
 */
public final class AppMain {

    /**
     * Private constructor. Change if needed.
     */
    private AppMain() {

    }

    /**
     * 	 * This is the main entry of the application.
     *
     * @param args The command-line arguments.
     */

    public static void main(final String[] args) {

        System.out.println("Current working dir: " + System.getProperty("user.dir"));

        if (args.length > 0) {
            switch (args[0]) {
                case "it":
                    System.out.println("Applicazione avviata.");
                    break;

                case "en":
                    System.out.println("Application started.");
                    break;

                default:
                    System.out.println("Specify the language. "
                            + "Languages supported: 'it' or 'en'");
                    break;
            }
        } else {
            System.out.println("Using default language 'en'");
            System.out.println("Application started.");
        }

        int i = 0;
        boolean isTrue = false;

        while (i < args.length && !isTrue) {
            if (args[i].equals("--help") || args[i].equals("-h")) {
                Help();
                isTrue = true;
            }
            i++;
        }
        Damiera d1 = new Damiera();

        // Comandi primo inserimento
        boolean NuovaPartita = false;

        do {
            System.out.print("Scrivere un comando:"
                    +"\n - --help | -h"
                    + "\n - gioca"
                    + "\n - numeri"
                    + "\n - damiera"
                    + "\n - tempo"
                    + "\n - esci" +
                    "\n> ");
            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();

            switch(comando){
                case "--help":
                    Help();
                    break;

                case "-h":
                    Help();
                    break;

                case "gioca":
                    Partita p1 = new Partita();
                    p1.Gioca();
                   // NuovaPartita = true;
                    break;

                case "numeri":
                    d1.StampaNumeri();
                    break;

                case "damiera":
                    System.out.println("Per mostrare la damiera con i pezzi, inizia una nuova partita (gioca)");
                    break;

                case "tempo":
                    System.out.println("Nessuna partita in corso | Inserire prima il comando 'gioca' per iniziarne una");
                    break;

                case "esci":
                    Partita.Esci();
                    break;
                default:
                    System.out.println("\n Inserire un comando valido \n");
                    break;
            }
        } while (NuovaPartita == false);
    }

    public static void Help() {
        System.out.println("\n | ---------- Dama Help Center ---------- | ");
        System.out.println("Benvenuto in Dama, il gioco tradizionale per 2 giocatori");
        System.out.println("Ecco un elenco dei comandi che puoi eseguire:"
                + "\n - Nuova Partita (gioca)"
                + "\n - Abbandona (abbandona)"
                + "\n - Esci (esci)"
                + "\n - Mostrare la damiera con numerazione (numeri)"
                + "\n - Mostrare la damiera con i pezzi (damiera)"
                + "\n - Mostrare il tempo di gioco (tempo)" +
                "\n");

    }

}

