package edu.fatec.aulapadraodeprojeto;

import java.util.List;

public class Veiculo {
    private String placa;
    private String responsavel;
    private Especificacao especificacao;
    private Manutencao manutencoes;
    private String seguradora;
    private String tipoCombustivel;

    public Veiculo(String placa, String responsavel, Especificacao especificacao, String tipoCombustivel, String seguradora) {
        this.placa = placa;
        this.responsavel = responsavel;
        this.especificacao = especificacao;
        this.tipoCombustivel = tipoCombustivel;
    }

    public List<Data> gerarRelatorioRevisoes() {
        return manutencoes.getRevisoes();
    }

    public List<Data> gerarRelatorioOleo() {
        return manutencoes.getTrocasDeOleo();
    }

    public List<Data> gerarRelatorioFiltros() {
        return manutencoes.getTrocasDeFiltro();
    }

    public List<Data> gerarRelatorioPneus() {
        return manutencoes.getTrocasDePneus();
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
        return manutencoes;
    }

    public void setManutencoes(Manutencao manutencoes) {
        this.manutencoes = manutencoes;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(String seguradora) {
        this.seguradora = seguradora;
    }
}
