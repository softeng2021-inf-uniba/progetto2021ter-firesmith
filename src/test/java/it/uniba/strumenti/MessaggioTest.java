package it.uniba.strumenti;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MessaggioTest {

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
        System.out.println(Messaggio.uscita());
        assertNull(null, out.toString());
    }
    @Test
    public void benvenutoTest(){
        System.out.println(Messaggio.benvenuto());
        assertNull(null, out.toString());
    }
    @Test
    public void aiutoTest(){
        System.out.println(Messaggio.aiuto());
        assertNull(null, out.toString());
    }
    @Test
    public void menuTest(){
        System.out.println(Messaggio.menu());
        assertNull(null, out.toString());
    }
    @Test
    public void inserimentoTest(){
        System.out.println(Messaggio.inserimento());
        assertNull(null, out.toString());
    }
    @Test
    public void partitaTest(){
        System.out.println(Messaggio.partita());
        assertNull(null, out.toString());
    }
    @Test
    public void messdamieraTest(){
        System.out.println(Messaggio.damiera());
        assertNull(null, out.toString());
    }
    @Test
    public  void biancoAbbandonaTest(){
        System.out.println(Messaggio.biancoAbbandona());
        assertNull(null, out.toString());
    }
    @Test
    public void neroAbbandonaTest(){
        System.out.println(Messaggio.neroAbbandona());
        assertNull(null, out.toString());
    }
    @Test
    public void errorePartitaTest(){
        System.out.println(Messaggio.errorePartita());
        assertNull(null, out.toString());
    }
    @Test
    public void nonValidaTest(){
        System.out.println(Messaggio.nonValida());
        assertNull(null, out.toString());
    }

}