package edu.fatec.aulapadraodeprojeto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Modelo users = Modelo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ResourceAsColor")
    public void onClickLogin(View view) {
        EditText login = findViewById(R.id.txtUser);
        EditText password = findViewById(R.id.txtPwd);
        TextView txtResult = findViewById(R.id.logResult);

        String log = login.getText().toString().trim();
        String pwd = password.getText().toString().trim();

        Usuario userLogged = users.matchLogin(log, pwd);

        if (userLogged == null) {
            //txtResult.setTextColor(R.color.colorLight);
            txtResult.setText(R.string.connection_fail);
        } else {
            //txtResult.setTextColor(R.color.colorLight);
            txtResult.setText(R.string.connection_succeed);
            Intent intent = new Intent(this, ActivityListVehicles.class);
            startActivity(intent);
        }
    }
}