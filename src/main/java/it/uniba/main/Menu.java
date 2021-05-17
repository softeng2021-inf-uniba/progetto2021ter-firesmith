package it.uniba.main;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.time.Instant;
import java.time.Duration;

/**
 * Class Type: <<Control>> *
 * Responsabilities: Classe che gestisce le interazioni tra le varie classi;
 * funge da interfaccia per l'utente.
 */


public class Menu {

    private Partita partita = new Partita();

    private boolean presaTripla = false;

    //getter e setter
    public Partita getPartita() {
        return partita;
    }

    public void setPartita(final Partita p) {
        partita = p;
    }

    public boolean isPresaTripla() {
        return presaTripla;
    }

    public void setPresaTripla(final boolean prTripla) {
        presaTripla = prTripla;
    }

    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static final String SPOSTAMENTO = "\\d{1,2}[-]{1}\\d{1,2}";
    public static final String PRESA_S = "\\d{1,2}[x]{1}\\d{1,2}";
    public static final String PRESA_M =
            "\\d{1,2}[x]{1}\\d{1,2}([x]{1}\\d{1,2}){1,2}";

    // All'avvio del programma, non c'è nessuna partita in corso

    // Menu da mostrare ad avvio programma
    public void generico() {
        // Serve per controllare se la partita è in corso
        boolean inizio = getPartita().getStato();

        do {
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

            Scanner in = new Scanner(System.in, "UTF-8");
            String comando = in.nextLine();

            comando = comando.toLowerCase(); //Trasforma l'input in minuscolo

            // Controlla cosa è stato inserito
            switch (comando) {
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
                    setPartita(new Partita());
                    gioca();
                    break;

                case "numeri":
                    getPartita().getDamiera().StampaPosizioniPedine();
                    break;

                case "damiera":
                    Messaggi.MsgInfoPartitaDamiera();
                    break;

                case "tempo":
                    Messaggi.MsgInfoPartita();
                    break;

                case "esci":
                    uscita();
                    getPartita().setStato(false);
                    inizio = getPartita().getStato();
                    break;

                default:
                    Messaggi.MsgErroreIns();
                    break;
            }
        } while (!inizio); // Partita = false
    }

    public void giocatoreBianco(final Giocatore bianco) {

        Instant start = Instant.now();

        boolean turnoBianco = true; // Inizio turno giocatore bianco

        Mossa mossa = new Mossa(0, 0);

        boolean chk = false;

        boolean statoPartita = getPartita().getStato();

        do {
            Messaggi.MsgMenuBianco();

            Scanner in = new Scanner(System.in, "UTF-8");
            String comando = in.nextLine();
            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo
            String presa = comando;

            // Gestione regex (bianco)
            Pattern p1 = Pattern.compile(SPOSTAMENTO);
            Pattern p2 = Pattern.compile(PRESA_S);
            Pattern p3 = Pattern.compile(PRESA_M);

            Matcher m1 = p1.matcher(comando);
            Matcher m2 = p2.matcher(comando);
            Matcher m3 = p3.matcher(comando);

            int posIniziale = 0;
            int posFinale = 0;
            int posFinale2 = 0;
            int posFinale3 = 0;

            String[] array = comando.split("-|x");

            try {
                if ((array.length > 1)) {

                    String posInizialeTemp = array[0];
                    String posFinaleTemp = array[1];


                    posIniziale = Integer.parseInt(posInizialeTemp);
                    posFinale = Integer.parseInt(posFinaleTemp);


                    mossa.setPosizione1(posIniziale);
                    mossa.setPosizione2(posFinale);

                    if (array.length > TWO) {
                        String posFinale2Temp = array[TWO];
                        posFinale2 = Integer.parseInt(posFinale2Temp);
                        mossa.setPosizione3(posFinale2);

                        if (array.length > THREE && !array[THREE].equals("")) {
                            String posFinale3Temp = array[THREE];
                            posFinale3 = Integer.parseInt(posFinale3Temp);
                            mossa.setPosizione4(posFinale3);

                            setPresaTripla(true);

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
            switch (comando) {
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
                    getPartita().getDamiera().StampaPosizioniPedine();
                    break;

                case "damiera":
                    getPartita().getDamiera().StampaDamieraPedine();
                    break;

                case "gioca":
                    Messaggi.MsgErrorePartita();
                    break;

                case "spostamento":
                    System.out.println("Sto effettuando lo spostamento...");

                    mossa.SpostamentoSempliceBianco(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setCronologiaMosse("Bianco :" + presa);
                        getPartita().setTurno(false);
                        Messaggi.MsgSpostamentoEffettuato();
                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }

                    turnoBianco = getPartita().getTurno();
                    break;

                case "presa semplice":
                    System.out.println("Sto effettuando la presa...");

                    mossa.PresaSempliceWhite(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setTurno(false);
                        getPartita().setCronologiaMosse("Bianco :" + presa);

                        bianco.setPedineMangiate(1);
                        Messaggi.MsgMossaEffettuata();
                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }
                    turnoBianco = getPartita().getTurno();
                    break;

                case "presa multipla":
                    System.out.println("Sto effettuando la presa...");
                    mossa.PresaMultiplaWhite(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setTurno(false);
                        getPartita().setCronologiaMosse("Bianco :" + presa);


                        if (!isPresaTripla()) {
                            bianco.setPedineMangiate(TWO);
                        } else {
                            bianco.setPedineMangiate(THREE);
                        }
                        Messaggi.MsgMossaEffettuata();

                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }
                    turnoBianco = getPartita().getTurno();
                    break;

                case "prese":
                    getPartita().stampaPedineMangiate();
                    break;

                case "mosse":
                    getPartita().getCronologiaMosse();
                    break;

                case "abbandona":
                    abbandona(bianco);
                    turnoBianco = getPartita().getTurno();
                    statoPartita = getPartita().getStato();

                    break;

                case "esci":
                    uscita();                         // System.exit(0);
                    break;

                case "tempo":
                    Instant finish = Instant.now();
                    long elapsed = Duration.between(start, finish).getSeconds();
                    bianco.setTempo(elapsed);
                    getPartita().tempo(bianco, start, finish);
                    break;

                default:
                    Messaggi.MsgErroreIns();
                    break;
            }
        } while (turnoBianco && statoPartita);

        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).getSeconds();
        bianco.setTempo(elapsed);
        // Se turnoBianco = false, tocca al giocatore Nero
        // Se turnoBianco = true, tocca ancora al giocatore Bianco
        // Se statoPartita = false, partita terminata
        // Se statoPartita = true, partita in corso
    }

    // Da mostrare al giocatore che ha scelto la pedina nera
    // Damiera damiera = damiera in uso dalla partita (da Partita)
    // boolean Partita = flag (da Partita) che:
    // Se Partita = true, la partita è in corso
    // Se Partita = false, la partita non è in corso/è stata terminata
    public void giocatoreNero(final Giocatore nero) {
        Mossa mossa = new Mossa(0, 0);

        // turnoNero = true, se il turno è in corso
        // turnoNero = false, se il turno è finito
        boolean turnoNero = true; // Inizio turno giocatore nero

        Instant start = Instant.now();

        boolean chk = false;

        do {
            Messaggi.MsgMenuNero();

            Scanner in = new Scanner(System.in, "UTF-8");
            String comando = in.nextLine();

            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo
            String presa = comando;

            // Gestione regex (nero)

            Pattern p1 = Pattern.compile(SPOSTAMENTO);
            Pattern p2 = Pattern.compile(PRESA_S);
            Pattern p3 = Pattern.compile(PRESA_M);

            Matcher m1 = p1.matcher(comando);
            Matcher m2 = p2.matcher(comando);
            Matcher m3 = p3.matcher(comando);

            int posIniziale = 0;
            int posFinale = 0;
            int posFinale2 = 0;
            int posFinale3 = 0;

            String[] array = comando.split("-|x");

            try {
                if ((array.length > ONE)) {

                    String posInizialeTemp = array[0];
                    String posFinaleTemp = array[1];

                    posIniziale = Integer.parseInt(posInizialeTemp);
                    posFinale = Integer.parseInt(posFinaleTemp);

                    mossa.setPosizione1(posIniziale);
                    mossa.setPosizione2(posFinale);

                    if (array.length > TWO && !array[TWO].equals("")) {
                        String posFinale2Temp = array[2];
                        posFinale2 = Integer.parseInt(posFinale2Temp);
                        mossa.setPosizione3(posFinale2);
                        if (array.length > THREE && !array[THREE].equals("")) {
                            String posFinale3Temp = array[THREE];
                            posFinale3 = Integer.parseInt(posFinale3Temp);
                            mossa.setPosizione4(posFinale3);

                            setPresaTripla(true);

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

            switch (comando) {
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
                    getPartita().getDamiera().StampaPosizioniPedine();
                    break;

                case "damiera":
                    getPartita().getDamiera().StampaDamieraPedine();
                    break;

                case "gioca":
                    Messaggi.MsgErrorePartita();
                    break;
                case "spostamento":
                    Messaggi.MsgSpostamento();

                    mossa.SpostamentoSempliceNero(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setCronologiaMosse("Nero :" + presa);
                        getPartita().setTurno(false);
                        Messaggi.MsgSpostamentoEffettuato();
                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }
                    turnoNero = getPartita().getTurno();
                    break;

                case "presa semplice":
                    Messaggi.MsgPresa();

                    mossa.PresaSempliceBlack(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setTurno(false);
                        getPartita().setCronologiaMosse("Nero :" + presa);

                        nero.setPedineMangiate(1);
                        Messaggi.MsgMossaEffettuata();

                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }
                    turnoNero = getPartita().getTurno();
                    break;

                case "presa multipla":
                    Messaggi.MsgPresa();

                    mossa.PresaMultiplaBlack(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setTurno(false);
                        getPartita().setCronologiaMosse("Nero :" + presa);

                        if (!presaTripla) {
                            nero.setPedineMangiate(TWO);
                        } else {
                            nero.setPedineMangiate(THREE);
                        }
                        Messaggi.MsgMossaEffettuata();

                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }
                    turnoNero = getPartita().getTurno();
                    break;

                case "prese":
                    getPartita().stampaPedineMangiate();
                    break;

                case "mosse":
                    getPartita().getCronologiaMosse();
                    break;

                case "abbandona":
                    abbandona(nero);
                    turnoNero = getPartita().getTurno();
                    break;

                case "esci":
                    uscita();                     // System.exit(0);
                    break;

                case "tempo":
                    Instant finish = Instant.now();
                    long elapsed = Duration.between(start, finish).getSeconds();
                    nero.setTempo(elapsed);
                    getPartita().tempo(nero, start, finish);
                    break;

                default:
                    Messaggi.MsgErroreIns();
                    break;
            }
        } while (turnoNero);

        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).getSeconds();
        nero.setTempo(elapsed);

        // Se turnoNero = false, tocca al giocatore Nero
        // Se turnoNero = true, tocca ancora al giocatore Bianco
    }

    // Metodo con il quale il giocatore può abbandonare
    // la partita corrente ritornando al menù
    public void abbandona(final Giocatore giocatore) {
        // partita = true, se partita in corso
        // partita = false, se abbandona partita (partita non in corso)
        boolean statoPartita = true;
        boolean statoTurno = true;
        boolean valido = false;


        System.out.print("\nVuoi abbandonare la partita?"
                + "\n➤ [Si/No] ");
        do {
            Scanner input1 = new Scanner(System.in, "UTF-8");
            String conferma = input1.nextLine();
            conferma = conferma.toLowerCase();


            if (conferma.equals("si")) {
                String colore = giocatore.getColore();
                valido = true;

                if (colore.equals("bianco")) {
                    Messaggi.MsgBiancoAbbandona();
                    statoPartita = false; // Abbandona partita bianco
                    statoTurno = false;
                    getPartita().setStato(statoPartita);
                    getPartita().setTurno(statoTurno);
                    getPartita().setAbbandona(true);
                } else {
                    Messaggi.MsgNeroAbbandona();
                    statoPartita = false;    // Abbandona partita nero
                    statoTurno = false;
                    getPartita().setStato(statoPartita);
                    getPartita().setTurno(statoTurno);
                    getPartita().setAbbandona(true);
                }

            } else if (conferma.equals("no")) {
                statoPartita = true;            // Continua partita in corso
                statoTurno = true;
                getPartita().setStato(statoPartita);
                getPartita().setTurno(statoTurno);
                valido = true;

            } else {
                Messaggi.MsgErroreIns();
                System.out.print("➤");
            }
        } while (!valido);
    }

    // Metodo con il quale si può terminare immediatamente il programma
    public void uscita() {
        boolean valido = false;
        System.out.print("\n\nPer confermare l'uscita dal gioco inserire "
                + "[Si/No]" + "\n➤ ");
        do {
            Scanner esci = new Scanner(System.in, "UTF-8");
            String uscita = esci.nextLine();
            uscita = uscita.toLowerCase();

            if (uscita.equals("si")) {
                Messaggi.MsgUscita();
                Runtime.getRuntime().exit(0);
                getPartita().setStato(false);
                valido = true;

            } else if (uscita.equals("no")) {
                Messaggi.MsgTornaMenu();
                getPartita().setStato(true);
                valido = true;

            } else {
                Messaggi.MsgErroreIns();
                System.out.print("➤");
            }
        } while (!valido);
    }

    public void gioca() {
        boolean statoPartita = getPartita().getStato();
        if (statoPartita) {
            Messaggi.MsgErrorePartita();
            // Stampa messaggio se la partita è già in corso (fix)
        } else {
            statoPartita = true;         // Inizia una nuova partita
            getPartita().setStato(statoPartita); // Imposta la nuova partita
            Giocatore giocatore1 = getPartita().getGiocatore1();
            Giocatore giocatore2 = getPartita().getGiocatore2();
            giocatore1.setColore("bianco");
            giocatore2.setColore("nero");
            // Prende in input il colore del primo giocatore

            // Impostazione turno giocatore
            int numeroTurno = 1;

            // Turno = false, se il turno del giocatore non è in corso
            // Turno = true, se il turno del giocatore è in corso
            do {
                System.out.printf("\n┌───────────────────┒"
                        + "\n│     Turno " + numeroTurno + "       │"
                        + "\n└───────────────────┘\n");

                // Giocatore1 = bianco (muove per primo)

                giocatoreBianco(getPartita().getGiocatore1());
                // turno = true, se il turno è in corso
                // turno = false, se il turno è terminato

                System.out.println("Fine turno giocatore "
                        + getPartita().getGiocatore1().getColore());

                // controllo se la partita è ancora in corso
                // partita = true, se la partita è ancora in corso
                // partita = false, la partita è stata terminata (abbandona)
                if (getPartita().getAbbandona()) {
                    System.out.println("Partita terminata!");
                } else {
                    // Giocatore2 = nero (muove per ultimo)
                    getPartita().setTurno(false);
                    // Reimposta il turno per far giocare l'avversario

                    giocatoreNero(getPartita().getGiocatore2());
                    // turno = true, se il turno è in corso
                    // turno = false, se il turno è terminato

                    System.out.println("Fine turno giocatore "
                            + getPartita().getGiocatore2().getColore());
                }

                numeroTurno++;
            } while (getPartita().getStato());
        }
    }
}

