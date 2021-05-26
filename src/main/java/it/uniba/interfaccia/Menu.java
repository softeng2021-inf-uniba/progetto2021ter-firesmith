package it.uniba.interfaccia;

import it.uniba.gioco.Giocatore;
import it.uniba.gioco.Partita;
import it.uniba.strumenti.Comando;
import it.uniba.strumenti.Messaggi;

import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

/**
 * <h2>Classe che gestisce l'input dell'utente durante l'esecuzione
 * del programma e le interazioni tra le varie classi.</h2>
 * <b>Class Type:</b> &#60; Control &#62; <br>
 * <b>Responsabilities:</b> <br>
 *      <b>Knows:</b>
 *      <ul>
 *          <li> Giocatore che sta giocando durante il suo turno. </li>
 *      </ul>
 *      <b>Does:</b> <br>
 *              <ul>
 *                  <li> Richiedere informazioni sul funzionamento
 *                  del programma; </li>
 *                  <li> Iniziare una nuova partita a dama; </li>
 *                  <li> Visualizzare la damiera numerata; </li>
 *                  <li> Uscire dal programma; </li>
 *                  <li> Mostrare messaggi di avviso/errore. </li>
 *              </ul>
 *
 */

public class Menu {
    /**
     * Crea una nuova partita.
     */
    private Partita partita = new Partita();
    private Comando cmd = new Comando();

    public Menu() {
    }

    /**
     * Mostra il menu iniziale del programma e accetta
     * dall'utente i comandi per:
     * <ul>
     *     <li>Visualizzare le istruzioni del programma;</li>
     *     <li>Iniziare una nuova partita;</li>
     *     <li>Visualizzare la damiera numerata;</li>
     *     <li>Uscire dal programma.</li>
     * </ul>
     */
    public void benvenuto() {
        // Serve per controllare se la partita è in corso
        boolean inizio = false;

        do {
            Messaggi.benvenuto();

            Scanner input = new Scanner(System.in, "UTF-8");
            String comando = input.nextLine();

            comando = comando.toLowerCase();

            switch (comando) {
                case "--help":
                    Messaggi.aiuto();
                    break;
                case "-h":
                    Messaggi.aiuto();
                    break;
                case "help":
                    Messaggi.aiuto();
                    break;
                case "gioca":
                    partita = new Partita();
                    gioca();
                    break;
                case "numeri":
                    partita.getDamiera().stampaDamieraPedine();
                    break;
                case "damiera":
                    Messaggi.damiera();
                    break;
                case "tempo":
                    Messaggi.partita();
                    break;
                case "esci":
                    cmd.esci(partita);
                    partita.setStato(false);
                    inizio = partita.getStato();
                    break;
                default:
                    Messaggi.inserimento();
                    break;
            }
        } while (!inizio);
    }

    /**
     * Gestisce i comandi inseriti dal giocatore che controlla
     * le pedine bianche.<br>
     * Permette al giocatore di:
     * <ul>
     *     <li>Invocare tutti i comandi di {@link Menu#generico()};</li>
     *     <li>Visualizzare la damiera con le pedine disposte;</li>
     *     <li>Effettuare 3 tipi di mosse: spostamento,
     *     presa semplice e presa multipla;</li>
     *     <li>Visualizzare il tempo trascorso dall'inizio della
     *     partita di entrambi i giocatori.</li>
     * </ul>
     * @param bianco Giocatore che possiede le pedine bianche
     */


    // Da mostrare al giocatore che ha scelto la pedina nera
    // Damiera damiera = damiera in uso dalla partita (da Partita)
    // boolean Partita = flag (da Partita) che:
    // Se Partita = true, la partita è in corso
    // Se Partita = false, la partita non è in corso/è stata terminata

    /**
     * Gestisce i comandi inseriti dal giocatore che controlla
     * le pedine nere.<br>
     * Permette al giocatore di:
     * <ul>
     *      <li>Invocare tutti i comandi di {@link Menu#generico()};</li>
     *      <li>Visualizzare la damiera con le pedine disposte;</li>
     *      <li>Effettuare 3 tipi di mosse: spostamento,
     *      presa semplice e presa multipla;</li>
     *      <li>Visualizzare il tempo trascorso dall'inizio
     *      della partita di entrambi i giocatori.</li>
     * </ul>
     * @param nero Giocatore che possiede le pedine nere
     */


    // Metodo con il quale il giocatore può abbandonare
    // la partita corrente ritornando al menù

    /**
     * Quando viene invocato dal menu, permette al giocatore
     * di arrendersi e concludere la partita.
     * @param giocatore Giocatore che ha richiesto di abbandonare la partita
     */


    // Metodo con il quale si può terminare immediatamente il programma

    /**
     * Quando viene invocato dal menu, permette al giocatore
     * di uscire dal programma.
     */


    /**
     * Gestisce tutte le operazioni permesse durante il turno di ogni giocatore.
     */
    public void gioca() {
        Turno bianco = new TurnoBianco();
        Turno nero = new TurnoNero();

        if (partita.getStato()) {
            Messaggi.partita();
        } else {
            partita.setStato(true);
            partita.setBianco();
            partita.setNero();

            int numeroTurno = 1;

            do {
                System.out.printf("\n┌───────────────────┒"
                        + "\n│     Turno " + numeroTurno + "       │"
                        + "\n└───────────────────┘\n");

                bianco.turnoGiocatore(partita);


                System.out.println("Fine turno giocatore "
                        + partita.getBianco().getColore());

                if (partita.getAbbandona()) {
                    System.out.println("Partita terminata!");
                } else {
                    partita.setTurno(false);

                    nero.turnoGiocatore(partita);


                    System.out.println("Fine turno giocatore "
                            + partita.getNero().getColore());

                }
                numeroTurno++;
            } while (partita.getStato());
        }
    }
}

