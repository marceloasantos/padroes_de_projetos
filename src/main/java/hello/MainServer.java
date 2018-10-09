package hello;

import static spark.Spark.*;


public class MainServer {
	
	final static Model model = new Model();
	
    public static void main(String[] args) {

		// Get port config of heroku on environment variable
        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 1223;
        }
        port(port);

		//Servir conteudo html, css e javascript
		staticFileLocation("/static");

		inicializarCarros();
		inicializarUser();


		Controller controller = new Controller(model);
		
		controller.buscarVeiculoEspecificacao();
		controller.buscarVeiculoPlaca();
		controller.loginUser();
		controller.addCar();
		
    }
    
    private static void inicializarUser() {
		Usuario user1 = new Usuario("Ana", "anaamorim.sjc@hotmail.com", "123456");
		model.addUser(user1);
	}

	public static void inicializarCarros(){
		Veiculo veiculo1 = new Veiculo("EPL123", "Ana Amorim", new Especificacao("modelo", "marca", "cor", "ano"), "Flex");
		model.addVeiculo(veiculo1);
    }
}
