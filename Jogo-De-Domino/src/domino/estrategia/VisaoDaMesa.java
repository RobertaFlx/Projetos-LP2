package domino.estrategia;

import java.util.List;

import domino.Peca;

/**
 * ESSA INTERFACE DEFINE OS MÉTODOS QUE IMPLEMENTAÇÕES DE ESTRATEGIADEJOGO PODEM ACESSAR SOBRE AS PEÇAS DO JOGO. DESSA MANEIRA, CONTROLAMOS ACESSO AOS
 * MÉTODOS QUE ALTERAM A MESA DE FATO.
 */
public interface VisaoDaMesa {

	/**
	 * ACESSA O NÚMERO ABERTO NA PEÇA MAIS À DIREITA DA MESA.
	 * @return Número que pode ser jogado nesse lado.
	 */
	int getNumNaDireita();

	/**
	 * ACESSA O NÚMERO ABERTO NA PEÇA MAIS À ESQUERDA DA MESA.
	 * @return Número que pode ser jogado nesse lado.
	 */
	int getNumNaEsquerda();

	/**
	 * ACESSA O NÚMERO DE PEÇAS NA MESA.
	 * @return peças na mesa.
	 */
	int getNumPecas();

	/**
	 * ACESSA UMA CÓPIA DAS PEÇAS DA MESA EM ORDEM, DA ESQUERDA PARA A DIREITA. COMO É UMA CÓPIA, AS ESTRATÉGIAS NÃO PODEM ALTERAR A MESA.
	 * @return lista da peças na mesa.
	 */
	List<Peca> getPecasNaMesa();
}
