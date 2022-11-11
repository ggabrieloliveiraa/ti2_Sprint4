package service;

import java.util.List;
import spark.Request;
import spark.Response;
import model.Curtida;
import dao.CurtidaDAO;

public class CurtidaService {
	private CurtidaDAO curtidaDAO = new CurtidaDAO();
	
	/*
	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("idGet"));
		Curtida curtida = (Curtida) curtidaDAO.get(id);
		if (curtida != null) {
			return (curtida.toString());
		} else {
			response.status(404); // 404 Not found
			return "Ingrediente " + id + " não encontrado.";
		}
	}
	
	*/
}
