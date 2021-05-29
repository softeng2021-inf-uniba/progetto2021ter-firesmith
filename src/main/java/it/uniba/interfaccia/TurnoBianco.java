package it.uniba.interfaccia;

import it.uniba.gioco.Mossa;
import it.uniba.gioco.MossaBianco;
import it.uniba.gioco.Partita;
import it.uniba.strumenti.Comando;
import it.uniba.strumenti.Costanti;
import it.uniba.strumenti.Messaggi;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h1>Gestisce i comandi inseriti dal giocatore che controlla
 *  le pedine bianche. </h1><br>
 * <b>Class Type:</b> &#60; Control &#62; <br><br>
 * <b>Responsabilities:</b> <br>
 * <b>Knows:</b>
 *  <ul>
 *      <li> La partita in corso </li>
 *      <li> Ogni comando che il giocatore Bianco inserisce </li>
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
public class TurnoBianco implements Turno {

    private Comando cmd = new Comando();

    private long start;
    private long finish;
    private long elapsed;

    /**
     * Costruttore vuoto
     */
    public TurnoBianco() {}

    public void setStart() {
        this.start = System.currentTimeMillis();
    }

    public long getStart() {
        return start;
    }

    public long getFinish() {
        return finish;
    }

    public void setFinish() {
        this.finish = System.currentTimeMillis();
    }

    public void setElapsed(long start, long finish) {
        this.elapsed = start - finish;
    }

    public long getElapsed() {
        return elapsed;
    }

    public Comando getCmd() {
        return cmd;
    }

    @Override
    public long turnoGiocatore(Partita partita, long tempoG) {

        setStart();

        boolean turnoBianco = true; // Inizio turno giocatore bianco

        Mossa mossa = new MossaBianco(0, 0);

        boolean chk = false;

        do {
            Messaggi.menuBianco();

            Scanner in = new Scanner(System.in, "UTF-8");
            String comando = in.nextLine();
            String presa = comando;
            comando = getCmd().gestisciRegex(mossa, comando);
            comando = comando.toLowerCase(); // Trasforma l'input in minuscolo


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
                        partita.setCronologiaMosse("Bianco: " + presa);
                        partita.setTurno(false);
                        Messaggi.spostamentoOk();
                    } else {
                        partita.setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }

                    turnoBianco = partita.getTurno();
                    break;

                case "presasemplice":
                    Messaggi.presa();

                    mossa.presaSemplice(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Bianco: " + presa);

                        partita.getBianco().setPedineMangiate(1);
                        Messaggi.presaOk();
                    } else {
                        partita.setTurno(true);
                        Messaggi.nonValida();
                    }
                    turnoBianco = partita.getTurno();
                    break;

                case "presamultipla":
                    Messaggi.presa();
                    mossa.presaMultipla(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Bianco: " + presa);

                        if (mossa.getPresaTripla()) {
                            partita.getBianco().setPedineMangiate(Costanti.DUE);
                        } else {
                            partita.getBianco().setPedineMangiate(Costanti.TRE);
                        }
                        Messaggi.presaOk();

                    } else {
                        partita.setTurno(true);
                        Messaggi.nonValida();
                    }
                    turnoBianco = partita.getTurno();
                    break;

                case "prese":
                    partita.stampaPedineMangiate();
                    break;

                case "mosse":
                    partita.getCronologiaMosse();
                    break;

                case "abbandona":
                    getCmd().abbandona(partita, partita.getBianco());
                    turnoBianco = partita.getTurno();

                    break;

                case "esci":
                    getCmd().esci(partita); // System.exit(0);
                    break;

                case "tempo":
                    setFinish();
                    setElapsed(getFinish(), getStart());

                    long tempoTurno = getElapsed() + tempoG;

                    partita.getBianco().setTempo(tempoTurno);

                    partita.tempo();
                    break;

                default:
                    Messaggi.inserimento();
                    break;
            }
        } while (turnoBianco);

        //questo per far scorrere il tempo anche se non viene richiesto il comando tempo
        setFinish();
        setElapsed(getFinish(), getStart());

        long tempoTurno = getElapsed() + tempoG;

        partita.getBianco().setTempo(tempoTurno);

        return partita.getBianco().getTempo();


        // Se turnoBianco = false, tocca al giocatore Nero
        // Se turnoBianco = true, tocca ancora al giocatore Bianco
        // Se statoPartita = false, partita terminata
        // Se statoPartita = true, partita in corso
    }


}
