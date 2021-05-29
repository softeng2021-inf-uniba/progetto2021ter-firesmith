package it.uniba.interfaccia;

import it.uniba.gioco.Partita;

/**
 * <h1>Interfaccia che presenta un solo metodo TurnoGiocatore</h1><br>
 * Questa interfaccia e' implementata dalle classi TurnoBianco e TurnoNero
 * poiche' ognuna di esse offre una diversa implementazione per lo stesso
 * metodo.
 *
 * @author Gruppo Firesmith
 */
public interface Turno {

        /**
         * Metodo implementato dalle classi TurnoBianco e TurnoNero
         * @param p la partita in corso
         * @param tempoG il tempo cumulativo del giocatore aggiornato ad ogni turno
         * @return il tempo trascorso dal giocatore nel singolo turno
         */
        public long turnoGiocatore(Partita p, long tempoG);

}
