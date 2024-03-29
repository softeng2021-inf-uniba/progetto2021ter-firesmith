package it.uniba.interfaccia;

import it.uniba.gioco.Partita;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


class TurnoBiancoTest {
    private Turno test = new TurnoBianco();
    private Turno testn = new TurnoNero();
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
        test.turnoGiocatore(partita, 53);
        String inpu = "9-13";
        InputStream inp = new ByteArrayInputStream(inpu.getBytes());
        System.setIn(inp);
        testn.turnoGiocatore(partita, 66);
        String presa = "18x9";
        InputStream pres = new ByteArrayInputStream(presa.getBytes());
        System.setIn(pres);
        test.turnoGiocatore(partita, 66);
        String spos1 = "10-14";
        InputStream sposner = new ByteArrayInputStream(spos1.getBytes());
        System.setIn(sposner);
        testn.turnoGiocatore(partita, 66);
        String spos2 = "25-21";
        InputStream sposbianc = new ByteArrayInputStream(spos2.getBytes());
        System.setIn(sposbianc);
        test.turnoGiocatore(partita, 80);
        String spos3 = "5-10";
        InputStream sposner1 = new ByteArrayInputStream(spos3.getBytes());
        System.setIn(sposner1);
        testn.turnoGiocatore(partita, 66);
        String spos4 = "21-17";
        InputStream sposbianc1 = new ByteArrayInputStream(spos4.getBytes());
        System.setIn(sposbianc1);
        test.turnoGiocatore(partita, 80);
        String spos5 = "14-19";
        InputStream sposbianc2 = new ByteArrayInputStream(spos5.getBytes());
        System.setIn(sposbianc2);
        testn.turnoGiocatore(partita, 66);
        String presamult = "23x14x5";
        InputStream presam = new ByteArrayInputStream(presamult.getBytes());
        System.setIn(presam);
        test.turnoGiocatore(partita, 80);

    }

    @Test
    public void menuTest() {
        Partita partita = new Partita();
        partita.setBianco();
        String simulatedUserInput = "damiera"
                + System.getProperty("line.separator")
                + "numeri" + System.getProperty("line.separator")
                + "help" + System.getProperty("line.separator")
                + "prese" + System.getProperty("line.separator")
                + "tempo" + System.getProperty("line.separator")
                + "gioca" + System.getProperty("line.separator")
                + "mosse" + System.getProperty("line.separator")
                + "21-18" + System.getProperty("line.separator");

        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        test.turnoGiocatore(partita, 2323);
// code that needs multiple user inputs

        System.setIn(savedStandardInputStream);
    }

}
