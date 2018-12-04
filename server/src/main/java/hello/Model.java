package hello;


import java.util.List;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;

import java.util.LinkedList;

public class Model {
	
	ObjectContainer usuarios = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "bd/usuarios.db4o");
		
	
	public void addUser(Usuario usuario){
		usuarios.store(usuario);
		usuarios.commit();
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


	public Usuario getUsuario() {
		Query query = usuarios.query();
		query.constrain(Usuario.class);
		ObjectSet<Usuario> allUsers= query.execute();
		return allUsers.get(0);
//		for (Usuario user : allUsers) {
//			if (user != null) {
//				return user;
//			}
//		}
//		return null;		
	}
	
	public void salvarVeiculos(LinkedList<Veiculo> veiculos) {
		usuarios.store(veiculos);
		usuarios.commit();
	}
	public void salvarManutencoes(LinkedList<Veiculo> veiculos) {
		for (Veiculo veiculo : veiculos) {
			usuarios.store(veiculo.getManutencoes().getRevisoes());
			usuarios.store(veiculo.getManutencoes().getTrocasDeOleo());
			usuarios.store(veiculo.getManutencoes().getTrocasDePneu());
			usuarios.store(veiculo.getManutencoes().getTrocasDeFiltro());
			usuarios.commit();
		}

	}
}
