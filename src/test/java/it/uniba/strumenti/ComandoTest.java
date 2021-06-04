package it.uniba.strumenti;

import it.uniba.gioco.Giocatore;
import it.uniba.gioco.Mossa;
import it.uniba.gioco.MossaBianco;

import it.uniba.gioco.Partita;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ComandoTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setStreams() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void restoreInitialStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void gestioneRegexSpostamentoTest() {
        Mossa mossa = new MossaBianco(9, 13);
        assertEquals("spostamento", (Comando.gestisciRegex(mossa, "9-13")));
    }

    @Test
    public void gestioneRegexPresaTest() {
        Mossa mossa = new MossaBianco(9, 13);
        assertEquals("presasemplice", (Comando.gestisciRegex(mossa, "9x13")));
    }

    @Test
    public void gestioneRegexPresaMultiplaTest() {
        Mossa mossa = new MossaBianco(9, 13);
        assertEquals("presamultipla",
                (Comando.gestisciRegex(mossa, "9x13x21")));
    }

    @Test
    public void esciTestNo() {
        Partita partita = new Partita();
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Comando.esci(partita);
    }


    @Test
    public void abbandonaBiancoTestSi() {
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        g.setColore("bianco");
        String input = "si";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Comando.abbandona(partita, g);

    }

    @Test
    public void abbandonaNeroTestSi() {
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        g.setColore("nero");
        String input = "si";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Comando.abbandona(partita, g);
    }

    @Test
    public void abbandonaBiancoTestNo() {
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        g.setColore("bianco");
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Comando.abbandona(partita, g);

    }

    @Test
    public void abbandonaNeroTestNo() {
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        g.setColore("nero");
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Comando.abbandona(partita, g);
    }

    @Test
    public void gestisciRegexErratoTest() {
        Mossa mossa = new MossaBianco(9, 13);
        assertEquals("presamultipla",
                (Comando.gestisciRegex(mossa, "1x10x17x26")));
    }

    @Test
    public void exceptionTest() {
        try {
            Mossa mossa = new MossaBianco(9, 13);
            Comando.gestisciRegex(mossa, "-5-4");
        } catch (NumberFormatException exc) {
            fail("Exception " + exc);
        }
    }

}
