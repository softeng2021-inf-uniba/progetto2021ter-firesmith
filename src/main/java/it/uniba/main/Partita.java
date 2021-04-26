/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.util.*;

import static it.uniba.main.AppMain.*;

/**
 *
 * @author anton
 */

/*CLASSE PARTITA: classe che racchiude i metodi e gli attributi necessari per gestire una partita*/
public class Partita {

    boolean partitaInCorso = false;

    private String giocatore1 = "", giocatore2 = "";
    private boolean IsBlack = false, IsWhite = false;

    private long startTime = System.currentTimeMillis(); // Variabile in cui è memorizzato l'istante di tempo
    // in cui inizia la partita

    Damiera d1 = new Damiera();

    public void Gioca() {
        if (partitaInCorso == true) {
            System.out.println(" ⚠ Attenzione, una partita è in corso!");
            return;
        } else {
            partitaInCorso = true;

            System.out.print("\n ⚔ Iniziando una nuova partita... ⚔ \n" +
                    "\nScegli il giocatore: " +
                    "\n ♦ Bianco" +
                    "\n ♢ Nero" +
                    "\n➤ ");

            ImpostaGiocatore();
            System.out.print("\nIl giocatore 1 ha scelto il colore: " + giocatore1 + " ");
            if (IsWhite) {
                System.out.println("⛂");  // Pedina bianca
            } else {
                System.out.println("⛀");  // Pedina nera
            }
            System.out.print("Il giocatore 2 ha scelto il colore: " + giocatore2 + " ");
            if (IsWhite) {
                System.out.println("⛀");  // Pedina nera
            } else {
                System.out.println("⛂");  // Pedina bianca
            }
            System.out.println();
        }
        Menu.Partita();
    }

    // Metodo che imposta il colore per entrambi i giocatori, sulla base della scelta del giocatore 1
    public void ImpostaGiocatore() {
        do {
            Scanner input = new Scanner(System.in);
            String Giocatore = input.nextLine();
            Giocatore = Giocatore.toLowerCase();

            if (Giocatore.equals("bianco")) {
                IsWhite = true;
                giocatore1 = Giocatore;
                giocatore2 = "nero";
            } else if (Giocatore.equals("nero")) {
                IsBlack = true;
                giocatore1 = Giocatore;
                giocatore2 = "bianco";
            } else {
                System.out.print("\n ⚠ Inserito comando sbagliato! Riprova." +
                        "\n➤ ");

            }
        } while (IsWhite == false & IsBlack == false); // Controllo sui flag, che permette di inserire correttamente
        // il colore per il giocatore 1


    }

    // Metodo che mostra il tempo trascorso per il giocatore 1 (il primo che interagisce con il programma)
    public void MostraTempo(long startTime) {
        long endTime = System.currentTimeMillis();

        long resultTime = (endTime - startTime) / 1000;
        if (resultTime < 60) {
            System.out.println("\n \uD83D\uDD51 Il tempo trascorso dall'inizio della partita è: " + resultTime + " secondi (" + giocatore1 + ")\n");
        } else {
            System.out.println("\n \uD83D\uDD51 Il tempo trascorso dall'inizio della partita è: " + resultTime / 60 + " minuto/i (" + giocatore1 + ")" + "\n");
        }
    }
}

