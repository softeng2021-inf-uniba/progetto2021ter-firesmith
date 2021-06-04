package it.uniba.strumenti;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MessaggiTest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
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
    public void uscitaTest(){
        System.out.println(Messaggi.uscita());
        assertNull(null, out.toString());
    }
    @Test
    public void benvenutoTest(){
        System.out.println(Messaggi.benvenuto());
        assertNull(null, out.toString());
    }
    @Test
    public void aiutoTest(){
        System.out.println(Messaggi.aiuto());
        assertNull(null, out.toString());
    }
    @Test
    public void menuTest(){
        System.out.println(Messaggi.menu());
        assertNull(null, out.toString());
    }
    @Test
    public void inserimentoTest(){
        System.out.println(Messaggi.inserimento());
        assertNull(null, out.toString());
    }
    @Test
    public void partitaTest(){
        System.out.println(Messaggi.partita());
        assertNull(null, out.toString());
    }
    @Test
    public void messdamieraTest(){
        System.out.println(Messaggi.damiera());
        assertNull(null, out.toString());
    }
    @Test
    public  void biancoAbbandonaTest(){
        System.out.println(Messaggi.biancoAbbandona());
        assertNull(null, out.toString());
    }
    @Test
    public void neroAbbandonaTest(){
        System.out.println(Messaggi.neroAbbandona());
        assertNull(null, out.toString());
    }
    @Test
    public void errorePartitaTest(){
        System.out.println(Messaggi.errorePartita());
        assertNull(null, out.toString());
    }
    @Test
    public void nonValidaTest(){
        System.out.println(Messaggi.nonValida());
        assertNull(null, out.toString());
    }

}