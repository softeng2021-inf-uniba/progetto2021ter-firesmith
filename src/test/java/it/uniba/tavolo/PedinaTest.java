package it.uniba.tavolo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PedinaTest {
    private Pedina test = new Pedina(13, 23);

    @Test
    void getRigaTest() {
        test.setRiga(2);
        assertEquals(2, test.getRiga());
    }

    @Test
    void getColonnaTest() {
        test.setColonna(3);
        assertEquals(3, test.getColonna());
    }
}
