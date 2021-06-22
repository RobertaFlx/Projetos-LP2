package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Aluno;
import controle.Grupo;

class TesteGrupo {

	/**
	 * CRIANDO GRUPO E ALUNOS PARA USAR NOS PRÓXIMOS TESTES
	 */
	Grupo g1 = new Grupo("Programação", "Computação");
	
	Aluno a1 = new Aluno("Roberta Felix", "Computação", "111111111");
	
	Aluno a2 = new Aluno("Rebeca Freire", "Computação", "111111222");
	
	/**
	 * TESTANDO A CONTRUÇÃO DE UM GRUPO.
	 */
	@Test
	void testConstrutor() {
		Grupo g0 = new Grupo("Programação", "Computação");
	}
	
	/**
	 * TESTANDO SE UM ALUNO ESTÁ SENDO ALOCADO CORRETAMENTE EM UM GRUPO
	 */
	@Test
	void testSetAluno() {
		g1.setAluno(a1);
	}
	
	/**
	 * ALOCANDO UM ALUNO EM UM GRUPO
	 */
	@BeforeEach
	public void initTestGrupo() {
		g1.setAluno(a1);
	}
	
	/**
	 * TESTANDO SE UM ALUNO PERTECE A UM GRUPO
	 */
	@Test
	void testContemAluno() {
		assertTrue(g1.contemAluno(a1));
		assertFalse(g1.contemAluno(a2));
	}

}
