package service;



import spark.Request;
import spark.Response;
import dao.IngredienteDAO;
import model.Ingrediente;

public class Ingrediente_receitaService {
	private IngredienteDAO ingredienteDAO = new IngredienteDAO();

	public String insert(Request request, Response response) throws Exception {
		//String ingredientesString = request.queryParams("ingredientes");
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
}