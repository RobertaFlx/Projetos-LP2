package agenda;

/**
 * ESSA CLASSE É RESPONSÁVEL PELA CRIAÇÃO DE UMA AGENDA, NELA SÃO MANTIDOS UMA LISTA DE CONTATOS ORDENADOS POR POSIÇÕES.
 * A AGENDA SUPORTA ATÉ 100 CONTATOS.
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	private Contato[] contatos;
	
	private Contato[] favoritos;

	/**
	 * CRIA UMA AGENDA.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	/**
	 * ACESSA A LISTA DE CONTATOS MANTIDA.
	 * @return O array de contatos
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * ACESSA OS DADOS DE UM CONTATO ESPECÍFICO.
	 * @param posicao Posição do contato na agenda
	 * @return Dados do contato. Null se não há contato na posição
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}
	
	/**
	 * CADASTRA UM CONTATO EM UMA POSIÇÃO, UM CADASTRO EM UMA POSIÇÃO QUE JÁ EXISTE SOBREESCREVE O ANTERIOR.
	 * @param posicao
	 * @param nome
	 * @param sobrenome
	 * @param numeroPrincipal
	 * @param numeroWhatsApp
	 * @param numeroAdicional
	 * @return
	 */
	public String cadastraContato(int posicao, String nome, String sobrenome, String numeroPrincipal, String numeroWhatsApp, String numeroAdicional) {
		String retornar = "";
		if(posicao <= 0 || posicao > 100) {
			retornar = "POSIÇÃO INVÁLIDA";
		}
		else {
			if(verificaContatoCadastrado(nome, sobrenome)) {
			retornar = "CONTATO JÁ CADASTRADO";
			}
			else {
				Contato novoContato = new Contato(nome, sobrenome, numeroPrincipal, numeroWhatsApp, numeroAdicional);
			    contatos[posicao] = novoContato;
			    retornar = "CADASTRO REALIZADO";
			}
		}
		return retornar;
	}
	
	/**
	 * VERIFICA SE UM CONTATO COM O MESMO NOME E SOBRENOME JÁ ESTA CADASTRADO.
	 * @param nome nome do contato
	 * @param sobrenome sobrenome do contato
	 * @return se o contato já está cadastrado ou não
	 */
	public boolean verificaContatoCadastrado(String nome, String sobrenome) {
		boolean cadastroExistente = false;
		String nomeContato = nome + sobrenome;
		for(int i = 0; i < contatos.length; i++) {
			if(contatos[i] != null) {
				String nomeExistente = contatos[i].getNome() + contatos[i].getSobrenome();
				if(nomeExistente.equals(nomeContato)) {
					cadastroExistente = true;
				}
			}
		}
		return cadastroExistente;
	}

	/**
	 * LISTA POSIÇÃO, NOME E SOBRENOME DE TODOS OS CONTATOS. 
	 * @return lista de contatos
	 */
	public String listarContatos() {
		String lista = "";
		for(int i = 0;i<contatos.length;i++) {
			if(contatos[i] != null) {
				lista +=  (i)  + " - " + contatos[i].getNome() + " " + contatos[i].getSobrenome() + "\n";
			}
		}
		return lista;
	}
	
	/**
	 * EXIBE OS DADOS DE UM CONTATO.
	 * @param posicao posicao do contato
	 * @return dados do contato
	 */
    public String exibirContato(int posicao) {
    	String retornar = "";
    	if(contatos[posicao] == null) {
    		retornar = "POSIÇÃO INVÁLIDA!";
    	}
    	else {
    		for(int i = 0; i< favoritos.length; i++) {
    			if(contatos[posicao].equals(favoritos[i])) {
    				retornar = "❤️" + " " + contatos[i].toString();
    				break;
    			}
    			else {
    				retornar = contatos[posicao].toString();
    			}
    		}
    	}
    	return retornar;
	}
    
    /**
     * ADICIONA UM CONTATO JÁ CADASTRADO COMO FAVORITO.
     * @param contato contato em questão
     * @param posicao posicao do contato
     * @return
     */
    public String adicionarFavorito(int contato, int posicao) {
    	String retornar = "";
    	if(posicao <= 0 || posicao > 10) {
			retornar = "POSIÇÃO INVÁLIDA";
		}
    	else {
    		if (verificaFavoritoCadastrado(contatos[contato].getNome(), contatos[contato].getSobrenome())) {
			retornar = "CONTATO JÁ CADASTRADO";
	    	}
	    	else {
	    		favoritos[posicao] = contatos[contato];
	    	    retornar = "CONTATO FAVORITADO NA POSIÇÃO" + " " + posicao;
	    	}
    	}
    	return retornar;
	}
    
    /**
     * VERIFICA SE UM CONTATO JÁ ESTÁ CADASTRADO COMO FAVORITO.
     * @param nome nome do contato
     * @param sobrenome sobrenome do contato
     * @return se o favorito já está cadastrado ou não
     */
    public boolean verificaFavoritoCadastrado(String nome, String sobrenome) {
        boolean cadastroExiste = false;
        String novoFavorito = nome + sobrenome;
        for (int i = 0; i< favoritos.length; i++) {
            if(favoritos[i]!= null) {
                String FavoritoExistente = favoritos[i].getNome() + favoritos[i].getSobrenome();
                if (FavoritoExistente.equals(novoFavorito)) {
                	cadastroExiste = true;
                }

            }
        }
        return cadastroExiste;
    }
    
    /**
     * FORMATA E PRINTA UMA LISTA DE FAVORITOS COM POSIÇÃO, NOME E SOBRENOME.
     * @return lista de favoritos
     */
    public String listarFavoritos() {
    	String lista = "";
    	for(int i = 0; i < favoritos.length; i++) {
    		if(favoritos[i] != null) {
    			lista += "\n" + i +  " - "  + favoritos[i].getNome() + " " + favoritos[i].getSobrenome();
    		}
    	}
    	return lista;
    }
    
}

