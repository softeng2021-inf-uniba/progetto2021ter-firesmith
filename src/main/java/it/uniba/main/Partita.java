/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.uniba.main;

/**
 *
 * @author anton
 */
public class Partita {

    private boolean partitaInCorso=false ;

    public void Gioca(){
        if(partitaInCorso==true){
            System.out.println("Finisci la partita in corso");
            return;
        }
        else{
            partitaInCorso=true;
            System.out.println("Iniziando una nuova partita...");

        }
    }

    public void MostraTempo(){

    }

    public void Abbandona(){

    }

    public void Esci(){

    }

}
