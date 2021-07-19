package com.example.paltapp.db;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;


import java.util.List;

@Dao
public interface GsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertGasto(Gasto gasto);

    @Update
    void updateGasto(Gasto gasto);

    @Delete
    void deleteGasto(Gasto gasto);

    @Query("DELETE FROM tabla_gastos")
    void deleteAllGasto();



    @Query("SELECT * FROM tabla_gastos")
    LiveData<List<Gasto>> selectAllGastos();


    @Query("SELECT SUM(monto) AS value FROM tabla_gastos")
    LiveData<Double> sumAllGastos();


    @Query("SELECT SUM(monto) AS total FROM TABLA_GASTOS group by categoria")
    LiveData<Double> SumGastosCategoria();

    @Query("SELECT SUM(monto) as total FROM tabla_gastos where categoria = :categorias")
    LiveData<Double> sumGsCat2(String categorias);


/* No borrar esto

    @Query("SELECT SUM(monto) AS total FROM TABLA_GASTOS WHERE categoria = :cat ")
    LiveData<Double> SumGastosCategoria(String cat);
 */








}
