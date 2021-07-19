package com.example.paltapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.paltapp.db.GsRepositorio;
import com.example.paltapp.model.GsViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private GsViewModel gsViewModel;
    private GsRepositorio gsRepositorio;
    private TextView textViewTotal, textViewHogar;

    private FloatingActionButton fbAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // try block to hide Action bar
        try {this.getSupportActionBar().hide();}
        // catch block to handle NullPointerException
        catch (NullPointerException e) {       }

        fbAgregar = findViewById(R.id.fbAgregar);
        textViewTotal = findViewById(R.id.textView_total);
        textViewHogar =  findViewById(R.id.tvHogar);



        gsViewModel = new ViewModelProvider(this).get(GsViewModel.class);

        Object montoTotal;
        gsViewModel.getmSumaGsCat().observe(this, aDouble ->

                textViewTotal.setText(
                        String.valueOf(aDouble
                )));
        gsViewModel.getSumaGsCat2("Hogar").observe(this, aDouble ->
                textViewHogar.setText(
                        String.valueOf(aDouble
                        )));

    }

    public void agregar(View view){
        Intent intent = new Intent(this, AgregarItem.class);
        startActivity(intent);
    }




}

/*
gsViewModel.getmSumaGsCat().observe(this, aDouble -> {
            textViewTotal.setText(
                    String.valueOf(gsViewModel.SumAllGastos()));
        });
 */