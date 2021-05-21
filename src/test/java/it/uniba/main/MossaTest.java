package it.uniba.main;

import com.google.api.client.util.NullValue;
import org.junit.jupiter.api.*;
import it.uniba.main.Mossa;
import it.uniba.main.Damiera;

import static org.junit.jupiter.api.Assertions.*;

public class MossaTest {
    Damiera test = new Damiera();

    @Test
    void setPosizione1PositiveValueTest() {

        Mossa toTest = new Mossa(0,0);
        toTest.setPosizione1(9);
        assertEquals(9, toTest.getPosizione1());
    }

    @Test
    @DisplayName("Sto testando spostamento semplice nero \n")
    void spostamentoSempliceNeroTest() {
        Mossa mossa = new Mossa(9,13);
        assertTrue(mossa.spostamentoSempliceNero(test));
    }

    @Test
    @DisplayName("Sto testando spostamento semplice bianco \n")
    void spostamentoSempliceBiancoTest() {
        Mossa mossa = new Mossa(21,18);
        assertTrue(mossa.spostamentoSempliceBianco(test));
    }

    @Test
    @DisplayName("Sto testando presa semplice bianco \n")
    void presaSempliceBiancoTest() {
        Mossa spostamentobianco = new Mossa(21,18);
        Mossa spostamentonero = new Mossa(9,13);
        spostamentobianco.spostamentoSempliceBianco(test);
        spostamentonero.spostamentoSempliceNero(test);
        Mossa mossa = new Mossa(18,9);
        assertTrue(mossa.presaSempliceWhite(test));
    }
    @Test
    @DisplayName("Sto testando presa semplice nero \n ")
    void presaSempliceNeroTest() {
        Mossa spostamentobianco = new Mossa(21,18);
        Mossa spostamentonero = new Mossa(10,14);
        Mossa spbianc1= new Mossa(18,13);
        Mossa mossa = new Mossa(9,18);
        assertTrue(spostamentobianco.spostamentoSempliceBianco(test));
        assertTrue(spostamentonero.spostamentoSempliceNero(test));
        assertTrue(spbianc1.spostamentoSempliceBianco(test));
        assertTrue(mossa.presaSempliceBlack(test));
    }
    @Test
    @DisplayName("Sto testando presa multipla bianca \n")
    void presaMultiplaWhiteTest(){
        Mossa spostamentobianco = new Mossa(21,18);
        Mossa spostamentonero = new Mossa(9,13);
        Mossa prbianca = new Mossa(18,9);
        Mossa spostNer1 = new Mossa(10,14);
        Mossa spostBian1 = new Mossa(25,21);
        Mossa spostNer2 = new Mossa(5,10);
        Mossa spostBian2 = new Mossa(21,17);
        Mossa spostNer3 = new Mossa(14,19);
        Mossa mossaerrat = new Mossa(23,14);
        mossaerrat.setPosizione3(7);
        Mossa mossa = new Mossa(23,14);
        mossa.setPosizione3(5);
        assertTrue(spostamentobianco.spostamentoSempliceBianco(test));
        assertTrue(spostamentonero.spostamentoSempliceNero(test));
        assertTrue(prbianca.presaSempliceWhite(test));
        assertTrue(spostNer1.spostamentoSempliceNero(test));
        assertTrue(spostBian1.spostamentoSempliceBianco(test));
        assertTrue(spostNer2.spostamentoSempliceNero(test));
        assertTrue(spostBian2.spostamentoSempliceBianco(test));
        assertTrue(spostNer3.spostamentoSempliceNero(test));
        assertFalse(mossaerrat.presaMultiplaWhite(test));
        assertTrue(mossa.presaMultiplaWhite(test));
    }
    @Test
    @DisplayName("Sto testando presa multipla nero \n")
    void presaMultiplaBlackTest() {

        Mossa spostamentobianco = new Mossa(23, 19);
        Mossa spostamentonero = new Mossa(10, 14);
        Mossa prbianca = new Mossa(24, 20);
        Mossa spostNer1 = new Mossa(11, 15);
        Mossa spostBian1 = new Mossa(28, 24);
        Mossa spostNer2 = new Mossa(12, 16);
        Mossa spostBian2 = new Mossa(32, 28);
        Mossa mossaerrat = new Mossa(14, 23);
        Mossa mossa = new Mossa(14, 23);
        mossaerrat.setPosizione3(31);
        mossa.setPosizione3(32);

        assertAll(() -> {
            assertTrue(spostamentobianco.spostamentoSempliceBianco(test));
            assertTrue(spostamentonero.spostamentoSempliceNero(test));
            assertTrue(prbianca.spostamentoSempliceBianco(test));
            assertTrue(spostNer1.spostamentoSempliceNero(test));
            assertTrue(spostBian1.spostamentoSempliceBianco(test));
            assertTrue(spostNer2.spostamentoSempliceNero(test));
            assertTrue(spostBian2.spostamentoSempliceBianco(test));
            assertFalse(mossaerrat.presaMultiplaBlack(test));
            assertTrue(mossa.presaMultiplaBlack(test));
        });
    }

}