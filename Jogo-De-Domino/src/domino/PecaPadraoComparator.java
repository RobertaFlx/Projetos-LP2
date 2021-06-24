package domino;

import java.util.Comparator;

public class PecaPadraoComparator implements Comparator<Peca>{

	/**
	 * MÉTODO QUE COMPARA DUAS PEÇAS ATRAVÉS DO SEUS LADOS DIREITO E ESQUERDO.
	 */
	@Override
	public int compare(Peca peca1, Peca peca2) {
		if(peca1.getNumEsquerdo() < peca2.getNumEsquerdo()) {
			return -1;
		}else if(peca2.getNumEsquerdo() < peca1.getNumEsquerdo()) {
			return 1;
		}
		if(peca1.getNumDireito() < peca2.getNumDireito()) {
			return -1;
		}else if (peca2.getNumDireito() < peca1.getNumDireito()) {
			return 1;
		} 
		return 0;     
	}
 
}
