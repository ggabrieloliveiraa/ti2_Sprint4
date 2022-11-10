package app;


import static spark.Spark.*;
import service.*;


public class Aplicacao {
	private static UsuarioService usuarioService = new UsuarioService();
	private static ReceitaService receitaService = new ReceitaService();
	private static IngredienteService ingredienteService = new IngredienteService();
	public static void main(String[] args) throws Exception {
		port(6789);
		
		post("/insert", (request, response) -> usuarioService.insert(request, response));
		post("/login", (request, response) -> usuarioService.autenticar(request, response));
		get("/get", (request, response) -> usuarioService.get(request, response));
		get("/update", (request, response) -> usuarioService.update(request, response));
		get("/delete", (request, response) -> usuarioService.delete(request, response));
		get("/list", (request, response) -> usuarioService.getAll(request, response));
		post("/insertreceita", (request, response) -> receitaService.insert(request, response));
		get("/getreceita", (request, response) -> receitaService.get(request, response));
		get("/updatereceita", (request, response) -> receitaService.update(request, response));
		get("/deletereceita", (request, response) -> receitaService.delete(request, response));
		get("/listreceitas", (request, response) -> receitaService.getAll(request, response));
		post("/insertingrediente", (request, response) -> ingredienteService.insert(request, response));
		get("/getingrediente", (request, response) -> ingredienteService.get(request, response));
		get("/updateingrediente", (request, response) -> ingredienteService.update(request, response));
		get("/deleteingrediente", (request, response) -> ingredienteService.delete(request, response));
		get("/listingredientes", (request, response) -> ingredienteService.getAll(request, response));
	}
}