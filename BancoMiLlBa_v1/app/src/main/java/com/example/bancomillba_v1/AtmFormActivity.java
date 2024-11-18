package com.example.bancomillba_v1;

import static com.example.bancomillba_v1.utils.Constantes.C_CREAR;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bancomillba_v1.Adapter.CajerosAdapter;
import com.example.bancomillba_v1.activities.MainActivity;
import com.example.bancomillba_v1.activities.WelcomeActivity;
import com.example.bancomillba_v1.api.BancoDAO;
import com.example.bancomillba_v1.utils.Constantes;

import java.lang.reflect.Array;

public class AtmFormActivity extends AppCompatActivity {

    private Button btnSave,btnCancel;

    private BancoDAO bancoDAO;
    private Cursor cursor;

    // Modo del formulario
    private int modo ;

    // Identificador del registro que se edita cuando la opción es MODIFICAR
    private long id ;

    // Elementos de la vista
    private EditText addres;
    private EditText latitutd;
    private EditText longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm_form);

        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);

        // Definimos las acciones para los dos botones
        // Comentar****************************************************************************
        //Poner los dos btn al final no funciona
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelar();
            }
        });

        Intent intent = getIntent();
        Bundle extra = intent.getExtras();

        if (extra == null) return;

        // Obtenemos los elementos de la vista
        addres = (EditText) findViewById(R.id.addres);
        latitutd = (EditText) findViewById(R.id.latitude);
        longitud = (EditText) findViewById(R.id.longitud);


        // Creamos el DAO
        bancoDAO = new BancoDAO(this);
        try {
            bancoDAO.abrir();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Obtenemos el identificador del registro si viene indicado
        if (extra.containsKey(BancoDAO.C_COLUMNA_ID)){
            id = this.getIntent().getIntExtra(BancoDAO.C_COLUMNA_ID, 1);
            consultar(id);
        }
        // Establecemos el modo del formulario
        establecerModo(extra.getInt(Constantes.C_MODO));

        //********************************************************************
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (modo == C_CREAR){
            return true;
        }
        else
            getMenuInflater().inflate(R.menu.menu_atm, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.delete:
                Toast.makeText(getApplicationContext(),
                        "Eliminar cajero", Toast.LENGTH_SHORT).show();
                borrar(id);
                return true;
        }

        switch (item.getItemId()) {
            case R.id.update:
                this.setEdicion(true);
                btnSave.setVisibility(View.VISIBLE);
                btnCancel.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), "Cajero actualizado", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void borrar(final long id) {

        // Borramos el registro con confirmación
        AlertDialog.Builder dgEliminar = new AlertDialog.Builder(this);
        dgEliminar.setIcon(android.R.drawable.ic_dialog_alert);
        dgEliminar.setTitle("Eliminar cajero");
        dgEliminar.setMessage("¿Seguro que desea eliminar el cajero?");
        dgEliminar.setCancelable(true);

        dgEliminar.setPositiveButton(getResources().getString(android.R.string.ok),
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int boton) {
                        bancoDAO.delete(id);
                        Toast.makeText(AtmFormActivity.this, "Cajero eliminado ", Toast.LENGTH_SHORT).show();

                        // Devolvemos el control
                        setResult(RESULT_OK);
                        finish();
                    }
                });
        dgEliminar.setNegativeButton(android.R.string.no, null);
        dgEliminar.show();
    }

    private void establecerModo(int m) {
        this.modo = m ;

        // Si estamos solamente visualizando establecemos el modo edición
        // desactivado a todo el formulario
        if (modo == Constantes.C_VISUALIZAR) {
            this.setTitle(addres.getText().toString());
            this.setEdicion(false);

            btnSave.setVisibility(View.GONE);
            btnCancel.setVisibility(View.GONE);
        }

        if (modo == C_CREAR){
            this.setTitle("Crear cajero");
            this.setEdicion(true);
            btnSave.setVisibility(View.VISIBLE);
            btnCancel.setVisibility(View.VISIBLE);
        }
    }

    @SuppressLint("Range")
    private void consultar(long id) {
        // Consultamos el centro por el identificador
        cursor = bancoDAO.getRegistro(id);

        //  comentar porque me da error sin el +1 y poque me imprime el numero del cursor y no el resultado
        addres.setText(cursor.getString(cursor.getColumnIndex(BancoDAO.C_COLUMNA_ADDRESS)));
        latitutd.setText(cursor.getString(cursor.getColumnIndex(BancoDAO.C_COLUMNA_LATITUD)+3));
        longitud.setText(cursor.getString(cursor.getColumnIndex(BancoDAO.C_COLUMNA_LONGITUD)+4));

    }


   /* @SuppressLint("Range")
    private void consultar(long id) {
        // Consultamos el centro por el identificador
        cursor = bancoDAO.getRegistro(id);

        //nombre.setText(cursor.getString(cursor.getColumnIndex(HipotecasDAO.C_COLUMNA_NOMBRE)));

        addres.setText(cursor.getString(cursor.getColumnIndex(BancoDAO.C_COLUMNA_ADDRESS)));
        latitutd.setText(cursor.getString(cursor.getColumnIndex(BancoDAO.C_COLUMNA_LATITUD)));
        longitud.setText(cursor.getString(cursor.getColumnIndex(BancoDAO.C_COLUMNA_LONGITUD)));

    }*/

    private void setEdicion(boolean opcion) {
        addres.setEnabled(opcion);
        latitutd.setEnabled(opcion);
        longitud.setEnabled(opcion);

    }

    private void guardar(){
        // Obtenemos los datos del formulario
        ContentValues reg = new ContentValues();

        reg.put(BancoDAO.C_COLUMNA_ADDRESS, addres.getText().toString());
        reg.put(BancoDAO.C_COLUMNA_LATITUD, latitutd.getText().toString());
        reg.put(BancoDAO.C_COLUMNA_LONGITUD, longitud.getText().toString());

        if (modo == C_CREAR){
            bancoDAO.insert(reg);
            Toast.makeText(AtmFormActivity.this, "Cajero nuevo", Toast.LENGTH_SHORT).show();
        }

        // Devolvemos el control
        setResult(RESULT_OK);
        finish();
    }

    private void cancelar(){
        setResult(RESULT_CANCELED, null);
        finish();
    }


}