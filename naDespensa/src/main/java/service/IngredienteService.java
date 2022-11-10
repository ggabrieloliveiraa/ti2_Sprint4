package service;


import java.util.List;
import spark.Request;
import spark.Response;
import dao.IngredienteDAO;
import model.Ingrediente;
import dao.Ingrediente_receitaDAO;

public class IngredienteService {
	private IngredienteDAO ingredienteDAO = new IngredienteDAO();

	public String insert(Request request, Response response) throws Exception {
		String nome = request.queryParams("nome");
		String tipo = request.queryParams("tipo");
		String resp = "";

		Ingrediente ingrediente = new Ingrediente(0, nome, tipo);

		if (ingredienteDAO.insert(ingrediente) == true) {
			resp = "Ingrediente (" + nome + ") inserido!";
			response.status(201); // 201 Created
		} else {
			resp = "Ingrediente (" + nome + ") não inserido!";
			response.status(404); // 404 Not found
		}
		return resp;
	}

	public Object update(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("id"));

		Ingrediente ingrediente = (Ingrediente) ingredienteDAO.get(id);
		if (ingrediente != null) {

			ingrediente.setNome(request.queryParams("nome"));
			ingrediente.setTipo(request.queryParams("tipo"));

			ingredienteDAO.update(ingrediente);

			return id;
		} else {
			response.status(404); // 404 Not found
			return "Ingrediente não encontrada.";
		}

	}

	public String delete(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("id"));
		Ingrediente ingrediente = ingredienteDAO.get(id);
		String resp = "";
		if (ingrediente != null) {
			ingredienteDAO.delete(id);
			response.status(200); // success
			resp = "Ingrediente (" + id + ") excluído!";
		} else {
			response.status(404); // 404 Not found
			resp = "Ingrediente (" + id + ") não encontrado!";
		}
		return resp;
	}

	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("idGet"));
		Ingrediente ingrediente = (Ingrediente) ingredienteDAO.get(id);
		if (ingrediente != null) {
			return (ingrediente.toString());
		} else {
			response.status(404); // 404 Not found
			return "Ingrediente " + id + " não encontrado.";
		}
	}

	public String getAll(Request request, Response response) {
		List<Ingrediente> ingredientes = ingredienteDAO.getOrderByCodigo();
		String allIngredientes = "";
		for (Ingrediente u : ingredientes) {
			allIngredientes += u.toString();
		}
		return allIngredientes;
	}
}