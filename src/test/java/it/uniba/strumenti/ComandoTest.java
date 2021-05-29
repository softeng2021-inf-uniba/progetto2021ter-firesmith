package it.uniba.strumenti;

import it.uniba.gioco.Giocatore;
import it.uniba.gioco.Mossa;
import it.uniba.gioco.MossaBianco;

import it.uniba.gioco.Partita;
import it.uniba.interfaccia.Turno;
import it.uniba.interfaccia.TurnoNero;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;



import static org.junit.jupiter.api.Assertions.*;

class ComandoTest {
    Comando test = new Comando();
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
        Mossa mossa = new MossaBianco(9,13);
        assertEquals("spostamento",(test.gestisciRegex(mossa,"9-13")));
    }

    @Test
    public void gestioneRegexPresaTest(){
        Mossa mossa = new MossaBianco(9,13);
        assertEquals("presa semplice",(test.gestisciRegex(mossa,"9x13")));
    }

    @Test
    public void gestioneRegexPresaMultiplaTest(){
        Mossa mossa = new MossaBianco(9,13);
        assertEquals("presa multipla",(test.gestisciRegex(mossa,"9x13x21")));
    }

    @Test
    public void esciTestNo() {
        Partita partita = new Partita();
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        test.esci(partita);
    }


    @Test
    public void AbbandonaBiancoTestSi(){
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        g.setColore("bianco");
        String input = "si";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        test.abbandona(partita,g);

    }
    @Test
    public void AbbandonaNeroTestSi(){
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        g.setColore("nero");
        String input = "si";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        test.abbandona(partita,g);
    }

    @Test
    public void AbbandonaBiancoTestNo(){
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        g.setColore("bianco");
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        test.abbandona(partita,g);

    }
    @Test
    public void AbbandonaNeroTestNo(){
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        g.setColore("nero");
        String input = "no";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        test.abbandona(partita,g);
    }
}