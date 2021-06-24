package domino;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import domino.Jogada.TipoJogada;
import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaInvalidaException;

/**
 * JOGO DE DOMINÓ ENVOLVENDO 2 JOGADORES.
 */
public class Jogo {

	private Jogador jogador1;
	private Jogador jogador2;

	private Mesa mesa;
	private int rodadasJogadas;

	private boolean finalizado;
	private String vencedor;
	private String tipoDeVitoria;
	
	/**
	 * CONSTRÓI UM JOGO.
	 */
	private Jogo() {
		this.rodadasJogadas = 0;
		this.finalizado = false; 
		this.vencedor = null;
		this.mesa = new Mesa();
	}

	/**
	 * CRIA, EMBARALHA E DISTRIBUI PEÇAS ENTRE DOIS JOGADORES DE MANEIRA REPRODUTÍVEL.
	 * SEMPRE QUE O MESMO OBJETO RANDOM FOR PASSADO, AS PEÇAS COM CADA JOGADOR ACABARÃO SENDO AS MESMAS.
	 * @param nomeJogador1   
	 * @param estrategia1       
	 * @param nomeJogador2    
	 * @param estrategia2        
	 * @param numPecasInicial           Número de peças a dar para cada jogador no início.
	 * @param geradorDeNumsAleatorios   Objeto que determina as peças que cada um receberá após embaralhamento.                            
	 */
	public Jogo(String nomeJogador1, EstrategiaDeJogo estrategia1, String nomeJogador2, EstrategiaDeJogo estrategia2,
			int numPecasInicial, Random geradorDeNumsAleatorios) {
		this();
		List<Peca> pecas = criaPecas();
		Collections.shuffle(pecas, geradorDeNumsAleatorios);

		List<Peca> maoJ1 = sorteiaMao(pecas, numPecasInicial);
		List<Peca> maoJ2 = sorteiaMao(pecas, numPecasInicial);

		this.jogador1 = new Jogador(nomeJogador1, estrategia1, maoJ1); 
		this.jogador2 = new Jogador(nomeJogador2, estrategia2, maoJ2);
	}

	/**
	 * CRIA, EMBARALHA E DISTRIBUI PEÇAS ENTRE DOIS JOGADORES.
	 * @param nomeJogador1    
	 * @param estrategia1     
	 * @param nomeJogador2   
	 * @param estrategia2     
	 * @param numPecasInicial   Número de peças a dar para cada jogador no início.
	 */
	public Jogo(String nomeJogador1, EstrategiaDeJogo estrategia1, String nomeJogador2, EstrategiaDeJogo estrategia2,
			int numPecasInicial) {
		this(nomeJogador1, estrategia1, nomeJogador2, estrategia2, numPecasInicial, new Random());
	}

	/**
	 * CRIA UM JOGO COM PEÇAS ESCOLHIDAS PARA A MÃO DOS JOGADORES. 
	 * @param nomeJogador1 
	 * @param estrategia1  
	 * @param nomeJogador2 
	 * @param estrategia2 
	 * @param maoJogador1  
	 * @param maoJogador2  
	 */
	public Jogo(String nomeJogador1, EstrategiaDeJogo estrategia1, String nomeJogador2, EstrategiaDeJogo estrategia2,
			List<Peca> maoJogador1, List<Peca> maoJogador2) {
		this();
		this.jogador1 = new Jogador(nomeJogador1, estrategia1, new LinkedList<Peca>(maoJogador1));
		this.jogador2 = new Jogador(nomeJogador2, estrategia2, new LinkedList<Peca>(maoJogador2));
	}

	/**
	 * SORTEIA PEÇAS PARA UM JOGADOR.
	 * @param pecas           
	 * @param numPecasInicial 
	 * @return Peças retiradas.
	 */
	private List<Peca> sorteiaMao(List<Peca> pecas, int numPecasInicial) {
		List<Peca> mao = new LinkedList<Peca>();
		for (int i = 0; i < numPecasInicial; i++) {
			mao.add(pecas.remove(0));
		}
		return mao;
	}

	/**
	 * CRIA O DOMINÓ.
	 * @return Conjunto de 28 peças de 0:0 a 6:6
	 */
	private List<Peca> criaPecas() {
		List<Peca> pecas = new LinkedList<Peca>();

		for (int i = 0; i <= 6; i++) {
			for (int j = i; j <= 6; j++) {
				pecas.add(new Peca(i, j));
			}
		}
		return pecas;
	}

	/**
	 * NÚMERO DE PEÇAS NA MÃO DO JOGADOR 1.
	 * @return 
	 */
	public int getNumPecasJ1() {
		return this.jogador1.getNumPecas();
	}

	/**
	 * NÚMERO DE PEÇAS NA MÃO DO JOGADOR 2.
	 * @return 
	 */
	public int getNumPecasJ2() {
		return this.jogador2.getNumPecas();
	}

	/**
	 * JOGA UMA RODADA DO JOGO.
	 * @throws EstrategiaInvalidaException   Se a estratégia de um dos jogadores decidir jogar uma peça que ele não possui.      
	 * @throws JogadaInvalidaException       Se a peça escolhida por algum dos jogadores não encaixar na mesa.                                  
	 */
	public void rodada() throws EstrategiaInvalidaException, JogadaInvalidaException {
		rodadasJogadas += 1;

		Jogada jogadaJ1 = jogador1.decideJogada(mesa);
		jogaJogada(jogador1, jogadaJ1);

		if (jogador1.getNumPecas() == 0) {
			this.finalizado = true;
			this.vencedor =  this.jogador1.getNome(); //J1 VENCEU
			return;
		}

		Jogada jogadaJ2 = jogador2.decideJogada(mesa);
		jogaJogada(jogador2, jogadaJ2);

		if (jogador2.getNumPecas() == 0) {
			this.finalizado = true;
			this.vencedor =  this.jogador2.getNome(); //J2 VENCEU
			return;
		}

		//SE OS DOIS JOGADORES PASSAM, É EMPATE
		
		if (jogadaJ1.getTipo() == TipoJogada.PASSA && jogadaJ2.getTipo() == TipoJogada.PASSA) {
			if(!this.desempatarJogo()) {
				this.finalizado = true;
				this.vencedor = null;
			}
		}
	}
	
	/** 
	 * VERIFICA INTERNAMENTE SE EXISTEM CONDIÇÕES QUE POSSAM GERAR UM DESEMPATE, CASO NÃO HAJA, O PROGRAMA RETORNA FALSE.
	 * @return 
	 */
	public boolean desempatarJogo() {  
		if (jogador1.getNumPecas() < jogador2.getNumPecas()) {
			this.vencedor = this.jogador1.getNome();
			this.tipoDeVitoria = "NORMAL";
			this.finalizado = true;
			return true; 
		}
		else {
			if(jogador2.getNumPecas() < jogador1.getNumPecas()){
				this.vencedor = this.jogador2.getNome();
				this.tipoDeVitoria = "NORMAL";
				this.finalizado = true;
				return true; 
		   }
			else {
				if (jogador1.soma() < jogador2.soma()){
					this.vencedor = this.jogador1.getNome();
					this.tipoDeVitoria = "NORMAL";
					this.finalizado = true;
					return true;
				}
				else {
					if(jogador2.soma() < jogador1.soma()) {
						this.vencedor = this.jogador2.getNome();
						this.tipoDeVitoria = "NORMAL";
						this.finalizado = true;
						return true;
				    }
				}
			}
		}
		return false;
	}

	/**
	 * JOGA O JOGO DO PONTO ATUAL ATÉ O SEU FIM.
	 * @return 
	 * @throws EstrategiaInvalidaException   Se a estratégia de um dos jogadores decidir jogar uma peça que ele não possui.                                  
	 * @throws JogadaInvalidaException       Se a peça escolhida por algum dos jogadores não encaixar na mesa.                                 
	 */
	public HistoricoDeJogo jogaJogoCompleto() throws EstrategiaInvalidaException, JogadaInvalidaException {
		HistoricoDeJogo jogado = new HistoricoDeJogo(jogador1, jogador2);
		while (!this.isFinalizado()) {
			this.rodada();
			jogado.addRodada(jogador1.getUltimaJogada(), jogador2.getUltimaJogada(), mesa);
			
		}if(this.finalizado) {
			if(this.isResultadoEmpate()) {
				jogado.setResultadoEmpate();
				
			} else {
				jogado.setVencedor(getVencedor());
				Jogador jogador = null;
				
				if(vencedor.equals(jogador1.getNome())) {
					jogador = jogador1;
				}
				else {
					jogador = jogador2;
				}
				
				Peca ultimaPeca = jogador.getUltimaJogada().getPeca();
				getTipoDeVitoria(mesa, ultimaPeca);
				jogado.setTipoDeVitoria(this.tipoDeVitoria);
			}
		}
		return jogado;
	}

	/**
	 * FAZ A JOGADA DECIDIDA POR UM DOS JOGADORES TER EFEITO. QUEM REALIZA DE FATO AS JOGADAS É A CLASSE JOGO.
	 * @param jogador 
	 * @param jogada  
	 * @throws JogadaInvalidaException   Caso ela não possa ser jogada na mesa atual
	 */
	private void jogaJogada(Jogador jogador, Jogada jogada) throws JogadaInvalidaException {
		if (jogada.getTipo() == TipoJogada.PASSA) {
			return;
		}

		switch (jogada.getTipo()) {
		case NA_ESQUERDA: {
			this.mesa.jogaNaEsquerda(jogada.getPeca());
			break;
		}
		case NA_DIREITA: {
			this.mesa.jogaNaDireita(jogada.getPeca());
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + jogada.getTipo());
		}

		jogador.removeDaMao(jogada.getPeca());
	}

	@Override
	public String toString() {
		String o = jogador1.toString() + "\n" + jogador2.toString() + "\nMesa: " + mesa.toString();
		return o;
	}

	/**
	 * RETORNA O NÚMERO DE JOGADAS JÁ JOGADAS.
	 * @return 
	 */
	public int getNumRodadas() {
		return rodadasJogadas;
	}

	/**
	 * RETORNA SE O JOGO ESTÁ ENCERRADO.
	 * @return 
	 */
	public boolean isFinalizado() {
		return this.finalizado;
	}

	/**
	 * RETORNA SE O JOGO TERMINOU E FOI EMPATE.
	 * @return 
	 */
	public boolean isResultadoEmpate() {
		return this.isFinalizado() && this.vencedor == null;
	}

	/**
	 * RETORNA NOME DO JOGADOR.
	 * @return 
	 */
	public String getVencedor() {
		return vencedor;
	}
	
	/**
	 * RETORNA O TIPO DE VITÓRIA.
	 * @return
	 */
	public String getTipo() {
		return this.tipoDeVitoria; 
	}
	
	/**
	 * MÉTODO QUE ATRIBUI O TIPO DE VITÓRIA AO VENCEDOR.
	 * @param mesa
	 * @param ultimaPeca
	 */
	public void getTipoDeVitoria(Mesa mesa, Peca ultimaPeca) {
		if(ultimaPeca != null) {
			if (verificaLaeLo(mesa, ultimaPeca)) {
				if(verificaCarroca(ultimaPeca)) {
					this.tipoDeVitoria = "LA E LO E CARROCA";
				}
				else {
				    this.tipoDeVitoria = "LA E LO";
				}
			}
			else {
				if(verificaCarroca(ultimaPeca)) { 
				    this.tipoDeVitoria = "CARROCA";
				}
				else{
					this.tipoDeVitoria = "NORMAL";
				}
			}
		}
		else {
			this.tipoDeVitoria = "NORMAL";
		}
	}

	/**
	 * RETORNA SE A JOGADA É LÁ E LÔ.
	 * @param mesa
	 * @param peca
	 * @return
	 */
	private boolean verificaLaeLo(Mesa mesa, Peca peca) {
		return peca.encaixa(mesa.getNumNaDireita()) && peca.encaixa(mesa.getNumNaEsquerda());
	}
	
	/**
	 * RETORNA SE A JOGADA É CARROÇA.
	 * @param peca
	 * @return
	 */
	private boolean verificaCarroca(Peca peca) {
		return peca.verificaSeTemLadosIguais(); 
	}

}
