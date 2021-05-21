package it.uniba.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GiocatoreTest {
    @Test
    void PedineMangiateTest() {
        Giocatore bianco = new Giocatore();
        Giocatore nero = new Giocatore();
        bianco.setPedineMangiate(3);
        nero.setPedineMangiate(1);
        assertEquals(3,bianco.getPedineMangiate());
        assertEquals(1,nero.getPedineMangiate());
    }

    @Test
    void tempoTest() {
        Giocatore bianco = new Giocatore();

        bianco.setTempo(4);
        assertEquals(4,bianco.getTempo());
    }

}