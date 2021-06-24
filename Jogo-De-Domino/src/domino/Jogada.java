package domino;

/**
 * ENCAPSULA UMA JOGADA, INCLUINDO UMA PEÇA E A POSIÇÃO ONDE JOGAR.
 */
public class Jogada {

	/**
	 * CONSTANTES PARA INFORMAR SE A JOGADA É NA DIREITA, ESQUERDA OU SE É PARA PASSAR A VEZ.
	 */
	public enum TipoJogada {
		NA_ESQUERDA, NA_DIREITA, PASSA 
	}

	private Peca peca;
	private TipoJogada tipo;

	/**
	 * CONSTRÓI A JOGADA.
	 * @param peca 
	 * @param tipo 
	 */
	public Jogada(Peca peca, TipoJogada tipo) {
		this.peca = peca;
		this.tipo = tipo;
	}

	/**
	 * CRIA UMA JOGADA DE PASSA SEM PRECISAR USAR UMA PEÇA, O JOGADOR SIMPLESMENTE PASSA A VEZ.
	 */
	public Jogada() {
		this(null, TipoJogada.PASSA);
	}

	/**
	 * RETORNA SE É UMA JOGADA À ESQUERDA, À DIREITA OU PASSA.
	 * @return 
	 */
	public TipoJogada getTipo() {
		return tipo;
	}

	/**
	 * RETORNA A PEÇA DA JOGADA.
	 * @return 
	 */
	public Peca getPeca() {
		return peca;
	}

	@Override
	public String toString() {
		return (this.tipo == TipoJogada.PASSA ? "" : peca.toString() + " ") + this.getTipoEmString();
	}

	/**
	 * RETORNA O TIPO DE JOGADA EM STRING.
	 * @return
	 */
	public String getTipoEmString() {
		switch (tipo) {
		case PASSA: {
			return "Passou";
		}
		case NA_DIREITA: {
			return "na direita"; 
		}
		case NA_ESQUERDA: {
			return "na esquerda";
		}
		default: {
			return null; 
		}
		}
	}

}
