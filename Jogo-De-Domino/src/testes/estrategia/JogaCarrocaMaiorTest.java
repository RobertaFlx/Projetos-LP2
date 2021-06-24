package testes.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Mesa;
import domino.Peca;
import domino.Jogada.TipoJogada;
import domino.estrategia.JogaCarrocaMaior;

class JogaCarrocaMaiorTest {  

	private Mesa m1;
	private Mesa m2;

	@BeforeEach
	void setUp() throws Exception {
		m1 = new Mesa();
		m2 = new Mesa();
		m1.jogaNaDireita(new Peca(3, 2));
		m1.jogaNaEsquerda(new Peca(5, 3));   
	}

    /**
     * TESTANDO SE A MAIOR CARROÇA É JOGADA NA DIREITA QUANDO NÃO EXISTE PEÇAS NA MESA
     */
	@Test
	void testJogaPrimeiro() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior(); 

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(4, 2), new Peca(6, 6)), m2);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());  
		assertEquals(6, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}
	
	/**
	 * TESTANDO SE ESTÁ PASSANDO A VEZ CORRETAMENTE
	 */
	@Test
	void testPassa() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(4, 4), new Peca(0, 0)), m1);

		assertEquals(TipoJogada.PASSA, j1.getTipo());
	}

	/**
	 * TESTANDO SE A MAIOR CARROÇA QUE ENCAIXA NA DIREITA ESTÁ SENDO JOGADA NA DIREITA
	 */
	@Test
	void testJogaMaiorNaDireita() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(2, 2), new Peca(2, 6)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	/**
	 * TESTANDO SE A MAIOR CARROÇA QUE ENCAIXA NA ESQUERDA ESTÁ SENDO JOGADA NA ESQUERDA 
	 */
	@Test
	void testJogaMaiorNaEsquerda() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(5, 5), new Peca(2, 6)), m1);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo()); 
		assertEquals(5, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito());
	}
			
	/**
	 * TESTANTO SE A PRIMEIRA CARROÇA QUE ENCAIXA NA DIREITA ESTÁ SENDO JOGADA NA DIREITA
	 */
	@Test
	void testJogaCarrocaNaDireita() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(4, 4), new Peca(2, 1), new Peca(2, 2), new Peca(6, 6)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	 
	/**
	 * TESTANTO SE A PRIMEIRA CARROÇA QUE ENCAIXA NA ESQUERDA ESTÁ SENDO JOGADA NA ESQUERDA
	 */
	@Test
	void testJogaCarrocaNaEsquerda() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(5, 5), new Peca(6, 6)), m1);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo()); 
		assertEquals(5, j1.getPeca().getNumEsquerdo());
		assertEquals(5, j1.getPeca().getNumDireito()); 
	}
	
	/**
	 * TESTANTO SE A PRIMEIRA PEÇA QUE NÃO É CARROÇA E QUE ENCAIXA NA DIREITA ESTÁ SENDO JOGADA NA DIREITA
	 */
	@Test 
	void testJogaPecaNaDireita() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(4, 1), new Peca(2, 6)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
	}

	/**
	 * TESTANTO SE A PRIMEIRA PEÇA QUE NÃO É CARROÇA E QUE ENCAIXA NA ESQUERDA ESTÁ SENDO JOGADA NA ESQUERDA
	 */
	@Test
	void testJogaPecaNaEsquerda() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(3, 4), new Peca(5, 1)), m1);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo()); 
		assertEquals(5, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito()); 
	}
	
	/**
	 * TESTANDO SE CASO O JOGADOR NÃO TIVER CARROÇAS, O MÉTODO GETMAIORCARROCA() RETORNA PARA ELE A PRIMEIRA PEÇA QUE ELE TIVER NA MÃO
	 */
	@Test
	void testJogadorSemCarrocas() {
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 2), new Peca(1, 4), new Peca(5, 3)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito()); 
	}
	 
	/**
	 * TESTANDO SE CASO A PEÇA A SER JOGADA ENCAIXE TANTO NA DIREITA QUANTO NA ESQUERDA, A PEÇA SERÁ JOGADA NA DIREITA
	 */
	@Test
	void testPrefereDireita() { 
		JogaCarrocaMaior estrategia = new JogaCarrocaMaior();

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(5, 2)), m1);

		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo()); 
		assertEquals(5, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());  
	}

} 


