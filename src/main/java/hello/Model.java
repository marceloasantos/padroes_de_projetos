package hello;


import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.util.LinkedList;

public class Model {
	
	ObjectContainer usuarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");
	LinkedList<Veiculo> veiculos = new LinkedList<>();
	
	public Veiculo addVeiculo(Veiculo veiculo){
		veiculos.add(veiculo);
		return veiculo;
	}
	
	public void addUser(Usuario usuario){
		usuarios.store(usuario);
		usuarios.commit();
	}
	
	public Veiculo buscarVeiculoPlaca(String placa){
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equals(placa)) {
				return veiculo;
			}		
		}
		return null;
	}
	
	
	public List<Veiculo> buscarEspecificacao(Especificacao esp){
		List<Veiculo> veiculosEncontrados = new LinkedList<Veiculo>();
		
		for(Veiculo veiculo : veiculos){
			 if(esp.comparar(veiculo.getEspecificacao())) veiculosEncontrados.add(veiculo);
		}		
		return veiculosEncontrados;
	}
	
	
	public List<Veiculo> getCarros(){
		List<Veiculo> veiculosEncontrados = new LinkedList<Veiculo>();
		
		for(Veiculo veiculo : veiculos){
			 veiculosEncontrados.add(veiculo);
		}		
		return veiculosEncontrados;
	}

	public Usuario loginUsuario(String username, String password) {

		Query query = usuarios.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers= query.execute();

		for (Usuario user : allUsers) {
			if (user.getEmail().toLowerCase().equals(username.toLowerCase()) && user.getSenha().toLowerCase().equals(password.toLowerCase())) {
				return user;
			}
		}
		return null;
	}
}
