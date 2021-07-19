package com.example.paltapp.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = Gasto.class, version = 1, exportSchema = false)
public abstract class GsDatabase extends RoomDatabase {

    public abstract GsDao gsDao();

    private static GsDatabase minstance; // singleton
    private static final String DB_NAME = "gastos_database";

    private static final int NUMBER_OF_THREADS = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static  GsDatabase getDatabase(final Context context) {

        if (minstance == null) {
            synchronized (GsDatabase.class){
                if (minstance == null){
                minstance =  Room.databaseBuilder(context.getApplicationContext(),
                        GsDatabase.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .addCallback(sRoomDatabaseCallback)
                        .build();
                }
            }

        }


        return minstance;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {


        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                GsDao dao = minstance.gsDao();
                //dao.deleteAllGasto();

                Gasto gasto = new Gasto("Ocio", "Netflix", "Julio",
                        7500);
                dao.insertGasto(gasto);
                gasto = new Gasto("Ocio", "The Withcer 3", "Julio",
                        5500);
                dao.insertGasto(gasto);

                gasto = new Gasto("Hogar", "Arriendo Julio", "Julio",
                        25000);
                dao.insertGasto(gasto);

                gasto = new Gasto("Compras", "Compra Lider", "Julio",
                        7200);
                dao.insertGasto(gasto);
                gasto = new Gasto("Hogar", "Electricidad",
                        "Julio", 15000);
                dao.insertGasto(gasto);

                gasto = new Gasto("Transporte", "Metro", "Julio", 30000);
                dao.insertGasto(gasto);
            });
        }

    };
}


