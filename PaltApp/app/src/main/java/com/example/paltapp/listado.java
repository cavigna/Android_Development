package com.example.paltapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.paltapp.adapter.GastosListAdapter;
import com.example.paltapp.db.Gasto;
import com.example.paltapp.db.GsDatabase;
import com.example.paltapp.model.GsViewModel;

import java.util.List;

public class listado extends AppCompatActivity {
    private GsViewModel mGsViewModel;
    private GastosListAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        mGsViewModel = new ViewModelProvider(this).get(GsViewModel.class);




        recyclerView = findViewById(R.id.recyclerview);


        adapter = new GastosListAdapter(new GastosListAdapter.GsDiff());

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mGsViewModel.getmAllGasto().observe(this, gastos -> {
            adapter.submitList(gastos);
        });

    }



}

/*
    private void loadGsList() {
        GsDatabase db = GsDatabase.getDatabase(this);
        List<Gasto> gastoList = (List<Gasto>) db.gsDao().selectAllGastos();
        LiveData<List<Gasto>> liveDataGs = db.gsDao().selectAllGastos();
        adapter.setGastos((List<Gasto>) liveDataGs);
        //adapter.setGastos(gastoList);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadGsList();
            Toast.makeText(this, "FUnca", Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
 */