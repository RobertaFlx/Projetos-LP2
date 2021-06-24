package domino.estrategia;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import domino.Jogada;
import domino.Peca;
import domino.Jogada.TipoJogada;

public class JogaPrimeiraPossivelComparadora implements EstrategiaDeJogo{
	
	private Comparator<Peca> pecaComparavel;
	
	/**
	 * CONSTRÓI A ESTRATÉGIA.
	 * @param peca
	 */
	public JogaPrimeiraPossivelComparadora(Comparator<Peca> peca) {
		this.pecaComparavel = peca;
	}  
	
	/**
	 * ESSE MÉTODO COMPARA A LISTA DE ELEMENTOS NA MÃO E OS ORDENA, SE NÃO EXISTEM ELEMENTOS NA MESA, JOGA O PRIMEIRO ELEMENTO NA MÃO, SE A MESA TIVER PELO
	 * MENOS UMA PEÇA, PERCORRE A LISTA ORDENADA E JOGA A PRIMEIRA PEÇA QUE ENCAIXA. 
	 */
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		Collections.sort(mao, pecaComparavel);
		
		if (mesa.getNumPecas() == 0) {
			return new Jogada(mao.get(0), TipoJogada.NA_DIREITA);  
		}
		
		for (Peca peca : mao) {
			if (peca.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca, TipoJogada.NA_DIREITA);
			}
			if (peca.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca, TipoJogada.NA_ESQUERDA);
			}
		}
		
		return new Jogada();
	} 

}

