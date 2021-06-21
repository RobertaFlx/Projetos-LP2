package agenda;

/**
 * ESSA CLASSE É RESPONSÁVEL PELO CADASTRO DOS DADOS DO CONTATO, SÃO ELES: NOME, SOBRENOME, NÚMERO PRINCIPAL, NÚMERO DE WHATSAPP E NÚMERO ADICIONAL.
 */
public class Contato {
	
	private String nome;
	private String sobrenome;
	private String numeroPrincipal;
	private String numeroWhatsApp;
	private String numeroAdicional;
	
	/**
	 * CONTRÓI UM CONTATO COM NOME, SOBRENOME, NÚMERO DE TELEFONE PRINCIPAL, NÚMERO DE WHATSAPP E NÚMERO ADICIONAL.
	 * @param nome
	 * @param sobrenome
	 * @param numPrincipal
	 * @param numWhats
	 * @param numAdicional
	 */
	public Contato(String nome, String sobrenome, String numPrincipal, String numWhats, String numAdicional) {
		
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroPrincipal = numPrincipal;
		this.numeroWhatsApp = numWhats;
		this.numeroAdicional = numAdicional;
	}
	
	/**
	 * CONTRÓI UM CONTATO COM NOME, SOBRENOME, NÚMERO DE TELEFONE PRINCIPAL, NÚMERO DE WHATSAPP.
	 * @param nome
	 * @param sobrenome
	 * @param numPrincipal
	 * @param numWhats
	 */
	public Contato(String nome, String sobrenome, String numPrincipal, String numWhats) {
			
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numeroPrincipal = numPrincipal;
		this.numeroWhatsApp = numWhats;
	}
	
	/**
	 * MÉTODO QUE RETORNA O NOME DO CONTATO.
	 * @return Nome do Contato
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * MÉTODO QUE RETORNA O SOBRENOME DO CONTATO.
	 * @return Sobrenome do Contato
	 */
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	/**
	 * MÉTODO QUE RETORNA O NÚMERO PRINCIPAL DO CONTATO.
	 * @return Número Principal
	 */
	public String getPrincipal() {
		return this.numeroPrincipal;
	}
	
	/**
	 * MÉTODO QUE RETORNA O NÚMERO DO WHATSAPP DO CONTATO.
	 * @return Número do Whatsapp
	 */
	public String getWhats() {
		return this.numeroWhatsApp;
	}
	
	/**
	 * MÉTODO QUE RETORNA O NÚMERO ADICIONAL DO CONTATO.
	 * @return Número Adicional
	 */
	public String getAdicional() {
		return this.numeroAdicional;
	}
	
	/**
	 * MÉTODO QUE RETORNA OS DADOS DO CONTATO.
	 * @return Nome, Sobrenome, Número Principal, Número Whatsapp, Número Adicional.
	 */
	public String toString() {
		String retornar = "";
		if(!this.numeroAdicional.trim().equals("\"\"") && !this.numeroAdicional.equals("")) {
			retornar = (nome + " " + sobrenome + "\n" + numeroPrincipal + " (Prioritário)" + "\n" + numeroWhatsApp + " (WhatsApp)" + "\n" + numeroAdicional + " (Adicional)");
		}
		else {
			retornar = (nome + " " + sobrenome + "\n" + numeroPrincipal + " (Prioritário)" + "\n" + numeroWhatsApp + " (WhatsApp)");
		}
		return retornar;
	}
	
}
