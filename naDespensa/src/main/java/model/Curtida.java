package model;

public class Curtida {
	private int usuarioCurtidor_codigo, receitaCurtida_id;

	public Curtida(int usuarioCurtidor_codigo, int receitaCurtida_id) {
		super();
		this.usuarioCurtidor_codigo = usuarioCurtidor_codigo;
		this.receitaCurtida_id = receitaCurtida_id;
	}

	/**
	 * @return the usuarioCurtidor_codigo
	 */
	public int getUsuarioCurtidor_codigo() {
		return usuarioCurtidor_codigo;
	}

	/**
	 * @param usuarioCurtidor_codigo the usuarioCurtidor_codigo to set
	 */
	public void setUsuarioCurtidor_codigo(int usuarioCurtidor_codigo) {
		this.usuarioCurtidor_codigo = usuarioCurtidor_codigo;
	}

	/**
	 * @return the receitaCurtida_id
	 */
	public int getReceitaCurtida_id() {
		return receitaCurtida_id;
	}

	/**
	 * @param receitaCurtida_id the receitaCurtida_id to set
	 */
	public void setReceitaCurtida_id(int receitaCurtida_id) {
		this.receitaCurtida_id = receitaCurtida_id;
	}

	@Override
	public String toString() {
		return "Curtida [usuarioCurtidor_codigo=" + usuarioCurtidor_codigo + ", receitaCurtida_id=" + receitaCurtida_id
				+ "]";
	}

}