package it.uniba.main;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


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
                    + "\n ♢ help | --help | -h"
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
                    Messaggi.Help();
                    break;

                case "-h":
                    Messaggi.Help();
                    break;
                case "help":
                    Messaggi.Help();
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
                    Messaggi.MsgUscita();
                    Uscita();
                    break;

                default:
                    Messaggi.MsgInserimentoSbagliato();
                    break;
            }
        } while (NuovaPartita == false);
    }

    public static void Partita() {
        final String Spostamento = "^[1-32]+[-]+[1-32]$";
        Pattern p1 = Pattern.compile(Spostamento);

        final String Presa = "^[1-32]+[x]+[1-32]$";
        Pattern p2 = Pattern.compile(Presa);

        Damiera d1 = new Damiera(); // crea una nuova damiera
        boolean partitaInCorso = true;

        do {
            System.out.print("┌──────────────────────┒"
                    +"      \n│ Menù comandi partita │"
                    +      "\n└──────────────────────┘"
                    + "\nScrivere un comando:"
                    + "\n ♢ help | --help | -h"
                    + "\n ♢ numeri"
                    + "\n ♢ damiera"
                    + "\n ♢ abbandona"
                    + "\n ♢ tempo"
                    + "\n ♢ esci" +
                    "\n➤ ");
            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();
            comando = comando.toLowerCase();

            Matcher m1 = p1.matcher(comando);
            Matcher m2 = p2.matcher(comando);

            if (m1.matches()) {
                comando = "spostamento";
            } else {
                if (m2.matches()) {
                    comando = "presa";
                }
            }

            switch(comando){
                case "--help":
                    Messaggi.Help();
                    break;

                case "-h":
                    Messaggi.Help();
                    break;

                case "help":
                    Messaggi.Help();
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

                case "spostamento":
                    System.out.println("Sto effettuando uno spostamento...");
                    break;

                case "presa":
                    System.out.println("Sto effettuando una presa...");
                    break;

                case "abbandona":
                    partitaInCorso = Abbandona();
                    break;

                case "esci":
                    Uscita();
                    break;

                case "tempo":
                    //Partita.MostraTempo();
                    break;

                default:
                    Messaggi.MsgInserimentoSbagliato();
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
            Messaggi.MsgInserimentoSbagliato();
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
            Messaggi.MsgUscita();
            System.exit(0);
        } else if (uscita.equals("No")) {
            System.out.println("\n ↩ Ritorno al menù... \n");
        } else {
            Messaggi.MsgInserimentoSbagliato();
        }
    }
}
