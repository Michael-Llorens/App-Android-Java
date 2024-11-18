package com.example.bancomillba_v1.api;

import static com.example.bancomillba_v1.bd.Constantes.CAJEROS_TABLE;
import static com.example.bancomillba_v1.bd.Constantes.FIELD_CAJEROS_ID;
import static com.example.bancomillba_v1.bd.Constantes.FIELD_DIRECCION;
import static com.example.bancomillba_v1.bd.Constantes.FIELD_LAT;
import static com.example.bancomillba_v1.bd.Constantes.FIELD_LNG;
import static com.example.bancomillba_v1.bd.Constantes.FIELD_ZOOM;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class BancoSQLiteHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String nombreBD = "BancoDB" ;
    private static SQLiteDatabase.CursorFactory factory = null;

    // Sentencia de creación de tabla hipotecas
    private String sqlCreacionTablaCajeros = "CREATE TABLE cajeros(" +
            " _id INTEGER PRIMARY KEY," +
            " address TEXT NOT NULL, " +
            " Latitud TEXT," +
            " Longitud TEXT)";

    //Insertamos un index que es el campo que mas vams a utilizar
    private String sqlIndiceNombreCajeros = "CREATE UNIQUE INDEX nombreBanco " +
            "ON cajeros(address ASC)";

    // Sentencia de inserción de datos iniciales en la tabla hipotecas
    private String[] sqlInsertCajeros = {
            "INSERT INTO cajeros(_id, address, Latitud, Longitud) VALUES(1,'C/ dels Carters, 1, 46007 València, Valencia', '39.455017', '-0.3869383')",
            "INSERT INTO cajeros(_id, address, Latitud, Longitud) VALUES(2,'BUL SUR, S/N, 46026 València', '39.4698', '-0.3774')",
            "INSERT INTO cajeros(_id, address, Latitud, Longitud) VALUES(3,'Carrer del Clariano, 1, 46021 Valencia, Valencia,España', '39.47600769999999','-0.3524475000000393')",
            "INSERT INTO cajeros(_id, address, Latitud, Longitud) VALUES(4,'Centro Comercial Gran Turia Plaza de Europa, s/n, 46014 Valencia', '40.1617', '-85.7197')",

            "INSERT INTO cajeros(_id, address, Latitud, Longitud) VALUES(5,'Avinguda del Cardenal Benlloch, 65, 46021 València, Valencia, España','39.4710366','-0.3547525000000178')",
            "INSERT INTO cajeros(_id, address, Latitud, Longitud) VALUES(6,'Av. del Port, 237, 46011 València, Valencia, España','39.46161999999999','-0.3376299999999901')",
            "INSERT INTO cajeros(_id, address, Latitud, Longitud) VALUES(7,'Carrer del Batxiller, 6, 46010 València, Valencia, España','39.4826729','-0.3639118999999482')",
            "INSERT INTO cajeros(_id, address, Latitud, Longitud) VALUES(8,'Av. del Regne de València, 2, 46005 València, Valencia, España','39.4647669','-0.3732760000000326')"
    };


    public BancoSQLiteHelper(@Nullable Context context) {
        super(context, nombreBD, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Se ejecuta la sentencia SQL de creación de la tabla
        Log.i(this.getClass().toString(), "Creando tabla cajeros");

        db.execSQL(sqlCreacionTablaCajeros);
        db.execSQL(sqlIndiceNombreCajeros);

        Log.i(this.getClass().toString(), "Tabla cajeros creada");

        // Ejecutamos la carga de datos iniciales en la tabla
        Log.i(this.getClass().toString(), "Insertando datos iniciales");

        for(int i=0;i<sqlInsertCajeros.length;i++){
            db.execSQL(sqlInsertCajeros[i]);
        }

        upgrade_2(db);

        Log.i(this.getClass().toString(), "Datos iniciales cargados");
        Log.i(this.getClass().toString(), "Base de datos inicial creada");



    }

    @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Actualización a versión 2
        if (oldVersion < 2) {
            upgrade_2(db);
        }
        // Actualización a versión 3
        if (oldVersion < 3) {
            upgrade_3(db);
        }

    }
    // Upgrade versión 2: definir algunos datos de ejemplo
    private void upgrade_2(SQLiteDatabase db) {

        db.execSQL( "UPDATE hipotecas " +
            " SET contacto = 'Julián Gómez Martínez'," +
            " email = 'jgmartinez@gmail.com'," +
            " observaciones = 'Tiene toda la documentación y está estudiando la solicitud. En breve llamará para informar de las condiciones'" +
            " WHERE _id = 1");
        Log.i(this.getClass().toString(), "Actualización versión 2 finalizada");
    }

    // Upgrade versión 3: Incluir pasivo_sn
    private void upgrade_3(SQLiteDatabase db) {

        db.execSQL("ALTER TABLE hipotecas ADD pasivo_sn VARCHAR2(1) NOT NULL DEFAULT 'N'");
        Log.i(this.getClass().toString(), "Actualización versión 3 finalizada");
    }


}
