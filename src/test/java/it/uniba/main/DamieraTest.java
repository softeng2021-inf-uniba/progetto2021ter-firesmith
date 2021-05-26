package it.uniba.main;

import org.junit.Ignore;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import it.uniba.tavolo.Damiera;


public class DamieraTest {
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
        test.stampaPosizioniPedine();

    }
    @Ignore
    @Test
    @DisplayName("disabled")
    public void stampadamieratest(){
        test.stampaDamieraPedine();
    }

}