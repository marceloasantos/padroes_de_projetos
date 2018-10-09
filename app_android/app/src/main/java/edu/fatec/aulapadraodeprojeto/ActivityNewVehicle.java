package edu.fatec.aulapadraodeprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class ActivityNewVehicle extends AppCompatActivity {
    Modelo model = Modelo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_vehicle);
    }

    public void onClickNewVehicle(View view) {
        EditText cor = findViewById(R.id.txtCor);
        Spinner ano = findViewById(R.id.spnAno);
        EditText placa = findViewById(R.id.tvPlaca);
        EditText responsavel = findViewById(R.id.txtResponsavel);
        Spinner combustivel = findViewById(R.id.spnTipoCombustivel);
        Spinner marca = findViewById(R.id.spnMarca);
        Spinner modelo = findViewById(R.id.spnModelo);

        model.getVeiculos().add(new Veiculo(placa.getText().toString(), responsavel.getText().toString(),
                new Especificacao(marca.getSelectedItem().toString(), modelo.getSelectedItem().toString(),
                        cor.getText().toString(), ano.getSelectedItem().toString()),
                combustivel.getSelectedItem().toString(), "Nenhum"));

        Intent intent = new Intent(this, ActivityListVehicles.class);
        startActivity(intent);
    }
}