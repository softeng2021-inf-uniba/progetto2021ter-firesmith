package it.uniba.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import it.uniba.main.Damiera;


public class DamieraTest {
    @Test
    public void testDamiera(){
        Damiera test = new Damiera();
        assertTrue(test.getDamieraPedine(4,4).getBlank());
        assertFalse(test.getDamieraPedine(0,0).getWhite());
        assertTrue(test.getDamieraPedine(7,7).getWhite());
    }
    @Test
    public void cercaColonnaTest() {
            Damiera toTest = new Damiera();
            toTest.cercaColonna(9);
            assertEquals(0, toTest.cercaColonna(9));
    }
    @Test
    public void cercaRigaTest() {
        Damiera toTest = new Damiera();
        toTest.cercaRiga(9);
        assertEquals(2, toTest.cercaRiga(9));
    }

}