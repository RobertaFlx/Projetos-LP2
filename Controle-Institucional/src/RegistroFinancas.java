package Lab02;

/**
 * ESSA CLASSE É RESPONSÁVEL PELO REGISTRO DE FINANÇAS(EM CENTAVOS) DE UM ALUNO, 
 * RETORNANDO SUA RECEITA TOTAL, SUA RECEITA ATUAL E SUAS DESPESAS.
 */

public class RegistroFinancas {
    int[] receitaTipo = {0,0,0,0};
    int despesa = 0;

    /**
     * A INICIALIZAÇÃO É SEMPRE REGISTRADA NO PRIMEIRO TIPO DE FONTE DE RENDA.
     * @param receitaInicialDoTipo1
     */
    public RegistroFinancas(int receitaInicialDoTipo1) {
        this.receitaTipo[0] = receitaInicialDoTipo1;
    }

    /**
     * ESSE MÉTODO AUMENTA O VALOR DA RECEITA EM UM TIPO ESPECÍFICO DE FONTE.
     * @param valorCentavos
     * @param tipoFonte
     */
    public void aumentaReceita(int valorCentavos, int tipoFonte) {
        this.receitaTipo[tipoFonte-1] += valorCentavos;
    }

    /**
     * ESSE MÉTODO ARMAZENA O DINHEIRO GASTO COM DESPESAS.
     * @param valorCentavos
     */
    public void pagaDespesa(int valorCentavos) {
        this.despesa += valorCentavos;
    }

    /**
     * MÉTODO QUE EXIBE O VALOR DA RECEITA ORGANIZADO NAS QUATRO FONTES DE RENDA DO ALUNO.
     * @return
     */
    public String exibeFontes() {
        return "1 - " + this.receitaTipo[0] + "\n2 - " + this.receitaTipo[1] + "\n3 - " + this.receitaTipo[2] + "\n4 - " + this.receitaTipo[3];
    }

    /**
     * ESSE MÉTODO CALCULA A RECEITA TOTAL DO ALUNO E A RETORNA, JUNTAMENTE COM A RECEITA ATUAL
     * E COM SUAS DESPESAS.
     * @return
     */
    public String toString(){
        int total =0;
        for(int i=0; i<this.receitaTipo.length; i++){
            total += this.receitaTipo[i];
        }
        return "Receita total: " + total + ", Receita atual: " + (total - this.despesa) + ", Despesas totais: " + this.despesa;
    }

}
