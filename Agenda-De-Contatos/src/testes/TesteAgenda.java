package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import agenda.Agenda;

class TesteAgenda {
	
	private Agenda a1;
	
	/**
	 * CRIANDO UMA AGENDA E CADASTRANDO NELA CONTATOS E FAVORITOS
	 */
	@BeforeEach
	public void initTestAgenda() {
		a1 = new Agenda();
		a1.cadastraContato(1,"Roberta","Felix","(83) 99999-9999","(83) 99999-9999","(83) 3333-3333");
		a1.cadastraContato(3,"Renato","Ferraz","(81) 99999-5555","(81) 99999-5555","");
		a1.cadastraContato(4,"Renan","Ferreira","(83) 99999-9999","(83) 99999-9999","");
		a1.adicionarFavorito(1,1);
		a1.adicionarFavorito(3,2);
	}
	
	/**
	 * TESTANTO UMA POSIÇÃO DE NÚMERO MAIOR DO QUE É PERMITIDO
	 */
	@Test
	void testIfMaiorCadastraContato() {
		String esperado = "POSIÇÃO INVÁLIDA";
		assertEquals(esperado,a1.cadastraContato(101,"Renan","Ferreira","(83) 99999-9999","(83) 99999-9999","(83) 99999-9999"));
	}
	
	/**
	 * TESTANTO UMA POSIÇÃO DE NÚMERO MENOR DO QUE É PERMITIDO
	 */
	@Test
	void testIfMenorCadastraContato() {
		String esperado = "POSIÇÃO INVÁLIDA";
		assertEquals(esperado,a1.cadastraContato(-1,"Renan","Ferreira","(83) 99999-9999","(83) 99999-9999","(83) 99999-9999"));
	}
	
	/**
	 * TESTANTO O CADASTRO DE UM CONTATO
	 */
	@Test
	void testElseElseCadastraContato() {
		String esperado = "CADASTRO REALIZADO";
		assertEquals(esperado,a1.cadastraContato(2,"Renata","Fernardes","(83) 99999-9999","(83) 99999-9999","(83) 99999-9999"));
	}
	
	/**
	 * TESTANTO O CADASTRO DE UM CONTATO QUE JÁ FOI CADASTRADO 
	 */
	@Test
	void testElseIfCadastraContato() {
		String esperado = "CONTATO JÁ CADASTRADO";
		assertEquals(esperado,a1.cadastraContato(3,"Roberta","Felix","(83) 99999-9999","(83) 99999-9999","(83) 3333-3333"));
	}
	
	/**
	 * TESTANDO SE UM CONTATO JÁ ESTÁ CADASTRADO OU NÃO
	 */
	@Test
	void testVerificaContatoCadastrado() {
		assertTrue(a1.verificaContatoCadastrado("Roberta","Felix"));
		assertFalse(a1.verificaContatoCadastrado("Rodrigo","Ferrão"));
	}
	
	/**
	 * TESTANTO A LISTAGEM DE TODOS OS CONTATOS CADASTRADOS
	 */
	@Test
	void testListarContatos() {
		String esperado = "1 - Roberta Felix" + "\n" + "3 - Renato Ferraz" + "\n" + "4 - Renan Ferreira" + "\n";
		assertEquals(esperado,a1.listarContatos());
	}
	
	/**
	 * TESTANTO EXIBIR UMA POSIÇÃO EM QUE NÃO EXISTE CONTATO
	 */
	@Test
	void testIfExibirContato() {
		String esperado = "POSIÇÃO INVÁLIDA!";
		assertEquals(esperado,a1.exibirContato(7));
	}
	
	/**
	 * TESTANTO EXIBIR OS DADOS DE UM CONTATO SALVO COMO FAVORITO
	 */
	@Test
	void testElseIfExibirContato() {
		String esperado = "❤️" + " Roberta Felix" + "\n" + "(83) 99999-9999 (Prioritário)" + "\n" + "(83) 99999-9999 (WhatsApp)" + "\n" + "(83) 3333-3333 (Adicional)" ; 
		assertEquals(esperado,a1.exibirContato(1));
	}
	
	/**
	 * TESTANTO EXIBIR OS DADOS DE UM CONTATO QUE NÃO FOI SALVO COMO FAVORITO
	 */
	@Test
	void testElseElseExibirContato() {
		String esperado = "Renan Ferreira" + "\n" + "(83) 99999-9999 (Prioritário)" + "\n" + "(83) 99999-9999 (WhatsApp)"; 
		assertEquals(esperado,a1.exibirContato(4));
	}
	
	/**
	 * TESTANTO UMA POSIÇÃO DE NÚMERO MAIOR DO QUE É PERMITIDO
	 */
	@Test
	void testIfMaiorAdicionarFavorito() {
		String esperado = "POSIÇÃO INVÁLIDA";
		assertEquals(esperado,a1.adicionarFavorito(1,15));
	}
	
	/**
	 * TESTANTO UMA POSIÇÃO DE NÚMERO MENOR DO QUE É PERMITIDO
	 */
	@Test
	void testIfMenorAdicionarFavorito() {
		String esperado = "POSIÇÃO INVÁLIDA";
		assertEquals(esperado,a1.adicionarFavorito(1,-2));
	}
	
	/**
	 * TESTANDO SE UM FAVORITO JÁ ESTÁ CADASTRADO OU NÃO
	 */
	@Test
	void testElseIfAdicionarFavorito() {
		String esperado = "CONTATO JÁ CADASTRADO";
		assertEquals(esperado,a1.adicionarFavorito(1,1));
	}
	
	/**
	 * TESTANTO O CADASTRO DE UM FAVORITO
	 */
	@Test
	void testElseElseAdicionarFavorito() {
		String esperado = "CONTATO FAVORITADO NA POSIÇÃO 5";
		assertEquals(esperado,a1.adicionarFavorito(4,5));
	}
	
	/**
	 * TESTANDO SE UM FAVORITO JÁ ESTÁ CADASTRADO OU NÃO
	 */
	@Test
	void testVerificaFavoritoCadastrado() {
		assertTrue(a1.verificaFavoritoCadastrado("Renato","Ferraz"));
		assertFalse(a1.verificaFavoritoCadastrado("Renan","Ferreira"));
	}
	
	/**
	 * TESTANTO A LISTAGEM DE TODOS OS FAVORITOS CADASTRADOS
	 */
	@Test
	void testListarFavoritos() {
		String esperado = "\n" + "1 - Roberta Felix" + "\n" + "2 - Renato Ferraz";
		assertEquals(esperado,a1.listarFavoritos());
	}

}
	
