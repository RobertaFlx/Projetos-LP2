package testes.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Mesa;
import domino.Peca;
import domino.Jogada.TipoJogada;
import domino.estrategia.JogaPrimeiraPossivel;

class JogaPrimeiraPossivelTest {

	private Mesa m1;
	private Mesa m2;

	@BeforeEach
	void setUp() throws Exception {
		m1 = new Mesa();
		m2 = new Mesa();
		m1.jogaNaDireita(new Peca(1, 2));
		m1.jogaNaEsquerda(new Peca(1, 1)); 
	}

	/**
	 * TESTANDO SE ESTÁ PASSANDO A VEZ CORRETAMENTE
	 */
	@Test
	void testPassa() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 3)), m1);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	/**
     * TESTANDO SE A PRIMEIRA PEÇA É JOGADA NA DIREITA QUANDO NÃO EXISTE PEÇAS NA MESA
     */
	@Test
	void testJogaPrimeiro() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(0, 2), new Peca(2, 6)), m2);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(3, j1.getPeca().getNumDireito());
	}

	/**
	 * TESTANDO SE CASO A PEÇA A SER JOGADA ENCAIXE TANTO NA DIREITA QUANTO NA ESQUERDA, A PEÇA SERÁ JOGADA NA DIREITA
	 */
	@Test
	void testPrefereDireita() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(2, 1), new Peca(2, 6)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());  
	}
	
	/**
	 * TESTANTO SE A PRIMEIRA PEÇA POSSÍVEL QUE ENCAIXA NA ESQUERDA ESTÁ SENDO JOGADA NA ESQUERDA
	 */
	@Test
	void testJogaNaEsquerda() {
		JogaPrimeiraPossivel estrategia = new JogaPrimeiraPossivel();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(4, 4), new Peca(1, 6)), m1);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}

}
