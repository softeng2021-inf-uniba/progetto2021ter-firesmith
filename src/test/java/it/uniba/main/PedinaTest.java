package it.uniba.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedinaTest {
    Pedina test = new Pedina(2,3);
    @Test
    void getRigaTest() {
        assertEquals(2,test.getRiga());
    }

    @Test
    void getColonnaTest() {
        assertEquals(3,test.getColonna());
    }
}