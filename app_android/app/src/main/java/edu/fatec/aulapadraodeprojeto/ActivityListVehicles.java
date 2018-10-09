package edu.fatec.aulapadraodeprojeto;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;

public class ActivityListVehicles extends Activity {
    Modelo model = Modelo.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        RecyclerView rv = findViewById(R.id.rvCars);
        CardAdapter adapter = new CardAdapter(model.getVeiculos());

        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onClickAddNewVehicle(View view) {
        Intent intent = new Intent(this, ActivityNewVehicle.class);
        startActivity(intent);
    }

}
