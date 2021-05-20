/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.util.ArrayList;
import java.time.Duration;
import java.time.Instant;
import java.util.ListIterator;

/**
 * Class Type: <<entity>>
 * Responsabilities: Classe che rappresenta la partita in corso
 * fra i due giocatori.
 */

public class Partita {

    // stato = false, se la partita non è in corso
    // stato = true, se la partita è in corso
    // turno = false, se il turno non è finito
    // turno = true, se il turno è finito
    // abbandona = false, se non è stato usato il comando abbandona
    // abbandona = true, se è stato usato il comando abbandona
    private boolean statoPartita = false;
    private boolean turnoPartita = false;
    private boolean abbandonaPartita = false;
    private Giocatore giocatore1 = new Giocatore();
    private Giocatore giocatore2 = new Giocatore();
    private Damiera damiera = new Damiera();
    private ArrayList<String> cronologiaMosse = new ArrayList<String>();

    public static final int SIXTY = 60;

    // Creo la partita
    public Partita() {
        statoPartita = false;
        turnoPartita = false;
        abbandonaPartita = false;
    }


    public void setStato(final boolean stato) {
        this.statoPartita = stato;
    }

    public void setTurno(final boolean turno) {
        this.turnoPartita = turno;
    }

    public void setAbbandona(final boolean abbandona) {
        this.abbandonaPartita = abbandona;
    }

    public void setCronologiaMosse(final String mossa) {
        cronologiaMosse.add(mossa);
    }

    public Giocatore getGiocatore1() {
        return giocatore1;
    }

    public Giocatore getGiocatore2() {
        return giocatore2;
    }

    public Damiera getDamiera() {
        return damiera;
    }

    public boolean getStato() {
        return statoPartita;
    }

    public boolean getTurno() {
        return turnoPartita;
    }

    public boolean getAbbandona() {
        return abbandonaPartita;
    }

    public void stampaPedineMangiate() {

        System.out.println("\n\nPEDINE MANGIATE\n"
                + "───────────────"); //TODO \u2501

        System.out.print("Bianco: ");
        for (int i = 0; i < giocatore1.getPedineMangiate(); i++) {
            System.out.print("⛂");
        }
        System.out.print("\nNero: ");
        for (int i = 0; i < giocatore2.getPedineMangiate(); i++) {
            System.out.print("⛀");
        }
        System.out.println();

        System.out.println("\n───────────────");
    }

    public void getCronologiaMosse() {
        ListIterator<String> cronoMosse = cronologiaMosse.listIterator();
        if (cronologiaMosse.size() != 0) {
            System.out.println("\n\nMOSSE EFFETTUATE\n"
                    + "────────────────");
            while (cronoMosse.hasNext()) {
                System.out.println(cronoMosse.next());
            }
            System.out.println("\n────────────────");
        } else {
            System.out.println("\n ⚠ Non ci sono ancora mosse\n");
        }

    }

    public void tempo(final Giocatore giocatore, final Instant start,
                      final Instant finish) {

        long elapsed = Duration.between(start, finish).getSeconds();
        giocatore.setTempo(elapsed);

        System.out.println("\n\nTEMPO TRASCORSO\n"
                + "────────────────");
        // calcola il tempo trascorso all inizio del turno bianco
        // o all'inizio del turno nero ,
        // nel caso passi il minuto cambia la stampa
        if (giocatore1.getColore().equals("bianco")) {

            if (giocatore1.getTempo() < SIXTY) {
                System.out.println("Bianco: " + giocatore1.getTempo()
                        + " secondi");
            } else {
                System.out.println("Bianco: " + (giocatore1.getTempo() / SIXTY)
                        + " minuto/i " + ((giocatore1.getTempo()) % SIXTY)
                        + " secondi");
            }

            if (giocatore2.getTempo() < SIXTY) {
                System.out.println("Nero: " + giocatore2.getTempo()
                        + " secondi");
            } else {
                System.out.println("Nero: " + giocatore2.getTempo() / SIXTY
                        + " minuto/i " + ((giocatore2.getTempo()) % SIXTY)
                        + " secondi");

            }
            System.out.println();

        }
        System.out.println("────────────────");
    }
}



