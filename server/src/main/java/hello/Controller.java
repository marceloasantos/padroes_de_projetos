package hello;

import static spark.Spark.get;
import static spark.Spark.post;

import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import spark.Request;
import spark.Response;
import spark.Route;

public class Controller {

	private Model model;

	public Controller(Model model) {
		this.model = model;
	}

	public void buscarVeiculoEspecificacao() {
		get("/carro/:modelo/:marca/:cor/:ano", (req, res) -> {

			Especificacao espec = new Especificacao(req.params(":modelo"), req.params(":marca"), req.params(":cor"),
					req.params(":ano"));
			List<Veiculo> carrosEncontrados = model.getUsuario().buscarEspecificacao(espec);
			return new Gson().toJson(carrosEncontrados);

		});
	}

	public void buscarVeiculoPlaca() {
		get("/carro/:placa", (req, res) -> {
			Veiculo carrosEncontrado = model.getUsuario().buscarVeiculoPlaca(req.params(":placa"));
			return new Gson().toJson(carrosEncontrado);

		});
	}

	public void buscarVeiculos() {
		get("/todos", (req, res) -> {
			List<Veiculo> carrosEncontrados = model.getUsuario().getVeiculos();
			return new Gson().toJson(carrosEncontrados);
		});
	}
	
	public void detalharManutencao() {
		get("/detalhar", (req, res) -> {
			List<Veiculo> carrosEncontrados = model.getUsuario().getVeiculos();
			return new Gson().toJson(carrosEncontrados);
		});
	}
	
	
	public void loginUser() {

		post("/login", new Route() {
			@Override
			public Object handle(final Request request, final Response response) throws JSONException {

				response.header("Access-Control-Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());
				System.out.println(request.body());
				String email = json.getString("email");

				String senha = json.getString("senha");

				try {
					Usuario usuario = model.loginUsuario(email, senha);

					if (usuario != null) {
						System.out.println("entrei no controller");
						JSONArray jsonResult = new JSONArray();
						JSONObject jsonObj = new JSONObject();

						jsonObj.put("status", 1);
						jsonObj.put("userName", usuario.getEmail());

						jsonResult.put(jsonObj);

						return jsonResult;

					} else {
						System.out.println("NUll");
					}

				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();

				jsonObj.put("status", 0);

				jsonResult.put(jsonObj);

				return jsonResult;
			}
		});
	}

	public void addCar() {

		post("/adicionar/carro", new Route() {
			@Override
			public Object handle(final Request request, final Response response) throws JSONException {

				response.header("Access-Control-Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());
				System.out.println(request.body());
				String placa = json.getString("c_placa");
				String ano = json.getString("c_ano");
				String responsavel = json.getString("c_responsavel");
				String marca = json.getString("c_marca");
				String modelo = json.getString("c_modelo");
				String cor = json.getString("c_cor");
				String combustivel = json.getString("c_combustivel");					
		

				try {
					Especificacao esp = new Especificacao(modelo, marca, cor, ano);
					Veiculo veiculo = new Veiculo(placa, responsavel, esp, combustivel);

					if (veiculo != null) {
						System.out.println("entrei no controller");
						model.getUsuario().addVeiculo(veiculo);
						LinkedList<Veiculo> veiculos = model.getUsuario().getVeiculos();
						model.salvarVeiculos(veiculos);
						JSONArray jsonResult = new JSONArray();
						JSONObject jsonObj = new JSONObject();

						jsonObj.put("status", 1);
						jsonObj.put("veiculo", veiculo.getPlaca());

						jsonResult.put(jsonObj);

						return jsonResult;

					} else 
						System.out.println("NUll");
					

				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();

				jsonObj.put("status", 0);

				jsonResult.put(jsonObj);

				return jsonResult;
			}
		});
	}
	
	public void addRevisao() {

		post("/adicionar/revisao", new Route() {
			@Override
			public Object handle(final Request request, final Response response) throws JSONException {

				response.header("Access-Control-Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());
				System.out.println(request.body());
				String placa = json.getString("c_placa");
				String revisao = json.getString("c_revisao");		
				System.out.println("placa: "+ placa);
				try {
					
					System.out.println("entrei no controller");
					model.getUsuario().addRevisao(revisao, placa);
					model.salvarManutencoes(model.getUsuario().getVeiculos());
					JSONArray jsonResult = new JSONArray();
					JSONObject jsonObj = new JSONObject();

					jsonObj.put("status", 1);
					jsonObj.put("veiculo", revisao.toString());
					jsonResult.put(jsonObj);

					return jsonResult;
					
				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("status", 0);
				jsonResult.put(jsonObj);
				return jsonResult;
			}
		});
	}
	
	//
	
	public void addTrocaOleo() {

		post("/adicionar/trocaOleo", new Route() {
			@Override
			public Object handle(final Request request, final Response response) throws JSONException {

				response.header("Access-Control-Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());
				System.out.println(request.body());
				String placa = json.getString("c_placa");
				String trocaOleo = json.getString("c_trocaOleo");		

				try {
					
					System.out.println("entrei no controller");
					model.getUsuario().addTrocaOleo(trocaOleo, placa);
					model.salvarManutencoes(model.getUsuario().getVeiculos());
					JSONArray jsonResult = new JSONArray();
					JSONObject jsonObj = new JSONObject();

					jsonObj.put("status", 1);
					jsonObj.put("veiculo", trocaOleo.toString());
					jsonResult.put(jsonObj);

					return jsonResult;
					
				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("status", 0);
				jsonResult.put(jsonObj);
				return jsonResult;
			}
		});
	}
	
	//
	
	public void addTrocaPneu() {

		post("/adicionar/trocaPneu", new Route() {
			@Override
			public Object handle(final Request request, final Response response) throws JSONException {

				response.header("Access-Control-Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());
				System.out.println(request.body());
				String placa = json.getString("c_placa");
				String trocaPneu = json.getString("c_trocaPneu");		

				try {
					
					System.out.println("entrei no controller");
					model.getUsuario().addTrocaPneu(trocaPneu, placa);
					model.salvarManutencoes(model.getUsuario().getVeiculos());
					JSONArray jsonResult = new JSONArray();
					JSONObject jsonObj = new JSONObject();

					jsonObj.put("status", 1);
					jsonObj.put("veiculo", trocaPneu.toString());
					jsonResult.put(jsonObj);

					return jsonResult;
					
				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("status", 0);
				jsonResult.put(jsonObj);
				return jsonResult;
			}
		});
	}
	
	//
	
	public void addTrocaFiltro() {

		post("/adicionar/trocaFiltro", new Route() {
			@Override
			public Object handle(final Request request, final Response response) throws JSONException {

				response.header("Access-Control-Allow-Origin", "*");

				JSONObject json = new JSONObject(request.body());
				System.out.println(request.body());
				String placa = json.getString("c_placa");
				String trocaFiltro = json.getString("c_trocaFiltro");		

				try {
					
					System.out.println("entrei no controller");
					model.getUsuario().addTrocaFiltro(trocaFiltro, placa);
					model.salvarManutencoes(model.getUsuario().getVeiculos());
					JSONArray jsonResult = new JSONArray();
					JSONObject jsonObj = new JSONObject();

					jsonObj.put("status", 1);
					jsonObj.put("veiculo", trocaFiltro.toString());
					jsonResult.put(jsonObj);

					return jsonResult;
					
				} catch (JSONException e) {

					// e.printStackTrace();

				}

				JSONArray jsonResult = new JSONArray();
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("status", 0);
				jsonResult.put(jsonObj);
				return jsonResult;
			}
		});
	}

}
