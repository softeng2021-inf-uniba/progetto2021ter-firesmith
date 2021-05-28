package it.uniba.interfaccia;

import it.uniba.gioco.Partita;
import it.uniba.interfaccia.Menu;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TurnoBiancoTest {
    Turno test = new TurnoBianco();
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setStreams() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    public void restoreInitialStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void turnoGiocBiancoSpostamentoTest() {
        Partita partita = new Partita();
        String input = "21-18";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        test.turnoGiocatore(partita,53);
    }

}