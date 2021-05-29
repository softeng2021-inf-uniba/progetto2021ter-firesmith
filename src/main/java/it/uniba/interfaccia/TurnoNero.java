package it.uniba.interfaccia;

import it.uniba.gioco.Mossa;
import it.uniba.gioco.MossaNero;
import it.uniba.gioco.Partita;
import it.uniba.strumenti.Comando;
import it.uniba.strumenti.Costanti;
import it.uniba.strumenti.Messaggi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Gestisce i comandi inseriti dal giocatore che controlla
 * le pedine nere. </h1><br>
 * <b>Class Type:</b> &#60; Control &#62; <br><br>
 * <b>Responsabilities:</b> <br>
 * <b>Knows:</b>
 *  <ul>
 *      <li> La partita in corso </li>
 *      <li> Ogni comando che il giocatore Nero inserisce </li>
 *  </ul> <br>
 *
 *  <b>Does:</b>
 *  <ul>
 *     <li>Invocare tutti i comandi di {@link Menu#gioca()};</li>
 *     <li>Visualizzare la damiera con le pedine disposte;</li>
 *     <li>Effettuare 3 tipi di mosse: spostamento,
 *     presa semplice e presa multipla;</li>
 *     <li>Visualizzare il tempo trascorso dall'inizio della
 *     partita di entrambi i giocatori.</li>
 * </ul>
 */

public class TurnoNero implements Turno {

    /**
     * Creazione istanza di Comando
     */
    private Comando cmd = new Comando();


    /**
     * Attributo che definisce l'istante di tempo dal quale iniziare
     * a contare per calcolare il tempo trascorso nel singolo turno
     */
    private long start;
    /**
     * Attributo che definisce l'istante di tempo nel quale terminare
     * il conteggio del tempo
     */
    private long finish;
    /**
     * Attributo che rappresenta il tempo trascorso dall'istante di tempo
     * individuato da 'finish' da quello individuato da 'start'
     */
    private long elapsed;

    /**
     * Costruttore vuoto
     */
    public TurnoNero() {}

    /**
     * Metodo getter che ritorna un istanza della classe Comando
     *
     * @return istanza di comando
     */
    public Comando getCmd() {
        return cmd;
    }

    /**
     * Metodo setter che imposta {@link TurnoNero#start} sfruttando il tempo
     * del sistema
     */
    public void setStart() {
        this.start = System.currentTimeMillis();
    }

    /**
     * Metodo getter
     * @return l'istante di tempo in cui è iniziato il conteggio
     */
    public long getStart() {
        return start;
    }

    /**
     * Metodo getter
     * @return l'istante di tempo in cui è terminato il conteggio
     */
    public long getFinish() {
        return finish;
    }

    /**
     * Metodo setter che imposta {@link TurnoNero#finish} sfruttando il tempo
     * del sistema
     */
    public void setFinish() {
        this.finish = System.currentTimeMillis();
    }

    /**
     * Metodo setter che calcola 'elapsed' come una semplice
     * differenza fra l'istante finale e quello iniziale
     * @param start l'istante di tempo iniziale
     * @param finish l'istante di tempo finale
     */
    public void setElapsed(long start, long finish) {
        this.elapsed = start - finish;
    }

    /**
     * Metodo getter
     * @return il tempo trascorso fra {@link TurnoNero#finish} e {@link TurnoNero#start}
     */
    public long getElapsed() {
        return elapsed;
    }

    /**
     * Metodo che gestisce il turno del giocatore Nero, permettendogli
     * di eseguire una serie di comandi
     *
     * @param partita la partita in corso
     * @param tempoG il tempo cumulativo del giocatore aggiornato ad ogni turno
     * @return il tempo trascorso dal giocatore nel singolo turno
     */
    @Override
    public long turnoGiocatore(Partita partita, long tempoG) {

        setStart();

        boolean turnoNero = true; // Inizio turno giocatore bianco

        Mossa mossa = new MossaNero(0, 0);

        boolean chk = false;

        do {
            Messaggi.menuNero();

            Scanner in = new Scanner(System.in, "UTF-8");
            String comando = in.nextLine();
            String presa = comando;
            comando = getCmd().gestisciRegex(mossa, comando);


            switch (comando) {
                case "--help":

                case "-h":

                case "help":
                    Messaggi.aiuto();
                    break;

                case "numeri":
                    partita.getDamiera().stampaPosizioniPedine();
                    break;

                case "damiera":
                    partita.getDamiera().stampaDamieraPedine();
                    break;

                case "gioca":
                    Messaggi.errorePartita();
                    break;

                case "spostamento":
                    Messaggi.spostamento();

                    mossa.spostamentoSemplice(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setCronologiaMosse("Nero: " + presa);
                        partita.setTurno(false);
                        Messaggi.spostamentoOk();
                    } else {
                        partita.setTurno(true);
                        Messaggi.nonValida();
                    }

                    turnoNero = partita.getTurno();
                    break;

                case "presasemplice":
                    Messaggi.presa();

                    mossa.presaSemplice(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Nero: " + presa);

                        partita.getNero().setPedineMangiate(1);
                        Messaggi.presaOk();
                    } else {
                        partita.setTurno(true);
                        Messaggi.nonValida();
                    }
                    turnoNero = partita.getTurno();
                    break;

                case "presamultipla":
                    Messaggi.presa();
                    mossa.presaMultipla(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Nero: " + presa);

                        if (mossa.getPresaTripla()) {
                            partita.getNero().setPedineMangiate(Costanti.DUE);
                        } else {
                            partita.getNero().setPedineMangiate(Costanti.TRE);
                        }
                        Messaggi.presaOk();

                    } else {
                        partita.setTurno(true);
                        Messaggi.nonValida();
                    }
                    turnoNero = partita.getTurno();
                    break;

                case "prese":
                    partita.stampaPedineMangiate();
                    break;

                case "mosse":
                    partita.getCronologiaMosse();
                    break;

                case "abbandona":
                    getCmd().abbandona(partita, partita.getNero());
                    turnoNero = partita.getTurno();

                    break;

                case "esci":
                    getCmd().esci(partita); // System.exit(0);
                    break;

                case "tempo":
                    setFinish();
                    setElapsed(getFinish(), getStart());

                    long tempoTurno = getElapsed() + tempoG;

                    partita.getNero().setTempo(tempoTurno);

                    partita.tempo();
                    break;

                default:
                    Messaggi.inserimento();
                    break;
            }
        } while (turnoNero);

        //questo per far scorrere il tempo anche se non viene richiesto il comando tempo
        setFinish();
        setElapsed(getFinish(), getStart());

        long tempoTurno = getElapsed() + tempoG;

        partita.getNero().setTempo(tempoTurno);

        return partita.getNero().getTempo();

        // Se turnoBianco = false, tocca al giocatore Nero
        // Se turnoBianco = true, tocca ancora al giocatore Bianco
        // Se statoPartita = false, partita terminata
        // Se statoPartita = true, partita in corso
    }
}
