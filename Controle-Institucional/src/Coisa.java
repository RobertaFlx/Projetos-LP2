package Lab02;

/**
 * LABORATÓRIO DE PROGRAMAÇÃO 2 - LAB02
 * @author ROBERTA FELIX DA SILVA
 */

public class Coisa {
    public static void main(String[] args) {
        RegistroTempoOnline tempoLP2 = new RegistroTempoOnline("LP2", 30);

        tempoLP2.adicionaTempoOnline(10);
        System.out.println(tempoLP2.
        atingiuMetaTempoOnline());

        tempoLP2.adicionaTempoOnline(10);
        tempoLP2.adicionaTempoOnline(10);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());

        tempoLP2.adicionaTempoOnline(2);
        System.out.println(tempoLP2.atingiuMetaTempoOnline());

        System.out.println(tempoLP2.toString());

        
        Disciplina prog2 = new Disciplina("PROGRAMACAO 2");
        prog2.cadastraHoras(4);
        prog2.cadastraNota(1, 5.0);
        prog2.cadastraNota(2, 6.0);
        prog2.cadastraNota(3, 7.0);
        System.out.println(prog2.aprovado());

        prog2.cadastraNota(4, 10.0);
        System.out.println(prog2.aprovado());
        System.out.println(prog2.toString());
        
        
        RegistroFinancas minhaFinanca = new RegistroFinancas(100000);   	 
        minhaFinanca.aumentaReceita(12000, 1);
        minhaFinanca.aumentaReceita(72100, 2);
        minhaFinanca.pagaDespesa(20000);
        System.out.println(minhaFinanca.exibeFontes());
        System.out.println(minhaFinanca.toString());

        
        Saude saude = new Saude();
        System.out.println(saude.getStatusGeral());
        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("boa");
        System.out.println(saude.getStatusGeral());

        saude.defineSaudeMental("fraca");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());

        saude.defineSaudeMental("boa");
        saude.defineSaudeFisica("fraca");
        System.out.println(saude.getStatusGeral());
        
    }
}
