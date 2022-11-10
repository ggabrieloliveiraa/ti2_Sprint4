package dao;

import java.sql.*;

import model.Ingrediente_receita;

public class Ingrediente_receitaDAO extends DAO {
	public int getMaxId() {
		int nextCodigo = 0;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT MAX(idreceita) AS max_id FROM receita";
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				nextCodigo = rs.getInt("max_id");
			}
			return nextCodigo;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return nextCodigo;
	}
	
	public Ingrediente_receitaDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Ingrediente_receita ingrediente_receita) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO ingrediente_receita (ingrediente_idingrediente, quantidade, receita_idreceita) "
					+ "VALUES (" + ingrediente_receita.getIngrediente_idingrediente() + ", '"
					+ ingrediente_receita.getQuantidade() + "', '" + ingrediente_receita.getReceita_idreceita() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public void get(String nome) {
		Ingrediente_receita ingrediente_receita = null;
		String ingrediente[] = nome.split(",");
		for (int i = 0; i < ingrediente.length; i++) {
			try {
				String array[] = ingrediente[i].split(" ", 0);
				Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				String sql = "SELECT idingrediente FROM ingrediente WHERE nome=" + "\'" + array[1] + "\'";
				System.out.println("numero = " + array[0] + "// nome = " + array[1]);
				System.out.println(sql);
				ResultSet rs = st.executeQuery(sql);
				if (rs.next()) {
					System.out.println("entrei");
					ingrediente_receita = new Ingrediente_receita(rs.getInt("idingrediente"), getMaxId(),
							Integer.parseInt(array[0]));
					insert(ingrediente_receita);
				}
				st.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	/*
	 * public List<Ingrediente_receita> get() { return get(""); }
	 * 
	 * public List<Ingrediente_receita> getOrderByCodigo() { return
	 * get("idingrediente"); }
	 * 
	 * 
	 * private List<Ingrediente_receita> get(String orderBy) {
	 * 
	 * List<Ingrediente_receita> ingredientes = new
	 * ArrayList<Ingrediente_receita>();
	 * 
	 * try { Statement st =
	 * conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	 * ResultSet.CONCUR_READ_ONLY); String sql = "SELECT * FROM ingrediente" +
	 * ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
	 * System.out.println(sql); ResultSet rs = st.executeQuery(sql); while
	 * (rs.next()) { Ingrediente_receita u = new
	 * Ingrediente_receita(rs.getInt("idIngrediente"), rs.getString("nome"),
	 * rs.getString("tipo")); ingredientes.add(u); } st.close(); } catch (Exception
	 * e) { System.err.println(e.getMessage()); } return ingredientes; }
	 * 
	 * public boolean update(Ingrediente_receita ingrediente) { boolean status =
	 * false; try { Statement st = conexao.createStatement(); String sql =
	 * "UPDATE ingrediente SET nome = '" + ingrediente.getNome() + "', tipo = '" +
	 * ingrediente.getTipo() + "'" + " WHERE idIngrediente = " +
	 * ingrediente.getIdIngrediente(); System.out.println(sql);
	 * st.executeUpdate(sql); st.close(); status = true; } catch (SQLException u) {
	 * throw new RuntimeException(u); } return status; }
	 * 
	 * public boolean delete(int id) { boolean status = false; try { Statement st =
	 * conexao.createStatement(); String sql =
	 * "DELETE FROM ingrediente WHERE idingrediente = " + id;
	 * System.out.println(sql); st.executeUpdate(sql); st.close(); status = true; }
	 * catch (SQLException u) { throw new RuntimeException(u); } return status; }
	 */
}