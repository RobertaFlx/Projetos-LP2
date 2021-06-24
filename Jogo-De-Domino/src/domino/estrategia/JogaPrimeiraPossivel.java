package domino.estrategia;

import java.util.List;

import domino.Jogada;
import domino.Peca;
import domino.Jogada.TipoJogada;

/**
 * JOGA SEMPRE A PRIMEIRA PEÇA QUE ENCAIXA, TENTA PRIMEIRO NO LADO DIREITO E DEPOIS NO ESQUERDO, SE ENCAIXAR EM AMBOS OS LADOS, JOGA NA DIREITA.
 */
public class JogaPrimeiraPossivel implements EstrategiaDeJogo { 

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
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

	@Override
	public String toString() {
		return "Joga Primeira Possível"; 
	}
}
