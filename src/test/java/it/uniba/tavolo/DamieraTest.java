package it.uniba.tavolo;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


public class DamieraTest {
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
    Damiera test = new Damiera();
    @Test
    public void testDamiera(){
        assertTrue(test.getDamieraPedine(4,4).getBlank());
        assertFalse(test.getDamieraPedine(0,0).getWhite());
        assertTrue(test.getDamieraPedine(7,7).getWhite());
    }
    @Test
    public void cercaColonnaTest() {
            test.cercaColonna(9);
            assertEquals(0, test.cercaColonna(9));
    }
    @Test
    public void cercaRigaTest() {
        test.cercaRiga(9);
        assertEquals(2, test.cercaRiga(9));
    }
    @Ignore
    @Test
    @DisplayName("disabled")
    public void stampadamieranumeritest(){
        System.out.println(test.stampaPosizioniPedine());
        assertNull(null,out.toString());
    }
    @Ignore
    @Test
    @DisplayName("disabled")
    public void stampadamieratest(){
        System.out.println(test.stampaDamieraPedine());
        assertNull(null,out.toString());
    }

}