package hello;

import java.util.LinkedList;

import com.db4o.ObjectContainer;

public class Manutencao {
	private LinkedList revisoes = new LinkedList<>();
	private LinkedList trocasDeOleo = new LinkedList<>();
	private LinkedList trocasDeFiltro = new LinkedList<>();
	private LinkedList trocasDePneu = new LinkedList<>();

	
	public Manutencao() {
		this.revisoes = revisoes;
		this.trocasDeOleo = trocasDeOleo;
		this.trocasDeFiltro = trocasDeFiltro;
		this.trocasDePneu = trocasDePneu;
	}


	public LinkedList getRevisoes() {
		return revisoes;
	}


	public void setRevisoes(LinkedList revisoes) {
		this.revisoes = revisoes;
	}


	public LinkedList getTrocasDeOleo() {
		return trocasDeOleo;
	}


	public void setTrocasDeOleo(LinkedList trocasDeOleo) {
		this.trocasDeOleo = trocasDeOleo;
	}


	public LinkedList getTrocasDeFiltro() {
		return trocasDeFiltro;
	}


	public void setTrocasDeFiltro(LinkedList trocasDeFiltro) {
		this.trocasDeFiltro = trocasDeFiltro;
	}


	public LinkedList getTrocasDePneu() {
		return trocasDePneu;
	}


	public void setTrocasDePneu(LinkedList trocasDePneu) {
		this.trocasDePneu = trocasDePneu;
	}
	
	
}