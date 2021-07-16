package com.example.gastapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GastosViewModel extends AndroidViewModel {
    private GastosRepository repository;
    private LiveData<List<Gastos>> allGastos;

    public GastosViewModel(@NonNull @NotNull Application application) {
        super(application);
        repository = new GastosRepository(application);
        allGastos = repository.getAllGastos();
    }

    public void insert(Gastos gastos){
        repository.insert(gastos);
    }

    public void update(Gastos gastos){
        repository.update(gastos);
    }

    public void delete(Gastos gastos){
        repository.delete(gastos);
    }

    public void deleteAll(Gastos gastos){
        repository.deleteAll();
    }

    public LiveData<List<Gastos>>getAllGastos(){
        return allGastos;
    }


}
