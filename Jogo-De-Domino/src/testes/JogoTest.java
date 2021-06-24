package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.HistoricoDeJogo;
import domino.JogadaInvalidaException;
import domino.Jogo;
import domino.Mesa;
import domino.Peca;
import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.JogaPrimeiraPossivel;

class JogoTest {
    
	private Mesa m1;
	private Mesa m2; 

	@BeforeEach
	void setUp() throws Exception {
		m1 = new Mesa(); 
		m2 = new Mesa();
		m1.jogaNaDireita(new Peca(2, 3));
		m1.jogaNaDireita(new Peca(3, 4));
		m2.jogaNaDireita(new Peca(1, 6));
		m2.jogaNaEsquerda(new Peca(6, 1)); 
		
	}
	
	/**
	 * TESTANDO A RODADA INICIAL DE UM JOGO
	 * @throws JogadaInvalidaException
	 * @throws EstrategiaInvalidaException
	 */
	@Test
	void testRodadaInicial() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 14);

		assertEquals(0, j.getNumRodadas());
		assertEquals(14, j.getNumPecasJ1());
		assertEquals(14, j.getNumPecasJ2());

		j.rodada();

		assertEquals(1, j.getNumRodadas());
		assertEquals(13, j.getNumPecasJ1());
		assertEquals(13, j.getNumPecasJ2());
	}
	
	/**
	 * TESTANDO UM JOGO ALEATÓRIO
	 * @throws JogadaInvalidaException
	 * @throws EstrategiaInvalidaException
	 */
	@Test
	void testJogoAleatorio() throws JogadaInvalidaException, EstrategiaInvalidaException {
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), 10, new Random(1));

		HistoricoDeJogo historico = j.jogaJogoCompleto();

		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
		
		System.out.println(historico.toString());
	}

	/**
	 * TENTANDO UMA VITÓRIA DO JOGADOR 1
	 * @throws Exception
	 */
	@Test
	void testVencedorJ1Simples() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(0, 1));
		List<Peca> mao2 = List.of(new Peca(0, 2), new Peca(0, 3));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		assertFalse(j.isFinalizado());
		assertEquals(null, j.getVencedor());

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J1", j.getVencedor());
	}
	
	/**
	 * TESTANDO UM CASO DE EMPATE
	 * @throws Exception
	 */
	@Test
	void testEmpate() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(4, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(5, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertNull(j.getVencedor());
	}
	
	/**
	 * TESTANDO UMA VITÓRIA DO JOGADOR 2
	 * @throws Exception
	 */
	@Test
	void testVitoriaJ2() throws Exception {
		List<Peca> mao1 = List.of(new Peca(0, 0), new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(0, 1), new Peca(1, 2));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertTrue(j.isFinalizado());
		assertEquals("J2", j.getVencedor());
	} 
	
	/**
	 * TESTANDO SE TODOS OS TIPOS DE VITÓRIA ESTÃO SENDO ATRIBUIDOS CORRETAMENTE
	 * @throws Exception
	 */
	@Test
	void testGetTiposDeVitoria() throws Exception {
		List<Peca> mao1 = List.of(new Peca(2, 4), new Peca(2, 2));
		List<Peca> mao2 = List.of(new Peca(6, 6), new Peca(1, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		j.getTipoDeVitoria(m1, mao1.get(0));
		assertEquals("LA E LO", j.getTipo());
		
		j.getTipoDeVitoria(m1, mao1.get(1)); 
		assertEquals("CARROCA", j.getTipo());
		
		j.getTipoDeVitoria(m2, mao2.get(0));
		assertEquals("LA E LO E CARROCA", j.getTipo());
		
		j.getTipoDeVitoria(m2, mao2.get(1));
		assertEquals("NORMAL", j.getTipo());
		
		j.getTipoDeVitoria(m2, null);
		assertEquals("NORMAL", j.getTipo());  
		
	} 

	/**
	 * TESTANDO O DESEMPATE SE O J1 TIVER UMA QUANTIDADE DE PEÇAS MENOR QUE J2
	 * @throws Exception
	 */
	@Test
	void testIfDesempatarJogo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(1, 2),new Peca(4, 4));
		List<Peca> mao2 = List.of(new Peca(2, 2), new Peca(6, 5), new Peca(6, 6));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertEquals("J1", j.getVencedor());
		assertEquals("NORMAL", j.getTipo());
		assertTrue(j.desempatarJogo()); 
		
	}
	
	/**
	 * TESTANDO O DESEMPATE SE O J2 TIVER UMA QUANTIDADE DE PEÇAS MENOR QUE J1
	 * @throws Exception
	 */
	@Test
	void testElseIfDesempatarJogo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(1, 2),new Peca(4, 4),new Peca(6, 6));
		List<Peca> mao2 = List.of(new Peca(2, 2), new Peca(6, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertEquals("J2", j.getVencedor());
		assertEquals("NORMAL", j.getTipo());
		assertTrue(j.desempatarJogo()); 
		
	}
	
	/**
	 * TESTANDO O DESEMPATE SE A SOMA DAS PEÇAS DE J1 FOR MENOR QUE A DE J2
	 * @throws Exception
	 */
	@Test
	void testElseElseIfDesempatarJogo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(3, 3),new Peca(4, 4));
		List<Peca> mao2 = List.of(new Peca(6, 6), new Peca(3, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertEquals("J1", j.getVencedor());
		assertEquals("NORMAL", j.getTipo());
		assertTrue(j.desempatarJogo()); 
		
	}  
	
	/**
	 * TESTANDO O DESEMPATE SE A SOMA DAS PEÇAS DE J2 FOR MENOR QUE A DE J1
	 * @throws Exception
	 */
	@Test
	void testElseElseElseDesempatarJogo() throws Exception {
		List<Peca> mao1 = List.of(new Peca(6, 6),new Peca(5, 5));
		List<Peca> mao2 = List.of(new Peca(3, 6), new Peca(4, 5));
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), "J2", new JogaPrimeiraPossivel(), mao1, mao2);

		j.jogaJogoCompleto();
		
		assertEquals("J2", j.getVencedor());
		assertEquals("NORMAL", j.getTipo());
		assertTrue(j.desempatarJogo());   
		
	}
	
}
