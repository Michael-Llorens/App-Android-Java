package com.example.bancomillba_v1.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoDAO {

        // Definimos constante con el nombre de la tabla
        private static final String C_TABLA = "cajeros";

        // Definimos constantes con el nombre de las columnas de la tabla
        public static final String C_COLUMNA_ID   = "_id";
        public static final String C_COLUMNA_ADDRESS = "address";
        public static final String C_COLUMNA_LATITUD = "latitud";
        public static final String C_COLUMNA_LONGITUD = "longitud";

        // Definimos lista de columnas de la tabla para utilizarla en las consultas
        // a la base de datos
        private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_ADDRESS, C_COLUMNA_LATITUD, C_COLUMNA_LONGITUD} ;

        private Context contexto;
        private BancoSQLiteHelper dbHelper;
        private SQLiteDatabase db;


        //Costructor
        public BancoDAO(Context contexto) {
                this.contexto = contexto;
        }

        public BancoDAO abrir(){
                dbHelper = new BancoSQLiteHelper(contexto);
                db = dbHelper.getWritableDatabase();
                return this;
        }

        public void cerrar() {
                dbHelper.close();
        }

        // Devuelve un cursor con todas las filas y todas las columnas de la tabla
        public Cursor getCursor() {
                Cursor c = db.query(true, C_TABLA, columnas, null, null,
                        null, null, null,null);
                return c;
        }

        // Devuelve cursor con todos las columnas del registro
        public Cursor getRegistro(long id) {
                String condicion = C_COLUMNA_ID + "=" + id;
                Cursor c = db.query( true, C_TABLA, columnas, condicion, null,
                        null, null, null, null);

                //Nos movemos al primer registro de la consulta
                if (c != null) {
                        c.moveToFirst();
                }
                return c;
        }

        // Inserta los valores en un registro de la tabla
        public long insert(ContentValues reg) {
                if (db == null)
                        abrir();

                return db.insert(C_TABLA, null, reg);
        }

        public void delete(long id) {
                if (db == null)
                        abrir();
                db.delete(C_TABLA, "_id=" + id, null);
        }
}
