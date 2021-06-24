package domino;

/**
 * UMA PEÇA DE DOMINÓ COM DOIS LADOS.
 */
public class Peca {

	private int numEsquerdo;
	private int numDireito;

	/**
	 * CONSTRÓI UMA PEÇA.
	 * @param numEsquerdo 
	 * @param numDireito  
	 */
	public Peca(int numEsquerdo, int numDireito) {
		this.numEsquerdo = numEsquerdo;
		this.numDireito = numDireito;
	}

	/**
	 * INVERTE OS LADOS DOS NÚMEROS NA PEÇA.
	 */
	public void gira() {
		int tmp = numEsquerdo;
		numEsquerdo = numDireito;
		numDireito = tmp;
	}

	/**
	 * RETORNA O NÚMERO DA DIREITA.
	 * @return 
	 */
	public int getNumDireito() {
		return numDireito;
	}

	/**
	 * RETORNA O NÚMERO DA ESQUERDA.
	 * @return 
	 */
	public int getNumEsquerdo() {
		return numEsquerdo;
	}

	@Override
	public String toString() {
		return this.getNumEsquerdo() + ":" + this.getNumDireito(); 
	}

	/**
	 * RETORNA SE A PEÇA ENCAIXA OU NÃO NA MESA.
	 * @param numero 
	 * @return 
	 */
	public boolean encaixa(int numero) {
		return this.numDireito == numero || this.numEsquerdo == numero;
	}
    
	/**
	 * RETORNA SE A PEÇA TEM LADOS IGUAIS OU NÃO.
	 * @return
	 */
	public boolean verificaSeTemLadosIguais() {
		 return this.numEsquerdo == this.numDireito; 
	}

	/**
	 * RETORNA A SOMA DOS DOIS LADOS.
	 * @return
	 */
	public int somaLados() {
		return this.numDireito + this.numEsquerdo; 
	}

}
