package com.example.paltapp.db;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class GsRepositorio {

    private GsDao gsDao;
    private LiveData<List<Gasto>> mAllGastos;
    private LiveData<List<Gasto>> mgastosMes;

    private LiveData<Double> msumaGsCate;
    private LiveData<Double> msumaAllGs;

    private LiveData<Double> msumaGsCat2;

    //private String categoria = "ocio";
    private String categoria;


    public GsRepositorio(Application application) {
        GsDatabase database = GsDatabase.getDatabase(application);
        gsDao = database.gsDao();
        mAllGastos = gsDao.selectAllGastos();
        msumaGsCate = gsDao.SumGastosCategoria();
        msumaAllGs = gsDao.sumAllGastos();
        msumaGsCat2 = gsDao.sumGsCat2(categoria);

        mgastosMes = gsDao.gastosMes();

    }


    public LiveData<List<Gasto>> selectAllGastos() {
        return mAllGastos;
    }

    public LiveData<Double> sumaGastosCategoria() {return msumaGsCate;}

    public LiveData<Double> sumaAllGs() {return msumaAllGs; }

    public LiveData<List<Gasto>> gastosMes() {
        return mgastosMes;
    }

    public LiveData<Double> sumaGsCat2(String categoria){
    return gsDao.sumGsCat2(categoria);
}



    // SQLite QUERIES definidas en DAO que se ejecuntan en el REPO.


    public void insert(Gasto gasto) {
        GsDatabase.databaseWriteExecutor.execute(()
                -> gsDao.insertGasto(gasto));
    }

    public void update(Gasto gasto) {
        GsDatabase.databaseWriteExecutor.execute(()
                -> gsDao.updateGasto(gasto));
    }

    public void delete(Gasto gasto) {
        GsDatabase.databaseWriteExecutor.execute(()
                -> gsDao.deleteGasto(gasto));
    }

    public void deleteAll() {
        GsDatabase.databaseWriteExecutor.execute(()
                -> gsDao.deleteAllGasto());
    }

//    public void sumAllGastos (){
//        GsDatabase.databaseWriteExecutor.execute(()
//                -> gsDao.sumAllGastos());
//    }

//    public void selectTodosGastos(){
//        GsDatabase.databaseWriteExecutor.execute(()
//                -> gsDao.selectAllGastos());
//    }
}
