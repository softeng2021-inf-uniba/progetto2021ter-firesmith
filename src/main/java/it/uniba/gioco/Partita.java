/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.gioco;

import it.uniba.tavolo.Damiera;

import java.util.ArrayList;
import java.util.ListIterator;

import it.uniba.strumenti.Costante;

/**
 * <h2>Classe che gestisce i dati della partita in corso.</h2>
 * <b>Class Type:</b> &#60; entity &#62; <br><br>
 * <b>Responsabilities:</b><br>
 * <b>Knows:</b>
 * <ul>
 *     <li>Tempo di inizio e fine turno di ogni giocatore;</li>
 * </ul>
 * <b>Does:</b>
 * <ul>
 *     <li>Imposta lo stato della partita;</li>
 *     <li>Visualizza le pedine mangiate di ogni giocatore;</li>
 *     <li>Visualizza la cronologia delle mosse di ogni giocatore;</li>
 *     <li>Visualizza il tempo trascorso per ogni giocatore.</li>
 * </ul>
 *
 * @author Gruppo Firesmith
 */

public class Partita {

    // stato = false, se la partita non è in corso
    // stato = true, se la partita è in corso
    // turno = false, se il turno non è finito
    // turno = true, se il turno è finito
    // abbandona = false, se non è stato usato il comando abbandona
    // abbandona = true, se è stato usato il comando abbandona
    /**
     * Definisce se la partita &#232; in corso.
     */
    private boolean statoPartita = false;
    /**
     * Definisce se il turno &#232; in corso.
     */
    private boolean turnoPartita = false;
    /**
     * Definisce se un giocatore ha abbandonato la partita.
     */
    private boolean abbandonaPartita = false;
    /**
     * Giocatore bianco.
     */
    private Giocatore bianco = new Giocatore();
    /**
     * Giocatore nero.
     */
    private Giocatore nero = new Giocatore();
    /**
     * Damiera utilizzata durante la partita.
     */
    private Damiera damiera = new Damiera();
    /**
     * Lista delle mosse effettuate dai giocatori.
     */
    private ArrayList<String> cronologiaMosse = new ArrayList<String>();


    /**
     * Imposta una nuova partita:
     * <ul>
     *     <li>La partita risulta non in corso;</li>
     *     <li>Il turno della partita non &#232; impostato;</li>
     *     <li>La partita non &#232; stata abbandonata da nessun giocatore.</li>
     * </ul>
     */

    public Partita() {
        statoPartita = false;
        turnoPartita = false;
        abbandonaPartita = false;
    }

    /**
     * Imposta il valore di {@link Partita#statoPartita}.
     *
     * @param stato Stato della partita
     */
    public void setStato(final boolean stato) {
        this.statoPartita = stato;
    }

    /**
     * Imposta il valore di {@link Partita#turnoPartita}.
     *
     * @param turno Stato del turno del giocatore
     */
    public void setTurno(final boolean turno) {
        this.turnoPartita = turno;
    }

    /**
     * Imposta il valore di {@link Partita#bianco}.
     */
    public void setBianco() {
        bianco.setColore("bianco");
    }

    /**
     * Imposta il valore di {@link Partita#nero}.
     */
    public void setNero() {
        nero.setColore("nero");
    }

    /**
     * Imposta il valore di {@link Partita#abbandonaPartita}.
     *
     * @param abbandona Indica se la partita &#232; stata abbandonata
     *                  da un giocatore
     */
    public void setAbbandona(final boolean abbandona) {
        this.abbandonaPartita = abbandona;
    }

    /**
     * Aggiunge alla lista delle mosse l'ultima mossa effettuata.
     *
     * @param mossa Ultima mossa inserita dal giocatore
     */
    public void setCronologiaMosse(final String mossa) {
        cronologiaMosse.add(mossa);
    }

    /**
     * Fornisce le informazioni del primo giocatore.
     *
     * @return Primo giocatore
     */
    public Giocatore getBianco() {
        return bianco;
    }

    /**
     * Fornisce le informazioni del secondo giocatore.
     *
     * @return Secondo giocatore
     */
    public Giocatore getNero() {
        return nero;
    }

    /**
     * Fornisce le informazioni della damiera utilizzata durante la partita.
     *
     * @return Damiera utilizzata dai giocatori
     */
    public Damiera getDamiera() {
        return damiera;
    }

    /**
     * Fornisce lo stato della partita:
     * <ul>
     *     <li><code>true</code> se la partita &#232; in corso;</li>
     *     <li><code>false</code> se la partita non &#232; iniziata
     *     o non &#232; in corso.</li>
     * </ul>
     *
     * @return Stato della partita
     */
    public boolean getStato() {
        return statoPartita;
    }

    /**
     * Fornisce lo stato del turno del giocatore:
     * <ul>
     *     <li><code>true</code>, il turno &#232; in corso;</li>
     *     <li><code>false</code>, il turno &#232; terminato.</li>
     * </ul>
     *
     * @return Stato del turno del giocatore
     */
    public boolean getTurno() {
        return turnoPartita;
    }

    /**
     * Indica se la partita &#232; stata abbandonata da un giocatore:
     * <ul>
     *     <li><code>true</code>, la partita &#232; stata abbandonata
     *     da un giocatore;</li>
     *     <li><code>false</code>, la partita &#232; ancora in corso.</li>
     * </ul>
     *
     * @return Stato della partita
     */
    public boolean getAbbandona() {
        return abbandonaPartita;
    }

    /**
     * Visualizza graficamente il numero delle pedine mangiate
     * da entrambi i giocatori.
     *
     * @return nullstring
     */
    public String stampaPedineMangiate() {

        System.out.println("\n\nPEDINE MANGIATE\n"
                + "───────────────");

        System.out.print("Bianco: ");
        for (int i = 0; i < bianco.getPedineMangiate(); i++) {
            System.out.print("⛀");
        }
        System.out.print("\nNero: ");
        for (int i = 0; i < nero.getPedineMangiate(); i++) {
            System.out.print("⛂");
        }
        System.out.println();

        System.out.println("\n───────────────");
        return null;
    }

    /**
     * Visualizza graficamente le mosse effettuate da entrambi i giocatori.
     *
     * @return nullstring
     */

    public String getCronologiaMosse() {
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

        return null;
    }

    /**
     * Stampa il tempo trascorso dall'inizio della partita per il giocatore
     * passato in input.
     */
    public void tempo() {

        System.out.println("\n\nTEMPO TRASCORSO\n"
                + "────────────────");
        // calcola il tempo trascorso all inizio del turno bianco
        // o all'inizio del turno nero ,
        // nel caso passi il minuto cambia la stampa
        if (bianco.getColore().equals("bianco")) {

            if ((bianco.getTempo() / Costante.INSECOND) < Costante.MINUTO) {
                System.out.println("Bianco: " + (bianco.getTempo() / Costante.INSECOND)
                        + " s");
            } else {
                System.out.println("Bianco: " + ((bianco.getTempo() / Costante.INSECOND) / Costante.MINUTO)
                        + " m " + ((bianco.getTempo() / Costante.INSECOND) % Costante.MINUTO)
                        + " s");
            }

            if ((nero.getTempo() / Costante.INSECOND) < Costante.MINUTO) {
                System.out.println("Nero: " + (nero.getTempo() / Costante.INSECOND)
                        + " s");
            } else {
                System.out.println("Nero: " + (nero.getTempo() / Costante.INSECOND) / Costante.MINUTO
                        + " m " + ((nero.getTempo() / Costante.INSECOND) % Costante.MINUTO)
                        + " s");

            }
            System.out.println();

        }
        System.out.println("────────────────");
    }
}



