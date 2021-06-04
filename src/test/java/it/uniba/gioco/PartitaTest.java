package it.uniba.gioco;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;


class PartitaTest {
    private Partita test = new Partita();
    private final OutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(out));
    }

    @After
    public void restoreInitialStreams() {
        System.setOut(originalOut);
    }

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
        System.out.println(test.stampaPedineMangiate());
        assertNull(null, out.toString());
    }

    @Ignore
    @Test
    @DisplayName("disabled")
    void setCronologiaMosseTest() {
        test.setCronologiaMosse("12-13");
        System.out.println(test.getCronologiaMosse());
        assertNull(null, out.toString());
    }

    @Test
    void getBiancoTest() {
        test.setBianco();
        assertEquals("bianco", test.getBianco().getColore());
    }

    @Test
    void getNeroTest() {
        test.setNero();
        assertEquals("nero", test.getNero().getColore());
    }

    @Test
    void tempoTest() {
        test.setNero();
        test.setBianco();
        test.getBianco().setColore("bianco");
        test.getBianco().setTempo(13000);
        test.getNero().setColore("nero");
        test.getNero().setTempo(133333);
        test.tempo();
    }


}
