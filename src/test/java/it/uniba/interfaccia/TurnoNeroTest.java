package it.uniba.interfaccia;


import it.uniba.gioco.Giocatore;
import it.uniba.gioco.Mossa;
import it.uniba.gioco.MossaNero;
import it.uniba.gioco.Partita;
import it.uniba.interfaccia.Menu;
import it.uniba.strumenti.Comando;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class TurnoNeroTest {
    Turno test = new TurnoNero();
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

    @Test()
    public void turnoGiocNeroSpostamentoTest() {
        Partita partita = new Partita();
        Giocatore g = new Giocatore();
        Comando cmd = new Comando();
        //Mossa mossa = new MossaNero(0, 0);

        g.setColore("nero");
        String input = "9-13";
        //String command = cmd.gestisciRegex(mossa,input);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        test.turnoGiocatore(partita,53);

    }

}