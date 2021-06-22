package controle;

import java.util.HashSet;

/**
 * ESSA CLASSE É RESPONSÁVEL PELO CADASTRO DOS DADOS DE UM GRUPO, SÃO ELES: NOME, RESTRIÇÃO E ALUNOS.
 */
public class Grupo {
	
    private HashSet<Aluno> alunos;
    private String nome;
    private String restricao;

    /**
     * CONSTRÓI UM GRUPO COM NOME E RESTRIÇÃO E ALUNOS.
     * @param nome
     * @param restricao
     */
    public Grupo(String nome, String restricao) {
        this.nome = nome;
        this.restricao = restricao;
        this.alunos = new HashSet<>();
    }
    
    /**
     * MÉTODO QUE RETORNA O NOME DO GRUPO.
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * MÉTODO QUE RETORNA A RESTRIÇÃO DO GRUPO.
     * @return
     */
    public String getRestricao() {
        return this.restricao;
    }
    
    /**
     * ALOCA O ALUNO NO GRUPO.
     * @param aluno
     */
    public void setAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }
    
    /**
     * MÉTODO QUE VERIFICA SE O ALUNO ESTÁ CADASTRADO NO GRUPO.
     * @param aluno
     * @return
     */
    public boolean contemAluno(Aluno aluno) {
    	return this.alunos.contains(aluno);
    }
}
