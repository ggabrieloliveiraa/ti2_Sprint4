package model;

public class Usuario {
	private int codigo;
	private String username;
	private String senha;
	private String email;
	
	public Usuario() {
		this.codigo = -1;
		this.username = "";
		this.senha = "";
		this.email = "";
	}
	
	public Usuario(int codigo, String username, String senha, String email) {
		this.codigo = codigo;
		this.username = username;
		this.senha = senha;
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", username=" + username + ", senha=" + senha + ", email=" + email + "]\n";
	}	
}
