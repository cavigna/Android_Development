package com.example.gastapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = Gastos.class, version = 1)

/* Acá Creamos la DB*/
public abstract class GastosDB extends RoomDatabase {

    private static  GastosDB instance;

    public abstract GastosDao gastosDao();

    public static synchronized GastosDB getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    GastosDB.class, "gastos_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instance;
    }


    // Metodo para llenar la base de datos desde el código.
//    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
//        @Override
//        public void onCreate(@NonNull  SupportSQLiteDatabase db) {
//            super.onCreate(db);
//        }
//    };
//
//    public static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void>{
//        private GastosDao gastosDao;
//
//        private  PopulateDbAsyncTask(GastosDB db){
//            gastosDao = db.gastosDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            Date currentTime = (Date) Calendar.getInstance().getTime();
//            gastosDao.insert(new Gastos(1, "ingreso", "papas",
//                    "Comida", 23.5,   currentTime));
//
//            return null;
//        }
//    }
}
