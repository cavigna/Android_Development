package com.example.paltapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.paltapp.R;
import com.example.paltapp.adapter.GsMesListAdapter;
import com.example.paltapp.model.GsViewModel;

public class ListadoMes extends AppCompatActivity {
    private GsViewModel mGsViewModel;
    private GsMesListAdapter adapter;
    RecyclerView recyclerViewMes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_mes);

        //Conexión con el ViewModel
        mGsViewModel = new ViewModelProvider(this).get(GsViewModel.class);

        //Conexión con el RecyclerView
        recyclerViewMes = findViewById(R.id.recycler_mes);

        //adapter

        adapter = new GsMesListAdapter(new GsMesListAdapter.GsMesDiff());
        recyclerViewMes.setAdapter(adapter);
        recyclerViewMes.setLayoutManager(new LinearLayoutManager(this));

        //observer
        mGsViewModel.SumMes().observe(this, gastos -> {
            adapter.submitList(gastos);
        });

    }
}