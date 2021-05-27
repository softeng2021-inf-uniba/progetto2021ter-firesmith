package it.uniba.strumenti;

import it.uniba.gioco.Mossa;
import it.uniba.gioco.MossaBianco;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

class ComandoTest {
    Comando test = new Comando();
    @Test
    public void gestioneRegexSpostamentoTest(){
        Mossa mossa = new MossaBianco(9,13);
        assertEquals("spostamento",(test.gestisciRegex(mossa,"9-13")));
    }
    @Test
    public void gestioneRegexPresaTest(){
        Mossa mossa = new MossaBianco(9,13);
        assertEquals("presa semplice",(test.gestisciRegex(mossa,"9x13")));
    }
    @Test
    public void gestioneRegexPresaMultiplaTest(){
        Mossa mossa = new MossaBianco(9,13);
        assertEquals("presa multipla",(test.gestisciRegex(mossa,"9x13x21")));
    }
}