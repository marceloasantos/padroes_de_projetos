package hello;

import static spark.Spark.get;
import static spark.Spark.post;

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
			List<Veiculo> carrosEncontrados = model.buscarEspecificacao(espec);
			return new Gson().toJson(carrosEncontrados);

		});
	}

	public void buscarVeiculoPlaca() {
		get("/carro/:placa", (req, res) -> {
			Veiculo carrosEncontrado = model.buscarVeiculoPlaca(req.params(":placa"));
			return new Gson().toJson(carrosEncontrado);

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
						model.addVeiculo(veiculo);
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

}
