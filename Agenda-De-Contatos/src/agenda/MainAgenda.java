package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * LABORATÓRIO DE PROGRAMAÇÃO 2 - LAB03
 * 
 * @author ROBERTA FELIX DA SILVA
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * ESSA É A MANEIRA DE LIDAR COM POSSÍVEIS ERROS POR FALTA DE ARQUIVO.
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * EXIBE O MENU E CAPTURA A ESCOLHA DO/A USÚARIO/A.
	 * @param scanner Para captura da opção do usuário
	 * @return O comando escolhido
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * INTERPRETA A OPÇÃO ESCOLHIDA POR QUEM ESTÁ USANDO O SISTEMA.
	 * @param opcao   Opção digitada
	 * @param agenda  A agenda que estamos manipulando
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;	
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * CADASTRA UM CONTATO NA AGENDA.
	 * @param agenda A agenda
	 * @param scanner Scanner para pedir informações do contato
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda: ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		
		System.out.print("\nNome: ");
		String nome = scanner.nextLine();
		
		System.out.print("\nSobrenome: ");
		String sobrenome = scanner.nextLine();
		
		System.out.print("\nPrioritário: ");
		String numeroPrincipal = scanner.nextLine();
		
		System.out.print("\nWhatsApp: ");
		String numeroWhatsApp = scanner.nextLine();
		
		System.out.print("\nAdicional: ");
		String numeroAdicional = scanner.nextLine();
		
		System.out.println(agenda.cadastraContato(posicao,nome,sobrenome,numeroPrincipal,numeroWhatsApp,numeroAdicional));
		
	}
	
	/**
	 * IMPRIME LISTA DE CONTATOS DA AGENDA.
	 * @param agenda A agenda sendo manipulada
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println(agenda.listarContatos());
	}
	
	/**
	 * IMPRIME OS DETALHES DE UM DOS CONTATOS DA AGENDA.
	 * @param agenda A agenda
	 * @param scanner Scanner para capturar qual contato
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		System.out.print(agenda.exibirContato(posicao));
		
	}
	
	/**
	 * IMPRIME LISTA DE FAVORITOS DA AGENDA.
	 * @param agenda A agenda sendo manipulada
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println(agenda.listarFavoritos());
	}

	/**
	 * ADICIONA CONTATO CADASTRADO COMO FAVORITO.
	 * @param agenda A agenda sendo manipulada
	 * @param scanner Scanner para capturar qual contato e em qual posição
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int contato = scanner.nextInt();
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt();
		System.out.println(agenda.adicionarFavorito(contato,posicao));
	}

	/**
	 * SAI DA APLICAÇÃO.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * LÊ UMA AGENDA DE UM ARQUIVO CSV.
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
