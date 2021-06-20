package Lab02;

/**
 * ESSA CLASSE É RESPONSÁVEL POR REGISTRAR O TEMPO ONLINE QUE O ALUNO TEM USADA PARA SE DEDICAR 
 * A UMA MATÉRIA ESPECÍFICA E COMPARAR COM A QUANTIDADE DE HORAS ESPERADA.
 */

public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineEsperado;
    private int tempo = 0;

    /**
     * CONSTRUTOR QUE REGISTRA O NOME DA DISCIPLINA E DEFINE QUE O TEMPO ESPERADO EM HORAS É 120.
     * @param nomeDisciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * CONSTRUTOR QUE REGISTRA O NOME DA DISCIPLINA E O TEMPO ESPERADO PASSADOS POR PARÂMETRO.
     * @param nomeDisciplina
     * @param tempoOnlineEsperado
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int tempo) {
        this.tempo += tempo;
    }

    /**
     * MÉTODO QUE RETORNA TRUE SE O TEMPO DE ESTUDO FOR MAIOR OU IGUAL AO TEMPO DE ESTUDO ESPERADO,
     * EM CASO CONTRÁRIO RETORNA FALSE.
     * @return
     */
    public boolean atingiuMetaTempoOnline() {
        if(tempo >= tempoOnlineEsperado){
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return nomeDisciplina + " " + tempo + "/" + tempoOnlineEsperado;
    }

}
