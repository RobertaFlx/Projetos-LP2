package domino;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import domino.estrategia.VisaoDaMesa;

/**
 * A MESA QUE GUARDA AS PEÇAS JOGADAS. A MESA TEM UM LADO DIREITO E UM ESQUERDO.
 */
public class Mesa implements VisaoDaMesa {

	public static final int SEM_PECA = -1;

	private Deque<Peca> pecas;

	/**
	 * CONSTRÓI UMA MESA VAZIA.
	 */
	public Mesa() {
		this.pecas = new LinkedList<Peca>(); 
	}

	/**
	 * RETORNA O NÚMERO DE PEÇAS NA MESA.
	 * @return 
	 */
	public int getNumPecas() {
		return pecas.size();
	}

	/**
	 * ACESSA O NÚMERO ABERTO NA PEÇA MAIS À DIREITA DA MESA.
	 * @return Número que pode ser jogado nesse lado.
	 */
	public int getNumNaDireita() {
		return pecas.isEmpty() ? SEM_PECA : pecas.peekLast().getNumDireito();
	}

	/**
	 * ACESSA O NÚMERO ABERTO NA PEÇA MAIS À ESQUERDA DA MESA.
	 * @return Número que pode ser jogado nesse lado.
	 */
	public int getNumNaEsquerda() {
		return pecas.isEmpty() ? SEM_PECA : pecas.peekFirst().getNumEsquerdo();
	}

	/**
	 * JOGA UMA PEÇA NA DIREITA DA MESA, A PEÇA É GIRADA SE FOR NECESSÁRIO PARA ENCAIXAR.
	 * @param peca 
	 * @throws JogadaInvalidaException    Se não é possível encaixar a peça.
	 */
	public void jogaNaDireita(Peca peca) throws JogadaInvalidaException {
		if (getNumPecas() == 0) {
			this.pecas.addLast(peca);
			return;
		}
		if (peca.getNumEsquerdo() != getNumNaDireita()) {
			peca.gira(); //SE A PEÇA NÃO ENCAIXA, GIRA ELA
		}
		if (peca.getNumEsquerdo() == getNumNaDireita()) {
			this.pecas.addLast(peca);
		} else {
			//SE NÃO ENCAIXA DE UM LADO NEM DO OUTRO
			throw new JogadaInvalidaException(
					"Impossível jogar " + peca.toString() + " no lado direito com " + getNumNaDireita() + " aberto");
		}
	}

	/**
	 * JOGA UMA PEÇA NA ESQUERDA DA MESA, A PEÇA É GIRADA SE FOR NECESSÁRIO PARA ENCAIXAR.
	 * @param peca 
	 * @throws JogadaInvalidaException    Se não é possível encaixar a peça.
	 */
	public void jogaNaEsquerda(Peca peca) throws JogadaInvalidaException {
		if (getNumPecas() == 0) {
			this.pecas.addFirst(peca);
			return;
		}
		if (peca.getNumDireito() != getNumNaEsquerda()) {
			peca.gira();  //SE A PEÇA NÃO ENCAIXA, GIRA ELA
		}
		if (peca.getNumDireito() == getNumNaEsquerda()) {
			this.pecas.addFirst(peca); 
		} else {
			//SE NÃO ENCAIXA DE UM LADO NEM DO OUTRO
			throw new JogadaInvalidaException(
					"Impossível jogar " + peca.toString() + " no lado esquerdo com " + getNumNaEsquerda() + " aberto");
		}
	}

	@Override
	public String toString() {
		if (pecas.size() == 1) {
			return pecas.getFirst().toString();
		}

		String o = "";
		for (Peca peca : pecas) {
			o = o + " " + peca;
		}
		return o;
	}

	@Override
	public List<Peca> getPecasNaMesa() {
		return new LinkedList<>(pecas);
	}

	
}
