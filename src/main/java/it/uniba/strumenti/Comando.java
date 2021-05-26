package it.uniba.strumenti;

import it.uniba.gioco.Giocatore;
import java.util.Scanner;
import it.uniba.gioco.Partita;

public final class Comando {

    /**
     * Quando viene invocato dal menu, permette al giocatore
     * di arrendersi e concludere la partita.
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
                Runtime.getRuntime().exit(0);
                partita.setStato(false);
                valido = true;

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
                System.out.print("➤");
            }
        } while (!valido);
    }
}