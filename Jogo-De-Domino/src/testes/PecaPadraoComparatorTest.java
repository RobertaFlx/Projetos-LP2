package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import domino.Peca;
import domino.PecaPadraoComparator;


class PecaPadraoComparatorTest {

	Comparator<Peca> cmp = new PecaPadraoComparator();
	
	/**
	 * TESTANDO SE CASO DUAS PEÇAS FOREM IGUAIS, RETORNA 0
	 */
	@Test
	void testIguais() {
		assertEquals(0, cmp.compare(new Peca(2, 4),new Peca(2, 4))); 
	}

	/**
	 * TESTANDO SE CASO A PRIMEIRA PEÇA POSSUIR O NÚMERO DA ESQUERDA MENOR QUE A SEGUNDA PEÇA, RETORNA -1
	 */
	@Test
	void testPrimeiraEsquerdaMenor() {
		assertEquals(-1, cmp.compare(new Peca(0, 2),new Peca(1, 5)));
	}
	
	/**
	 * TESTANDO SE CASO A SEGUNDA PEÇA POSSUIR O NÚMERO DA ESQUERDA MENOR QUE A PRIMEIRA PEÇA, RETORNA 1
	 */
	@Test
	void testSegundaEsquerdaMenor() {
		assertEquals(1, cmp.compare(new Peca(6, 3),new Peca(4, 3)));
	}
	
	
	/**
	 * TESTANDO SE CASO A PRIMEIRA PEÇA POSSUIR O NÚMERO DA DIREITA MENOR QUE A SEGUNDA PEÇA, RETORNA -1
	 */
	@Test
	void testPrimeiraDireitaMenor() {
		assertEquals(-1, cmp.compare(new Peca(1, 2),new Peca(1, 5)));
	}
	
	/**
	 * TESTANDO SE CASO A SEGUNDA PEÇA POSSUIR O NÚMERO DA DIREITA MENOR QUE A PRIMEIRA PEÇA, RETORNA 1
	 */
	@Test
	void testSegundaDireitaMenor() {
		assertEquals(1, cmp.compare(new Peca(3, 4),new Peca(3, 3))); 
	}
	
}
