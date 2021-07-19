package com.example.paltapp.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.paltapp.db.Gasto;
import com.example.paltapp.db.GsRepositorio;

import java.util.List;

public class GsViewModel extends AndroidViewModel {

    //private  List<Gasto> mselectAll;
    private GsRepositorio mRepository;
    private final LiveData<List<Gasto>> mAllGasto;
    private LiveData<Double> mSumaGsCat;
    private LiveData<Double> mSumAllGastos;

    private LiveData<List<Gasto>> mSumMes;

    private LiveData<Double> mSumaGsCat2;
    public String categoria;

    public GsViewModel(@NonNull Application application) {
        super(application);
        mRepository = new GsRepositorio(application);
        mAllGasto = mRepository.selectAllGastos();

        mSumaGsCat = mRepository.sumaGastosCategoria();
        mSumAllGastos = mRepository.sumaAllGs();


        mSumaGsCat2 = mRepository.sumaGsCat2(categoria);

        mSumMes = mRepository.gastosMes();




    }

    public LiveData<List<Gasto>> SumMes() {
        return mSumMes;
    }

    public LiveData<Double> getSumaGsCat2(String categoria ) {
        return mRepository.sumaGsCat2(categoria);
    }

    public LiveData<List<Gasto>> getmAllGasto() {
        return mAllGasto;
    }

    public LiveData<Double> getmSumaGsCat() {
        return mSumaGsCat;
    }

    public LiveData<Double> SumAllGastos() {
        return mSumAllGastos;
    }

    public void insert(Gasto gasto){mRepository.insert(gasto);}

    public void update(Gasto gasto){mRepository.update(gasto);}

    public void delete(Gasto gasto){mRepository.delete(gasto);}

    public void deleteAll(){mRepository.deleteAll();}

    public void selectAll(){mRepository.selectAllGastos();}

//    public void sumAllGastos(){
//        mRepository.sumAllGastos();
//
//    }

    //    public List<Gasto> selAll(){
//        return mselectAll;
//    }

//    LiveData<List<Gasto>> selectAllGastos(){return mAllGasto;}


}
