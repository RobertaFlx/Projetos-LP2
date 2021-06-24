package domino.estrategia;

import java.util.List;

import domino.Jogada;
import domino.Peca;
import domino.Jogada.TipoJogada;

/**
 * O OBJETIVO DESSA ESTRATÉGIA É JOGAR PRIMEIRO AS PEÇAS DE MAIORES VALORES, A ESTRATÉGIA PEGA A PEÇA MAIOR QUE ESTÁ NA MÃO DO JOGADOR E SE NÃO TIVER PEÇAS
 * NA MESA, A MAIOR CARROÇA É JOGADA, CASO CONTRÁRIO A ESTRATÉGIA VERIFICA SE ESSA PEÇA ENCAIXA COM AS PEÇAS JOGADAS NA MESA, SE NÃO ENCAIXAR, A ESTRATÉGIA
 * VAI PERCORRER A  MÃO DO JOGADOR E JOGAR A PRIMEIRA PEÇA QUE ENCAIXAR, TENDO ELA UM VALOR ALTO OU NÃO, SE MESMO ASSIM NÃO TIVER UMA PEÇA QUE ENCAIXE, O 
 * JOGADOR PASSA A VEZ.
 */

public class JogaPecaMaior implements EstrategiaDeJogo {

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		
		Peca peca = getMaiorValor(mao);  
		
		if (mesa.getNumPecas() == 0) {
			return new Jogada(peca, TipoJogada.NA_DIREITA); //JOGA A PEÇA MAIOR SE A MESA NÃO TIVER PEÇAS
		}
		
		//SE A MESA JÁ TIVER PEÇAS, VERIFICA SE A PEÇA MAIOR ENCAIXA NA DIREITA OU NA ESQUERDA
		
		if (peca.encaixa(mesa.getNumNaDireita())) {
			return new Jogada(peca, TipoJogada.NA_DIREITA);
		}
		if (peca.encaixa(mesa.getNumNaEsquerda())) {
			return new Jogada(peca, TipoJogada.NA_ESQUERDA);  
		}
		
		//SE A PEÇA MAIOR NÃO ENCAIXAR, PROCURA UMA PEÇA QUE ENCAIXE
		
		for (Peca peca1 : mao) {  
			if (peca1.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca1, TipoJogada.NA_DIREITA);
			}
			if (peca1.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca1, TipoJogada.NA_ESQUERDA);
			}
		}
 
		return new Jogada(); //PASSA 
	}

	/**
	 * MÉTODO QUE PEGA A MÃO DO JOGADOR E SOMA OS DOIS LADOS DE CADA PEÇA PARA VERIFICAR QUAL PEÇA TEM VALOR MAIOR.
	 * @param mao
	 * @return
	 */
	private Peca getMaiorValor(List<Peca> mao) {
		int maior = 0; 
		for(int i = 0; i < mao.size(); i++) {
			if(mao.get(i).somaLados() > maior) { 
				maior = i;
			}
		}
		return mao.get(maior);   
	}
		
}
