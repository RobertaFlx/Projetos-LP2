package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controle.Aluno;

class TesteAluno {

	/**
	 * TESTANDO A CONTRUÇÃO DE UM ALUNO.
	 */
	@Test
	void testConstrutor() {
		Aluno a0 = new Aluno("Roberta Felix", "Computação", "111111111");
	}
	
	Aluno a1 = new Aluno("Roberta Felix", "Computação", "111111111");  //CRIANDO ALUNO PARA USAR NO PRÓXIMO TESTE

	/**
	 * TESTE PARA VER SE A FORMATAÇÃO DOS DADOS DO ALUNO ESTÃO SENDO PRINTADOS CORRETAMENTE
	 */
	@Test
	void testToString() {
		String esperado = "111111111 - Roberta Felix - Computação";
		assertEquals(esperado, a1.toString());
	}

}
