/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.util.*;

import static it.uniba.main.AppMain.Help;

/**
 *
 * @author anton
 */
public class Partita {

    private boolean partitaInCorso=false ;

    private String giocatore1 = "",giocatore2 = "" ;
    private boolean IsBlack = false, IsWhite = false;
    Damiera d1 = new Damiera();

    public void Gioca(){
        if(partitaInCorso==true){
            System.out.println("Finisci la partita in corso");
            return;
        }
        else{
            partitaInCorso=true;

            System.out.println("Iniziando una nuova partita..." +
                                "\nScegli il giocatore: " +
                                "\n- Bianco"+
                                "\n- Nero");

            ImpostaGiocatore();
            System.out.println("Il giocatore 1 ha scelto il colore: " + giocatore1);
            System.out.println("Il giocatore 2 ha scelto il colore: " + giocatore2);
        }
        ComandiPartita();
    }

    public void ComandiPartita() {
        boolean PartitaInCorso = true;

        do {
            System.out.print("** MENU COMANDI PARTITA **"
                    +"\n Scrivere un comando:"
                    +"\n - --help | -h"
                    + "\n - numeri"
                    + "\n - damiera"
                    + "\n - abbandona"
                    + "\n - esci" +
                    "\n> ");
            Scanner in = new Scanner(System.in);
            String comando = in.nextLine();

            switch(comando){
                case "--help":
                    Help();
                    break;

                case "-h":
                    Help();
                    break;

                case "numeri":
                    d1.StampaNumeri();
                    break;

                case "damiera":
                    d1.StampaPezzi();
                    break;

                case "gioca":
                    System.out.println("La partita è già in corso!");
                    break;
                case "abbandona":
                    Abbandona();
                    PartitaInCorso = false;
                    break;
                case "esci":
                    System.out.println("Per confermare l'uscita dal gioco inserire [Si/No]: ");
                    Scanner usc = new Scanner(System.in);
                    String uscita = usc.nextLine();
                    if (uscita.equals("Si"))
                    {
                        PartitaInCorso = false;
                        System.out.println(">Uscita dal gioco...");
                        System.exit(0);
                    }
                    else if (uscita.equals("No"))
                    {
                        System.out.println(">Ritorno al menù... \n");
                    }
                    else
                    {
                        System.out.println(">Comando non valido \n");
                    }
                    break;
                default:
                    System.out.println(">Inserire un comando valido \n");
                    break;
            }
        } while (PartitaInCorso == true);
    }

    public void ImpostaGiocatore() {
        // TODO switch(comando)
        Scanner input = new Scanner(System.in);
        String Giocatore = input.nextLine();
        //...controlli per ortografia...
        if(Giocatore.equals("Bianco")) {
            IsWhite = true;
            giocatore1 = Giocatore;
            giocatore2="Nero";
        }
        else if (Giocatore.equals("Nero")) {
            IsBlack = true;
            giocatore1 = Giocatore;
            giocatore2= "Bianco";
        }
        else {
            System.out.println("\n Inserito comando sbagliato \n");
            return;
        }


    }

    public void MostraTempo(){

             }

    public void Abbandona(){
            System.out.print("Vuoi abbandonare la partita?" +
                    "\n> [SI/NO] ");
            Scanner input1 = new Scanner(System.in);
            String conferma=input1.nextLine();
            if(conferma.equals("SI")){
                if(IsWhite==true){
                    System.out.println("Il bianco abbandona la partita," +
                            "il nero vince");
                } else{
                    System.out.println("Il nero abbandona la partita," +
                            "il bianco vince");
                }
            } else if(conferma.equals("NO")){
                return;
            } else{
              System.out.println("Comando non valido") ;
            }
    }

    public void Esci(){

    }

}
