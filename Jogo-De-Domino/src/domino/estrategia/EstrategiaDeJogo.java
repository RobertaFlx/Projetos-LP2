package domino.estrategia;

import java.util.List;

import domino.Jogada;
import domino.Peca;

/**
 * UMA ESTRATÉGIA PARA JOGAR EM UMA PARTIDA DE DOMINÓ. É USADA PELO JOGO PARA DECIDIR A PRÓXIMA JOGADA DO JOGADOR.
 */
public interface EstrategiaDeJogo {

	/**
	 * DECIDE A JOGADA NA VEZ DO JOGADOR.
	 * @param mao  
	 * @param mesa 
	 * @return Uma Jogada
	 */
	public Jogada decideJogada(List<Peca> mao, VisaoDaMesa mesa);
}