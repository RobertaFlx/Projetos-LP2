package domino.estrategia;

import java.util.ArrayList;
import java.util.List;

import domino.Jogada;
import domino.Peca;

public class EstrategiaDeJogoComposta implements EstrategiaDeJogo {
	
	/**
	 * LISTA DE ESTRATÉGIAS.
	 */
    List<EstrategiaDeJogo> estrategias = new ArrayList<>();
    
    /**
     * CONTADOR DE QUANTAS VEZES A ESTRATÉGIA FOI USADA.
     */
	private int contador;
	
	/**
	 * ATRIBUTO QUE GUARDA A ESTRATÉGIA QUE IREMOS USAR NA RODADA.
	 */
	private EstrategiaDeJogo estrategiaDaRodada;
	
	/**
	 * CONSTRÓI UMA ESTRATÉGIA DE JOGO COMPOSTA.
	 * @param estrategias
	 */
	public EstrategiaDeJogoComposta(List<EstrategiaDeJogo> estrategias) {
		this.estrategias = estrategias;
		this.contador = 0; 
	}
	
	/**
	 * MÉTODO QUE PEGA A ESTRATÉGIA DA RODADA E DECIDE A JOGADA ATRAVÉS DELA.
	 */
	@Override
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa) {
		alternaEstrategias(estrategias, mao, mesa);
		return estrategiaDaRodada.decideJogada(mao, mesa);
	}
	
	/**
	 * MÉTODO QUE A CADA RODADA ALTERNA ENTRES AS DUAS ESTRATÉGIAS DA LISTA.
	 * @param estrategias
	 * @param mao
	 * @param mesa
	 */
	public void alternaEstrategias(List<EstrategiaDeJogo> estrategias, List<Peca> mao, VisaoDaMesa mesa) {
		if(contador % 2 == 0) {
			this.estrategiaDaRodada = estrategias.get(0);
			contador++;
		}
		else {
			this.estrategiaDaRodada = estrategias.get(1);
			contador++;
		}
	}  
	
}
