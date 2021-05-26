package it.uniba.interfaccia;

import it.uniba.gioco.Giocatore;
import it.uniba.gioco.Mossa;
import it.uniba.gioco.Partita;
import it.uniba.strumenti.Messaggi;
import it.uniba.strumenti.Costanti;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.time.Instant;
import java.time.Duration;

/**
 * <h2>Classe che gestisce l'input dell'utente durante l'esecuzione
 * del programma e le interazioni tra le varie classi.</h2>
 * <b>Class Type:</b> &#60; Control &#62; <br>
 * <b>Responsabilities:</b> <br>
 *      <b>Knows:</b>
 *      <ul>
 *          <li> Giocatore che sta giocando durante il suo turno. </li>
 *      </ul>
 *      <b>Does:</b> <br>
 *              <ul>
 *                  <li> Richiedere informazioni sul funzionamento
 *                  del programma; </li>
 *                  <li> Iniziare una nuova partita a dama; </li>
 *                  <li> Visualizzare la damiera numerata; </li>
 *                  <li> Uscire dal programma; </li>
 *                  <li> Mostrare messaggi di avviso/errore. </li>
 *              </ul>
 *
 */

public class Menu {
    /** Crea una nuova partita. */
    private Partita partita = new Partita();
    /** Definisce se il giocatore ha effettuato una presa tripla. */
    private boolean presaTripla = false;

    //getter e setter
    //TODO questi metodi vanno messi in partita e ricostruiti
    public Partita getPartita() {
        return partita;
    }

    public void setPartita(final Partita p) {
        partita = p;
    }

    /**
     * Fornisce informazioni sulla presa tripla:
     * <ul>
     *     <li><code>true</code>, il giocatore ha effettuato
     *     una presa tripla;</li>
     *     <li><code>false</code>, il giocatore non ha effettuato
     *     una presa tripla.</li>
     * </ul>
     * @return Tipo di mossa inserita
     */
    public boolean isPresaTripla() {
        return presaTripla;
    }

    /**
     * Imposta il valore della presa tripla inserita dal giocatore.
     * @param prTripla Mossa effettuata dal giocatore
     */
    public void setPresaTripla(final boolean prTripla) {
        presaTripla = prTripla;
    }

    // All'avvio del programma, non c'è nessuna partita in corso

    // Menu da mostrare ad avvio programma

    /**
     * Costruttore di {@link Menu}.
     */
    public Menu() {
    }

    /**
     * Mostra il menu iniziale del programma e accetta
     * dall'utente i comandi per:
     * <ul>
     *     <li>Visualizzare le istruzioni del programma;</li>
     *     <li>Iniziare una nuova partita;</li>
     *     <li>Visualizzare la damiera numerata;</li>
     *     <li>Uscire dal programma.</li>
     * </ul>
     */
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
                    Messaggi.aiuto();
                    break;

                case "-h":
                    Messaggi.aiuto();
                    break;

                case "help":
                    Messaggi.aiuto();
                    break;

                case "gioca":
                    setPartita(new Partita());
                    gioca();
                    break;

                case "numeri":
                    getPartita().getDamiera().stampaPosizioniPedine();
                    break;

                case "damiera":
                    Messaggi.damiera();
                    break;

                case "tempo":
                    Messaggi.partita();
                    break;

                case "esci":
                    uscita();
                    getPartita().setStato(false);
                    inizio = getPartita().getStato();
                    break;

                default:
                    Messaggi.erroreInser();
                    break;
            }
        } while (!inizio); // Partita = false
    }

    /**
     * Gestisce i comandi inseriti dal giocatore che controlla
     * le pedine bianche.<br>
     * Permette al giocatore di:
     * <ul>
     *     <li>Invocare tutti i comandi di {@link Menu#generico()};</li>
     *     <li>Visualizzare la damiera con le pedine disposte;</li>
     *     <li>Effettuare 3 tipi di mosse: spostamento,
     *     presa semplice e presa multipla;</li>
     *     <li>Visualizzare il tempo trascorso dall'inizio della
     *     partita di entrambi i giocatori.</li>
     * </ul>
     * @param bianco Giocatore che possiede le pedine bianche
     */
    public void giocatoreBianco(final Giocatore bianco) {

        Instant start = Instant.now();

        boolean turnoBianco = true; // Inizio turno giocatore bianco

        Mossa mossa = new Mossa(0, 0);

        boolean chk = false;

        boolean statoPartita = getPartita().getStato();

        do {
            Messaggi.menuBianco();

            Scanner in = new Scanner(System.in, "UTF-8");
            String comando = in.nextLine();
            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo
            String presa = comando;

            // Gestione regex (bianco)
            Pattern p1 = Pattern.compile(Costanti.SPOSTAMENTO);
            Pattern p2 = Pattern.compile(Costanti.PRESA_S);
            Pattern p3 = Pattern.compile(Costanti.PRESA_M);

            Matcher m1 = p1.matcher(comando);
            Matcher m2 = p2.matcher(comando);
            Matcher m3 = p3.matcher(comando);

            int posIniziale = 0;
            int posFinale = 0;
            int posFinale2 = 0;
            int posFinale3 = 0;

            String[] array = comando.split("-|x");

            try {
                if ((array.length > Costanti.POS_UNO)) {

                    String posInizialeTemp = array[0];
                    String posFinaleTemp = array[1];


                    posIniziale = Integer.parseInt(posInizialeTemp);
                    posFinale = Integer.parseInt(posFinaleTemp);


                    mossa.setPosizione1(posIniziale);
                    mossa.setPosizione2(posFinale);

                    if (array.length > Costanti.POS_DUE && !array[Costanti.POS_DUE].equals("")) {
                        String posFinale2Temp = array[Costanti.POS_DUE];
                        posFinale2 = Integer.parseInt(posFinale2Temp);
                        mossa.setPosizione3(posFinale2);

                        if (array.length > Costanti.POS_TRE && !array[Costanti.POS_TRE].equals("")) {
                            String posFinale3Temp = array[Costanti.POS_TRE];
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
                    Messaggi.aiuto();
                    break;

                case "-h":
                    Messaggi.aiuto();
                    break;

                case "help":
                    Messaggi.aiuto();
                    break;

                case "numeri":
                    getPartita().getDamiera().stampaPosizioniPedine();
                    break;

                case "damiera":
                    getPartita().getDamiera().stampaDamieraPedine();
                    break;

                case "gioca":
                    Messaggi.errorePartita();
                    break;

                case "spostamento":
                    System.out.println("Sto effettuando lo spostamento...");

                    mossa.spostamentoSempliceBianco(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setCronologiaMosse("Bianco :" + presa);
                        getPartita().setTurno(false);
                        Messaggi.spostamentoOk();
                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }

                    turnoBianco = getPartita().getTurno();
                    break;

                case "presa semplice":
                    System.out.println("Sto effettuando la presa...");

                    mossa.presaSempliceWhite(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setTurno(false);
                        getPartita().setCronologiaMosse("Bianco :" + presa);

                        bianco.setPedineMangiate(1);
                        Messaggi.presaOk();
                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }
                    turnoBianco = getPartita().getTurno();
                    break;

                case "presa multipla":
                    System.out.println("Sto effettuando la presa...");
                    mossa.presaMultiplaWhite(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setTurno(false);
                        getPartita().setCronologiaMosse("Bianco :" + presa);


                        if (!isPresaTripla()) {
                            bianco.setPedineMangiate(Costanti.POS_DUE);
                        } else {
                            bianco.setPedineMangiate(Costanti.POS_TRE);
                        }
                        Messaggi.presaOk();

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
                    uscita(); // System.exit(0);
                    break;

                case "tempo":
                    Instant finish = Instant.now();
                    long elapsed = Duration.between(start, finish).getSeconds();
                    bianco.setTempo(elapsed);
                    getPartita().tempo(bianco, start, finish);
                    break;

                default:
                    Messaggi.erroreInser();
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

    /**
     * Gestisce i comandi inseriti dal giocatore che controlla
     * le pedine nere.<br>
     * Permette al giocatore di:
     * <ul>
     *      <li>Invocare tutti i comandi di {@link Menu#generico()};</li>
     *      <li>Visualizzare la damiera con le pedine disposte;</li>
     *      <li>Effettuare 3 tipi di mosse: spostamento,
     *      presa semplice e presa multipla;</li>
     *      <li>Visualizzare il tempo trascorso dall'inizio
     *      della partita di entrambi i giocatori.</li>
     * </ul>
     * @param nero Giocatore che possiede le pedine nere
     */
    public void giocatoreNero(final Giocatore nero) {
        Mossa mossa = new Mossa(0, 0);

        /**
         * Assume valore:
         * <ul>
         *     <li><code>true</code>, se il turno &#232; in corso;</li>
         *     <li><code>false</code>, se il turno &#232; terminato.</li>
         * </ul>
         */
        boolean turnoNero = true; // Inizio turno giocatore nero

        Instant start = Instant.now();

        boolean chk = false;

        do {
            Messaggi.menuNero();

            Scanner in = new Scanner(System.in, "UTF-8");
            String comando = in.nextLine();

            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo
            String presa = comando;

            // Gestione regex (nero)

            Pattern p1 = Pattern.compile(Costanti.SPOSTAMENTO);
            Pattern p2 = Pattern.compile(Costanti.PRESA_S);
            Pattern p3 = Pattern.compile(Costanti.PRESA_M);

            Matcher m1 = p1.matcher(comando);
            Matcher m2 = p2.matcher(comando);
            Matcher m3 = p3.matcher(comando);

            int posIniziale = 0;
            int posFinale = 0;
            int posFinale2 = 0;
            int posFinale3 = 0;

            String[] array = comando.split("-|x");

            try {
                if ((array.length > Costanti.POS_UNO)) {

                    String posInizialeTemp = array[0];
                    String posFinaleTemp = array[1];

                    posIniziale = Integer.parseInt(posInizialeTemp);
                    posFinale = Integer.parseInt(posFinaleTemp);

                    mossa.setPosizione1(posIniziale);
                    mossa.setPosizione2(posFinale);

                    if (array.length > Costanti.POS_DUE && !array[Costanti.POS_DUE].equals("")) {
                        String posFinale2Temp = array[2];
                        posFinale2 = Integer.parseInt(posFinale2Temp);
                        mossa.setPosizione3(posFinale2);
                        if (array.length > Costanti.POS_TRE && !array[Costanti.POS_TRE].equals("")) {
                            String posFinale3Temp = array[Costanti.POS_TRE];
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
                    Messaggi.aiuto();
                    break;

                case "-h":
                    Messaggi.aiuto();
                    break;

                case "help":
                    Messaggi.aiuto();
                    break;

                case "numeri":
                    getPartita().getDamiera().stampaPosizioniPedine();
                    break;

                case "damiera":
                    getPartita().getDamiera().stampaDamieraPedine();
                    break;

                case "gioca":
                    Messaggi.errorePartita();
                    break;
                case "spostamento":
                    Messaggi.sppostamento();

                    mossa.spostamentoSempliceNero(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setCronologiaMosse("Nero :" + presa);
                        getPartita().setTurno(false);
                        Messaggi.spostamentoOk();
                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }
                    turnoNero = getPartita().getTurno();
                    break;

                case "presa semplice":
                    Messaggi.presa();

                    mossa.presaSempliceBlack(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setTurno(false);
                        getPartita().setCronologiaMosse("Nero :" + presa);

                        nero.setPedineMangiate(1);
                        Messaggi.presaOk();

                    } else {
                        getPartita().setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }
                    turnoNero = getPartita().getTurno();
                    break;

                case "presa multipla":
                    Messaggi.presa();

                    mossa.presaMultiplaBlack(getPartita().getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        getPartita().setTurno(false);
                        getPartita().setCronologiaMosse("Nero :" + presa);

                        if (!presaTripla) {
                            nero.setPedineMangiate(Costanti.POS_DUE);
                        } else {
                            nero.setPedineMangiate(Costanti.POS_TRE);
                        }
                        Messaggi.presaOk();

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
                    Messaggi.erroreInser();
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

    /**
     * Quando viene invocato dal menu, permette al giocatore
     * di arrendersi e concludere la partita.
     * @param giocatore Giocatore che ha richiesto di abbandonare la partita
     */
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
                    Messaggi.biancoAbbandona();
                    statoPartita = false; // Abbandona partita bianco
                    statoTurno = false;
                    getPartita().setStato(statoPartita);
                    getPartita().setTurno(statoTurno);
                    getPartita().setAbbandona(true);
                } else {
                    Messaggi.neroAbbandona();
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
                Messaggi.erroreInser();
                System.out.print("➤");
            }
        } while (!valido);
    }

    // Metodo con il quale si può terminare immediatamente il programma

    /**
     * Quando viene invocato dal menu, permette al giocatore
     * di uscire dal programma.
     */
    public void uscita() {
        boolean valido = false;
        System.out.print("\n\nPer confermare l'uscita dal gioco inserire "
                + "[Si/No]" + "\n➤ ");
        do {
            Scanner esci = new Scanner(System.in, "UTF-8");
            String uscita = esci.nextLine();
            uscita = uscita.toLowerCase();

            if (uscita.equals("si")) {
                Messaggi.uscita();
                Runtime.getRuntime().exit(0);
                getPartita().setStato(false);
                valido = true;

            } else if (uscita.equals("no")) {
                Messaggi.menu();
                getPartita().setStato(true);
                valido = true;

            } else {
                Messaggi.erroreInser();
                System.out.print("➤");
            }
        } while (!valido);
    }

    /**
     * Gestisce tutte le operazioni permesse durante il turno di ogni giocatore.
     */
    public void gioca() {
        boolean statoPartita = getPartita().getStato();
        if (statoPartita) {
            Messaggi.errorePartita();
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

