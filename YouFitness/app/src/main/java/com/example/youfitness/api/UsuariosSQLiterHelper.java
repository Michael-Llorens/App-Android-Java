package com.example.youfitness.api;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class UsuariosSQLiterHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String nombreBD = "YouFitnessBD";

    private static SQLiteDatabase.CursorFactory factory = null;

    private static SQLiteDatabase db;

    private static UsuariosSQLiterHelper instance = null;

    private Usuarios usuarios;

    // Sentencia de creación de tabla usuarios
    private String sqlCreacionTablaUsuarios = "CREATE TABLE usuariosYouFitnes(" +
            " id_usuario INTEGER PRIMARY KEY," +
            " imagen TEXT, " +
            " latitud TEXT," +
            " longitud TEXT," +
            " nombre TEXT)";

    //Insertamos un index que es el campo que mas vams a utilizar
    private String sqlIndiceNombreUsuarios = "CREATE UNIQUE INDEX nombreusuarios " +
            "ON usuariosYouFitnes(nombre ASC)";

    // Sentencia de inserción de datos iniciales en la tabla hipotecas
    private String[] sqlInsertUsuarios = {
            "INSERT INTO usuariosYouFitnes(id_usuario, imagen, Latitud, Longitud,nombre) VALUES(1,'https://tse4.mm.bing.net/th?id=OIP.X_M-3rqsJ-h2VHqeR0oViAHaJ4&pid=Api&P=0', '38.988269', '-0.529858', 'Elena')",
            "INSERT INTO usuariosYouFitnes(id_usuario, imagen, Latitud, Longitud,nombre) VALUES(2,'https://tse3.mm.bing.net/th?id=OIP.U4VscHpDKpHkZHXSvZGYMwHaET&pid=Api&P=0', '39.455017', '-0.3869383', 'Juan')",
            "INSERT INTO usuariosYouFitnes(id_usuario, imagen, Latitud, Longitud,nombre) VALUES(3,'https://tse3.mm.bing.net/th?id=OIP.-tP0mjiPAH019NADQXrJ7AHaHa&pid=Api&P=0', '38.255647', '-4.814917', 'Silvia')",
            "INSERT INTO usuariosYouFitnes(id_usuario, imagen, Latitud, Longitud,nombre) VALUES(4,'https://tse3.mm.bing.net/th?id=OIP.-_ajcJFRsHJIjckPAOPzzgHaE7&pid=Api&P=0', '39.4647669','-0.3732760000000326', 'Vicente')",
            "INSERT INTO usuariosYouFitnes(id_usuario, imagen, Latitud, Longitud,nombre) VALUES(5,'https://tse1.explicit.bing.net/th?id=OIP.hcVZiCht6qStxcmC-sGGnAHaEM&pid=Api&P=0', '40.342912', '-3.881842', 'Ramon')"};


    public UsuariosSQLiterHelper(@Nullable Context context) {
        super(context, nombreBD, factory, version);
    }

    public static UsuariosSQLiterHelper getInstance(Context context) {
        if(instance == null) {
            instance = new UsuariosSQLiterHelper(context);
            db = instance.getWritableDatabase();
           // clienteDAO = new ClienteDAO();
            //cuentaDAO = new CuentaDAO();
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Se ejecuta la sentencia SQL de creación de la tabla
        Log.i(this.getClass().toString(), "Creando tabla usuarios");

        db.execSQL(sqlCreacionTablaUsuarios);
        db.execSQL(sqlIndiceNombreUsuarios);

        Log.i(this.getClass().toString(), "Tabla Usuario creada");

        // Ejecutamos la carga de datos iniciales en la tabla
        Log.i(this.getClass().toString(), "Insertando datos iniciales");

        for(int i=0;i<sqlInsertUsuarios.length;i++){
            db.execSQL(sqlInsertUsuarios[i]);
        }

        //upgrade_2(db);

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

        // db.execSQL( "UPDATE hipotecas " +
        //   " SET contacto = 'Julián Gómez Martínez'," +
        // " email = 'jgmartinez@gmail.com'," +
        //" observaciones = 'Tiene toda la documentación y está estudiando la solicitud. En breve llamará para informar de las condiciones'" +
        //" WHERE _id = 1");
        Log.i(this.getClass().toString(), "Actualización versión 2 finalizada");
    }

    // Upgrade versión 3: Incluir pasivo_sn
    private void upgrade_3(SQLiteDatabase db) {

        //db.execSQL("ALTER TABLE hipotecas ADD pasivo_sn VARCHAR2(1) NOT NULL DEFAULT 'N'");
        Log.i(this.getClass().toString(), "Actualización versión 3 finalizada");
    }
}
