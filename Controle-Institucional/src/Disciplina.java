package Lab02;

/**
 * ESSA CLASSE É RESPONSÁVEL POR CADASTRAR A DISCIPLINA, QUANTIDADE DE HORAS USADAS NELA E 
 * AS QUATRO NOTAS DO ALUNO E ALÉM DE RETORNAR TUDO JÁ CITADO, RETORNA A MÉDIA E UM VALOR BOOLEANO 
 * QUE SIGNIFICA QUE O ALUNO PASSOU OU NÃO. 
 */

public class Disciplina {
    private String nomeDisciplina;
    private int horas = 0;
    private double[] notas = {0,0,0,0};
    private double media = 0;

    /**
     * O MÉTODO É RESPONSÁVEL POR ATRIBUIR O PARÂMETRO PASSADO AO NOME DA DISCIPLINA.
     * @param nomeDisciplina
     */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
     * ESSE MÉTODO É RESPONSÁVEL POR CADASTRAR E SOMAR A QUANTIDADE DE HORAS.
     * @param horas
     */
    public void cadastraHoras(int horas) {
        this.horas += horas;
    }

    /**
     * MÉTODO QUE CADASTRA AS NOTAS.
     * @param nota
     * @param valorNota
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota-1] = valorNota;
    }

    /**
     * MÉTODO QUE RETORNA TRUE SE O ALUNO PASSOU, CASO CONTRÁRIO RETORNA FALSE.
     * @return
     */
    public boolean aprovado() {
        media = 0;
        for(int i=0; i<this.notas.length; i++){
            this.media += this.notas[i];
        }

        this.media = this.media/this.notas.length;

        if(this.media >= 7){
            return true;
        }else{
            return false;
        }
    }

    /**
     * MÉTODO USADO PARA FORMATAR A MÉDIA E AS QUATRO NOTAS DO ALUNO E RETORNAR TUDO JÁ CITADO.
     * @return
     */
    public String toString(){
        String mediaFormatada = String.format("%.1f", media);
        String[] notasFormatada = new String[4];
        for(int i=0; i<this.notas.length; i++){
            notasFormatada[i] = String.format("%.1f", this.notas[i]);
        }
        String listaFormatada = "[" + notasFormatada[0] + ", " + notasFormatada[1] + ", " + notasFormatada[2] + ", " + notasFormatada[3] + "]";

        return nomeDisciplina + " " + horas + " " + mediaFormatada + " " + listaFormatada ;
    }

}
