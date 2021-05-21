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
 * <h2>Classe che gestisce i dati della partita in corso.</h2>
 * <b>Class Type:</b> &#60; entity &#62; <br><br>
 * <b>Responsabilities:</b><br>
 *      <b>Knows:</b>
 *      <ul>
 *          <li>Tempo di inizio e fine turno di ogni giocatore;</li>
 *      </ul>
 *      <b>Does:</b>
 *      <ul>
 *          <li>Imposta lo stato della partita;</li>
 *          <li>Visualizza le pedine mangiate di ogni giocatore;</li>
 *          <li>Visualizza la cronologia delle mosse di ogni giocatore;</li>
 *          <li>Visualizza il tempo trascorso per ogni giocatore.</li>
 *      </ul>
 * @author Gruppo Firesmith
 */

public class Partita {

    // stato = false, se la partita non è in corso
    // stato = true, se la partita è in corso
    // turno = false, se il turno non è finito
    // turno = true, se il turno è finito
    // abbandona = false, se non è stato usato il comando abbandona
    // abbandona = true, se è stato usato il comando abbandona
    /** Definisce se la partita &#232; in corso. */
    private boolean statoPartita = false;
    /** Definisce se il turno &#232; in corso. */
    private boolean turnoPartita = false;
    /** Definisce se un giocatore ha abbandonato la partita. */
    private boolean abbandonaPartita = false;
    /** Giocatore bianco. */
    private Giocatore giocatore1 = new Giocatore();
    /** Giocatore nero. */
    private Giocatore giocatore2 = new Giocatore();
    /** Damiera utilizzata durante la partita. */
    private Damiera damiera = new Damiera();
    /** Lista delle mosse effettuate dai giocatori. */
    private ArrayList<String> cronologiaMosse = new ArrayList<String>();

    /** Costante utilizzata per il controllo della posizione delle pedine. */
    public static final int SIXTY = 60;

    // Creo la partita

    /**
     * Imposta una nuova partita:
     * <ul>
     *     <li>La partita risulta non in corso;</li>
     *     <li>Il turno della partita non &#232; impostato;</li>
     *     <li>La partita non &#232; stata abbandonata da nessun giocatore.</li>
     * </ul>
     */
    //TODO questo metodo deve essere private e non public
    public Partita() {
        statoPartita = false;
        turnoPartita = false;
        abbandonaPartita = false;
    }

    /**
     * Imposta il valore di {@link Partita#statoPartita}.
     * @param stato Stato della partita
     */
    public void setStato(final boolean stato) {
        this.statoPartita = stato;
    }

    /**
     * Imposta il valore di {@link Partita#turnoPartita}.
     * @param turno Stato del turno del giocatore
     */
    public void setTurno(final boolean turno) {
        this.turnoPartita = turno;
    }

    /**
     * Imposta il valore di {@link Partita#abbandonaPartita}.
     * @param abbandona Indica se la partita &#232; stata abbandonata da un giocatore
     */
    public void setAbbandona(final boolean abbandona) {
        this.abbandonaPartita = abbandona;
    }

    /**
     * Aggiunge alla lista delle mosse l'ultima mossa effettuata.
     * @param mossa Ultima mossa inserita dal giocatore
     */
    public void setCronologiaMosse(final String mossa) {
        cronologiaMosse.add(mossa);
    }

    /**
     * Fornisce le informazioni del primo giocatore.
     * @return Primo giocatore
     */
    public Giocatore getGiocatore1() {
        return giocatore1;
    }

    /**
     * Fornisce le informazioni del secondo giocatore.
     * @return Secondo giocatore
     */
    public Giocatore getGiocatore2() {
        return giocatore2;
    }

    /**
     * Fornisce le informazioni della damiera utilizzata durante la partita.
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
     * @return Stato della partita
     */
    public boolean getAbbandona() {
        return abbandonaPartita;
    }

    /**
     * Visualizza graficamente il numero delle pedine mangiate
     * da entrambi i giocatori.
     */
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

    /**
     * Visualizza graficamente le mosse effettuate da entrambi i giocatori.
     */

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

    /**
     * Stampa il tempo trascorso dall'inizio della partita per il giocatore
     * passato in input.
     *
     * @param giocatore Giocatore di cui viene calcolato il tempo
     * @param start Istante di tempo da cui inizia il conteggio
     * @param finish Istante di tempo in cui finisce il conteggio
     */

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



