package it.uniba.tavolo;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

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


    @Test
    public void testDamiera() {
        Damiera test = new Damiera();
        assertTrue(test.getDamieraPedine(4, 4).getBlank());
        assertFalse(test.getDamieraPedine(0, 0).getWhite());
        assertTrue(test.getDamieraPedine(7, 7).getWhite());
    }

    @Test
    public void cercaColonnaTest() {
        Damiera test = new Damiera();
        test.cercaColonna(9);
        assertEquals(0, test.cercaColonna(9));
    }

    @Test
    public void cercaRigaTest() {
        Damiera test = new Damiera();
        test.cercaRiga(9);
        assertEquals(2, test.cercaRiga(9));
    }


}
