package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Peca;
import domino.Jogada.TipoJogada;

class JogadaTest { 

	/**
	 * TESTANDO UMA JOGADA QUE PASSA A VEZ
	 */
	@Test
	void testJogadaPassa() {
		Jogada j1 = new Jogada();
		assertEquals(TipoJogada.PASSA, j1.getTipo());
		assertEquals("Passou", j1.getTipoEmString());
	}

	/**
	 * TESTANDO UMA JOGADA NA ESQUERDA
	 */
	@Test
	void testJogadaNaEsquerda() {
		Jogada j1 = new Jogada(new Peca(1, 1), TipoJogada.NA_ESQUERDA);
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals("na esquerda", j1.getTipoEmString()); 
	}

	/**
	 * TESTANDO UMA JOGADA NA DIREITA 
	 */
	@Test
	void testStringNaDireita() {
		Jogada j1 = new Jogada(new Peca(5, 6), TipoJogada.NA_DIREITA);
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals("na direita", j1.getTipoEmString());
	}
	
}
