package testes.estrategia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Mesa;
import domino.Peca;
import domino.Jogada.TipoJogada;
import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaDeJogoComposta;
import domino.estrategia.JogaCarrocaMaior;
import domino.estrategia.JogaPrimeiraPossivel;

class EstrategiaDeJogoCompostaTest {  
 
	private Mesa m1;
	List<EstrategiaDeJogo> estrategias = new ArrayList<>();

	@BeforeEach
	void setUp() throws Exception {
		m1 = new Mesa();
		m1.jogaNaDireita(new Peca(4,6));
		
		JogaPrimeiraPossivel estrategia1 = new JogaPrimeiraPossivel();
		JogaCarrocaMaior estrategia2 = new JogaCarrocaMaior();
		
		estrategias.add(estrategia1);
		estrategias.add(estrategia2);
 
	}
	
	/**
     * TESTANDO SE A ESTRATÉGIA AINDA NÃO TIVER JOGADO NENHUMA VEZ OU SE TIVER JOGADO UM NÚMERO PAR DE VEZES, JOGARÁ COM A PRIMEIRA ESTRATÉGIA
     */
	@Test
	void testContadorPar() { 
		
		EstrategiaDeJogoComposta estrategia = new  EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(1, 1), new Peca(4, 2), new Peca(6, 6)), m1);

		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());  
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
	}
	
	/**
     * TESTANDO SE A ESTRATÉGIA TIVER JOGADO UM NÚMERO IMPAR DE VEZES, JOGARÁ COM A SEGUNDA ESTRATÉGIA
     */
	@Test
	void testContadorImpar() { 
		EstrategiaDeJogoComposta estrategia = new  EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 1), new Peca(4, 2), new Peca(6, 6)), m1); //JOGA 4,2 NA ESQUERDA E O CONTADOR PASSA A SER 1.
		
		assertEquals(TipoJogada.NA_ESQUERDA, j1.getTipo());  
		assertEquals(4, j1.getPeca().getNumEsquerdo());
		assertEquals(2, j1.getPeca().getNumDireito());
		
		Jogada j2 = estrategia.decideJogada(List.of(new Peca(3, 1), new Peca(6, 6)), m1); // COMO 1 É IMPAR, JOGAMOS COM A SEGUNDA ESTRATÉGIA

		assertEquals(TipoJogada.NA_DIREITA, j2.getTipo());  
		assertEquals(6, j2.getPeca().getNumEsquerdo());
		assertEquals(6, j2.getPeca().getNumDireito());
	}
	
	/**
     * TESTANDO SE EM CASO DE NENHUMA PEÇA ENCAIXAR, A PRIMEIRA ESTRATÉGIA IRÁ PASSAR
     */
	@Test
	void testPrimeiraPassa() { 
		EstrategiaDeJogoComposta estrategia = new  EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 1), new Peca(3, 2), new Peca(5, 1)), m1);
		assertEquals(TipoJogada.PASSA, j1.getTipo());  
	}
	
	/**
     * TESTANDO SE EM CASO DE NENHUMA PEÇA ENCAIXAR, A SEGUNDA ESTRATÉGIA IRÁ PASSAR
     */
	@Test
	void testSegundaPassa() { 
		EstrategiaDeJogoComposta estrategia = new  EstrategiaDeJogoComposta(estrategias);

		Jogada j1 = estrategia.decideJogada(List.of(new Peca(3, 1), new Peca(3, 6)), m1); //JOGA 3,6 NA DIREITA E O CONTADOR PASSA A SER 1.
		
		assertEquals(TipoJogada.NA_DIREITA, j1.getTipo());  
		assertEquals(3, j1.getPeca().getNumEsquerdo());
		assertEquals(6, j1.getPeca().getNumDireito());
		
		Jogada j2 = estrategia.decideJogada(List.of(new Peca(3, 1)), m1); // COMO 1 É IMPAR, JOGAMOS COM A SEGUNDA ESTRATÉGIA
		assertEquals(TipoJogada.PASSA, j2.getTipo()); 
	}
	
}
