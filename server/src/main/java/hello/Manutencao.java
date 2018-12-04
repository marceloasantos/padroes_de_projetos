package hello;

import java.util.LinkedList;

import com.db4o.ObjectContainer;

public class Manutencao {
	private LinkedList<String> revisoes = new LinkedList<>();
	private LinkedList<String> trocasDeOleo = new LinkedList<>();
	private LinkedList<String> trocasDeFiltro = new LinkedList<>();
	private LinkedList<String> trocasDePneu = new LinkedList<>();


	
	public Manutencao() {
	}
	
	public LinkedList<String> getRevisoes() {
		return revisoes;
	}


	public void setRevisoes(LinkedList<String> revisoes) {
		this.revisoes = revisoes;
	}


	public LinkedList<String> getTrocasDeOleo() {
		return trocasDeOleo;
	}


	public void setTrocasDeOleo(LinkedList<String> trocasDeOleo) {
		this.trocasDeOleo = trocasDeOleo;
	}


	public LinkedList<String> getTrocasDeFiltro() {
		return trocasDeFiltro;
	}


	public void setTrocasDeFiltro(LinkedList<String> trocasDeFiltro) {
		this.trocasDeFiltro = trocasDeFiltro;
	}


	public LinkedList<String> getTrocasDePneu() {
		return trocasDePneu;
	}


	public void setTrocasDePneu(LinkedList<String> trocasDePneu) {
		this.trocasDePneu = trocasDePneu;
	}
	
	
}