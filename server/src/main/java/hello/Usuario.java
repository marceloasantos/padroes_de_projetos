package hello;

import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	public LinkedList<Veiculo> veiculos = new LinkedList<>();


	public Usuario(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Veiculo addVeiculo(Veiculo veiculo){
		veiculos.add(veiculo);
		return veiculo;
	}
	
	public Veiculo buscarVeiculoPlaca(String placa){
		for (Veiculo veiculo : veiculos) {
			if (veiculo.getPlaca().equals(placa)) {
				return veiculo;
			}		
		}
		return null;
	}
	
	
	public void addRevisao(String data, String placa){
		Veiculo veiculo = buscarVeiculoPlaca(placa);
		veiculo.getManutencoes().getRevisoes().add(data);
	}
	
	public void addTrocaOleo(String data, String placa){		
		Veiculo veiculo = buscarVeiculoPlaca(placa);
		veiculo.getManutencoes().getTrocasDeOleo().add(data);
	}
	
	public void addTrocaPneu(String data, String placa){		
		Veiculo veiculo = buscarVeiculoPlaca(placa);
		veiculo.getManutencoes().getTrocasDePneu().add(data);
	}
	
	public void addTrocaFiltro(String data, String placa){		
		Veiculo veiculo = buscarVeiculoPlaca(placa);
		veiculo.getManutencoes().getTrocasDeFiltro().add(data);
		}
	
	public List<Veiculo> buscarEspecificacao(Especificacao esp){
		List<Veiculo> veiculosEncontrados = new LinkedList<Veiculo>();
		
		for(Veiculo veiculo : veiculos) {
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
	
	public LinkedList<Veiculo> getVeiculos() {
		return veiculos;
	}


	public void setVeiculos(LinkedList<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
