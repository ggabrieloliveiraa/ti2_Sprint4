package model;

public class Ingrediente_receita {
	private int ingrediente_idingrediente, receita_idreceita, quantidade;

	public Ingrediente_receita() {
		this.ingrediente_idingrediente = -1;
		this.receita_idreceita = -1;
		this.quantidade = 0;
	}

	public Ingrediente_receita(int ingrediente_idingrediente, int receita_idreceita, int quantidade) {
		super();
		this.ingrediente_idingrediente = ingrediente_idingrediente;
		this.receita_idreceita = receita_idreceita;
		this.quantidade = quantidade;
	}

	/**
	 * @return the ingrediente_idingrediente
	 */
	public int getIngrediente_idingrediente() {
		return ingrediente_idingrediente;
	}

	/**
	 * @param ingrediente_idingrediente the ingrediente_idingrediente to set
	 */
	public void setIngrediente_idingrediente(int ingrediente_idingrediente) {
		this.ingrediente_idingrediente = ingrediente_idingrediente;
	}

	/**
	 * @return the receita_idreceita
	 */
	public int getReceita_idreceita() {
		return receita_idreceita;
	}

	/**
	 * @param receita_idreceita the receita_idreceita to set
	 */
	public void setReceita_idreceita(int receita_idreceita) {
		this.receita_idreceita = receita_idreceita;
	}

	/**
	 * @return the quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}

	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Ingrediente_receita [ingrediente_idingrediente=" + ingrediente_idingrediente + ", receita_idreceita="
				+ receita_idreceita + ", quantidade=" + quantidade + "]";
	}
	

}