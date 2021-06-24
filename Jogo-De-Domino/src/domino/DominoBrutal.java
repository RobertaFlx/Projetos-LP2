package domino;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import domino.estrategia.EstrategiaDeJogo;
import domino.estrategia.EstrategiaInvalidaException;
import domino.estrategia.JogaCarrocaMaior;
import domino.estrategia.JogaPrimeiraPossivel;
import domino.estrategia.JogaPrimeiraPossivelComparadora;

/**
 * EXEMPLO DE COMO FAZER UMA DISPUTA ENTRE DUAS ESTRATÉGIAS EM UMA UI.
 */
public class DominoBrutal {

	public static void main(String[] args) {
		
		List<EstrategiaDeJogo> estrategias = new ArrayList<>();
		estrategias.add(new JogaPrimeiraPossivel());
		estrategias.add(new JogaCarrocaMaior()); 
		
		Comparator<Peca> cmp = new PecaPadraoComparator();
		
		Jogo j = new Jogo("J1", new JogaPrimeiraPossivel(), 
						  "J2", new JogaPrimeiraPossivelComparadora(cmp), 
						  12); 

		HistoricoDeJogo historico;
		
		try {
			historico = j.jogaJogoCompleto();
			System.out.println(historico.toString());
		} catch (EstrategiaInvalidaException e) {
			e.printStackTrace();
		} catch (JogadaInvalidaException e) {
			e.printStackTrace();
		}
		
	}

}
