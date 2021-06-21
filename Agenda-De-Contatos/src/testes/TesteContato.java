package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import agenda.Contato;

class TesteContato {

	/**
	 * TESTANDO A CONTRUÇÃO DE UM CONTATO COM TODOS OS DADOS
	 */
	@Test
	void testConstrutor() {
		Contato c0 = new Contato("Roberta","Felix","(83) 99999-9999","(83) 99999-9999","(83) 3333-3333");
	}
	
	/**
	 * TESTANDO A CONTRUÇÃO DE UM CONTATO QUE NÃO POSSUE NÚMERO ADICIONAL
	 */
	@Test
	void testConstrutorSemAdicional() {
		Contato c0 = new Contato("Renato","Ferraz","(81) 99999-5555","(81) 99999-5555");
	}
	
	/**
	 * CRIANDO CONTATOS PARA USAR NOS PRÓXIMOS TESTES
	 */
	Contato c1 = new Contato("Roberta","Felix","(83) 99999-9999","(83) 99999-9999","(83) 3333-3333");
	
	Contato c2 = new Contato("Renato","Ferraz","(81) 99999-5555","(81) 99999-5555","");
	
	/**
	 * TESTE PARA VER SE O NOME ESTÁ SENDO PEGO CORRETAMENTE
	 */
	@Test
	void testGetNome() {
		String esperado = "Roberta";
		assertEquals(esperado, c1.getNome());
	}
	
	/**
	 * TESTE PARA VER SE O SOBRENOME ESTÁ SENDO PEGO CORRETAMENTE
	 */
	@Test
	void testGetSobrenome() {
		String esperado = "Ferraz";
		assertEquals(esperado, c2.getSobrenome());
	}
	
	/**
	 * TESTE PARA VER SE O NÚMERO PRIORITÁRIO ESTÁ SENDO PEGO CORRETAMENTE
	 */
	@Test
	void testGetPrincipal() {
		String esperado = "(83) 99999-9999";
		assertEquals(esperado, c1.getPrincipal());
	}
	
	/**
	 * TESTE PARA VER SE O NÚMERO DE WHATSAPP ESTÁ SENDO PEGO CORRETAMENTE
	 */
	@Test
	void testGetWhatsApp() {
		String esperado = "(81) 99999-5555";
		assertEquals(esperado, c2.getWhats());
	}
	
	/**
	 * TESTE PARA VER SE O NÚMERO ADICIONAL ESTÁ SENDO PEGO CORRETAMENTE
	 */
	@Test
	void testGetAdicional() {
		String esperado = "(83) 3333-3333";
		assertEquals(esperado, c1.getAdicional());
	}
	
	/**
	 * TESTE PARA VER SE A FORMATAÇÃO DO CONTATO COM TODOS OS DADOS ESTÁ SENDO PRINTADA CORRETAMENTE
	 */
	@Test
	void testIfToString() {
		String esperado = "Roberta Felix" + "\n" + "(83) 99999-9999" + " (Prioritário)" + "\n" + "(83) 99999-9999" + " (WhatsApp)" + "\n" + "(83) 3333-3333" + " (Adicional)";
		assertEquals(esperado, c1.toString());
	 }
	
	/**
	 * TESTE PARA VER SE A FORMATAÇÃO DO CONTATO SEM O NÚMERO ADICIONAL ESTÁ SENDO PRINTADA CORRETAMENTE
	 */
	@Test
	void testElseToString() {
		String esperado = "Renato Ferraz" + "\n" + "(81) 99999-5555" + " (Prioritário)" + "\n" + "(81) 99999-5555" + " (WhatsApp)";
		assertEquals(esperado, c2.toString());
	 }

}
