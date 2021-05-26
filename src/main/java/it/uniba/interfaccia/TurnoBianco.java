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

public class TurnoBianco implements Turno {
    Comando cmd = new Comando();

    @Override
    public void turnoGiocatore(Partita partita) {

        boolean turnoBianco = true; // Inizio turno giocatore bianco

        Mossa mossa = new MossaBianco(0, 0);

        boolean chk = false;

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
                        partita.setCronologiaMosse("Bianco :" + presa);
                        partita.setTurno(false);
                        Messaggi.spostamentoOk();
                    } else {
                        partita.setTurno(true);
                        System.out.println(" ⚠ Mossa non valida");
                    }

                    turnoBianco = partita.getTurno();
                    break;

                case "presa semplice":
                    System.out.println("Sto effettuando la presa...");

                    mossa.presaSemplice(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Bianco :" + presa);

                        partita.getBianco().setPedineMangiate(1);
                        Messaggi.presaOk();
                    } else {
                        partita.setTurno(true);
                        Messaggi.nonValida();
                    }
                    turnoBianco = partita.getTurno();
                    break;

                case "presa multipla":
                    System.out.println("Sto effettuando la presa...");
                    mossa.presaMultipla(partita.getDamiera());
                    chk = mossa.getValid();
                    if (chk) {
                        partita.setTurno(false);
                        partita.setCronologiaMosse("Bianco :" + presa);

                        if (!mossa.getPresaTripla()) {
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
                    cmd.abbandona(partita, partita.getBianco());
                    turnoBianco = partita.getTurno();

                    break;

                case "esci":
                    cmd.esci(partita); // System.exit(0);
                    break;

                case "tempo":
                    ;
                    break;

                default:
                    Messaggi.inserimento();
                    break;
            }
        } while (turnoBianco);


        // Se turnoBianco = false, tocca al giocatore Nero
        // Se turnoBianco = true, tocca ancora al giocatore Bianco
        // Se statoPartita = false, partita terminata
        // Se statoPartita = true, partita in corso
    }


}
