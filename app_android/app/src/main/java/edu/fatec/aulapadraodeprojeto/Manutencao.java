package edu.fatec.aulapadraodeprojeto;

import java.util.LinkedList;
import java.util.List;

class Manutencao {
    private List<Data> revisoes = new LinkedList<>();
    private List<Data> trocasDeOleo = new LinkedList<>();
    private List<Data> trocasDeFiltro = new LinkedList<>();
    private List<Data> trocasDePneus = new LinkedList<>();

    public void cadastrarRevisao(Data d) {
        revisoes.add(d);
    }

    public void cadastrarTrocaDeOleo(Data d) {
        trocasDeOleo.add(d);
    }

    public void cadastrarTrocaDeFiltro(Data d) {
        trocasDeFiltro.add(d);
    }

    public void cadastrarTrocaDePneus(Data d) {
        trocasDePneus.add(d);
    }

    public List<Data> getRevisoes() {
        return revisoes;
    }

    public void setRevisoes(List<Data> revisoes) {
        this.revisoes = revisoes;
    }

    public List<Data> getTrocasDeOleo() {
        return trocasDeOleo;
    }

    public void setTrocasDeOleo(List<Data> trocasDeOleo) {
        this.trocasDeOleo = trocasDeOleo;
    }

    public List<Data> getTrocasDeFiltro() {
        return trocasDeFiltro;
    }

    public void setTrocasDeFiltro(List<Data> trocasDeFiltro) {
        this.trocasDeFiltro = trocasDeFiltro;
    }

    public List<Data> getTrocasDePneus() {
        return trocasDePneus;
    }

    public void setTrocasDePneus(List<Data> trocasDePneus) {
        this.trocasDePneus = trocasDePneus;
    }
}
