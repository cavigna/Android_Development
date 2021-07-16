package com.example.gastapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public  class GastosAdapter extends RecyclerView.Adapter<GastosAdapter.GastosHolder> {
    private List<Gastos> gastos = new ArrayList<>();


    @NonNull
    @NotNull
    @Override
    public GastosHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.gastos_items, parent, false);
        return new GastosHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull GastosHolder holder, int position) {
        Gastos gastoActual = gastos.get(position);
        holder.textViewCategoria.setText(gastoActual.getCategoría());
        holder.textViewMonto.setText(String.valueOf(gastoActual.getMonto()));
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public void setGastos(List<Gastos> gastos){
        this.gastos = gastos;
        notifyDataSetChanged();
    }

    class GastosHolder extends RecyclerView.ViewHolder{
        private TextView textViewCategoria;
        private TextView textViewMonto;
        private ImageView imageViewCategoria;

        public GastosHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewCategoria = itemView.findViewById(R.id.categoria);
            textViewMonto = itemView.findViewById(R.id.card_monto);
            imageViewCategoria = itemView.findViewById(R.id.imageViewIcon);
        }
    }
}
