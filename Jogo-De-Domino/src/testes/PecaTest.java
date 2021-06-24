package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domino.Mesa;
import domino.Peca;

class PecaTest {

	private Mesa m1; 

	@BeforeEach
	void setUp() throws Exception {
		m1 = new Mesa(); ;
		m1.jogaNaDireita(new Peca(4, 3));
		m1.jogaNaDireita(new Peca(3, 6));
	}
	
    /**
     * TESTANDO SE O NÚMERO DIREITO DE UMA PEÇA ESTÁ SENDO PASSADO CORRETAMENTE
     */
	@Test
	void testGetNumDireito() {
		assertEquals(1, (new Peca(6, 1)).getNumDireito());
		assertEquals(3, (new Peca(3, 3)).getNumDireito());
	}

	/**
     * TESTANDO SE O NÚMERO ESQUERDO DE UMA PEÇA ESTÁ SENDO PASSADO CORRETAMENTE
     */
	@Test
	void testGetNumEsquerdo() {
		assertEquals(6, (new Peca(6, 1)).getNumEsquerdo());
		assertEquals(3, (new Peca(3, 3)).getNumEsquerdo());
	}

	/**
	 * TESTANDO SE A PEÇA ESTÁ SENDO GIRADA CORRETAMENTE
	 */
	@Test
	void testGira() {
		Peca peca = new Peca(6, 1);  
		
		peca.gira();
		assertEquals(6, peca.getNumDireito());
		assertEquals(1, peca.getNumEsquerdo());
		
		peca.gira();
		assertEquals(1, peca.getNumDireito());
		assertEquals(6, peca.getNumEsquerdo());
	}
	
	/**
	 * TESTANDO A FORMATAÇÃO DAS PEÇAS
	 * @throws Exception
	 */
	@Test
	void testToString(){
		assertEquals("6:1", (new Peca(6, 1)).toString());
		assertEquals("3:3", (new Peca(3, 3)).toString());
	}
	
	/**
	 * TESTANDO SE A PEÇA ENCAIXA NOS LADOS DE UMA MESA
	 */
	@Test
	void testEncaixa(){
		assertTrue((new Peca(6, 1)).encaixa(m1.getNumNaDireita()));
		assertFalse((new Peca(6, 1)).encaixa(m1.getNumNaEsquerda()));
		
		assertTrue((new Peca(2, 4)).encaixa(m1.getNumNaEsquerda()));
		assertFalse((new Peca(2, 4)).encaixa(m1.getNumNaDireita()));
		
		assertFalse((new Peca(3, 3)).encaixa(m1.getNumNaEsquerda()));
		assertFalse((new Peca(3, 3)).encaixa(m1.getNumNaDireita()));
	}
	
	/**
	 * TESTANDO SE A PEÇA TEM LADOS IGUAIS
	 */
	@Test
	void testLadosIguais(){
		assertTrue((new Peca(2, 2)).verificaSeTemLadosIguais());
		assertFalse((new Peca(4, 1)).verificaSeTemLadosIguais());
	}
	
	/**
	 * TESTANDO SE A SOMA DOS LADOS DA PEÇA ESTÃO SENDO FEITOS CORRETAMENTE
	 */
	@Test
	void testSomaLados(){
		assertEquals(5, (new Peca(2, 3)).somaLados());
		assertEquals(6, (new Peca(4, 2)).somaLados()); 
	}
	
}
