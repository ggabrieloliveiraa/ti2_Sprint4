package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Receita;

public class ReceitaDAO extends DAO {
	public int getMaxId() {
		int nextCodigo = 0;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT MAX(idReceita) AS max_id FROM receita";
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

	public ReceitaDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Receita receita) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO receita (idReceita, nome, serve, dificuldade, tempoDePreparo, modoDePreparo, categoria, usuarioPublicador_codigo, imagem) "
					+ "VALUES (" + getMaxId() + ", '" + receita.getNome() + "', '" + receita.getServe() + "', '"
					+ receita.getDificuldade() + "', '" + receita.getTempoDePreparo() + "', '"
					+ receita.getModoDePreparo() + "', '" + receita.getCategoria() + "', '"
					+ receita.getUsuarioPublicador_codigo() + "', '" + receita.getImagem() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public Receita get(int idReceita) {
		Receita receita = null;

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM receita WHERE idreceita=" + idReceita;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				receita = new Receita(rs.getInt("idReceita"), rs.getInt("serve"), rs.getInt("dificuldade"),
						rs.getInt("tempoDePreparo"), rs.getInt("categoria"), rs.getInt("usuariopublicador_codigo"),
						rs.getString("nome"), rs.getString("modoDePreparo"), rs.getString("imagem"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return receita;
	}

	public List<Receita> get() {
		return get("");
	}

	public List<Receita> getOrderByCodigo() {
		return get("idreceita");
	}

	private List<Receita> get(String orderBy) {

		List<Receita> receitas = new ArrayList<Receita>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM receita" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Receita u = new Receita(rs.getInt("idReceita"), rs.getInt("serve"), rs.getInt("dificuldade"),
						rs.getInt("tempoDePreparo"), rs.getInt("categoria"), rs.getInt("usuariopublicador_codigo"),
						rs.getString("nome"), rs.getString("modoDePreparo"), rs.getString("imagem"));
				receitas.add(u);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return receitas;
	}

	public boolean update(Receita receita) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "UPDATE receita SET nome = '" + receita.getNome() + "', categoria = '" + receita.getCategoria()
					+ "', dificuldade = '" + receita.getDificuldade() + "', serve = '" + receita.getServe()
					+ "', tempoDePreparo = '" + receita.getTempoDePreparo() + "', modoDePreparo = '"
					+ receita.getModoDePreparo() + "', imagem = '" + receita.getImagem() + "'" + " WHERE idReceita = "
					+ receita.getIdReceita();
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
			String sql = "DELETE FROM receita WHERE idreceita = " + id;
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