package com.example.paltapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paltapp.R;

public class GsRecyclerViewHolder extends RecyclerView.ViewHolder {
    private TextView textView_categoria, textView_monto;

    public GsRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        textView_categoria = itemView.findViewById(R.id.textView_categoria_list);
        textView_monto = itemView.findViewById(R.id.textView_monto_item);

    }

    public void bindCategoria(String cate){
        textView_categoria.setText(cate);
        //textView_monto.setText(Double.toString(monto));
    }

    public void bindMonto(Double amount){
        textView_monto.setText(Double.toString(amount));
    }

    public static GsRecyclerViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new GsRecyclerViewHolder(view);
    }
}
