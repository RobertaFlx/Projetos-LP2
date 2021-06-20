package Lab02;

/**
 * ESSA CLASSE É RESPONSÁVEL PELO REGISTRO TANTO DA SAÚDE MENTAL QUANTO DA FÍSICA,
 * RETORNA O STATUS GERAL DE SAÚDE.
 */

public class Saude {
    private String saudeMental;
    private String saudeFisica;
    private String emoji = new String();

    /**
     * ESSE CONSTRUTOR INICIALIZA A SAÚDE DO ALUNO COMO BOA.
     */
    public Saude(){
        this.saudeFisica = "boa";
        this.saudeMental = "boa";
    }

    /**
     * OS TRÊS PRÓXIMOS MÉTODOS SÃO RESPONSÁVEIS POR ATRIBUIREM OS PARÂMETROS PASSADOS À SAÚDE MENTAL,
     * À SAÚDE FÍSICA E AO EMOJI(REFERENTE AO BÔNUS 5.3) RESPECTIVAMENTE.
     * @param valor
     */
    public void defineSaudeMental(String valor) {
        this.saudeMental = valor;
        this.emoji = "";
    }

    public void defineSaudeFisica(String valor) {
        this.saudeFisica = valor;
        this.emoji = "";
    }

    public void definirEmoji(String valor){
        this.emoji = valor;
    }

    /**
     * ESSE MÉTODO É RESPONSÁVEL POR FAZER UMA RELAÇÃO ENTRE A SAÚDE MENTAL E FÍSICA
     * E RETORNAR O STATUS DE SAÚDE GERAL.
     * @return
     */
    public String getStatusGeral() {
        String saudeGeral;

        if(this.saudeFisica.equals("boa") && this.saudeMental.equals("boa")){
            saudeGeral = "boa" + " " + this.emoji;
        }else if(this.saudeFisica.equals("fraca") && this.saudeMental.equals("fraca")){
            saudeGeral = "fraca" + " " + this.emoji;
        }else{
            saudeGeral = "ok" + " " + this.emoji;;
        }

        return saudeGeral;
    }

}
