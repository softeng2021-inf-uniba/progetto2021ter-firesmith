package it.uniba.interfaccia;

import it.uniba.gioco.Partita;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuTest {

    private Partita p = new Partita();
    private Menu m = Menu.getInstance();

    @Test
    void setGetPartitaTest() {
        m.setPartita(p);
        assertEquals(p, m.getPartita());
    }

    @Test
    void getInstance() {
        Menu m1 = Menu.getInstance();
        assertEquals(m1, m);
    }
}
