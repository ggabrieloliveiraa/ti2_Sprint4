package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import model.Usuario;

public class UsuarioDAO extends DAO {
	public int getMaxCodigo() {
		int nextCodigo = 0;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT MAX(codigo) AS max_id FROM usuario";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
			    nextCodigo = rs.getInt("max_id") + 1;
			}
			return nextCodigo;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return nextCodigo;
	}

	public UsuarioDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Usuario usuario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO usuario (codigo, username, senha, email) " + "VALUES (" + getMaxCodigo() + ", '"
					+ usuario.getUsername() + "', '" + usuario.getSenha() + "', '" + usuario.getEmail() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public Usuario get(int codigo) {
		Usuario usuario = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE codigo=" + codigo;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				usuario = new Usuario(rs.getInt("codigo"), rs.getString("username"), rs.getString("senha"),
						rs.getString("email"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuario;
	}

	public List<Usuario> get() {
		return get("");
	}

	public List<Usuario> getOrderByCodigo() {
		return get("codigo");
	}

	public List<Usuario> getOrderByUsername() {
		return get("username");
	}

	public List<Usuario> getOrderByEmail() {
		return get("email");
	}

	private List<Usuario> get(String orderBy) {

		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Usuario u = new Usuario(rs.getInt("codigo"), rs.getString("username"), rs.getString("senha"),
						rs.getString("email"));
				usuarios.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return usuarios;
	}

	public boolean update(Usuario usuario) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE usuario SET username = '" + usuario.getUsername() + "', senha = '" + usuario.getSenha()
					+ "', email = '" + usuario.getEmail() + "'" + " WHERE codigo = " + usuario.getCodigo();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean delete(int codigo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM usuario WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean autenticar(String username, String senha) {
		boolean resp = false;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM usuario WHERE username LIKE '" + username + "' AND senha LIKE '" + senha + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			resp = rs.next();
			//if (resp)
			//{
			//	String sql2 = "SELECT codigo AS currentCodigo FROM usuario WHERE username=" + username;
		//		ResultSet rs2 = st.executeQuery(sql2);
		//		CurrentUser cu = new CurrentUser(rs2.getInt("currentCodigo"), username, "fodase");
		//	}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return resp;
	}
}