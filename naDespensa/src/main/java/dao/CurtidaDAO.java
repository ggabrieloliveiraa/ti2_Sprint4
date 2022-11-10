package dao;

import java.sql.*;

import model.Curtida;
import model.Ingrediente;
import model.Ingrediente_receita;

public class CurtidaDAO extends DAO {
	public CurtidaDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Curtida curtida) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO curtida (usuariocurtidor_codigo, receitacurtida_id) " + "VALUES ("
					+ curtida.getUsuarioCurtidor_codigo() + ", '" + curtida.getReceitaCurtida_id() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public Curtida get(int idreceita) {
		Curtida curtida = null;
		
		curtida = new Curtida(SessionControl.currentUserId, idreceita);
		insert(curtida);
		return curtida;
		
	}
}