package controle;

import java.util.Scanner;

/**
 * LABORATÓRIO DE PROGRAMAÇÃO 2 - LAB04
 * 
 * @author ROBERTA FELIX DA SILVA
 */
public class MainControle {
	 
	public static void main(String[] args) {
		Controle controle = new Controle();
		Scanner scanner = new Scanner(System.in);
		String escolha = "";

		while (true) {
			escolha = menu(scanner);
			comando(escolha, controle, scanner);
		}

	}

	/**
	 * EXIBE O MENU E CAPTURA A ESCOLHA DO/A USÚARIO/A.
	 * @param scanner 
	 * @return comando escolhido
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" +
					"(C)adastrar Aluno\n" +
					"(E)xibir Aluno\n" +
					"(N)ovo Grupo\n" +
					"(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n" +
					"(R)egistrar Aluno que Respondeu\n" +
					"(I)mprimir Alunos que Responderam\n" +
					"(O)xe, e a contagem dos grupos com restrição de curso?\n" +
					"(S)im, quero fechar o programa!\n" +
					"\n" +
					"Opção>" );
	
		return scanner.nextLine().toUpperCase();
		}
	
	/**
	 * INTERPRETA A OPÇÃO ESCOLHIDA POR QUEM ESTÁ USANDO O SISTEMA.
	 * @param opcao
	 * @param controle
	 * @param scanner
	 */
	public static void comando(String opcao, Controle controle, Scanner scanner) {
		switch (opcao) {
			case "C":
				cadastraAluno(scanner, controle);	
				break;
			case "E":
				exibeAluno(scanner,controle);
				break;
			case "N":
				cadastraGrupo(scanner,controle);
				break;
			case "A":
				alocaAlunoOuVerificaPertinencia(scanner,controle);
				break;
			case "R":
				registraAlunoQueRespondeu(scanner,controle);
				break;
			case "I":
	            imprimeAlunosQueResponderam(controle);
				break;
			case "O":
				contaGruposComRestricao(scanner,controle);
				break;
			case "S":
				sai();
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
				sai();
		}
	}

	/**
	 * CADASTRA UM ALUNO NO CONTROLE.
	 * @param scanner
	 * @param controle
	 */
	public static void cadastraAluno(Scanner scanner, Controle controle) {
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		System.out.println("Nome: ");
		String nome = scanner.nextLine();
		System.out.println("Curso: ");
		String curso = scanner.nextLine();
		System.out.println(controle.cadastrarAluno(matricula, nome, curso));
	}
	
	/**
	 * IMPRIME OS DADOS DE UM DOS ALUNOS CADASTRADOS.
	 * @param scanner
	 * @param controle
	 */
	public static void exibeAluno(Scanner scanner, Controle controle) {
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		System.out.println(controle.exibirAluno(matricula));
	}
	
	/**
	 * CADASTRA UM GRUPO NO CONTROLE.
	 * @param scanner
	 * @param controle
	 */
	public static void cadastraGrupo(Scanner scanner, Controle controle) {
		System.out.println("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		System.out.println("Restrição? ");
		String restricao = scanner.nextLine();
		System.out.println(controle.cadastrarGrupo(nomeGrupo, restricao));
	}
	
	/**
	 * INTERPRETA A OPÇÃO ESCOLHIDA POR QUEM ESTÁ USANDO O SISTEMA.
     * @param scanner
	 * @param controle
	 */
	public static void alocaAlunoOuVerificaPertinencia(Scanner scanner, Controle controle) {
		System.out.println("(A)locar Aluno ou (P)ertinência a Grupo? ");
		String opcao = scanner.nextLine().toUpperCase();
		if (opcao.equals("A")) {
			System.out.println(alocaAluno(scanner,controle));
		}
		else if (opcao.equals("P")) {
			System.out.println(verificaPertinencia(scanner,controle));
		}
		else {
			System.out.println("OPÇÃO INVÁLIDA");
		}	
	}
	
	/**
	 * ALOCA O ALUNO EM UM GRUPO.
	 * @param scanner
	 * @param controle
	 * @return
	 */
	public static String alocaAluno(Scanner scanner, Controle controle) {
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		System.out.println("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		return controle.alocarAluno(matricula, nomeGrupo);		
	}
	
	/**
	 * VERIFICA SE UM ALUNO PERTENCE OU NÃO A UM GRUPO.
	 * @param scanner
	 * @param controle
	 * @return
	 */
	public static String verificaPertinencia(Scanner scanner, Controle controle) {
		System.out.println("Grupo: ");
		String nomeGrupo = scanner.nextLine();
		System.out.println("Aluno: ");
		String matricula = scanner.nextLine();
		return controle.verificarPertinencia(nomeGrupo, matricula);
	}
	
	/**
	 * REGISTRA UM ALUNO NA LISTA DOS ALUNOS QUE RESPONDERAM
	 * @param scanner
	 * @param controle
	 */
	private static void registraAlunoQueRespondeu(Scanner scanner, Controle controle) {
		System.out.println("Matrícula: ");
		String matricula = scanner.nextLine();
		System.out.println(controle.registrarAlunoQueRespondeu(matricula));
	}
	
	/**
	 * IMPRIME A LISTA DOS ALUNOS QUE RESPONDERAM
	 * @param controle
	 */
	private static void imprimeAlunosQueResponderam(Controle controle) {
		System.out.println(controle.imprimeAlunosQueResponderam());
	}
	
	/**
	 * CONTADOR DE GRUPOS COM A RESTRIÇÃO DE CURSO.
	 * @param scanner
	 * @param controle
	 */
	public static void contaGruposComRestricao(Scanner scanner, Controle controle) {
		System.out.println("Curso: ");
		String curso = scanner.nextLine();
		System.out.println(controle.contadorDeGruposComRestricao(curso));
	}
	
	/**
	 * SAI DA APLICAÇÃO.
	 */
	public static void sai() {
		System.exit(0);
	}
	
}
