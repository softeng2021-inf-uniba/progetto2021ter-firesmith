package it.uniba.gioco;

import it.uniba.gioco.Mossa;
import it.uniba.gioco.MossaBianco;
import it.uniba.gioco.MossaNero;
import org.junit.jupiter.api.*;
import it.uniba.tavolo.Damiera;

import static org.junit.jupiter.api.Assertions.*;

public class MossaTest {
    Damiera test = new Damiera();

    @Test
    void setPosizione1PositiveValueTest() {

        Mossa toTest = new MossaNero(0,0);
        toTest.setPosizione1(9);
        assertEquals(9, toTest.getPosizione1());
    }

    @Test
    @DisplayName("Sto testando spostamento semplice nero \n")
    void spostamentoSempliceNeroTest() {
        Mossa mossa = new MossaNero(9,13);
        assertTrue(mossa.spostamentoSemplice(test));
    }

    @Test
    @DisplayName("Sto testando spostamento semplice bianco \n")
    void spostamentoSempliceBiancoTest() {
        Mossa mossa = new MossaBianco(21,18);
        assertTrue(mossa.spostamentoSemplice(test));
    }

    @Test
    @DisplayName("Sto testando presa semplice bianco \n")
    void presaSempliceBiancoTest() {
        Mossa spostamentobianco = new MossaBianco(21,18);
        Mossa spostamentonero = new MossaNero(9,13);
        spostamentobianco.spostamentoSemplice(test);
        spostamentonero.spostamentoSemplice(test);
        MossaBianco mossa = new MossaBianco(18,9);
        assertTrue(mossa.presaSemplice(test));
    }
    @Test
    @DisplayName("Sto testando presa semplice nero \n ")
    void presaSempliceNeroTest() {
        Mossa spostamentobianco = new MossaBianco(21,18);
        Mossa spostamentonero = new MossaNero(10,14);
        Mossa spbianc1= new MossaBianco(18,13);
        Mossa mossa = new MossaNero(9,18);
        assertTrue(spostamentobianco.spostamentoSemplice(test));
        assertTrue(spostamentonero.spostamentoSemplice(test));
        assertTrue(spbianc1.spostamentoSemplice(test));
        assertTrue(mossa.presaSemplice(test));
    }
    @Test
    @DisplayName("Sto testando presa semplice nero a sinistra \n ")
    void presaSempliceNeroaSinistraTest() {
        Mossa spostamentobianco = new MossaBianco(21,17);
        Mossa spostamentonero = new MossaNero(9,13);
        Mossa spbianc1= new MossaBianco(24,20);
        Mossa spner1= new MossaNero(13,18);
        Mossa spbianc2 = new MossaBianco(17,13);
        Mossa mossa = new MossaNero(10,17);
        assertTrue(spostamentobianco.spostamentoSemplice(test));
        assertTrue(spostamentonero.spostamentoSemplice(test));
        assertTrue(spbianc1.spostamentoSemplice(test));
        assertTrue(spner1.spostamentoSemplice(test));
        assertTrue(spbianc2.spostamentoSemplice(test));
        assertTrue(mossa.presaSemplice(test));
    }
    @Test
    @DisplayName("Sto testando una presa semplice con spostamento nero non valido")
    void presaSempliceNeroaSinistraFalseTest() {
        Mossa spostamentobianco = new MossaBianco(21,18);
        Mossa spostamentonero = new MossaNero(13,14);
        Mossa spbianc1= new MossaBianco(18,13);
        Mossa mossa = new MossaNero(9,18);
        assertTrue(spostamentobianco.spostamentoSemplice(test));
        assertFalse(spostamentonero.spostamentoSemplice(test));
        assertTrue(spbianc1.spostamentoSemplice(test));
        assertTrue(mossa.presaSemplice(test));
    }
    @Test
    @DisplayName("Sto testando presa semplice nero non valida\n ")
    void presaSempliceNeroaSinistraFalsaTest() {
        Mossa spostamentobianco = new MossaBianco(21,18);
        Mossa spostamentonero = new MossaNero(10,14);
        Mossa spbianc1= new MossaBianco(18,13);
        Mossa mossa = new MossaNero(9,13);
        assertTrue(spostamentobianco.spostamentoSemplice(test));
        assertTrue(spostamentonero.spostamentoSemplice(test));
        assertTrue(spbianc1.spostamentoSemplice(test));
        assertFalse(mossa.presaSemplice(test));
    }
    @Test
    @DisplayName("Sto testando presa multipla bianca \n")
    void presaMultiplaWhiteTest(){
        Mossa spostamentobianco = new MossaBianco(21,18);
        Mossa spostamentonero = new MossaNero(9,13);
        Mossa prbianca = new MossaBianco(18,9);
        Mossa spostNer1 = new MossaNero(10,14);
        Mossa spostBian1 = new MossaBianco(25,21);
        Mossa spostNer2 = new MossaNero(5,10);
        Mossa spostBian2 = new MossaBianco(21,17);
        Mossa spostNer3 = new MossaNero(14,19);
        Mossa mossaerrat = new MossaBianco(23,14);
        mossaerrat.setPosizione3(7);
        Mossa mossa = new MossaBianco(23,14);
        mossa.setPosizione3(5);
        assertTrue(spostamentobianco.spostamentoSemplice(test));
        assertTrue(spostamentonero.spostamentoSemplice(test));
        assertTrue(prbianca.presaSemplice(test));
        assertTrue(spostNer1.spostamentoSemplice(test));
        assertTrue(spostBian1.spostamentoSemplice(test));
        assertTrue(spostNer2.spostamentoSemplice(test));
        assertTrue(spostBian2.spostamentoSemplice(test));
        assertTrue(spostNer3.spostamentoSemplice(test));
        assertFalse(mossaerrat.presaMultipla(test));
        assertTrue(mossa.presaMultipla(test));
    }
    @Test
    @DisplayName("Sto testando presa multipla nero \n")
    void presaMultiplaBlackTest() {

        Mossa spostamentobianco = new MossaBianco(23, 19);
        Mossa spostamentonero = new MossaNero(10, 14);
        Mossa prbianca = new MossaBianco(24, 20);
        Mossa spostNer1 = new MossaNero(11, 15);
        Mossa spostBian1 = new MossaBianco(28, 24);
        Mossa spostNer2 = new MossaNero(12, 16);
        Mossa spostBian2 = new MossaBianco(32, 28);
        Mossa mossaerrat = new MossaNero(14, 23);
        Mossa mossa = new MossaNero(14, 23);
        mossaerrat.setPosizione3(31);
        mossa.setPosizione3(32);

        assertAll(() -> {
            assertTrue(spostamentobianco.spostamentoSemplice(test));
            assertTrue(spostamentonero.spostamentoSemplice(test));
            assertTrue(prbianca.spostamentoSemplice(test));
            assertTrue(spostNer1.spostamentoSemplice(test));
            assertTrue(spostBian1.spostamentoSemplice(test));
            assertTrue(spostNer2.spostamentoSemplice(test));
            assertTrue(spostBian2.spostamentoSemplice(test));
            assertFalse(mossaerrat.presaMultipla(test));
            assertTrue(mossa.presaMultipla(test));
        });
    }
    @Test
    @DisplayName("Sto testando una presa multipla tripla con damatura")
    void presaMultiplaTriplaTest(){
        Mossa spostamentobianco = new MossaBianco(21, 17);
        Mossa spostamentonero = new MossaNero(9, 13);
        Mossa prbianca = new MossaBianco(24, 20);
        Mossa spostNer1 = new MossaNero(10, 14);
        Mossa spostBian1 = new MossaBianco(17, 10);
        Mossa spostNer2 = new MossaNero(11, 15);
        Mossa spostBian2 = new MossaBianco(25, 21);
        Mossa prNera = new MossaNero(15, 24);
        Mossa spostBian3 = new MossaBianco(23, 19);
        Mossa spostNer3 = new MossaNero(12, 16);
        Mossa spostBian4 = new MossaBianco(22, 18);
        Mossa spostNer4 = new MossaNero(14, 23);
        Mossa spostBian5 = new MossaBianco(18, 13);
        Mossa spostNer5 = new MossaNero(6, 11);
        Mossa spostBian6 = new MossaBianco(21, 17);
        Mossa spostNer6 = new MossaNero(11, 14);
        Mossa spostBian7 = new MossaBianco(10, 6);
        Mossa spostNer7 = new MossaNero(8, 12);
        Mossa spostBian8 = new MossaBianco(29, 25);
        Mossa spostNer8 = new MossaNero(5, 9);
        Mossa spostBian9 = new MossaBianco(25, 21);
        Mossa spostNer9 = new MossaNero(1, 5);
        Mossa prmult = new MossaBianco(28,19);
        prmult.setPosizione3(10);
        prmult.setPosizione4(1);

        assertTrue(spostamentobianco.spostamentoSemplice(test));
        assertTrue(spostamentonero.spostamentoSemplice(test));
        assertTrue(prbianca.spostamentoSemplice(test));
        assertTrue(spostNer1.spostamentoSemplice(test));
        assertTrue(spostBian1.presaSemplice(test));
        assertTrue(spostNer2.spostamentoSemplice(test));
        assertTrue(spostBian2.spostamentoSemplice(test));
        assertTrue(prNera.presaSemplice(test));
        assertTrue(spostBian3.spostamentoSemplice(test));
        assertTrue(spostNer3.spostamentoSemplice(test));
        assertTrue(spostBian4.spostamentoSemplice(test));
        assertTrue(spostNer4.presaSemplice(test));
        assertTrue(spostBian5.spostamentoSemplice(test));
        assertTrue(spostNer5.spostamentoSemplice(test));
        assertTrue(spostBian6.spostamentoSemplice(test));
        assertTrue(spostNer6.spostamentoSemplice(test));
        assertTrue(spostBian7.spostamentoSemplice(test));
        assertTrue(spostNer7.spostamentoSemplice(test));
        assertTrue(spostBian8.spostamentoSemplice(test));
        assertTrue(spostNer8.spostamentoSemplice(test));
        assertTrue(spostBian9.spostamentoSemplice(test));
        assertTrue(spostNer9.spostamentoSemplice(test));
        assertTrue(prmult.presaMultipla(test));

    }

}