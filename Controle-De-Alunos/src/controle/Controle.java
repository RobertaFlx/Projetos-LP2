package controle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * ESSA CLASSE É RESPONSÁVEL PELA CRIAÇÃO DE UM CONTROLE DE ALUNOS DE GRUPOS.
 */
public class Controle {
	
	private HashMap<String, Aluno> alunos;
	private HashMap<String, Grupo> grupos = new HashMap<>();
	private ArrayList<Aluno> alunosQueResponderam = new ArrayList<>();
	
	public Controle() {
		this.alunos = new HashMap<>();
	} 
	
	/**
	 * CADASTRA UM ALUNO COM NOME, MATRÍCULA E CURSO. 
	 * @param matricula
	 * @param nome
	 * @param curso
	 * @return
	 */
	public String cadastrarAluno(String matricula, String nome,String curso) {
		String retornar = "";
		if (alunos.containsKey(matricula)) {
			retornar = "MATRÍCULA JÁ CADASTRADA!";
		}
		else {
			Aluno aluno = new Aluno(nome, curso, matricula);
			this.alunos.put(matricula, aluno);
			retornar = "CADASTRO REALIZADO!";
		}
		return retornar;
	}
	
	/**
	 * EXIBE OS DADOS DE UM ALUNO A PARTIR DA MATRÍCULA.
	 * @param matricula
	 * @return dados do aluno
	 */
	public String exibirAluno(String matricula) {
		String retornar = "";
		if (alunos.containsKey(matricula)) {
			Aluno aluno = this.alunos.get(matricula);
			retornar = "Aluno: " + aluno.toString();
		}
		else {
			retornar = "ALUNO NÃO CADASTRADO!";
		}
		return retornar; 
	}
	
	/**
	 * CADASTRA UM GRUPO COM NOME E RESTRIÇÃO DE CURSO.
	 * @param nome
	 * @param restricao
	 * @return
	 */
	public String cadastrarGrupo(String nomeGrupo, String restricao) {
		String retornar = "";
		String nomeEmMaiusculo = nomeGrupo.toUpperCase();  //COLOCA O NOME DO GRUPO EM MAIÚSCULO.
		if (grupos.containsKey(nomeEmMaiusculo)) {
			retornar = "GRUPO JÁ CADASTRADO!";
		}
		else {
			Grupo grupo = new Grupo(nomeGrupo, restricao);
			this.grupos.put(nomeEmMaiusculo, grupo);  //SALVA O NOME DO GRUPO EM MAIÚSCULO.
			retornar = "GRUPO CADASTRADO!";
		}
		return retornar;
	}
	
	/**
	 * ALOCA ATRAVÉS DA MATRÍCULA UM ALUNO EM UM GRUPO.
	 * @param matricula
	 * @param nomeGrupo
	 * @return
	 */
	public String alocarAluno(String matricula, String nomeGrupo) {
		String retornar = "";
		if (!(alunos.containsKey(matricula))) {
			retornar = "ALUNO NÃO CADASTRADO!";
		}
		else {
			if (!(grupos.containsKey(nomeGrupo.toUpperCase()))) {  //VERIFICANDO SE EXISTE O NOME DO GRUPO EM MAIÚSCULO.
				retornar = "GRUPO NÃO CADASTRADO!";
			}
			else {
				Aluno aluno = this.alunos.get(matricula);
				Grupo grupo = this.grupos.get(nomeGrupo.toUpperCase());	
				String cursoAluno = aluno.getCurso();
				String restricaoDoGrupo = grupo.getRestricao();
				if ((!(cursoAluno.equals(restricaoDoGrupo))) && (!(restricaoDoGrupo.equals("")))) {
					retornar = "GRUPO COM RESTRIÇÃO DE CURSO!";
				}		
				else {
					grupo.setAluno(aluno);
					retornar = "ALUNO ALOCADO!";
				}
		    }
		}	
		return retornar;  
	}
	
	/**
	 * VERIFICA ATRAVÉS DA MATRÍCULA SE UM ALUNO PERTENCE A UM GRUPO.
	 * @param nomeGrupo
	 * @param matricula
	 * @return
	 */
	public String verificarPertinencia(String nomeGrupo, String matricula) {
		String retornar = "";
		if (!(alunos.containsKey(matricula))) {
			retornar = "ALUNO NÃO CADASTRADO!";
		} 
		else {
			if (!(grupos.containsKey(nomeGrupo.toUpperCase()))) {  //VERIFICANDO SE EXISTE O NOME DO GRUPO EM MAIÚSCULO.
				retornar = "GRUPO NÃO CADASTRADO!";
			}
			else {
				Aluno aluno = this.alunos.get(matricula);
				Grupo grupo = grupos.get(nomeGrupo.toUpperCase());  //PEGA O NOME DO GRUPO E COLOCA EM MAIÚSCULO PARA FUTURA VERIFICAÇÃO.
				if (grupo.contemAluno(aluno)) {  //VERIFICANDO SE O ALUNO EXISTE NO GRUPO.
					retornar = "ALUNO PERTENCE AO GRUPO";
				}
				else {
					retornar = "ALUNO NÃO PERTENCE AO GRUPO";
				}
			}
		}	
		return retornar;
	}
	
	/**
	 * REGISTRANDO UM ALUNO NA LISTA DOS ALUNOS QUE RESPONDERAM
	 * @param matricula
	 * @return
	 */
	public String registrarAlunoQueRespondeu(String matricula) {
		String retornar = "";
		if (!(alunos.containsKey(matricula))) {
			retornar = "ALUNO NÃO CADASTRADO!";
		}
		else {
			Aluno aluno = this.alunos.get(matricula);
	        alunosQueResponderam.add(aluno);
	        retornar = "ALUNO REGISTRADO!";
		}
	    return retornar;
	} 

	/**
	 * IMPRIME A LISTA DOS ALUNOS QUE RESPONDERAM
	 * @return
	 */
	public String imprimeAlunosQueResponderam() {
		String retornar = "Alunos:";
		int cont = 1;
		for(Aluno aluno : alunosQueResponderam) {
			retornar += "\n" + cont + ". " + aluno.toString();
			cont +=1;
		}
		return retornar;
	}
	 
	/**
	 * CONTADOR DE GRUPOS QUE TEM A RESTRIÇÃO IGUAL AO CURSO INSERIDO.
	 * @param curso
	 * @return
	 */
	public String contadorDeGruposComRestricao(String curso) {
		String retornar = "";
		int cont = 0;
		for (Grupo grupo : this.grupos.values()) {
			if (grupo.getRestricao().equals(curso)) {
				cont = cont + 1;
			}
		}
		retornar = curso + " " + cont;
		return retornar;
	}

}
