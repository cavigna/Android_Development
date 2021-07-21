package com.example.paltapp.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tabla_gastos")
public class Gasto {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String categoria;
    private String nombre;
    private String fecha;
    private double monto;
    private double total;

    // Construnctor
    public Gasto( String categoria, String nombre, String fecha, double monto) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.fecha = fecha;
        this.monto = monto;
    }

    // GETTERS AND SETTERS.


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
