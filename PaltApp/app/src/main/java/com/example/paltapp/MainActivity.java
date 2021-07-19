package com.example.paltapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.paltapp.model.GsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {
    private GsViewModel gsViewModel;
    private TextView textViewTotal, textViewHogar,textViewOcio, textViewCompras;
    private String total;

    private FloatingActionButton fbAgregar;


    //NumberFormat formatter = new DecimalFormat("$ #.###,##");

    NumberFormat format = NumberFormat.getCurrencyInstance();
//    format.setMaximumFractionDigits(0);
//    format.setCurrency(Currency.getInstance("EUR"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // try block to hide Action bar
        try {
            this.getSupportActionBar().hide();
        }
        // catch block to handle NullPointerException
        catch (NullPointerException e) {
        }

        fbAgregar = findViewById(R.id.fbAgregar);
        textViewTotal = findViewById(R.id.textView_total);
        textViewHogar = findViewById(R.id.tvHogar);
        textViewOcio = findViewById(R.id.tvOcio);
        textViewCompras = findViewById(R.id.tvCompras);
        //textViewTotal.setText("$ ");

        gsViewModel = new ViewModelProvider(this).get(GsViewModel.class);

        gsViewModel.SumAllGastos().observe(this, aDouble ->

                textViewTotal.setText(
                        format.format(aDouble)
                        ));


        agregarTextCategorias("Hogar", textViewHogar);
        agregarTextCategorias("Ocio", textViewOcio);
        agregarTextCategorias("Compras",textViewCompras );
    }

    public void agregar(View view) {
        Intent intent = new Intent(this, AgregarItem.class);
        startActivity(intent);
    }

    private void agregarTextCategorias(String cat, TextView textView){

         gsViewModel.getSumaGsCat2(cat).observe(this, aDouble ->
                textView.setText(String.valueOf(format.format(aDouble))));

    }

    public void irListadoMes(View view) {
        Intent intent = new Intent(this, ListadoMes.class);
        startActivity(intent);
    }

    public void irListado(View view) {
        Intent intent = new Intent(this, listado.class);
        startActivity(intent);
    }

}

/*
gsViewModel.getmSumaGsCat().observe(this, aDouble ->

                textViewTotal.setText(
                        String.valueOf(aDouble
                )));
 */

/*
 String.valueOf(aDouble)
 */

/*
        gsViewModel.getmSumaGsCat().observe(this, aDouble ->
            total = new StringBuilder().append("$ ").append(String.valueOf(aDouble)).toString()
        );
        textViewTotal.setText(total);


                gsViewModel.getSumaGsCat2("Hogar").observe(this, aDouble ->
                textViewHogar.setText(
                        String.valueOf(aDouble
                        )));
 */