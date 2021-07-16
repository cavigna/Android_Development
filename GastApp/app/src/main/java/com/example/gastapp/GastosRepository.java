package com.example.gastapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class GastosRepository {
    private  GastosDao gastosDao;
    private LiveData<List<Gastos>> allGastos;
    private LiveData<List<Gastos>> groupAllGastos;

    public GastosRepository(Application application){
        GastosDB database = GastosDB.getInstance(application);
        gastosDao = database.gastosDao();
        allGastos = gastosDao.selectAllGastos();
        groupAllGastos = gastosDao.groupAllGastos();
    }

    public void insert(Gastos gastos){
        new InsertGastosAsyncTask(gastosDao).execute(gastos);
    }

    public void update(Gastos gastos){
        new UpdateGastosAsyncTask(gastosDao).execute(gastos);
    }

    public void delete(Gastos gastos){
        new DeleteGastosAsyncTask(gastosDao).execute(gastos);
    }

    public void deleteAll(){
        new DeleteAllGastosAsyncTask(gastosDao).execute();
    }

    public LiveData<List<Gastos>> getAllGastos(){
            return allGastos;
    }

    // Async Insert
    private static class InsertGastosAsyncTask extends AsyncTask<Gastos, Void, Void>{
        private GastosDao gastosDao;


        private InsertGastosAsyncTask(GastosDao gastosDao){
            this.gastosDao = gastosDao;
        }
        @Override
        protected Void doInBackground(Gastos... gastos) {
            gastosDao.insert(gastos[0]);
            return null;
        }
    }

    // Async Update
    private static class UpdateGastosAsyncTask extends AsyncTask<Gastos, Void, Void>{
        private GastosDao gastosDao;


        private UpdateGastosAsyncTask(GastosDao gastosDao){
            this.gastosDao = gastosDao;
        }
        @Override
        protected Void doInBackground(Gastos... gastos) {
            gastosDao.update(gastos[0]);
            return null;
        }
    }

    // Async Delete
    private static class DeleteGastosAsyncTask extends AsyncTask<Gastos, Void, Void>{
        private GastosDao gastosDao;


        private DeleteGastosAsyncTask(GastosDao gastosDao){
            this.gastosDao = gastosDao;
        }
        @Override
        protected Void doInBackground(Gastos... gastos) {
            gastosDao.delete(gastos[0]);
            return null;
        }
    }

    // Async DeleteAll
    private static class DeleteAllGastosAsyncTask extends AsyncTask<Void, Void, Void>{
        private GastosDao gastosDao;


        private DeleteAllGastosAsyncTask(GastosDao gastosDao){
            this.gastosDao = gastosDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            gastosDao.deleteAllGastos();
            return null;
        }
    }

}
