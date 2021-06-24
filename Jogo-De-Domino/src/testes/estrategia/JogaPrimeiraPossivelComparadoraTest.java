package testes.estrategia;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Mesa;
import domino.Peca;
import domino.PecaPadraoComparator;
import domino.Jogada.TipoJogada;
import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.JogaPrimeiraPossivelComparadora;

class JogaPrimeiraPossivelComparadoraTest {
	
	private Mesa m1;
	private Mesa m2;
	Comparator<Peca> cmp = new PecaPadraoComparator();

	@BeforeEach
	void setUp() throws Exception {
		m1 = new Mesa();
		m2 = new Mesa();
		m1.jogaNaDireita(new Peca(1, 2));
		m1.jogaNaEsquerda(new Peca(1, 1));  
	}
	
	/**
	 * TESTANDO SE A ESTRATÉGIA ORDENA A MÃO CORRETAMENTE E PASSA A VEZ SE NENHUMA PEÇA ENCAIXAR
	 */
	@Test
	void testPassa() {
		EstrategiaDeJogo estrategia = new JogaPrimeiraPossivelComparadora(cmp);
		
		List<Peca> mao = new LinkedList<Peca>();
		mao.add(new Peca(4, 3));
		mao.add(new Peca(4, 4));
		mao.add(new Peca(3, 3));
		
		Jogada j1 = estrategia.decideJogada(mao, m1);
		assertEquals(TipoJogada.PASSA, j1.getTipo());
		assertEquals("[3:3, 4:3, 4:4]", mao.toString());
	}
	
	/**
	 * TESTANDO SE A ESTRATÉGIA ORDENA A MÃO CORRETAMENTE E JOGA A PRIMEIRA PEÇA NA DIREITA CASO NÃO TIVER NENHUMA PEÇA NA MESA
	 */
	@Test
	void testJogaPrimeiro() {
		EstrategiaDeJogo estrategia = new JogaPrimeiraPossivelComparadora(cmp);
		
		List<Peca> mao = new LinkedList<Peca>();
		mao.add(new Peca(2, 4));
		mao.add(new Peca(3, 4));
		mao.add(new Peca(2, 5));

		Jogada j1 = estrategia.decideJogada(mao, m2);
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(2, j1.getPeca().getNumEsquerdo());
		assertEquals(4, j1.getPeca().getNumDireito());
		assertEquals("[2:4, 2:5, 3:4]", mao.toString());
	} 
	 
	/**
	 * TESTANDO SE A ESTRATÉGIA ORDENA A MÃO CORRETAMENTE E JOGA A PRIMEIRA PEÇA QUE ENCAIXA NA ESQUERDA
	 */
	@Test
	void testJogaEsquerda() {
		EstrategiaDeJogo estrategia = new JogaPrimeiraPossivelComparadora(cmp);
		
		List<Peca> mao = new LinkedList<Peca>();
		mao.add(new Peca(2, 3));
		mao.add(new Peca(2, 2));
		mao.add(new Peca(1, 2));
		mao.add(new Peca(1, 1));
		
		Jogada j1 = estrategia.decideJogada(mao, m1);
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(1, j1.getPeca().getNumDireito());
		assertEquals("[1:1, 1:2, 2:2, 2:3]", mao.toString());	
	}  
  
	/**
	 * TESTANDO SE A ESTRATÉGIA ORDENA A MÃO CORRETAMENTE E JOGA A PRIMEIRA PEÇA QUE ENCAIXA NA DIREITA
	 */
	@Test
	void testdireita() {
		EstrategiaDeJogo estrategia = new JogaPrimeiraPossivelComparadora(cmp);
		
		List<Peca> mao = new LinkedList<Peca>();
		mao.add(new Peca(2, 3));
		mao.add(new Peca(1, 4));
		mao.add(new Peca(1, 2));
		mao.add(new Peca(1, 6));
		
		Jogada j1 = estrategia.decideJogada(mao, m1);
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());
		assertEquals(1, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
		assertEquals("[1:2, 1:4, 1:6, 2:3]", mao.toString());
	}   
	 
}
