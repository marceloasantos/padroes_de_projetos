package hello;

import static spark.Spark.*;

import java.util.LinkedList;


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

		inicializarUser();


		Controller controller = new Controller(model);
		
		controller.buscarVeiculoEspecificacao();
		controller.buscarVeiculoPlaca();
		controller.loginUser();
		controller.addCar();
		controller.addRevisao();
		controller.addTrocaFiltro();
		controller.addTrocaOleo();
		controller.addTrocaPneu();
		controller.buscarVeiculos();
		controller.detalharManutencao();
		
    }
    
    private static void inicializarUser() {
		Usuario user1 = new Usuario("Ana", "anaamorim.sjc@hotmail.com", "123456");
		model.addUser(user1);
		
	}
    
    

}
