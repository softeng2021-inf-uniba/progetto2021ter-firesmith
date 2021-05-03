/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.util.*;

import static it.uniba.main.AppMain.*;


/** <<entity>> */

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

    // Creo la partita
    public Partita() {
        stato = false;
        turno = false;
        abbandona = false;
        Giocatore giocatore1 = new Giocatore();
        Giocatore giocatore2 = new Giocatore();
        Damiera damiera = new Damiera();
    }

    public void setGiocatore1(Giocatore giocatore1) { this.giocatore1 = giocatore1; }
    public void setGiocatore2(Giocatore giocatore2) { this.giocatore2 = giocatore2; }
    public void setDamiera(Damiera damiera) { this.damiera = damiera; }
    public void setStato(boolean stato) { this.stato = stato; }
    public void setTurno(boolean turno) { this.turno = turno; }
    public void setAbbandona(boolean abbandona) { this.abbandona = abbandona; }
    public Giocatore getGiocatore1() { return giocatore1; }
    public Giocatore getGiocatore2() { return giocatore2; }
    public Damiera getDamiera() { return damiera; }
    public boolean getStato() { return stato; }
    public boolean getTurno() { return turno; }
    public boolean getAbbandona() { return abbandona; }

}