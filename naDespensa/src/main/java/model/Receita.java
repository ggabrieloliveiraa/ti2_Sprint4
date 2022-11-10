package model;

public class Receita {
	private int idReceita, serve, dificuldade, tempoDePreparo, categoria, usuarioPublicador_codigo;
	private String nome, modoDePreparo, imagem;
	public Receita() {
		this.idReceita = -1;
		this.serve = -1;
		this.dificuldade = -1;
		this.tempoDePreparo = -1;
		this.categoria = -1;
		this.usuarioPublicador_codigo = -1;
		this.nome = "";
		this.modoDePreparo = "";
	}
	
	public Receita(int idReceita, int serve, int dificuldade, int tempoDePreparo, int categoria,
			int usuarioPublicador_codigo, String nome, String modoDePreparo, String imagem) {
		this.idReceita = idReceita;
		this.serve = serve;
		this.dificuldade = dificuldade;
		this.tempoDePreparo = tempoDePreparo;
		this.categoria = categoria;
		this.usuarioPublicador_codigo = usuarioPublicador_codigo;
		this.nome = nome;
		this.modoDePreparo = modoDePreparo;
		this.imagem = imagem;
	}

	/**
	 * @return the idReceita
	 */
	public int getIdReceita() {
		return idReceita;
	}

	/**
	 * @param idReceita the idReceita to set
	 */
	public void setIdReceita(int idReceita) {
		this.idReceita = idReceita;
	}

	/**
	 * @return the serve
	 */
	public int getServe() {
		return serve;
	}

	/**
	 * @param serve the serve to set
	 */
	public void setServe(int serve) {
		this.serve = serve;
	}

	/**
	 * @return the dificuldade
	 */
	public int getDificuldade() {
		return dificuldade;
	}

	/**
	 * @param dificuldade the dificuldade to set
	 */
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	/**
	 * @return the tempoDePreparo
	 */
	public int getTempoDePreparo() {
		return tempoDePreparo;
	}

	/**
	 * @param tempoDePreparo the tempoDePreparo to set
	 */
	public void setTempoDePreparo(int tempoDePreparo) {
		this.tempoDePreparo = tempoDePreparo;
	}

	/**
	 * @return the categoria
	 */
	public int getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}



	/**
	 * @return the modoDePreparo
	 */
	public String getModoDePreparo() {
		return modoDePreparo;
	}

	/**
	 * @param modoDePreparo the modoDePreparo to set
	 */
	public void setModoDePreparo(String modoDePreparo) {
		this.modoDePreparo = modoDePreparo;
	}
	
	/**
	 * @return the usuarioPublicador_codigo
	 */
	public int getUsuarioPublicador_codigo() {
		return usuarioPublicador_codigo;
	}

	/**
	 * @param usuarioPublicador_codigo the usuarioPublicador_codigo to set
	 */
	public void setUsuarioPublicador_codigo(int usuarioPublicador_codigo) {
		this.usuarioPublicador_codigo = usuarioPublicador_codigo;
	}
	

	/**
	 * @return the imagem
	 */
	public String getImagem() {
		return imagem;
	}

	/**
	 * @param imagem the imagem to set
	 */
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "Receita [idReceita=" + idReceita + ", serve=" + serve + ", dificuldade=" + dificuldade
				+ ", tempoDePreparo=" + tempoDePreparo + ", categoria=" + categoria + ", usuarioPublicador_codigo="
				+ usuarioPublicador_codigo + ", nome=" + nome + ", modoDePreparo=" + modoDePreparo + ", imagem="
				+ imagem + "]";
	}
	

	
}