/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

import java.util.*;

/**
 *
 * @author anton
 */
public class Partita {

    private boolean partitaInCorso=false ;

    private String giocatore1 = "",giocatore2 = "" ;
    private boolean IsBlack = false, IsWhite = false;

    public void Gioca(){
        if(partitaInCorso==true){
            System.out.println("Finisci la partita in corso");
            return;
        }
        else{
            partitaInCorso=true;
            System.out.println("Iniziando una nuova partita..." +
                                "\nScegli il giocatore: " +
                                "\n- Bianco" +
                                "\n- Nero");

            ImpostaGiocatore();
            System.out.println("Il giocatore 1 ha scelto il colore :" + giocatore1);
                System.out.println("Il giocatore 2 ha scelto il colore " + giocatore2);
        }
    }

    public void ImpostaGiocatore() {
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
            System.out.println("Inserito comando sbagliato");
            return;
        }


    }

    public void MostraTempo(){

             }

    public void Abbandona(){

    }

    public void Esci(){

    }

}
