package it.uniba.strumenti;

import it.dama.gioco.Giocatore;
import it.dama.strumenti.messaggi.Info;
import java.util.Scanner;
import it.dama.gioco.Partita;
import it.dama.strumenti.messaggi.Bianco;
import it.dama.strumenti.messaggi.Errore;
import it.dama.strumenti.messaggi.Nero;

/**
 *
 * @author ester
 */
public final class Comando {
    public void esci(Partita partita) {
        boolean valido = false;
        System.out.print("\n\nPer confermare l'uscita dal gioco inserire "
                + "[Si/No]" + "\n➤ ");
        do {
            Scanner esci = new Scanner(System.in, "UTF-8");
            String uscita = esci.nextLine();
            uscita = uscita.toLowerCase();

            if (uscita.equals("si")) {
                Info.uscita();
                Runtime.getRuntime().exit(0);
                partita.setStato(false);
                valido = true;

            } else if (uscita.equals("no")) {
                Info.menu();
                partita.setStato(true);
                valido = true;

            } else {
                Errore.inserimento();
                System.out.print("➤");
            }
        } while (!valido);
    }

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
                    Bianco.abbandona();
                    statoPartita = false; // Abbandona partita bianco
                    statoTurno = false;
                    p.setStato(statoPartita);
                    p.setTurno(statoTurno);
                    p.setAbbandona(true);
                } else {
                    Nero.abbandona();
                    statoPartita = false;    // Abbandona partita nero
                    statoTurno = false;
                    p.setStato(statoPartita);
                    p.setTurno(statoTurno);
                    p.setAbbandona(true);
                }

            } else if (conferma.equals("no")) {
                statoPartita = true;            // Continua partita in corso
                statoTurno = true;
                p.setStato(statoPartita);
                p.setTurno(statoTurno);
                valido = true;

            } else {
                Errore.inserimento();
                System.out.print("➤");
            }
        } while (!valido);
    }
}