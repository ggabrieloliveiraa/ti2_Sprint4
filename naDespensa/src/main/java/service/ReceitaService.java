package service;


import java.util.List;
import spark.Request;
import spark.Response;

import dao.ReceitaDAO;
import model.Receita;
import dao.Ingrediente_receitaDAO;


public class ReceitaService {
	private ReceitaDAO receitaDAO = new ReceitaDAO();
	private Ingrediente_receitaDAO ingredientereceitaDAO = new Ingrediente_receitaDAO();

	public String insert(Request request, Response response) throws Exception {
		String nome = request.queryParams("nome");
		int categoria = Integer.parseInt(request.queryParams("categoria"));
		int dificuldade = Integer.parseInt(request.queryParams("dificuldade"));
		int tempoDePreparo = Integer.parseInt(request.queryParams("tempoDePreparo"));
		int serve = Integer.parseInt(request.queryParams("serve"));
		String modoDePreparo = request.queryParams("modoDePreparo");
		String imagem = request.queryParams("imagem");
		String ingredientes = request.queryParams("ingredientes");
		
		
		// int receitaPublicador_codigo =
		// Integer.parseInt(request.queryParams("serve"));
//idReceita, serve, dificuldade, tempoDePreparo, categoria, receitaPublicador_codigo
		String resp = "";

		Receita receita = new Receita(0, serve, dificuldade, tempoDePreparo, categoria, 1, nome, modoDePreparo, imagem);

		if (receitaDAO.insert(receita) == true) {
			resp = "Receita (" + nome + ") inserido!";
			response.status(201); // 201 Created
		} else {
			resp = "Receita (" + nome + ") não inserido!";
			response.status(404); // 404 Not found
		}
		ingredientereceitaDAO.get(ingredientes);
		return resp;
	}

	public Object update(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("id"));

		Receita receita = (Receita) receitaDAO.get(id);
		if (receita != null) {
			receita.setServe(Integer.parseInt(request.queryParams("serve")));
			receita.setCategoria(Integer.parseInt(request.queryParams("categoria")));
			receita.setDificuldade(Integer.parseInt(request.queryParams("dificuldade")));
			receita.setTempoDePreparo(Integer.parseInt(request.queryParams("tempoDePreparo")));
			receita.setNome(request.queryParams("nome"));
			receita.setModoDePreparo(request.queryParams("modoDePreparo"));
			receita.setImagem(request.queryParams("imagem"));

			receitaDAO.update(receita);

			return id;
		} else {
			response.status(404); // 404 Not found
			return "Receita não encontrada.";
		}

	}

	public String delete(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("id"));
		Receita receita = receitaDAO.get(id);
		String resp = "";
		if (receita != null) {
			receitaDAO.delete(id);
			response.status(200); // success
			resp = "Receita (" + id + ") excluído!";
		} else {
			response.status(404); // 404 Not found
			resp = "Receita (" + id + ") não encontrado!";
		}
		return resp;
	}

	public Object get(Request request, Response response) {
		int id = Integer.parseInt(request.queryParams("idGet"));
		Receita receita = (Receita) receitaDAO.get(id);
		if (receita != null) {
			return (receita.toString());
		} else {
			response.status(404); // 404 Not found
			return "Receita " + id + " não encontrado.";
		}
	}

	public String getAll(Request request, Response response) {
		List<Receita> receitas = receitaDAO.getOrderByCodigo();
		String allReceitas = "";
		for (Receita u : receitas) {
			allReceitas += u.toString();
		}
		return allReceitas;
	}
}