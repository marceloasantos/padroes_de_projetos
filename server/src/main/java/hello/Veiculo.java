package hello;

import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Veiculo {
	private String placa;
	private String responsavel;
	private Especificacao especificacao;
	private Manutencao manutencao = new Manutencao();
	private String tipoCombustivel;

	
	public Veiculo(String placa, String responsavel, Especificacao especificacao,
			String tipoCombustivel) {
		this.placa = placa;
		this.responsavel = responsavel;
		this.especificacao = especificacao;
		this.tipoCombustivel = tipoCombustivel;
		}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getResponsavel() {
		return responsavel;
	}


	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}


	public Especificacao getEspecificacao() {
		return especificacao;
	}


	public void setEspecificacao(Especificacao especificacao) {
		this.especificacao = especificacao;
	}


	public Manutencao getManutencoes() {
		return manutencao;
	}


	public void setManutencoes(Manutencao manutencao) {
		this.manutencao = manutencao;
	}


	public String getTipoCombustivel() {
		return tipoCombustivel;
	}


	public void setTipoCombustivel(String tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}


	
	
	
	
}
