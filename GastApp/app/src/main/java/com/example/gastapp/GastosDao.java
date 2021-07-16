package com.example.gastapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GastosDao {

        @Insert
        void insert(Gastos gastos );

        @Update
        void update(Gastos gastos);

        @Delete
        void delete(Gastos gastos);

        @Query("DELETE  FROM tabla_gastos")
        void deleteAllGastos();

        @Query("SELECT * FROM tabla_gastos ")
        LiveData<List<Gastos>> selectAllGastos();

        @Query("SELECT categoría, SUM(monto) FROM tabla_gastos GROUP BY categoría")
        LiveData<List<Gastos>> groupAllGastos();


}
