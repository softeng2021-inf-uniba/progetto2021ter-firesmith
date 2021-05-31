package it.uniba.interfaccia;

import it.uniba.gioco.Partita;
import it.uniba.strumenti.Comando;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    Partita p = new Partita();
    Menu m = Menu.getInstance();

    @Test
    void SetGetPartitaTest() {
        m.setPartita(p);
        assertEquals(p,m.getPartita());
    }

    @Test
    void getInstance() {
        Menu m1 = Menu.getInstance();
        assertEquals(m1,m);
    }
}