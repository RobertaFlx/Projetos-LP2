package testes.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Mesa;
import domino.Peca;
import domino.Jogada.TipoJogada;
import domino.estrategia.JogaPecaMaior;

class JogaPecaMaiorTest {

	private Mesa m1; 
	private Mesa m2; 

	@BeforeEach
	void setUp() throws Exception {
		m1 = new Mesa();
		m2 = new Mesa();
		m1.jogaNaDireita(new Peca(3, 5));
		m1.jogaNaEsquerda(new Peca(1, 3));  
	}

	/**
     * TESTANDO SE A PEÇA MAIOR É JOGADA NA DIREITA QUANDO NÃO EXISTE PEÇAS NA MESA
     */
	@Test
	void testJogaPrimeiro() {
		JogaPecaMaior estrategia = new JogaPecaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 4), new Peca(3, 3), new Peca(6, 5)), m2);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(6, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	}
	
	/**
	 * TESTANDO SE ESTÁ PASSANDO A VEZ CORRETAMENTE
	 */
	@Test
	void testPassa() {
		JogaPecaMaior estrategia = new JogaPecaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 4),new Peca(2, 4)), m1);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}
	
	/**
	 * TESTANDO SE A PEÇA MAIOR QUE ENCAIXA NA DIREITA ESTÁ SENDO JOGADA NA DIREITA
	 */
	@Test
	void testJogaMaiorNaDireita() { 
		JogaPecaMaior estrategia = new JogaPecaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(2, 3), new Peca(2, 5)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	} 
	
	/**
	 * TESTANDO SE A PEÇA MAIOR QUE ENCAIXA NA ESQUERDA ESTÁ SENDO JOGADA NA ESQUERDA
	 */
	@Test
	void testJogaMaiorNaEsquerda() {
		JogaPecaMaior estrategia = new JogaPecaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(2, 3), new Peca(1, 6)), m1);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo()); 
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());  
	}
	
	/**
	 * TESTANTO SE A PRIMEIRA PEÇA QUE ENCAIXA NA DIREITA ESTÁ SENDO JOGADA NA DIREITA
	 */
	@Test
	void testJogaPecaNaDireita() {
		JogaPecaMaior estrategia = new JogaPecaMaior(); 

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 3), new Peca(2, 5),new Peca(6, 6)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	}
 
	/**
	 * TESTANTO SE A PRIMEIRA PEÇA QUE ENCAIXA NA ESQUERDA ESTÁ SENDO JOGADA NA ESQUERDA
	 */
	@Test
	void testJogaPecaNaEsquerda() {  
		JogaPecaMaior estrategia = new JogaPecaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(0, 0),new Peca(4, 1), new Peca(4, 6)), m1);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo()); 
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());  
	}
	
	/**
	 * TESTANDO SE CASO A PEÇA A SER JOGADA ENCAIXE TANTO NA DIREITA QUANTO NA ESQUERDA, A PEÇA SERÁ JOGADA NA DIREITA
	 */
	@Test
	void testPrefereDireita() { 
		JogaPecaMaior estrategia = new JogaPecaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 5)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());  
	}
	 
}


