package it.uniba.main;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/** Class Type: <<Control>> *
 *  Responsabilities: Classe che gestisce le interazioni tra le varie classi; funge da interfaccia per l'utente
 */


public class Menu {
    Messaggi msg = new Messaggi();
    Partita partita = new Partita();

    boolean Bianco = false;
    boolean Nero = false;

    boolean presaTripla = false;

    //public static final String ALLCASES = "\\d{1,2}([x]{1}|[-]{1})\\d{1,2}([x]{1}\\d{1,2})?";*/
    public static final String SPOSTAMENTO = "\\d{1,2}[-]{1}\\d{1,2}";
    public static final String PRESA_S = "\\d{1,2}[x]{1}\\d{1,2}";
    public static final String PRESA_M = "\\d{1,2}[x]{1}\\d{1,2}([x]{1}\\d{1,2}){1,2}";

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

            comando = comando.toLowerCase(); //Trasforma l'input in minuscolo

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
                    partita = new Partita();
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

        Mossa mossa = new Mossa(0,0);

        boolean chk = false;

        boolean StatoPartita = partita.getStato();

        do {
            System.out.print("┌───────────────────────┒"
                    +"      \n│ Menù Giocatore Bianco │"
                    +      "\n└───────────────────────┘"
                    + "\nScrivere un comando:"
                    + "\n ♢ --help | -h | help"
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
                    + "\n➤ ");

            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();
            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo
            String presa=comando;

            // Gestione regex (bianco)
            Pattern p1 = Pattern.compile(SPOSTAMENTO);
            Pattern p2 = Pattern.compile(PRESA_S);
            Pattern p3 = Pattern.compile(PRESA_M);

            Matcher m1 = p1.matcher(comando);
            Matcher m2 = p2.matcher(comando);
            Matcher m3 = p3.matcher(comando);

            int PosizioneIniziale = 0;
            int PosizioneFinale = 0;
            int PosizioneFinale2 = 0;
            int PosizioneFinale3 = 0;

            String[] array = comando.split("-|x");

            try {
                if ((array.length > 1)) {

                    String PosizioneInizialeTemp = array[0];
                    String PosizioneFinaleTemp = array[1];


                    PosizioneIniziale = Integer.parseInt(PosizioneInizialeTemp);
                    PosizioneFinale = Integer.parseInt(PosizioneFinaleTemp);


                    mossa.setPosizione1(PosizioneIniziale);
                    mossa.setPosizione2(PosizioneFinale);

                    if(array.length > 2) {
                        String PosizioneFinale2Temp = array[2];
                        PosizioneFinale2 = Integer.parseInt(PosizioneFinale2Temp);
                        mossa.setPosizione3(PosizioneFinale2);

                        if(array.length > 3 && !array[3].equals("")) {
                            String PosizioneFinale3Temp = array[3];
                            PosizioneFinale3 = Integer.parseInt(PosizioneFinale3Temp);
                            mossa.setPosizione4(PosizioneFinale3);

                            presaTripla = true;

                        }
                    }

                    if (m1.matches()) {
                        comando = "spostamento";
                    } else if (m2.matches()) {
                        comando = "presa semplice";
                    } else if (m3.matches()) {
                        comando = "presa multipla";
                    }
                }
            } catch (NumberFormatException ex) {
                System.err.println("\nIllegal string (exception)");
            }
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

                case "spostamento":
                    System.out.println("Sto effettuando lo spostamento...");

                    mossa.SpostamentoSempliceBianco(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setCronologiaMosse("Bianco :" + presa);
                        partita.setTurno(false);
                    } else {
                        partita.setTurno(true);
                    }

                    TurnoBianco = partita.getTurno();
                    break;

                case "presa semplice":
                    System.out.println("Sto effettuando la presa...");

                    mossa.PresaSempliceWhite(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Bianco :" + presa);
                        partita.getDamiera().StampaDamieraPedine();

                        bianco.setPedineMangiate(1);

                    } else {
                        partita.setTurno(true);
                    }
                    TurnoBianco = partita.getTurno();
                    break;

                case "presa multipla":
                    System.out.println("Sto effettuando la presa...");
                    mossa.PresaMultiplaWhite(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Bianco :" + presa);
                        partita.getDamiera().StampaDamieraPedine();

                        if(!presaTripla) {
                            bianco.setPedineMangiate(2);
                        } else {
                            bianco.setPedineMangiate(3);
                        }


                    } else {
                        partita.setTurno(true);
                    }
                    TurnoBianco = partita.getTurno();
                    break;

                case "prese":

                    partita.StampaPedineMangiate();

                    break;

                    case "mosse":

                        partita.getCronologiaMosse();

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
        Mossa mossa = new Mossa(0,0);

        boolean StatoPartita = partita.getStato();
        // TurnoNero = true, se il turno è in corso
        // TurnoNero = false, se il turno è finito
        boolean TurnoNero = true; // Inizio turno giocatore nero

        boolean chk = false;

        do {
            System.out.print("┌──────────────────────┒"
                    +"      \n│ Menù Giocatore Nero  │"
                    +      "\n└──────────────────────┘"
                    + "\nScrivere un comando:"
                    + "\n ♢ --help | -h | help"
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
                    + "\n➤ ");

            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();

            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo
            String presa=comando;

            // Gestione regex (nero)

            Pattern p1 = Pattern.compile(SPOSTAMENTO);
            Pattern p2 = Pattern.compile(PRESA_S);
            Pattern p3 = Pattern.compile(PRESA_M);

            Matcher m1 = p1.matcher(comando);
            Matcher m2 = p2.matcher(comando);
            Matcher m3 = p3.matcher(comando);

            int PosizioneIniziale = 0;
            int PosizioneFinale = 0;
            int PosizioneFinale2 = 0;
            int PosizioneFinale3 = 0;

            String[] array = comando.split("-|x");

            try {
                if ((array.length > 1)) {

                    String PosizioneInizialeTemp = array[0];
                    String PosizioneFinaleTemp = array[1];

                    PosizioneIniziale = Integer.parseInt(PosizioneInizialeTemp);
                    PosizioneFinale = Integer.parseInt(PosizioneFinaleTemp);

                    mossa.setPosizione1(PosizioneIniziale);
                    mossa.setPosizione2(PosizioneFinale);

                    if(array.length > 2 && !array[2].equals("")) {
                        String PosizioneFinale2Temp = array[2];
                        PosizioneFinale2 = Integer.parseInt(PosizioneFinale2Temp);
                        mossa.setPosizione3(PosizioneFinale2);
                        if(array.length > 3 && !array[3].equals("")) {
                            String PosizioneFinale3Temp = array[3];
                            PosizioneFinale3 = Integer.parseInt(PosizioneFinale3Temp);
                            mossa.setPosizione4(PosizioneFinale3);

                            presaTripla = true;

                        }
                    }

                    if (m1.matches()) {
                        comando = "spostamento";
                    } else if (m2.matches()) {
                        comando = "presa semplice";
                    } else if (m3.matches()) {
                        comando = "presa multipla";
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println("\nIllegal string (exception)");
            }

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
                case "spostamento":
                    System.out.println("Sto effettuando lo spostamento...");

                    mossa.SpostamentoSempliceNero(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setCronologiaMosse("Nero :" + presa);
                        partita.setTurno(false);
                    } else {
                        partita.setTurno(true);
                    }
                    TurnoNero = partita.getTurno();
                    break;

                case "presa semplice":
                    System.out.println("Sto effettuando la presa...");

                    mossa.PresaSempliceBlack(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Nero :" + presa);
                        partita.getDamiera().StampaDamieraPedine();

                        nero.setPedineMangiate(1);

                    } else {
                        partita.setTurno(true);
                    }
                    TurnoNero = partita.getTurno();
                    break;

                case "presa multipla":
                    System.out.println("Sto effettuando la presa...");

                    mossa.PresaMultiplaBlack(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Nero :" + presa);
                        partita.getDamiera().StampaDamieraPedine();

                        if(!presaTripla) {
                            nero.setPedineMangiate(2);
                        } else {
                            nero.setPedineMangiate(3);
                        }

                    } else {
                        partita.setTurno(true);
                    }
                    TurnoNero = partita.getTurno();
                    break;

                case "prese":
                    partita.StampaPedineMangiate();
                    break;
                case "mosse":

                    partita.getCronologiaMosse();

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

