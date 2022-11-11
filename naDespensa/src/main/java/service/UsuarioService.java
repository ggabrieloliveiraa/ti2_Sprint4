package service;




import java.awt.*;

import java.io.File;

import java.util.List;
import spark.Request;
import spark.Response;
import dao.DAO;
import dao.UsuarioDAO;
import dao.SessionControl;
import model.Usuario;


public class UsuarioService {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();

	public String insert(Request request, Response response) throws Exception {
		String username = request.queryParams("inputName");
		String senha = DAO.toMD5(request.queryParams("inputPwd"));
		String email = request.queryParams("inputEmail");

		String resp = "";

		Usuario usuario = new Usuario(0, username, senha, email);

		if (usuarioDAO.insert(usuario) == true) {
			resp = "Usuario (" + username + ") inserido!";
			response.status(201); // 201 Created
		} else {
			resp = "Usuario (" + username + ") não inserido!";
			response.status(404); // 404 Not found
		}
		return resp;
	}
	

	public Object update(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("id"));

		Usuario usuario = (Usuario) usuarioDAO.get(id);

		if (usuario != null) {
			usuario.setUsername(request.queryParams("inputName"));
			usuario.setEmail(request.queryParams("inputEmail"));
			usuario.setSenha(request.queryParams("inputPwd"));

			usuarioDAO.update(usuario);

			return id;
		} else {
			response.status(404); // 404 Not found
			return "Usuario não encontrado.";
		}

	}

	public String delete(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("id"));
		Usuario usuario = usuarioDAO.get(id);
		System.out.println("id = " + id);
		String resp = "";
		if (usuario != null) {
			usuarioDAO.delete(id);
			response.status(200); // success
			resp = "Usuario (" + id + ") excluído!";
		} else {
			response.status(404); // 404 Not found
			resp = "Usuario (" + id + ") não encontrado!";
		}
		return resp;
	}

	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("idGet"));
		Usuario usuario = (Usuario) usuarioDAO.get(id);
		if (usuario != null) {
			return (usuario.toString());
		} else {
			response.status(404); // 404 Not found
			return "Usuario " + id + " não encontrado.";
		}
	}

	public String getAll(Request request, Response response) {
		List<Usuario> usuarios = usuarioDAO.getOrderByCodigo();
		String allUsers = "";
		for (Usuario u : usuarios) {
			allUsers += u.toString();
		}
		return allUsers;
	}

	public String autenticar(Request request, Response response) throws Exception {
		File htmlFile = new File("/home/gabriel/git/ti2_Sprint4/naDespensa/src/main/resources/front-end/index.html");
		String username = request.queryParams("logUser");
		String senha = DAO.toMD5(request.queryParams("logPwd"));
		if (usuarioDAO.autenticar(username, senha)) {
			SessionControl currentUser = new SessionControl();
			currentUser.setCurrentUser(username);
			Desktop.getDesktop().browse(htmlFile.toURI());
			return ("LOGIN SUCESSO, BEM VINDO " + SessionControl.currentUserName);
		} else {
			return ("LOGIN FALHO");
		}
	}
}