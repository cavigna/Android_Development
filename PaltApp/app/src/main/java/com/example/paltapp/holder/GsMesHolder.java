package com.example.paltapp.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paltapp.R;

import java.text.NumberFormat;

public class GsMesHolder extends RecyclerView.ViewHolder {
    private TextView textView_Mes, textView_Total;
    private NumberFormat format = NumberFormat.getCurrencyInstance();

    public GsMesHolder(@NonNull  View itemView) {
        super(itemView);
        textView_Mes = itemView.findViewById(R.id.tvGsMes_Mes);
        textView_Total = itemView.findViewById(R.id.tvGsMes_Total);


    }
    public void bind(String mes, Double monto){
        textView_Mes.setText(mes);
        textView_Total.setText(format.format(monto));
    }

    public static GsMesHolder create(ViewGroup parent){
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gs_mes_item, parent, false);
        return new GsMesHolder(view);
    }

}
