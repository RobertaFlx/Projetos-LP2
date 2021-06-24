package domino.estrategia;

import java.util.ArrayList;
import java.util.List;

import domino.Jogada;
import domino.Peca;
import domino.Jogada.TipoJogada;

/**
 * O OBJETIVO DESSA ESTRATÉGIA É JOGAR PRIMEIRO AS CARROÇAS, A ESTRATÉGIA PEGA A MAIOR CARROÇA QUE ESTÁ NA MÃO DO JOGADOR E SE NÃO TIVER PEÇAS NA MESA, A 
 * MAIOR CARROÇA É JOGADA, CASO CONTRÁRIO A ESTRATÉGIA VERIFICA SE ESSA PEÇA ENCAIXA COM AS PEÇAS JOGADAS NA MESA, SE NÃO ENCAIXAR, A ESTRATÉGIA PERCORRE 
 * UMA LISTA DE POSSÍVEIS JOGADAS, ONDE ESTÃO ARMAZENADAS TODAS AS CARROÇAS DO JOGADOR, E JOGA A PRIMEIRA CARROÇA QUE ENCAIXAR, SE A LISTA NÃO TIVER 
 * ELEMENTOS OU SE NENHUMA DAS PEÇAS DA LISTA ENCAIXAREM NA MESA, A ESTRATÉGIA VAI PERCORRER A MÃO DO JOGADOR E JOGAR A PRIMEIRA PEÇA QUE ENCAIXAR, SENDO 
 * ELA CARROÇA OU NÃO, SE MESMO ASSIM NÃO TIVER UMA PEÇA QUE ENCAIXE, O JOGADOR PASSA A VEZ.
 */
 
public class JogaCarrocaMaior implements EstrategiaDeJogo {  

	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		List<Peca> possiveis = new ArrayList<>();

		for(int i = 0; i < mao.size(); i++) {
			if(mao.get(i).verificaSeTemLadosIguais()) { 
				possiveis.add(mao.get(i)); 
			}
		}
		
		Peca peca = getMaiorCarroca(mao, possiveis); 
		
		if (mesa.getNumPecas() == 0) {
			return new Jogada(peca, TipoJogada.NA_DIREITA); //JOGA A MAIOR CARROÇA SE A MESA NÃO TIVER PEÇAS
		}

		//SE A MESA JÁ TIVER PEÇAS, VERIFICA SE A MAIOR CARROÇA ENCAIXA NA DIREITA OU NA ESQUERDA
		
		if (peca.encaixa(mesa.getNumNaDireita())) {
			return new Jogada(peca, TipoJogada.NA_DIREITA);
		}
		if (peca.encaixa(mesa.getNumNaEsquerda())) {
			return new Jogada(peca, TipoJogada.NA_ESQUERDA);
		}
		
		//SE A MAIOR CARROÇA NÃO ENCAIXAR, PROCURA UMA CARROÇA QUE ENCAIXE
		
		for (Peca peca1 : possiveis) {
			if (peca1.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca1, TipoJogada.NA_DIREITA);
			}
			if (peca1.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca1, TipoJogada.NA_ESQUERDA);
			}
		}
		
		//SE NENHUMA CARROÇA ENCAIXAR, PROCURA UMA PEÇA QUE ENCAIXE
		
		for (Peca peca2 : mao) { 
			if (peca2.encaixa(mesa.getNumNaDireita())) {
				return new Jogada(peca2, TipoJogada.NA_DIREITA);
			}
			if (peca2.encaixa(mesa.getNumNaEsquerda())) {
				return new Jogada(peca2, TipoJogada.NA_ESQUERDA);
			}
		} 
		
		return new Jogada(); //PASSA
	}

	/**
	 * MÉTODO QUE PEGA A LISTA COM TODAS AS CARROÇAS E SOMA OS DOIS LADOS DE CADA PEÇA PARA VERIFICAR QUAL CARROÇA É MAIOR.
	 * @param mao
	 * @param possiveis
	 * @return 
	 */
	private Peca getMaiorCarroca(List<Peca> mao, List<Peca> possiveis) {
		if(possiveis.size() != 0) { 
			int maior = 0;
			for(int i = 0; i < possiveis.size(); i++) {
				if(possiveis.get(i).somaLados() > maior) {   
					maior = i;
				}
			}
			return possiveis.get(maior); 
		}
		return mao.get(0);  
		
	}
	
}