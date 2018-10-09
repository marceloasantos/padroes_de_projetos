package edu.fatec.aulapadraodeprojeto;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    public List<Veiculo> lVeiculos;

    public CardAdapter(List<Veiculo> veiculos) {
        lVeiculos = veiculos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View cardView = inflater.inflate(R.layout.card_car, parent, false);

        // Return a new holder instance
        return new ViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        // Get the data model based on position
        Veiculo v = lVeiculos.get(i);

        // Set item views based on your views and data model
        TextView textView = viewHolder.txtPlaca;
        TextView tvPlaca = viewHolder.tvPlaca;
        TextView textViewM = viewHolder.txtMarca;
        TextView tvMarca = viewHolder.tvMarca;

        textView.setText(v.getPlaca());
        tvPlaca.setText(R.string.placa);
        textViewM.setText(v.getEspecificacao().getMarca());
        tvMarca.setText(R.string.marca);
    }

    @Override
    public int getItemCount() {
        return lVeiculos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView txtPlaca;
        public TextView tvPlaca;
        public TextView txtMarca;
        public TextView tvMarca;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            txtPlaca = itemView.findViewById(R.id.txtPlaca);
            tvPlaca = itemView.findViewById(R.id.tvPlaca);
            txtMarca = itemView.findViewById(R.id.txtMarca);
            tvMarca = itemView.findViewById(R.id.tvMarca);
        }
    }
}
