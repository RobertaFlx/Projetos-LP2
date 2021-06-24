package domino;

import java.util.LinkedList;
import java.util.List;

import domino.Jogada.TipoJogada;
import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.VisaoDaMesa;

/**
 * ENCAPSULA AS INFORMAÇÕES DE UM JOGADOR EM UMA PARTIDA DE DOMINÓ.
 */
public class Jogador {

	private EstrategiaDeJogo estrategia;
	private List<Peca> mao;
	private String nome;
	private Jogada ultimaJogada;

	/**
	 * CONSTRÓI UM JOGADOR.
	 * @param nome       
	 * @param estrategia 
	 * @param maoJogador 
	 */
	public Jogador(String nome, EstrategiaDeJogo estrategia, List<Peca> maoJogador) {
		this.nome = nome;
		this.estrategia = estrategia;
		this.mao = new LinkedList<>(maoJogador);
		this.ultimaJogada = null;
	}

	/**
	 * RETORNA NOME DO JOGADOR.
	 * @return 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * DECIDE A PRÓXIMA JOGADA A SER FEITA PELO JOGADOR DADO O ESTADO DA MESA E VERIFICA SE A DECISÃO DA ESTRATÉGIA É PARA UMA PEÇA QUE ESTÁ NA MÃO.
	 * @param mesa 
	 * @return A Jogada decidida.
	 * @throws EstrategiaInvalidaException Caso a estratégia decida jogar uma peça que não está na mão do jogador.
	 */
	public Jogada decideJogada(VisaoDaMesa mesa) throws EstrategiaInvalidaException {
		Jogada jogada = this.estrategia.decideJogada(mao, mesa);

		if (jogada.getTipo() != TipoJogada.PASSA) {
			Peca pecaJogada = jogada.getPeca();
			boolean realmenteTem = mao.contains(pecaJogada);
			if (!realmenteTem) {
				throw new EstrategiaInvalidaException(nome + " tentou jogar peça que não tem: " + pecaJogada);
			}
		}
		this.ultimaJogada = jogada;
		return jogada;
	}

	/**
	 * RETIRA UMA PEÇA DA MÃO DO JOGADOR QUANDO A PEÇA É COLOCADA NA MESA.
	 * @param peca 
	 */
	public void removeDaMao(Peca peca) {
		this.mao.remove(peca);
	}

	/**
	 * RETORNA O NÚMERO DE PEÇAS NA MÃO DO JOGADOR.
	 * @return 
	 */
	public int getNumPecas() {
		return mao.size();
	}

	@Override
	public String toString() {
		return this.getNome() + (ultimaJogada == null ? "" : ", joga: " + ultimaJogada.toString()) + ", mão: "
				+ mao.toString();
	}

	/**
	 * RETORNA A ÚLTIMA JOGADA DO JOGADOR.
	 * @return
	 */
	public Jogada getUltimaJogada() {
		return ultimaJogada;
	}
	
	/**
	 * RETORNA CÓPIA DA MÃO DISPONÍVEL PARA ESSE JOGADOR.
	 * @return 
	 */
	public List<Peca> getMao() {
		return new LinkedList<>(mao); 
	}

	/**
	 * SOMA O VALOR DAS PEÇAS QUE ESTÃO NA MÃO DO JOGADOR PARA DESEMPATAR.
	 * @return
	 */
	public int soma() {
		int soma = 0;
		for(Peca peca: mao) {
			soma += peca.somaLados();
		}
		return soma; 
	}
	
}
