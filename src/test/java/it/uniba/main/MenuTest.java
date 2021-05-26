package it.uniba.main;

import it.uniba.gioco.Partita;
import it.uniba.interfaccia.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    Menu test = new Menu();
    @Test
    void getPartitaTest() {
        Partita p1 = new Partita();
        test.setPartita(p1);
        assertEquals(p1, test.getPartita());
    }
}