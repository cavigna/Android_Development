package com.example.gastapp;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "tabla_gastos")
public class Gastos {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String tipo;

    private String nombre;

    private String categoría;

    private String fecha;

    private double monto;

    public Gastos(@NonNull int id, String tipo, String nombre, String categoría, double monto,
                 String fecha) {
        this.id = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.categoría = categoría;
        this.monto = monto;
        this.fecha = fecha;
    }

    /* Getters and Setters */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoría() {
        return categoría;
    }

    public void setCategoría(String categoría) {
        this.categoría = categoría;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
