package controle;

/**
 * ESSA CLASSE É RESPONSÁVEL PELO CADASTRO DOS DADOS DE UM ALUNO, SÃO ELES: NOME, CURSO E MATRÍCULA.
 */
public class Aluno {
	
    private String nome;
    private String curso;
    private String matricula;

    /**
     * CONSTRÓI UM ALUNO COM NOME, CURSO E MATRÍCULA.
     * @param nome
     * @param curso
     */
    public Aluno(String nome, String curso, String matricula) {
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
    }
       
    /**
     * MÉTODO QUE RETORNA O CURSO DO ALUNO.
     * @return
     */
    public String getCurso() {
        return this.curso;
    }
    
    /**
     * MÉTODO QUE RETORNA OS DADOS FORMATADOS DO ALUNO.
     * @return
     */
    public String toString() {
    	return matricula + " - " + nome + " - " + curso;
    }
}