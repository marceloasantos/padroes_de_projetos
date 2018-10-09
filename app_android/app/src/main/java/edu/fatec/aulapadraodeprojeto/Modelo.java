package edu.fatec.aulapadraodeprojeto;

import java.util.LinkedList;
import java.util.List;

public class Modelo {
    private List<Usuario> users = new LinkedList<Usuario>();
    private List<Veiculo> veiculos = new LinkedList<Veiculo>();

    private static Modelo modelo;

    private Modelo() {
        userListInitialize();
        veiculoListInitialize();
    }

    //design pattern singleton
    public static Modelo getInstance() {
        if(modelo == null){
            modelo = new Modelo();
        }
        return modelo;
    }

    public Usuario matchLogin(String user, String password) {
        for (Usuario u : users) {
            if (u.getUser().equalsIgnoreCase(user) && u.getPassword().equalsIgnoreCase(password))
                return u;
        }
        return null;
    }

    public void userListInitialize() {
        this.users.add(new Usuario("Admin", "", ""));
        this.users.add(new Usuario("Marcelo", "user", "123"));
        this.users.add(new Usuario("Augusto", "user1", "1234"));
        this.users.add(new Usuario("Vinicius", "user2", "12345"));
    }

    public void veiculoListInitialize() {
        this.veiculos.add(new Veiculo("ENK-7477", "Marcelo", new Especificacao("VW", "FOX G2", "Cinza", "2010"), "Flex", "Nenhum"));
        this.veiculos.add(new Veiculo("NEG-1234", "Augusto", new Especificacao("VW", "FOX G3", "Preto", "2015"), "Flex", "Eu mesmo"));
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo v : veiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) return v;
        }
        return null;
    }

    public String gerarRelatorioUltimasManutencoes(String placa) {
        Veiculo veiculoEncontrado = buscarVeiculo(placa);
        return null;
    }

    public String gerarRelatorioTipoManutencao(String placa, String tipoManutencao) {
        Veiculo veiculoEncontrado = buscarVeiculo(placa);
        String resultado = "";
        switch (tipoManutencao) {
            case "revisao":
                for (Data data : veiculoEncontrado.getManutencoes().getRevisoes()) {
                    resultado = resultado + data.toString() + "\n";
                }
                break;
            case "troca_de_oleo":
                for (Data data : veiculoEncontrado.getManutencoes().getTrocasDeOleo()) {
                    resultado = resultado + data.toString() + "\n";
                }
                break;
            case "troca_de_filtros":
                for (Data data : veiculoEncontrado.getManutencoes().getTrocasDeFiltro()) {
                    resultado = resultado + data.toString() + "\n";
                }
                break;
            case "troca_de_pneus":
                for (Data data : veiculoEncontrado.getManutencoes().getTrocasDePneus()) {
                    resultado = resultado + data.toString() + "\n";
                }
                break;
        }
        return resultado;
    }

    public List<Usuario> getUsers() {
        return users;
    }

    public void setUsers(List<Usuario> users) {
        this.users = users;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
