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
 * Gestisce i comandi inseriti dal giocatore che controlla
 * le pedine nere.<br>
 * Permette al giocatore di:
 * <ul>
 *      <li>Invocare tutti i comandi di {@link Menu#gioca()} };</li>
 *      <li>Visualizzare la damiera con le pedine disposte;</li>
 *      <li>Effettuare 3 tipi di mosse: spostamento,
 *      presa semplice e presa multipla;</li>
 *      <li>Visualizzare il tempo trascorso dall'inizio
 *      della partita di entrambi i giocatori.</li>
 * </ul>
 */

public class TurnoNero implements Turno {

    private Comando cmd = new Comando();

    public Comando getCmd() {
        return cmd;
    }

    @Override
    public void turnoGiocatore(Partita partita){

        boolean turnoNero = true; // Inizio turno giocatore bianco

        Mossa mossa = new MossaNero(0, 0);

        boolean chk = false;

        boolean statoPartita = partita.getStato();

        do {
            Messaggi.menuNero();

            //TODO FUNZIONE PER REGEX
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
                if ((array.length > 1)) {

                    String posInizialeTemp = array[0];
                    String posFinaleTemp = array[1];


                    posIniziale = Integer.parseInt(posInizialeTemp);
                    posFinale = Integer.parseInt(posFinaleTemp);


                    mossa.setPosizione1(posIniziale);
                    mossa.setPosizione2(posFinale);

                    if (array.length > Costanti.DUE) {
                        String posFinale2Temp = array[Costanti.DUE];
                        posFinale2 = Integer.parseInt(posFinale2Temp);
                        mossa.setPosizione3(posFinale2);

                        if (array.length > Costanti.TRE && !array[Costanti.TRE].equals("")) {
                            String posFinale3Temp = array[Costanti.TRE];
                            posFinale3 = Integer.parseInt(posFinale3Temp);
                            mossa.setPosizione4(posFinale3);

                            mossa.setPresaTripla(true);

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
                    partita.getDamiera().stampaPosizioniPedine();
                    break;

                case "damiera":
                    partita.getDamiera().stampaDamieraPedine();
                    break;

                case "gioca":
                    Messaggi.partita();
                    break;

                case "spostamento":
                    Messaggi.spostamento();

                    mossa.spostamentoSemplice(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setCronologiaMosse("Nero :" + presa);
                        partita.setTurno(false);
                        Messaggi.spostamentoOk();
                    } else {
                        partita.setTurno(true);
                        Messaggi.nonValida();
                    }

                    turnoNero = partita.getTurno();
                    break;

                case "presa semplice":
                    System.out.println("Sto effettuando la presa...");

                    mossa.presaSemplice(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Nero :" + presa);

                        partita.getNero().setPedineMangiate(1);
                        Messaggi.presaOk();
                    } else {
                        partita.setTurno(true);
                        Messaggi.nonValida();
                    }
                    turnoNero = partita.getTurno();
                    break;

                case "presa multipla":
                    System.out.println("Sto effettuando la presa...");
                    mossa.presaMultipla(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Nero :" + presa);

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
                    statoPartita = partita.getStato();

                    break;

                case "esci":
                    getCmd().esci(partita); // System.exit(0);
                    break;

                case "tempo":
                    break;

                default:
                    Messaggi.inserimento();
                    break;
            }
        } while (turnoNero);


        // Se turnoBianco = false, tocca al giocatore Nero
        // Se turnoBianco = true, tocca ancora al giocatore Bianco
        // Se statoPartita = false, partita terminata
        // Se statoPartita = true, partita in corso
    }
}
