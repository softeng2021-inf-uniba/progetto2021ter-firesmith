package it.uniba.main;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
    Metodi classe Menu
     - Generico()
     - GiocatoreBianco()
     - GiocatoreNero()
     - Abbandona(Giocatore)
     - Uscita()
     - Gioca()
     - ImpostaGiocatore()

 */
public class Menu {
    Messaggi msg = new Messaggi();
    Partita partita = new Partita();

    boolean Bianco = false;
    boolean Nero = false;

    private static final String Spostamento = "^([1-3]{0,1}[0-9]{1})([-]{1})([1-3]{0,1}[0-9]{1})$";
    private static final String Presa = "^([1-3]{0,1}[0-9]{1})([x]{1})([1-3]{0,1}[0-9]{1})$";

    // All'avvio del programma, non c'è nessuna partita in corso

    // Menu da mostrare ad avvio programma
    public void Generico() {
        // Serve per controllare se la partita è in corso
        boolean Inizio = partita.getStato();

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

            // Controlla cosa è stato inserito
            switch(comando){
                case "--help":
                    msg.Help();
                    break;

                case "-h":
                    msg.Help();
                    break;

                case "help":
                    msg.Help();
                    break;

                case "gioca":
                    Gioca();
                    break;

                case "numeri":
                    partita.getDamiera().StampaPosizioniPedine();
                    break;

                case "damiera":
                    msg.MsgInfoPartitaDamiera();
                    break;

                case "tempo":
                    msg.MsgInfoPartita();
                    break;

                case "esci":
                    Uscita();
                    break;

                default:
                    msg.MsgErroreIns();
                    break;
            }
        } while (!Inizio); // Partita = false
    }

    public void GiocatoreBianco(Giocatore bianco) {

        boolean TurnoBianco = true; // Inizio turno giocatore bianco

        boolean StatoPartita = partita.getStato();

        do {
            System.out.print("┌──────────────────────┒"
                    +"      \n│ Menù comandi partita │"
                    +      "\n└──────────────────────┘"
                    + "\nScrivere un comando:"
                    + "\n ♢ --help | -h | help"
                    + "\n ♢ numeri"
                    + "\n ♢ damiera"
                    + "\n ♢ abbandona"
                    + "\n ♢ tempo"
                    + "\n ♢ esci"
                    + "\n➤ ");

            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();
            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo

            switch(comando){
                case "--help":
                    msg.Help();
                    break;

                case "-h":
                    msg.Help();
                    break;

                case "help":
                    msg.Help();
                    break;

                case "numeri":
                    partita.getDamiera().StampaPosizioniPedine();
                    break;

                case "damiera":
                    partita.getDamiera().StampaDamieraPedine();
                    break;

                case "gioca":
                    msg.MsgInfoPartita();
                    break;

                case "abbandona":
                    Abbandona(bianco);
                    TurnoBianco = partita.getTurno();
                    StatoPartita = partita.getStato();
                    System.out.println("Stato turno bianco: " + partita.getTurno());
                    System.out.println("Stato partita in corso: " + partita.getStato());
                    break;

                case "esci":
                    Uscita();						 // System.exit(0);
                    break;

                case "tempo":
                    // Classe Partita
                    // partita.MostraTempo();
                    // System.out.println("Tempo trascorso: " + bianco.getTempo());
                    break;

                default:
                    msg.MsgErroreIns();
                    break;
            }
        } while (TurnoBianco && StatoPartita);

        // Se TurnoBianco = false, tocca al giocatore Nero
        // Se TurnoBianco = true, tocca ancora al giocatore Bianco
        // Se StatoPartita = false, partita terminata
        // Se StatoPartita = true, partita in corso
    }

    // Da mostrare al giocatore che ha scelto la pedina nera
    // Damiera damiera = damiera in uso dalla partita (da Partita)
    // boolean Partita = flag (da Partita) che:
    // 	Se Partita = true, la partita è in corso
    // 	Se Partita = false, la partita non è in corso/è stata terminata
    public void GiocatoreNero(Giocatore nero) {

        // TurnoNero = true, se il turno è in corso
        // TurnoNero = false, se il turno è finito
        boolean TurnoNero = true; // Inizio turno giocatore nero

        do {
            System.out.print("┌──────────────────────┒"
                    +"      \n│ Menù comandi partita │"
                    +      "\n└──────────────────────┘"
                    + "\nScrivere un comando:"
                    + "\n ♢ --help | -h | help"
                    + "\n ♢ numeri"
                    + "\n ♢ damiera"
                    + "\n ♢ abbandona"
                    + "\n ♢ tempo"
                    + "\n ♢ esci"
                    + "\n➤ ");

            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();

            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo

            switch(comando){
                case "--help":
                    msg.Help();
                    break;

                case "-h":
                    msg.Help();
                    break;

                case "help":
                    msg.Help();
                    break;

                case "numeri":
                    partita.getDamiera().StampaPosizioniPedine();
                    break;

                case "damiera":
                    partita.getDamiera().StampaDamieraPedine();
                    break;

                case "gioca":
                    msg.MsgInfoPartita();
                    break;

                case "abbandona":
                    Abbandona(nero);
                    TurnoNero = partita.getTurno();
                    System.out.println("Stato turno nero: " + partita.getTurno());
                    System.out.println("Stato partita in corso: " + partita.getStato());
                    break;

                case "esci":
                    Uscita();					 // System.exit(0);
                    break;

                case "tempo":
                    // TODO da implementare
                    // partita.MostraTempo();
                    // System.out.println("Tempo trascorso: " + nero.getTempo());
                    break;

                default:
                    msg.MsgErroreIns();
                    break;
            }
        } while (TurnoNero);

        // Se TurnoNero = false, tocca al giocatore Nero
        // Se TurnoNero = true, tocca ancora al giocatore Bianco
    }

    // Metodo con il quale il giocatore può abbandonare la partita corrente ritornando al menù
    public void Abbandona(Giocatore giocatore) {
        // partita = true, se partita in corso
        // partita = false, se abbandona partita (partita non in corso)
        boolean StatoPartita = true;
        boolean StatoTurno = true;


        System.out.print("\nVuoi abbandonare la partita?" +
                "\n➤ [Si/No] ");
        Scanner input1 = new Scanner(System.in);
        String conferma = input1.nextLine();
        conferma = conferma.toLowerCase();

        if (conferma.equals("si")) {
            String Colore = giocatore.getColore();

            if (Colore.equals("bianco")) {
                msg.MsgBiancoAbbandona();
                StatoPartita = false; // Abbandona partita bianco
                StatoTurno = false;
                partita.setStato(StatoPartita);
                partita.setTurno(StatoTurno);
                partita.setAbbandona(true);
            } else {
                msg.MsgNeroAbbandona();
                StatoPartita = false;	// Abbandona partita nero
                StatoTurno = false;
                partita.setStato(StatoPartita);
                partita.setTurno(StatoTurno);
                partita.setAbbandona(true);
            }

        } else if (conferma.equals("no")) {
            StatoPartita = true;			// Continua partita in corso
            StatoTurno = true;
            partita.setStato(StatoPartita);
            partita.setTurno(StatoTurno);

        } else {
            msg.MsgErroreIns();
        }
    }

    // Metodo con il quale si può terminare immediatamente il programma
    public void Uscita() {
        System.out.print("\nPer confermare l'uscita dal gioco inserire [Si/No]" +
                "\n➤ ");
        Scanner esci = new Scanner(System.in);
        String uscita = esci.nextLine();
        uscita = uscita.toLowerCase();

        if (uscita.equals("si")) {
            msg.MsgUscita();
            System.exit(0);
            partita.setStato(false);
        } else if (uscita.equals("No")) {
            System.out.println("\n ↩ Ritorno al menù... \n");
            partita.setStato(true);
        } else {
            msg.MsgErroreIns();
        }
    }

    public void Gioca() {
        boolean StatoPartita = partita.getStato();
        if (StatoPartita) {
            msg.MsgErrorePartita(); // Stampa messaggio se la partita è già in corso (fix)
        } else {
            StatoPartita = true; 							// Inizia una nuova partita
            partita.setStato(StatoPartita);		// Imposta la nuova partita

            msg.MsgInizioPartita();

            ImpostaGiocatore(); // Prende in input il colore del primo giocatore

            // Impostazione turno giocatore
            int NumeroTurno = 1;

            // Turno = false, se il turno del giocatore non è in corso
            // Turno = true, se il turno del giocatore è in corso
            do {
                System.out.printf("\n┌───────────────────┒"
                        +  "\n│     Turno " + NumeroTurno + "       │"
                        +  "\n└───────────────────┘\n");

                if (partita.getGiocatore1().getColore().equals("bianco")) {
                    // Giocatore1 = bianco (muove per primo)
                    System.out.println("Tocca al giocatore " + partita.getGiocatore1().getColore());

                    GiocatoreBianco(partita.getGiocatore1());
                    // turno = true, se il turno è in corso
                    // turno = false, se il turno è terminato

                    System.out.println("Fine turno giocatore " + partita.getGiocatore1().getColore());
                    System.out.println(" ---> Stato partita: " + partita.getStato());
                    System.out.println(" ---> Abbandona: " + partita.getAbbandona());

                    // controllo se la partita è ancora in corso
                    // partita = true, se la partita è ancora in corso
                    // partita = false, la partita è stata terminata (abbandona)
                    if (partita.getAbbandona()) {
                        System.out.println("Partita terminata (hai inserito abbandona?)");
                    } else {
                        // Giocatore2 = nero (muove per ultimo)
                        System.out.println("Tocca al giocatore " + partita.getGiocatore2().getColore());
                        partita.setTurno(false); // Reimposta il turno per far giocare l'avversario

                        GiocatoreNero(partita.getGiocatore2());
                        // turno = true, se il turno è in corso
                        // turno = false, se il turno è terminato

                        System.out.println("Fine turno giocatore " + partita.getGiocatore2().getColore());
                        System.out.println(" ---> Stato partita: " + partita.getStato());
                        System.out.println(" ---> Abbandona: " + partita.getAbbandona());
                    }
                } else {
                    // Giocatore2 = bianco (muove per primo)
                    System.out.println("Tocca al giocatore " + partita.getGiocatore2().getColore());

                    GiocatoreBianco(partita.getGiocatore2());
                    // turno = true, se il turno è in corso
                    // turno = false, se il turno è terminato

                    System.out.println("Fine turno giocatore " + partita.getGiocatore2().getColore());
                    System.out.println(" ---> Stato partita: " + partita.getStato());
                    System.out.println(" ---> Abbandona: " + partita.getAbbandona());

                    // controllo se la partita è ancora in corso
                    // partita = true, se la partita è ancora in corso
                    // partita = false, la partita è stata terminata (abbandona)
                    if (partita.getAbbandona()) {
                        System.out.println("Partita terminata (hai inserito abbandona?)");
                    } else {
                        // Giocatore1 = nero (muove per ultimo)
                        System.out.println("Tocca al giocatore " + partita.getGiocatore1().getColore());
                        partita.setTurno(false); // Reimposta il turno per far giocare l'avversario

                        GiocatoreNero(partita.getGiocatore1());
                        // turno = true, se il turno è in corso
                        // turno = false, se il turno è terminato

                        System.out.println("Fine turno giocatore " + partita.getGiocatore2().getColore());
                        System.out.println(" ---> Stato partita: " + partita.getStato());
                        System.out.println(" ---> Abbandona: " + partita.getAbbandona());
                    }
                }
                NumeroTurno++;
            } while (partita.getStato());
        }
    }

    public void ImpostaGiocatore() {
        do {
            Scanner input = new Scanner(System.in);
            String colore = input.nextLine();
            colore = colore.toLowerCase();
            Giocatore giocatore1 = partita.getGiocatore1();
            Giocatore giocatore2 = partita.getGiocatore2();

            if (colore.equals("bianco")) {
                Bianco = true;                 // serve solo per il while
                giocatore1.setColore(colore);
                giocatore2.setColore("nero");
            } else if (colore.equals("nero")) {
                Nero = true;                 // serve solo per il while
                giocatore1.setColore(colore);
                giocatore2.setColore("bianco");
            } else {
                System.out.print("\n ⚠ Inserito comando sbagliato! Riprova." +
                        "\n➤ ");

            }
        } while (Bianco == false & Nero == false); // Controllo sui flag, che permette di inserire correttamente
        // il colore per il giocatore 1

        System.out.print("\nIl [giocatore 1] ha scelto il colore: " + partita.getGiocatore1().getColore() + " ");
        if (Bianco) {
            System.out.println("⛀");  // Pedina bianca
        } else {
            System.out.println("⛂");  // Pedina nera
        }
        System.out.print("Il [giocatore 2] ha scelto il colore: " + partita.getGiocatore2().getColore() + " ");
        if (Bianco) {
            System.out.println("⛂");  // Pedina nera
        } else {
            System.out.println("⛀");  // Pedina bianca
        }
        System.out.println();
    }
}
