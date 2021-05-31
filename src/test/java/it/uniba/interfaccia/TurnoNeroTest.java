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
    Turno test = new TurnoBianco();
    Turno testn = new TurnoNero();
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
    public void turnoGiocNeroSpostePresaTest() {
        Partita partita = new Partita();
        String input = "21-18";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        test.turnoGiocatore(partita,53);
        String inpu = "9-13";
        InputStream inp = new ByteArrayInputStream(inpu.getBytes());
        System.setIn(inp);
        testn.turnoGiocatore(partita,66);
        String presa = "22-19";
        InputStream pres = new ByteArrayInputStream(presa.getBytes());
        System.setIn(pres);
        test.turnoGiocatore(partita,66);
        String spos1 = "10-14";
        InputStream sposner = new ByteArrayInputStream(spos1.getBytes());
        System.setIn(sposner);
        testn.turnoGiocatore(partita,66);
        String spos2 = "23-20";
        InputStream sposbianc = new ByteArrayInputStream(spos2.getBytes());
        System.setIn(sposbianc);
        test.turnoGiocatore(partita,80);
        String spos3 = "14x23";
        InputStream sposner1 = new ByteArrayInputStream(spos3.getBytes());
        System.setIn(sposner1);
        testn.turnoGiocatore(partita,66);
        String spos4 = "28x19";
        InputStream sposbianc1 = new ByteArrayInputStream(spos4.getBytes());
        System.setIn(sposbianc1);
        test.turnoGiocatore(partita,80);
        String spos5 = "11-15";
        InputStream sposbianc2 = new ByteArrayInputStream(spos5.getBytes());
        System.setIn(sposbianc2);
        testn.turnoGiocatore(partita,66);
        String presamult = "31-28";
        InputStream presam = new ByteArrayInputStream(presamult.getBytes());
        System.setIn(presam);
        test.turnoGiocatore(partita,80);
        String presa5 = "13x22x31";
        InputStream pres2 = new ByteArrayInputStream(presa5.getBytes());
        System.setIn(pres2);
        testn.turnoGiocatore(partita,1231);

    }
    @Test
    public void menuTest(){
        Partita partita = new Partita();
        partita.setNero();
        partita.setBianco();
        String simulatedUserInput ="damiera"+System.getProperty("line.separator")+"numeri"+System.getProperty("line.separator")+"help"+System.getProperty("line.separator")+ "prese"+System.getProperty("line.separator")+"tempo"+System.getProperty("line.separator")+"gioca"+System.getProperty("line.separator")+"mosse" + System.getProperty("line.separator")
                + "9-13" + System.getProperty("line.separator");

        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        testn.turnoGiocatore(partita,2323);
// code that needs multiple user inputs

        System.setIn(savedStandardInputStream);
    }

}