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
    @DisplayName("Sto testando presa semplice nero a sinistra \n ")
    void presaSempliceNeroaSinistraTest() {
        Mossa spostamentobianco = new Mossa(21,17);
        Mossa spostamentonero = new Mossa(9,13);
        Mossa spbianc1= new Mossa(24,20);
        Mossa spner1= new Mossa(13,18);
        Mossa spbianc2 = new Mossa(17,13);
        Mossa mossa = new Mossa(10,17);
        assertTrue(spostamentobianco.spostamentoSempliceBianco(test));
        assertTrue(spostamentonero.spostamentoSempliceNero(test));
        assertTrue(spbianc1.spostamentoSempliceBianco(test));
        assertTrue(spner1.spostamentoSempliceNero(test));
        assertTrue(spbianc2.spostamentoSempliceBianco(test));
        assertTrue(mossa.presaSempliceBlack(test));
    }
    @Test
    @DisplayName("Sto testando una presa semplice con spostamento nero non valido")
    void presaSempliceNeroaSinistraFalseTest() {
        Mossa spostamentobianco = new Mossa(21,18);
        Mossa spostamentonero = new Mossa(13,14);
        Mossa spbianc1= new Mossa(18,13);
        Mossa mossa = new Mossa(9,18);
        assertTrue(spostamentobianco.spostamentoSempliceBianco(test));
        assertFalse(spostamentonero.spostamentoSempliceNero(test));
        assertTrue(spbianc1.spostamentoSempliceBianco(test));
        assertTrue(mossa.presaSempliceBlack(test));
    }
    @Test
    @DisplayName("Sto testando presa semplice nero non valida\n ")
    void presaSempliceNeroaSinistraFalsaTest() {
        Mossa spostamentobianco = new Mossa(21,18);
        Mossa spostamentonero = new Mossa(10,14);
        Mossa spbianc1= new Mossa(18,13);
        Mossa mossa = new Mossa(9,13);
        assertTrue(spostamentobianco.spostamentoSempliceBianco(test));
        assertTrue(spostamentonero.spostamentoSempliceNero(test));
        assertTrue(spbianc1.spostamentoSempliceBianco(test));
        assertFalse(mossa.presaSempliceBlack(test));
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
    @Test
    @DisplayName("Sto testando una presa multipla tripla con damatura")
    void presaMultiplaTriplaTest(){
        Mossa spostamentobianco = new Mossa(21, 17);
        Mossa spostamentonero = new Mossa(9, 13);
        Mossa prbianca = new Mossa(24, 20);
        Mossa spostNer1 = new Mossa(10, 14);
        Mossa spostBian1 = new Mossa(17, 10);
        Mossa spostNer2 = new Mossa(11, 15);
        Mossa spostBian2 = new Mossa(25, 21);
        Mossa prNera = new Mossa(15, 24);
        Mossa spostBian3 = new Mossa(23, 19);
        Mossa spostNer3 = new Mossa(12, 16);
        Mossa spostBian4 = new Mossa(22, 18);
        Mossa spostNer4 = new Mossa(14, 23);
        Mossa spostBian5 = new Mossa(18, 13);
        Mossa spostNer5 = new Mossa(6, 11);
        Mossa spostBian6 = new Mossa(21, 17);
        Mossa spostNer6 = new Mossa(11, 14);
        Mossa spostBian7 = new Mossa(10, 6);
        Mossa spostNer7 = new Mossa(8, 12);
        Mossa spostBian8 = new Mossa(29, 25);
        Mossa spostNer8 = new Mossa(5, 9);
        Mossa spostBian9 = new Mossa(25, 21);
        Mossa spostNer9 = new Mossa(1, 5);
        Mossa prmult = new Mossa(28,19);
        prmult.setPosizione3(10);
        prmult.setPosizione4(1);

        assertTrue(spostamentobianco.spostamentoSempliceBianco(test));
        assertTrue(spostamentonero.spostamentoSempliceNero(test));
        assertTrue(prbianca.spostamentoSempliceBianco(test));
        assertTrue(spostNer1.spostamentoSempliceNero(test));
        assertTrue(spostBian1.presaSempliceWhite(test));
        assertTrue(spostNer2.spostamentoSempliceNero(test));
        assertTrue(spostBian2.spostamentoSempliceBianco(test));
        assertTrue(prNera.presaSempliceBlack(test));
        assertTrue(spostBian3.spostamentoSempliceBianco(test));
        assertTrue(spostNer3.spostamentoSempliceNero(test));
        assertTrue(spostBian4.spostamentoSempliceBianco(test));
        assertTrue(spostNer4.presaSempliceBlack(test));
        assertTrue(spostBian5.spostamentoSempliceBianco(test));
        assertTrue(spostNer5.spostamentoSempliceNero(test));
        assertTrue(spostBian6.spostamentoSempliceBianco(test));
        assertTrue(spostNer6.spostamentoSempliceNero(test));
        assertTrue(spostBian7.spostamentoSempliceBianco(test));
        assertTrue(spostNer7.spostamentoSempliceNero(test));
        assertTrue(spostBian8.spostamentoSempliceBianco(test));
        assertTrue(spostNer8.spostamentoSempliceNero(test));
        assertTrue(spostBian9.spostamentoSempliceBianco(test));
        assertTrue(spostNer9.spostamentoSempliceNero(test));
        assertTrue(prmult.presaMultiplaWhite(test));

    }

}