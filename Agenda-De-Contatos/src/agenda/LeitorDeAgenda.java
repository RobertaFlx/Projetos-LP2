package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * CLASSE RESPONSÁVEL PELA LÓGICA PARA LER OS DADOS DE ARQUIVOS CSV PARA POVOAR UMA AGENDA.
 */
public class LeitorDeAgenda {

	private static final int COLUNA_POSICAO = 0;
	private static final int COLUNA_NOME = 1;
	private static final int COLUNA_SOBRENOME = 2;
	private static final int COLUNA_PRINCIPAL = 3;
	private static final int COLUNA_WHATS = 4;
	private static final int COLUNA_ADICIONAL = 5;


	/**
	 * LÊ CONTANTOS DE UM ARQUIVO CSV E OS COLOCA EM UMA AGENDA.
	 * @param arquivoContatos Caminho para arquivo contendo contatos.
	 * @param agenda A agenda a manipular.
	 * @return O número de contatos adicionados à agenda.
	 * @throws IOException Caso não tenhamos permissão de ler o arquivo.
	 * @throws FileNotFoundException Caso o arquivo não exista.
	 */
	public int carregaContatos(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		int carregados = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(arquivoContatos))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				carregados += 1;
				if (carregados == 1) {
					// pulamos a primeira linha, o cabeçalho
					continue;
				}
				String[] campos = linha.split(",");
				processaLinhaCsvContatos(campos, agenda);
			}
		}
		
		return carregados;
	}

	
	/**
	 * COLOCA NO ARQUIVO COM A AGENDA INICIAL A NOVA LINHA DE DADOS DO NOVO CONTATO. 
	 * @param campos As informações lidas do csv. 
	 * @param agenda A agenda a manipular. 
	 */
	private void processaLinhaCsvContatos(String[] campos, Agenda agenda) {
		int posicao = Integer.parseInt(campos[COLUNA_POSICAO]);
		String nome = campos[COLUNA_NOME].trim();
		String sobrenome = campos[COLUNA_SOBRENOME].trim();
		String numeroPrincipal = campos[COLUNA_PRINCIPAL].trim();
		String numeroWhats = campos[COLUNA_WHATS].trim();
		String numeroAdicional = campos[COLUNA_ADICIONAL].trim();
		
		agenda.cadastraContato(posicao, nome, sobrenome, numeroPrincipal, numeroWhats, numeroAdicional);
	}

}
