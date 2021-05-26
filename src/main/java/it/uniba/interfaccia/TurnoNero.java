package it.uniba.interfaccia;

import it.uniba.gioco.Giocatore;
import it.uniba.gioco.Mossa;
import it.uniba.gioco.MossaNero;
import it.uniba.gioco.Partita;
import it.uniba.strumenti.Comando;
import it.uniba.tavolo.Damiera;
import it.uniba.strumenti.Costanti;
import it.uniba.strumenti.Messaggi;
import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TurnoNero implements Turno {
    Comando cmd = new Comando();

    @Override
    public void turnoGiocatore(Partita partita){

        boolean turnoNero = true; // Inizio turno giocatore bianco

        Mossa mossa = new MossaNero(0, 0);

        boolean chk = false;

        boolean statoPartita = partita.getStato();

        do {
            Nero.menu();

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

                    if (array.length > Costanti.POS_DUE) {
                        String posFinale2Temp = array[Costanti.POS_DUE];
                        posFinale2 = Integer.parseInt(posFinale2Temp);
                        mossa.setPosizione3(posFinale2);

                        if (array.length > Costanti.POS_TRE && !array[Costanti.POS_TRE].equals("")) {
                            String posFinale3Temp = array[Costanti.POS_TRE];
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
                    Info.aiuto();
                    break;

                case "-h":
                    Info.aiuto();
                    break;

                case "help":
                    Info.aiuto();
                    break;

                case "numeri":
                    partita.getDamiera().stampaPosizioniPedine();
                    break;

                case "damiera":
                    partita.getDamiera().stampaDamieraPedine();
                    break;

                case "gioca":
                    Errore.partita();
                    break;

                case "spostamento":
                    Gioco.spostamento();

                    mossa.spostamentoSemplice(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setCronologiaMosse("Nero :" + presa);
                        partita.setTurno(false);
                        Gioco.spostamentoOk();
                    } else {
                        partita.setTurno(true);
                        Gioco.nonValida();
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
                        Gioco.presaOk();
                    } else {
                        partita.setTurno(true);
                        Gioco.nonValida();
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

                        if (!mossa.getPresaTripla()) {
                            partita.getNero().setPedineMangiate(Costanti.POS_DUE);
                        } else {
                            partita.getNero().setPedineMangiate(Costanti.POS_TRE);
                        }
                        Gioco.presaOk();

                    } else {
                        partita.setTurno(true);
                        Gioco.nonValida();
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
                    cmd.abbandona(partita, partita.getNero());
                    turnoNero = partita.getTurno();
                    statoPartita = partita.getStato();

                    break;

                case "esci":
                    cmd.esci(partita); // System.exit(0);
                    break;

                case "tempo":
                    Instant finish = Instant.now();
                    long elapsed = Duration.between(start, finish).getSeconds();
                    partita.getNero().setTempo(elapsed);
                    partita.tempo(partita.getNero(), start, finish);
                    break;

                default:
                    Errore.inserimento();
                    break;
            }
        } while (turnoNero);


        // Se turnoBianco = false, tocca al giocatore Nero
        // Se turnoBianco = true, tocca ancora al giocatore Bianco
        // Se statoPartita = false, partita terminata
        // Se statoPartita = true, partita in corso
    }
}
