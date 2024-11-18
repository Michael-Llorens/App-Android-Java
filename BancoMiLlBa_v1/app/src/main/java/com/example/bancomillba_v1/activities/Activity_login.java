package com.example.bancomillba_v1.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.pojo.Cliente;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Activity_login extends AppCompatActivity {

    private Button btnEnviar, btnSalir;
    private EditText Usuario, contraseña;

    MiBancoOperacional bancoOperacional;

    ProgressDialog progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEnviar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnSalir);
        Usuario = (EditText) findViewById(R.id.Usuario);
        contraseña = findViewById(R.id.Password);

        //Se crea el objeto para poder conectarse a la base de datos
        bancoOperacional = MiBancoOperacional.getInstance(this);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ExecutorService service = Executors.newSingleThreadExecutor();
                service.execute(new Runnable() {
                    @Override
                    public void run() {
                        //onPreExecute Method
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Log.d("111111111111111",String.valueOf("hola"));
                                showProgressDialog();
                            }
                        });

                        //this is doInBackgroud method of Asynctask

                        try {
                            while (progreso.getProgress() != 100){
                                SystemClock.sleep(100);
                                progreso.incrementProgressBy(10);
                            }
                            Cliente c = new Cliente();

                            c.setNif(Usuario.getText().toString());
                            c.setClaveSeguridad(contraseña.getText().toString());

                            Cliente cAux = bancoOperacional.login(c);

                            if (cAux == null) {
                                Toast.makeText(Activity_login.this, "Error, cliente no registrado", Toast.LENGTH_SHORT).show();
                            } else {
                                Intent inicio = new Intent(Activity_login.this, MainActivity.class);

                                Bundle enviarDatos = new Bundle();
                                enviarDatos.putSerializable("Cliente", cAux);

                                inicio.putExtras(enviarDatos);
                                startActivity(inicio);
                            }
                        }catch (Exception e) {

                        }

                        //this is a onPostExecute Method
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progreso.dismiss();

                            }
                        });
                    }
                });
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent salir = new Intent(Activity_login.this, WelcomeActivity.class);
                startActivity(salir);
            }
        });

    }

    public void showProgressDialog() {
        progreso = new ProgressDialog(Activity_login.this);
        progreso.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progreso.setMessage("Calculando...");
        progreso.setCancelable(false);
        progreso.setMax(100);
        progreso.setProgress(0);
        progreso.show();
    }

}