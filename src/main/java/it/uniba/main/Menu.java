package it.uniba.main;

import java.util.Scanner;

import static it.uniba.main.AppMain.Help;

public class Menu {

    public static void Generale() {
        Damiera d1 = new Damiera(); // crea una nuova damiera
        boolean NuovaPartita = false; // se la partita è in corso, fa uscire dal menù
        // Menù Iniziale
        do {
            System.out.print("┌─────────────────────────────────┒"
                    +      "\n│ Dama Italiana by Team Firesmith │"
                    +      "\n└─────────────────────────────────┘"
                    +"\nScrivere un comando:"
                    + "\n ♢ --help | -h"
                    + "\n ♢ gioca"
                    + "\n ♢ numeri"
                    + "\n ♢ damiera"
                    + "\n ♢ tempo"
                    + "\n ♢ esci" +
                    "\n➤ ");
            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();

            switch(comando){
                case "--help":
                    Help();
                    break;

                case "-h":
                    Help();
                    break;
                case "help":
                    Help();
                    break;

                case "gioca":
                    Partita p1 = new Partita();
                    p1.Gioca();
                    break;

                case "numeri":
                    d1.StampaNumeri();
                    break;

                case "damiera":
                    System.out.println("\n \uD83D\uDCA1 Per mostrare la damiera con i pezzi, inizia una nuova partita (gioca)\n");
                    break;

                case "tempo":
                    System.out.println("\n \uD83D\uDCA1 Nessuna partita in corso, inizia una nuova partita (gioca)\n");
                    break;

                case "esci":
                    Uscita();
                    break;

                default:
                    System.out.println("\n ⚠ Inserire un comando valido \n");
                    break;
            }
        } while (NuovaPartita == false);
    }

    public static void Partita() {
        Damiera d1 = new Damiera(); // crea una nuova damiera
        boolean partitaInCorso = true;
        long startTime = System.currentTimeMillis();

        do {
            System.out.print("┌──────────────────────┒"
                    +"      \n│ Menù comandi partita │"
                    +      "\n└──────────────────────┘"
                    + "\nScrivere un comando:"
                    + "\n ♢ --help | -h"
                    + "\n ♢ numeri"
                    + "\n ♢ damiera"
                    + "\n ♢ abbandona"
                    + "\n ♢ tempo"
                    + "\n ♢ esci" +
                    "\n➤ ");
            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();
            comando = comando.toLowerCase();

            switch(comando){
                case "--help":
                    Help();
                    break;

                case "-h":
                    Help();
                    break;

                case "help":
                    Help();
                    break;

                case "numeri":
                    d1.StampaNumeri();
                    break;

                case "damiera":
                    d1.StampaPezzi();
                    break;

                case "gioca":
                    System.out.println("\n \uD83D\uDCA1 La partita è già in corso!");
                    break;

                case "abbandona":
                    partitaInCorso = Abbandona();
                    break;

                case "esci":
                    Uscita();
                    break;

                case "tempo":
                    //Partita.MostraTemp
                    break;

                default:
                    System.out.println("\n ⚠ Inserire un comando valido \n");
                    break;
            }
        } while (partitaInCorso == true);
    }

        // Metodo con il quale il giocatore può abbandonare la partita corrente ritornando al menù
        public static boolean Abbandona() {
        boolean partitaInCorso = true;
        System.out.print("\nVuoi abbandonare la partita?" +
                         "\n➤ [Si/No] ");
        Scanner input1 = new Scanner(System.in);
        String conferma = input1.nextLine();
        conferma = conferma.toLowerCase();

        if(conferma.equals("si")){
            boolean IsWhite = Pedina.getGiocatore();

            if(IsWhite==true){
                System.out.println("\n ⚑ Il Bianco abbandona la partita, il Nero vince ✌\n");
                return (partitaInCorso = false);
            } else {
                System.out.println("\n ⚑ Il Nero abbandona la partita, il Bianco vince ✌\n");
                return (partitaInCorso = false);
            }
        } else if(conferma.equals("no")){
            return (partitaInCorso = true);
        } else {
            System.out.println("\n ⚠ Comando non valido\n") ;
        }
         return partitaInCorso;
     }

    // Metodo con il quale si può terminare immediatamente il programma
    public static void Uscita() {
        System.out.print("\nPer confermare l'uscita dal gioco inserire [Si/No]" +
                "\n➤ ");
        Scanner usc = new Scanner(System.in);
        String uscita = usc.nextLine();
        uscita = uscita.toLowerCase();

        if (uscita.equals("si"))
        {
            System.out.println("\n \uD83D\uDEAA Uscita dal gioco...");
            System.exit(0);
        } else if (uscita.equals("No")) {
            System.out.println("\n ↩ Ritorno al menù... \n");
        } else {
            System.out.println("\n ⚠ Comando non valido \n");
        }
    }
}
