package com.example.paltapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paltapp.db.Gasto;
import com.example.paltapp.db.GsDatabase;
import com.example.paltapp.db.GsRepositorio;
import com.example.paltapp.model.GsViewModel;

public class AgregarItem extends AppCompatActivity {
    private GsViewModel gsViewModel;

    Button btn, btn_add, btn_deleteAll;
    EditText  editText_nombre, editText_fecha,
            editText_categoria, editText_monto;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_item);

        gsViewModel = new ViewModelProvider(this).get(GsViewModel.class);



        btn = findViewById(R.id.button_home);
        btn_add = findViewById(R.id.button_add);
        btn_deleteAll = findViewById(R.id.button_delete);


        editText_nombre = findViewById(R.id.editText_nombre);
        editText_fecha = findViewById(R.id.editText_fecha);
        editText_categoria = findViewById(R.id.editText_categoria);
        editText_monto = findViewById(R.id.editText_monto);




    }

    public void agregar (View view){

    String categoria = editText_categoria.getText().toString();
    String nombre = editText_nombre.getText().toString();
    String fecha = editText_fecha.getText().toString();
    double monto = Double.parseDouble(editText_monto.getText().toString());

        Gasto gasto = new Gasto( categoria, nombre, fecha
            , monto);
        gsViewModel.insert(gasto);

        editText_categoria.getText().clear();
        editText_nombre.getText().clear();
        editText_fecha.getText().clear();
        editText_monto.getText().clear();
        Toast.makeText(this, "Data Successfully Saved", Toast.LENGTH_SHORT).show();

    }

    public void agregarMuchos(View view){
//        Gasto gasto = new Gasto("Ocio", "Netflix", "Julio",
//                7500);
//        gsViewModel.insert(gasto);
//        gasto = new Gasto("Ocio", "The Withcer 3", "Julio",
//                5500);
//        gsViewModel.insert(gasto);
//
//        gasto = new Gasto("Hogar", "Arriendo Julio", "Julio",
//                25000);
//        gsViewModel.insert(gasto);
        Gasto gasto= new Gasto("Compras", "Compra Lider", "Julio",
                7200);
        gsViewModel.insert(gasto);

        gasto = new Gasto("Hogar", "Electricidad",
                "Julio", 15000);
        gsViewModel.insert(gasto);

    }

    public void deleteAll(View view){
        gsViewModel.deleteAll();

    }

    public void homeprueba(View view){
        Intent intent = new Intent(this, home2.class);
        startActivity(intent);
    }

    public void irListado(View view){
        Intent intent = new Intent(this, listado.class);
        startActivity(intent);
    }
}



//    String categoria = editText_categoria.getText().toString();
//    String nombre = editText_nombre.getText().toString();
//    String fecha = editText_fecha.getText().toString();
//    double monto = Double.parseDouble(editText_monto.getText().toString());
//
//    Gasto gasto = new Gasto( categoria, nombre, fecha
//            , monto);
//
////GsRepositorio gsRepositorio = new GsRepositorio;
//
//            GsDatabase.getDatabase(getApplicationContext()).gsDao().
//                    insertGasto(gasto);
