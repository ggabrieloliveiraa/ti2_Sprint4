package model;

public class Ingrediente {
	private int idIngrediente;
	private String nome, tipo;

	public Ingrediente() {
		this.idIngrediente = -1;
		this.nome = "";
		this.tipo = "";
	}

	public Ingrediente(int idIngrediente, String nome, String tipo) {
		this.idIngrediente = idIngrediente;
		this.nome = nome;
		this.tipo = tipo;
	}

	/**
	 * @return the idIngrediente
	 */
	public int getIdIngrediente() {
		return idIngrediente;
	}

	/**
	 * @param idIngrediente the idIngrediente to set
	 */
	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", nome=" + nome + ", tipo=" + tipo + "]";
	}

}