package dao;

import java.sql.ResultSet;

import java.sql.Statement;
import java.sql.*;
import model.Usuario;

public class SessionControl extends DAO {
	static public String currentUserName;
	static public int currentUserId;

	
	public void setCurrentUser(String nome) {
		currentUserName = nome;
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT codigo FROM usuario WHERE username=" + "\'" + currentUserName + "\'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				currentUserId = rs.getInt("codigo");
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void logout () {
		currentUserName = null;
		currentUserId = -1;
	}
	
	
	public SessionControl() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public static int getCurrentUserId() {
		return currentUserId;
	}

	public static String getCurrentUserName() {
		return currentUserName;
	}

}