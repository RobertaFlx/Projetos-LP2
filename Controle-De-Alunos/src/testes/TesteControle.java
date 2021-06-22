package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controle.Controle;


class TesteControle {

	//nao testei o construtor
	
	private Controle c1;

	@BeforeEach
	public void initTestControle() {
		c1 = new Controle();
		c1.cadastrarAluno("111111111", "Roberta Felix", "Computação");
		c1.cadastrarAluno("111111222","Rebeca Freire", "Computação");
		c1.cadastrarAluno("111111555","Robson Ferreira", "Farmácia");
		c1.cadastrarGrupo("Programação OO","Computação");
		c1.cadastrarGrupo("Língua Portuguesa","");
		c1.alocarAluno("111111111","Programação OO");
		c1.registrarAlunoQueRespondeu("111111222");
		c1.registrarAlunoQueRespondeu("111111555");
	}
	
	/**
	 * TESTANTO O CADASTRO DE UM ALUNO
	 */
	@Test
	void testElseCadastrarAluno() {
		String esperado = "CADASTRO REALIZADO!";
		assertEquals(esperado,c1.cadastrarAluno("111111333","Renata Fernardes","Nutrição"));
	}
	
	/**
	 * TESTANTO O CADASTRO DE UM ALUNO QUE JÁ FOI CADASTRADO 
	 */
	@Test 
	void testIfCadastrarAluno() {
		String esperado = "MATRÍCULA JÁ CADASTRADA!";
		assertEquals(esperado,c1.cadastrarAluno("111111111","Roberta Felix", "Computação"));
	} 
	
	/**
	 * TESTANTO A EXIBIÇÃO DOS DADOS FORMATADOS DE UM ALUNO
	 */ 
	@Test
	void testIfExibirAluno() {
		String esperado = "Aluno: 111111222 - Rebeca Freire - Computação";
		assertEquals(esperado,c1.exibirAluno("111111222"));
	}
	
	/**
	 * TESTANTO A EXIBIÇÃO DE UM ALUNO NÃO CADASTRADO
	 */
	@Test
	void testElseExibirAluno() {
		String esperado = "ALUNO NÃO CADASTRADO!";
		assertEquals(esperado,c1.exibirAluno("111111444"));
	}
	
	/**
	 * TESTANDO O CADASTRO DE UM GRUPO QUE JÁ FOI CADASTRADO
	 */
	@Test 
	void testIfCadastrarGrupo() {
		String esperado = "GRUPO JÁ CADASTRADO!";
		assertEquals(esperado,c1.cadastrarGrupo("língua portuguesa","")); // NÃO OCORRE DISTINÇÃO ENTRE LETRAS MAIÚSCULAS E MINÚSCULAS
	}
	
	/**
	 * TESTANTO O CADASTRO DE UM GRUPO
	 */
	@Test
	void testElseCadastrarGrupo() {
		String esperado = "GRUPO CADASTRADO!";
		assertEquals(esperado,c1.cadastrarGrupo("Química Orgânica","Farmácia"));
	}
	
	/**
	 * TESTANDO ALOCAÇÃO DE UM ALUNO NÃO CADASTRADO EM UM GRUPO
	 */
	@Test 
	void testIfAlocarAluno() {
		String esperado = "ALUNO NÃO CADASTRADO!";
		assertEquals(esperado,c1.alocarAluno("111111000","Programação OO"));
	}
	
	/**
	 * TESTANDO ALOCAÇÃO DE UM ALUNO EM UM GRUPO NÃO CADASTRADO
	 */
	@Test 
	void testElseIfAlocarAluno() {
		String esperado = "GRUPO NÃO CADASTRADO!";
		assertEquals(esperado,c1.alocarAluno("111111222","Metodologia"));
	}
	
	/**
	 * TESTANDO ALOCAÇÃO DE UM ALUNO DE OUTRO CURSO EM UM GRUPO COM RESTRIÇÃO DE CURSO
	 */
	@Test 
	void testElseElseIfAlocarAluno() {
		String esperado = "GRUPO COM RESTRIÇÃO DE CURSO!";
		assertEquals(esperado,c1.alocarAluno("111111555","Programação OO"));
	}
	
	/**
	 * TESTANDO ALOCAÇÃO DE UM ALUNO EM UM GRUPO
	 */
	@Test 
	void testElseElseElseAlocarAluno() {
		String esperado = "ALUNO ALOCADO!";
		assertEquals(esperado,c1.alocarAluno("111111222","Língua Portuguesa"));
	}
	
	/**
	 * TESTANDO ALOCAÇÃO DE UM ALUNO JÁ CADASTRADO EM UM GRUPO NESSE MESMO GRUPO
	 */
	@Test 
	void testAlocarMesmoAluno() {
		String esperado = "ALUNO ALOCADO!";
		assertEquals(esperado,c1.alocarAluno("111111111","Programação OO"));
	}
	
	/**
	 * TESTANDO PERTINÊNCIA DE UM ALUNO NÃO CADASTRADO A UM GRUPO
	 */
	@Test 
	void testIfVerificarPertinencia() {
		String esperado = "ALUNO NÃO CADASTRADO!";
		assertEquals(esperado,c1.verificarPertinencia("Programação OO","111111444"));
	}
	
	/**
	 * TESTANDO PERTINÊNCIA DE UM ALUNO A UM GRUPO NÃO CADASTRADO
	 */
	@Test 
	void testElseIfVerificarPertinencia() {
		String esperado = "GRUPO NÃO CADASTRADO!";
		assertEquals(esperado,c1.verificarPertinencia("Metodologia","111111222"));
	}
	
	/**
	 * TESTANDO PERTINÊNCIA DE UM ALUNO PERTENCENTE AO GRUPO
	 */
	@Test 
	void testElseElseIfVerificarPertinencia() {
		String esperado = "ALUNO PERTENCE AO GRUPO";
		assertEquals(esperado,c1.verificarPertinencia("Programação OO","111111111"));
	}
	
	/**
	 * TESTANDO PERTINÊNCIA DE UM ALUNO NÃO PERTENCENTE AO GRUPO
	 */
	@Test 
	void testElseElseElseVerificarPertinencia() {
		String esperado = "ALUNO NÃO PERTENCE AO GRUPO";
		assertEquals(esperado,c1.verificarPertinencia("Língua Portuguesa","111111555"));
	}
	
	/**
	 * TESTANDO REGISTRAR UM ALUNO NÃO CADASTRADO À LISTA DOS ALUNOS QUE RESPONDERAM
	 */
	@Test 
	void testIfRegistrarAlunoQueRespondeu() {
		String esperado = "ALUNO NÃO CADASTRADO!";
		assertEquals(esperado,c1.registrarAlunoQueRespondeu("111111000"));
	}
	
	/**
	 * TESTANDO REGISTRAR UM ALUNO À LISTA DOS ALUNOS QUE RESPONDERAM
	 */
	@Test 
	void testElseRegistrarAlunoQueRespondeu() {
		String esperado = "ALUNO REGISTRADO!";
		assertEquals(esperado,c1.registrarAlunoQueRespondeu("111111111"));
	}
	
	/**
	 * TESTANDO A IMPRESSÃO DA LISTA DOS ALUNOS QUE RESPONDERAM
	 */ 
	@Test 
	void testImprimeAlunosQueResponderam() {
		String esperado = "Alunos:" + "\n" + "1. 111111222 - Rebeca Freire - Computação" + "\n" + "2. 111111555 - Robson Ferreira - Farmácia";
		assertEquals(esperado,c1.imprimeAlunosQueResponderam());
	}
	
	/**
	 * TESTANDO A CONTAGEM DE GRUPOS COM RESTRIÇÃO
	 */
	@Test 
	void testContadorDeGruposComRestricao() {
		String esperado = "Computação 1";
		assertEquals(esperado,c1.contadorDeGruposComRestricao("Computação"));
	}
}
