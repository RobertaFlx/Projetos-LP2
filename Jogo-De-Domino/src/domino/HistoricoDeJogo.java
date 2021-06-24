package domino;

import java.util.LinkedList;
import java.util.List;

/**
 * GUARDA O HISTÓRICO DE UM JOGO, COM AS POSIÇÕES DA MESA, A JOGADA E O RESULTADO DA RODADA, PARA USARMOS EM INTERFACES.
 */
public class HistoricoDeJogo {

	private List<SituacaoNoJogo> rodadas;
	private Jogador jogador1;
	private Jogador jogador2;
	private boolean empate;
	private String vencedor;
	private String tipoDeVitoria;

	/**
	 * CONSTRÓI UM NOVO HISTÓRICO.
	 * @param jogador1 
	 * @param jogador2 
	 */
	public HistoricoDeJogo(Jogador jogador1, Jogador jogador2) {
		this.rodadas = new LinkedList<SituacaoNoJogo>();
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		this.empate = false;
		this.vencedor = null;
		this.tipoDeVitoria = null;
	}

	public void addRodada(Jogada ultimaJogadaJ1, Jogada ultimaJogadaJ2, Mesa mesa) {
		SituacaoNoJogo novaSituacao = new SituacaoNoJogo(jogador1, ultimaJogadaJ1, jogador2, ultimaJogadaJ2,
				jogador1.getMao(), jogador2.getMao(), mesa.getPecasNaMesa());
		this.rodadas.add(novaSituacao);
	}

	/**
	 * INFORMA QUE O RESULTADO DA PARTIDA NESSE HISTÓRICO FOI EMPATE.
	 */
	public void setResultadoEmpate() {
		this.empate = true;
		this.vencedor = null;
	}

	/**
	 * INFORMA O VENCEDOR.
	 * @param vencedor
	 */
	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
		this.empate = false;
	}

	/**
	 * RETORNA SE É EMPATE OU NÃO.
	 * @return
	 */
	public boolean isEmpate() {
		return empate;
	}

	/**
	 * RETORNA O NOME DO VENCEDOR.
	 * @return
	 */
	public String getVencedor() {
		return vencedor;
	}

	@Override
	public String toString() {
		String o = "==\n== Novo Jogo \n==";
		for (int i = 0; i < rodadas.size(); i++) {
			o += "\nRodada " + i + "\n" + rodadas.get(i).toString();
		}

		o += "\n--RESULTADO: " + (this.isEmpate() ? "EMPATE\n" : ("VITÓRIA DE " + getVencedor()) + "\n");
		return o;
	}

	/**
	 * CLASSE PRIVADA PARA ENCAPSULAR O ESTADO DA PARTIDA DEPOIS DE UMA RODADA.
	 */
	private class SituacaoNoJogo {
		private Jogada jogadaJ1;
		private Jogada jogadaJ2;
		private List<Peca> maoJ1;
		private List<Peca> maoJ2;
		private List<Peca> mesa;
		private Jogador jogador1;
		private Jogador jogador2;

		public SituacaoNoJogo(Jogador j1, Jogada jogadaJ1, Jogador j2, Jogada jogadaJ2, List<Peca> maoJ1,
				List<Peca> maoJ2, List<Peca> naMesa) {
			this.jogador1 = j1;
			this.jogadaJ1 = jogadaJ1;
			this.jogador2 = j2;
			this.jogadaJ2 = jogadaJ2;
			this.maoJ1 = maoJ1;
			this.maoJ2 = maoJ2;
			this.mesa = naMesa;
		}

		@Override
		public String toString() {
			return "  " + this.jogador1.getNome() + " : " + jogadaJ1.toString() + ", mão: " + maoJ1.toString() + "\n  "
					+ this.jogador2.getNome() + " : " + jogadaJ2.toString() + ", mão: " + maoJ2.toString() + "\n  "
					+ "MESA: " + mesa.toString(); 
		}
	} 
	
	/**
	 * RETORNA O TIPO DE VITÓRIA DA RODADA
	 * @return
	 */
	public String getTipoDeVitoria() {
		return tipoDeVitoria;
	}
	
	/**
	 * INFORMA O TIPO DE VITÓRIA DA RODADA
	 * @return
	 */
	public void setTipoDeVitoria(String tipoDeVitoria) {
		this.tipoDeVitoria = tipoDeVitoria;
	}
	
}
