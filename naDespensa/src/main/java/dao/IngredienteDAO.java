package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Ingrediente;

public class IngredienteDAO extends DAO {
	public int getMaxId() {
		int nextCodigo = 0;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT MAX(idIngrediente) AS max_id FROM ingrediente";
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

	public IngredienteDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Ingrediente ingrediente) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO ingrediente (idIngrediente, nome, tipo) "
					+ "VALUES (" + getMaxId() + ", '" + ingrediente.getNome() + "', '" + ingrediente.getTipo() + "');"; 
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public Ingrediente get(int idIngrediente) {
		Ingrediente ingrediente = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM ingrediente WHERE idingrediente=" + idIngrediente;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				ingrediente = new Ingrediente(rs.getInt("idIngrediente"),
						rs.getString("nome"), rs.getString("tipo"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return ingrediente;
	}

	public List<Ingrediente> get() {
		return get("");
	}

	public List<Ingrediente> getOrderByCodigo() {
		return get("idingrediente");
	}


	private List<Ingrediente> get(String orderBy) {

		List<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM ingrediente" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Ingrediente u = new Ingrediente(rs.getInt("idIngrediente"),
						rs.getString("nome"), rs.getString("tipo"));
				ingredientes.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return ingredientes;
	}

	public boolean update(Ingrediente ingrediente) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE ingrediente SET nome = '" + ingrediente.getNome() + "', tipo = '" + 
			ingrediente.getTipo() + "'" + " WHERE idIngrediente = " + ingrediente.getIdIngrediente();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean delete(int id) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM ingrediente WHERE idingrediente = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
}