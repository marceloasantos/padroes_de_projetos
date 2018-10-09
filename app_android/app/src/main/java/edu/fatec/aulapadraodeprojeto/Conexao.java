package edu.fatec.aulapadraodeprojeto;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Conexao {

    private final String USER_AGENT = "Mozilla/5.0";


    // HTTP GET request
    public List<Veiculo> sendGet(String placa) throws Exception {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        String url = "http://172.16.2.253:1223/carro/" + placa;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //System.out.println(response.toString());

        List<Veiculo> found = findAllItems(new JSONArray(response.toString()));

        return found;
    }

    public List<Veiculo> findAllItems(JSONArray response) {

        List<Veiculo> found = new LinkedList<>();

        try {


            for (int i = 0; i < response.length(); i++) {
                JSONObject obj = response.getJSONObject(i);
                found.add(new Veiculo(
                        obj.getString("placa"),
                        obj.getString("responsavel"),
                        new Especificacao(obj.getJSONObject("especificacao").getString("marca"),
                                obj.getJSONObject("especificacao").getString("modelo"),
                                obj.getJSONObject("especificacao").getString("cor"),
                                obj.getJSONObject("especificacao").getString("ano")),
                        obj.getString("combustivel"), obj.getString("seguradora")));
            }

        } catch (JSONException e) {
            // handle exception
        }

        return found;
    }

}
