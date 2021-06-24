package domino;

import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.JogaCarrocaMaior;
import domino.estrategia.JogaPrimeiraPossivel; 

/**
 * LABORATÓRIO DE PROGRAMAÇÃO 2 - LAB06
 * 
 * @author ROBERTA FELIX DA SILVA
 */

public class DominoBrutalRepetido {    
	
	private static final int NUM_PECAS_INICIAL = 12;
	private static final int REPETICOES = 50000;

	public static void main(String[] args) throws EstrategiaInvalidaException, JogadaInvalidaException {
		int vitoriasJ1 = 0, vitoriasJ2 = 0, empates = 0;
		
		int[] tiposVitoriasJ1 = {0,0,0,0};
		int[] tiposVitoriasJ2 = {0,0,0,0}; 
		int[] somaPontuacoes = {0,0}; 

		EstrategiaDeJogo estrategia1 = new JogaPrimeiraPossivel(), estrategia2 = new JogaCarrocaMaior(); 
		
		// CADA ESTRATÉGIA COMEÇA JOGANDO METADE DAS PARTIDAS
		
		for (int i = 0; i < REPETICOES; i++) {
			Jogo j;
			
			if( i < REPETICOES / 2) { 
				j = new Jogo("J1", estrategia1, "J2", estrategia2, NUM_PECAS_INICIAL);
			} else {
				j = new Jogo("J2", estrategia2, "J1", estrategia1, NUM_PECAS_INICIAL);
			}
			
			HistoricoDeJogo historico = j.jogaJogoCompleto();
			String tipoDeVitoria = historico.getTipoDeVitoria(); 
			
			if (historico.isEmpate()) {
				empates++;
			} else if (historico.getVencedor() == "J1") {
				vitoriasJ1++;
				atribuirDadosDeJ1(tipoDeVitoria,tiposVitoriasJ1,somaPontuacoes);

			} else if (historico.getVencedor() == "J2") {
				vitoriasJ2++;
				atribuirDadosDeJ2(tipoDeVitoria,tiposVitoriasJ2,somaPontuacoes);
			}
			
		}

		String vencedor = vencedorPorPontos(somaPontuacoes);
		
		System.out.println(
				"====================================="
		        + "\n          ESTATÍSTICA GERAL"     
		        + "\n====================================="
		        + "\n -> Total De Jogos:\t" + (REPETICOES) 
				+ "\n -> Vitórias De E1:\t" + vitoriasJ1 + "  (" + Math.round((float)vitoriasJ1 / REPETICOES * 100) + "%)" 
				+ "\n -> Vitórias De E2:\t" + vitoriasJ2 + "  (" + Math.round((float)vitoriasJ2 / REPETICOES * 100) + "%)" 
				+ "\n -> Total De Empates:\t  " + empates + "   (" + Math.round((float)empates / REPETICOES * 100) + "%)"
				+ "\n -> Vitória Por Pontos:\t   "  + vencedor
				+ "\n====================================="
		        + "\n          ESTATÍSTICA DE J1"     
		        + "\n====================================="
		        + "\n -> Pontuação:\t\t" + somaPontuacoes[0]
		        + "\n -> Batida Normal:\t" + tiposVitoriasJ1[0] + "  (" + Math.round((float)tiposVitoriasJ1[0] / vitoriasJ1 * 100) + "%)"
		        + "\n -> Batida Carroça:\t " + tiposVitoriasJ1[1] + "   (" + Math.round((float)tiposVitoriasJ1[1] / vitoriasJ1 * 100) + "%)"
		        + "\n -> Batida La e Lô:\t  " + tiposVitoriasJ1[2] + "   (" + Math.round((float)tiposVitoriasJ1[2] / vitoriasJ1 * 100) + "%)"
		        + "\n -> Batida Cruzada:\t   " + tiposVitoriasJ1[3] + "   (" + Math.round((float)tiposVitoriasJ1[3] / vitoriasJ1 * 100) + "%)"
        		+ "\n====================================="
		        + "\n          ESTATÍSTICA DE J2"     
		        + "\n====================================="
		        + "\n -> Pontuação:\t\t" + somaPontuacoes[1]
		        + "\n -> Batida Normal:\t" + tiposVitoriasJ2[0] + "  (" + Math.round((float)tiposVitoriasJ2[0] / vitoriasJ2 * 100) + "%)"
		        + "\n -> Batida Carroça:\t " + tiposVitoriasJ2[1] + "   (" + Math.round((float)tiposVitoriasJ2[1] / vitoriasJ2 * 100) + "%)"
		        + "\n -> Batida Lá e Lô:\t  " + tiposVitoriasJ2[2] + "   (" + Math.round((float)tiposVitoriasJ2[2] / vitoriasJ2 * 100) + "%)"
		        + "\n -> Batida Cruzada:\t   " + tiposVitoriasJ2[3] + "   (" + Math.round((float)tiposVitoriasJ2[3] / vitoriasJ2 * 100) + "%)");
	
    }

    /**
     * MÉTODO QUE COMPARA AS PONTUAÇÕES E RETORNAR O VENCEDOR.
     * @param somaPontuacoes
     * @return
     */
	private static String vencedorPorPontos(int[] somaPontuacoes) {
		String retornar = "";
		if(somaPontuacoes[0] > somaPontuacoes[1]) {
			retornar = "J1";
		}
		else {
			if((somaPontuacoes[0] < somaPontuacoes[1])) {
				retornar = "J2";
			}
		}
		return retornar;
	}

    /**
     * MÉTODO QUE ATRIBUI E ATUALIZA A CADA RODADA A PONTUAÇÃO E A QUANTIDADE DE CADA TIPO DE VITOŔIA DO JOGADOR 1.
     * @param tipoDeVitoria
     * @param tiposVitoriasJ1
     * @param somaPontuacoes
     */
	private static void atribuirDadosDeJ1(String tipoDeVitoria, int[] tiposVitoriasJ1, int[] somaPontuacoes) {
		if(tipoDeVitoria.equals("NORMAL")) {
			tiposVitoriasJ1[0]++;
			somaPontuacoes[0]++;
		}
		if(tipoDeVitoria.equals("CARROCA")) {
			tiposVitoriasJ1[1]++;
			somaPontuacoes[0] += 2;
		}
		if(tipoDeVitoria.equals("LA E LO")) {
			tiposVitoriasJ1[2]++;
			somaPontuacoes[0] += 3;
		}
		if(tipoDeVitoria.equals("LA E LO E CARROCA")) {
			tiposVitoriasJ1[3]++;
			somaPontuacoes[0] += 6;
		}
	}
	
	/**
	 * MÉTODO QUE ATRIBUI E ATUALIZA A CADA RODADA A PONTUAÇÃO E A QUANTIDADE DE CADA TIPO DE VITOŔIA DO JOGADOR 1.
	 * @param tipoDeVitoria
	 * @param tiposVitoriasJ2
	 * @param somaPontuacoes
	 */
	private static void atribuirDadosDeJ2(String tipoDeVitoria, int[] tiposVitoriasJ2, int[] somaPontuacoes) {
		if(tipoDeVitoria.equals("NORMAL")) {
			tiposVitoriasJ2[0]++;
			somaPontuacoes[1]++;
		}
		if(tipoDeVitoria.equals("CARROCA")) {
			tiposVitoriasJ2[1]++;
			somaPontuacoes[1] += 2;
		}
		if(tipoDeVitoria.equals("LA E LO")) {
			tiposVitoriasJ2[2]++;
			somaPontuacoes[1] += 3;
		}
		if(tipoDeVitoria.equals("LA E LO E CARROCA")) {
			tiposVitoriasJ2[3]++;
			somaPontuacoes[1] += 6;
		}
	}
	
}