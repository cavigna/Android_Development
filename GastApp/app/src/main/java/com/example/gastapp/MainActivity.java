package com.example.gastapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GastosViewModel gastosViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        GastosAdapter adapter = new GastosAdapter();
        recyclerView.setAdapter(adapter);

        gastosViewModel = ViewModelProviders.of(this).get(GastosViewModel.class);
        gastosViewModel.getAllGastos().observe(this, new Observer<List<Gastos>>() {
            @Override
            public void onChanged(List<Gastos> gastos) {
                //Update RecyclerView
                adapter.setGastos(gastos);
                Toast.makeText(MainActivity.this,
                        "onChanged", Toast.LENGTH_SHORT).show();
            }
        });
    }
}