package it.uniba.interfaccia;

import it.uniba.gioco.Partita;
import it.uniba.strumenti.Comando;
import it.uniba.strumenti.Messaggi;

import java.util.Scanner;

/**
 * <h2>Classe SINGLETON che gestisce l'input dell'utente durante l'esecuzione
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
     * Questa è l'unica istanza di menù creata.
     */
    private static Menu istanza = new Menu();

    /**
     * Crea una nuova partita.
     */
    private Partita partita = new Partita();
    private Comando cmd = new Comando();

    /**
     * Costruttore vuoto
     */
    public Menu() {
    }

    public Partita getPartita() {
        return partita;
    }

    public void setPartita(Partita partita) {
        this.partita = partita;
    }

    public Comando getCmd() {
        return cmd;
    }

    /**
     * Metodo che ritorna l'unica istanza di Menù,
     * chiamato in AppMain.
     * @return l'oggetto solo se NON esiste:
     */
    public static Menu getInstance() {
        if (istanza == null) {
            istanza = new Menu();
        }
        return istanza;
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

            comando = cmd.trasformaComando(comando);

            switch (comando) {

                case "--help":

                case "-h":

                case "help":
                    Messaggi.aiuto();
                    break;

                case "gioca":
                    setPartita(new Partita());
                    gioca();
                    break;

                case "numeri":
                    getPartita().getDamiera().stampaDamieraPedine();
                    break;

                case "damiera":
                    Messaggi.damiera();
                    break;

                case "tempo":
                    Messaggi.partita();
                    break;

                case "esci":
                    getCmd().esci(getPartita());
                    getPartita().setStato(false);
                    inizio = getPartita().getStato();
                    break;

                default:
                    Messaggi.inserimento();
                    break;
            }
        } while (!inizio);
    }


    /**
     * Gestisce tutte le operazioni permesse durante il turno di ogni giocatore.
     * @return nullstring
     */
    public String gioca() {
        Turno bianco = new TurnoBianco();
        Turno nero = new TurnoNero();

        long tempoB = 0;
        long tempoN = 0;

        if (getPartita().getStato()) {
            Messaggi.partita();
        } else {
            getPartita().setStato(true);
            getPartita().setBianco();
            getPartita().setNero();

            int numeroTurno = 1;

            do {
                System.out.print("\n┌───────────────────┒"
                        + "\n│     Turno " + numeroTurno + "       │"
                        + "\n└───────────────────┘\n");

                tempoB += bianco.turnoGiocatore(getPartita(), tempoB);

                System.out.println("Fine turno giocatore "
                        + getPartita().getBianco().getColore());

                if (getPartita().getAbbandona()) {
                    System.out.println("Partita terminata!");
                } else {
                    getPartita().setTurno(false);

                    tempoN += nero.turnoGiocatore(partita, tempoN);

                    System.out.println("Fine turno giocatore "
                            + getPartita().getNero().getColore());

                }
                numeroTurno++;
            } while (getPartita().getStato());
        }
        return null;
    }
}

