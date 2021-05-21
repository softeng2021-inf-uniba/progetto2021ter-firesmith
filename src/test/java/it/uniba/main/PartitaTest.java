package it.uniba.main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniba.main.*;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class PartitaTest {

    @Test
    void statoPartitaTest() {
        Partita test = new Partita();
        test.setStato(true);
        assertTrue(test.getStato());
    }
}