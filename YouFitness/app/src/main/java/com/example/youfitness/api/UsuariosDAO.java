package com.example.youfitness.api;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.youfitness.fragments.HomeFragmen;

public class UsuariosDAO {

    // Definimos constante con el nombre de la tabla
    private static final String C_TABLA = "usuariosYouFitnes";

    // Definimos constantes con el nombre de las columnas de la tabla
    public static final String C_COLUMNA_ID   = "id_usuario";
    public static final String C_COLUMNA_IMAGEN = "imagen";
    public static final String C_COLUMNA_LATITUD = "latitud";
    public static final String C_COLUMNA_LONGITUD = "longitud";
    public static final String C_COLUMNA_NOMBRE = "nombre";

    // Definimos lista de columnas de la tabla para utilizarla en las consultas
    // a la base de datos
    private String[] columnas = new String[]{ C_COLUMNA_ID, C_COLUMNA_IMAGEN, C_COLUMNA_LATITUD, C_COLUMNA_LONGITUD, C_COLUMNA_NOMBRE} ;

    private Context contexto;
    private UsuariosSQLiterHelper dbHelper;
    private SQLiteDatabase db;




    //Costructor
    public UsuariosDAO(Context contexto) {
        this.contexto = contexto;
    }

    public UsuariosDAO abrir(){
        dbHelper = new UsuariosSQLiterHelper(contexto);
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
