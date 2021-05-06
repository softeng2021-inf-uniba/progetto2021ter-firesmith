/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.util.*;
import java.time.*;

/** Class Type: <<entity>>
 *  Responsabilities: Classe che rappresenta la partita in corso fra i due giocatori
 */

public class Partita {

    // stato = false, se la partita non è in corso
    // stato = true, se la partita è in corso
    // turno = false, se il turno non è finito
    // turno = true, se il turno è finito
    // abbandona = false, se non è stato usato il comando abbandona
    // abbandona = true, se è stato usato il comando abbandona
    private boolean stato = false;
    private boolean turno = false;
    private boolean abbandona = false;
    private Giocatore giocatore1 = new Giocatore();
    private Giocatore giocatore2 = new Giocatore();
    private Damiera damiera = new Damiera();
    private ArrayList<String> CronologiaMosse = new ArrayList<String>();

    // Creo la partita
    public Partita() {
        stato = false;
        turno = false;
        abbandona = false;
        Giocatore giocatore1 = new Giocatore();
        Giocatore giocatore2 = new Giocatore();
        Damiera damiera = new Damiera();
    }

    public void setGiocatore1(Giocatore giocatore1) {
        this.giocatore1 = giocatore1;
    }

    public void setGiocatore2(Giocatore giocatore2) {
        this.giocatore2 = giocatore2;
    }

    public void setDamiera(Damiera damiera) {
        this.damiera = damiera;
    }

    public void setStato(boolean stato) {
        this.stato = stato;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public void setAbbandona(boolean abbandona) {
        this.abbandona = abbandona;
    }

    public void setCronologiaMosse(String mossa) {
        CronologiaMosse.add(mossa);
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
        return stato;
    }

    public boolean getTurno() {
        return turno;
    }

    public boolean getAbbandona() {
        return abbandona;
    }

    public void StampaPedineMangiate() {

        System.out.println("\nPEDINE MANGIATE\n" +
                "───────────────"); //TODO \u2501

        if (giocatore1.getColore().equals("bianco")) {
            System.out.print("Bianco: ");
            for (int i = 0; i < giocatore1.getPedineMangiate(); i++) {
                System.out.print("⛂");
            }
            System.out.print("\nNero: ");
            for (int i = 0; i < giocatore2.getPedineMangiate(); i++) {
                System.out.print("⛀");
            }
            System.out.println();
        } else if (giocatore1.getColore().equals("nero")) {
            System.out.print("Nero: ");
            for (int i = 0; i < giocatore1.getPedineMangiate(); i++) {
                System.out.print("⛀");
            }
            System.out.print("\nBianco: ");
            for (int i = 0; i < giocatore2.getPedineMangiate(); i++) {
                System.out.print("⛂");
            }
        }
        System.out.println("\n──────────────────");
    }

    public void getCronologiaMosse() {
        ListIterator<String> CronoMosse = CronologiaMosse.listIterator();
        System.out.println("\nMOSSE EFFETTUATE\n" +
                             "────────────────");
        while (CronoMosse.hasNext()) {
            System.out.println(CronoMosse.next());
        }
        System.out.println("\n────────────────");
    }

    public void Tempo(Giocatore giocatore, Instant start, Instant finish) {

        long elapsed = Duration.between(start, finish).getSeconds();
        giocatore.setTempo(elapsed);

        System.out.println("\nTEMPO TRASCORSO\n" +
                             "───────────────");

        if (giocatore1.getColore().equals("bianco")) {

            if (giocatore1.getTempo() < 60) {
                System.out.println("Bianco: " + giocatore1.getTempo() + " secondi");
            } else {
                System.out.println("Bianco: " + giocatore1.getTempo() / 60 + " minuto/i");
            }

            if (giocatore2.getTempo() < 60) {
                System.out.println("Nero: " + giocatore2.getTempo() + " secondi");
            } else {
                System.out.println("Nero: " + giocatore2.getTempo() / 60 + " minuto/i");
            }
            System.out.println();

        } else if (giocatore1.getColore().equals("nero")) {

            if (giocatore2.getTempo() < 60) {
                System.out.println("Bianco: " + giocatore2.getTempo() + " secondi");
            } else {
                System.out.println("Bianco: " + giocatore2.getTempo() / 60 + " minuto/i");
            }

            if (giocatore1.getTempo() < 60) {
                System.out.println("Nero: " + giocatore1.getTempo() + " secondi");
            } else {
                System.out.println("Nero: " + giocatore1.getTempo() / 60 + " minuto/i");
            }
        }
    }
}



