package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import domino.Jogada;
import domino.Jogador;
import domino.Mesa;
import domino.Peca;
import domino.Jogada.TipoJogada;
import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.JogaPrimeiraPossivel;
import domino.estrategia.VisaoDaMesa;

class JogadorTest {

	List<Peca> mao1 = List.of(new Peca(0, 2), new Peca(0, 3));
 
	/**
	 * TESTANDO SE A CONTAGEM DE PEÇAS NA MÃO ESTÁ SENDO FEITA CORRETAMENTE
	 */
	@Test
	void testGetNumPecas() {
		Jogador jogador = new Jogador("j", new JogaPrimeiraPossivel(), mao1);
		assertEquals(2, jogador.getNumPecas()); 
	}

	/**
	 * TESTANDO A REMOÇÃO DE UMA PEÇA DA MÃO
	 */
	@Test
	void testRemovePeca() {
		Jogador jogador = new Jogador("j", new JogaPrimeiraPossivel(), mao1);
		jogador.removeDaMao(mao1.get(0));
		assertEquals(1, jogador.getNumPecas());
	}
	
	@Test
	void testEstrategiaComBug() throws Exception {
		EstrategiaDeJogo errada = new EstrategiaDeJogo() {
			@Override
			public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
				return new Jogada(new Peca(6, 6), TipoJogada.NA_ESQUERDA);
			}
		};
		
		Jogador jogador = new Jogador("j", errada, mao1);
		
		try {
			jogador.decideJogada(new Mesa());
			fail("Deve jogar exceção em caso de decisão impossível da estratégia");
		} catch (EstrategiaInvalidaException e) {
			// esperada
		}
	}

}
