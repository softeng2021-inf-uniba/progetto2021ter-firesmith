package it.uniba.main;

import it.uniba.gioco.Partita;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PartitaTest {
    Partita test = new Partita();
    @Test
    void statoPartitaTest() {
        test.setStato(true);
        assertTrue(test.getStato());
    }
    @Test
    void turnoPartitaTest() {
        test.setTurno(true);
        assertTrue(test.getTurno());
    }
    @Test
    void setAbbandonaTest() {
        test.setAbbandona(true);
        assertTrue(test.getAbbandona());
    }
    @Ignore
    @Test
    @DisplayName("disabled")
    void setTest() {
        test.stampaPedineMangiate();
        test.getCronologiaMosse();
        test.getGiocatore1();
    }
    @Ignore
    @Test
    @DisplayName("disabled")
    void setCronologiaMosseTest(){
        test.setCronologiaMosse("12-13");
        test.getCronologiaMosse();
    }


}