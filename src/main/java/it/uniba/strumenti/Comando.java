package it.uniba.strumenti;

import it.uniba.gioco.Giocatore;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.uniba.gioco.Mossa;
import it.uniba.gioco.Partita;

public final class Comando {

    /**
     * Quando viene invocato dal menu, permette al giocatore
     * di arrendersi e concludere la partita.
     *
     * @param partita la partita in corso
     */
    public void esci(Partita partita) {
        boolean valido = false;
        System.out.print("\n\nPer confermare l'uscita dal gioco inserire "
                + "[Si/No]" + "\n➤ ");
        do {
            Scanner esci = new Scanner(System.in, "UTF-8");
            String uscita = esci.nextLine();
            uscita = uscita.toLowerCase();

            if (uscita.equals("si")) {
                Messaggi.uscita();
                partita.setStato(false);
                valido = true;
                Runtime.getRuntime().exit(0);

            } else if (uscita.equals("no")) {
                Messaggi.menu();
                partita.setStato(true);
                valido = true;

            } else {
                Messaggi.inserimento();
                System.out.print("➤");
            }
        } while (!valido);
    }

    /**
     * Quando viene invocato dal menu, permette al giocatore
     * di arrendersi e concludere la partita.
     *
     * @param p Partita in corso
     * @param g Giocatore che ha richiesto di abbandonare la partita
     */
    public void abbandona(Partita p, Giocatore g) {
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
                String colore = g.getColore();
                valido = true;

                if (colore.equals("bianco")) {
                    Messaggi.biancoAbbandona();
                    statoPartita = false; // Abbandona partita bianco
                    statoTurno = false;
                    p.setStato(statoPartita);
                    p.setTurno(statoTurno);
                    p.setAbbandona(true);
                } else {
                    Messaggi.neroAbbandona();
                    statoPartita = false;    // Abbandona partita nero
                    statoTurno = false;
                    p.setStato(statoPartita);
                    p.setTurno(statoTurno);
                    p.setAbbandona(true);
                }

            } else if (conferma.equals("no")) {
                // Continua partita in corso
                p.setStato(statoPartita);
                p.setTurno(statoTurno);
                valido = true;

            } else {
                Messaggi.inserimento();
                System.out.print("➤ ");
            }
        } while (!valido);
    }

    /**
     * Metodo che gestisce l'input e verifica la validità attraverso le regex
     * @param mossa su cui vengono impostate le coordinate ottenute
     * @param comando la stringa gestita dal metodo
     * @return il comando, come mossa o comando per il menù
     */
    public String gestisciRegex(Mossa mossa, String comando) {

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

        String[] array = comando.split("[-|x]");

        if(!comando.equals("-h") && !comando.equals("--help")) {
            try {
                if ((array.length > 1)) {

                    String posInizialeTemp = array[Costanti.ZERO];
                    String posFinaleTemp = array[Costanti.UNO];

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
        }

        return trasformaComando(comando);
    }

    public String trasformaComando(String comando) {
        comando = comando.toLowerCase();
        comando = comando.replaceAll("\\s+","");
        return comando;
    }
}