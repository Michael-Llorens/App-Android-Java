package com.example.bancomillba_v1.activities;

import  android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bancomillba_v1.AtmManagementActivity;
import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.pojo.Cliente;

public class MainActivity extends AppCompatActivity {

    private TextView bienvenida;
    private Button btnSalirInicio,btnCambiarContraseña,btnTransferencias,btnMovimientos,btnPosicion,btnATM;

    MiBancoOperacional bancoOperacional;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Bundle recibirrDatos = getIntent().getExtras();
        Cliente info = (Cliente) recibirrDatos.getSerializable("Cliente");

        Cliente cAux = bancoOperacional.login(info);

        switch (item.getItemId()) {
            case R.id.action_settings1:
                Intent login1 = new Intent(MainActivity.this, GlobalPositionActivity.class);
                Bundle enviarDatos1 = new Bundle();
                enviarDatos1.putSerializable("Cliente",cAux);

                login1.putExtras(enviarDatos1);
                startActivity(login1);
                return true;

            case R.id.action_settings2:
                Intent login = new Intent(MainActivity.this, MovementsActivity.class);

                Bundle enviarDatos2 = new Bundle();
                enviarDatos2.putSerializable("Cliente",cAux);
                login.putExtras(enviarDatos2);

                startActivity(login);
                return true;

            case R.id.action_settings3:
                Intent login3 = new Intent(MainActivity.this, TransferActivity.class);
                startActivity(login3);
                return true;

            case R.id.action_settings4:
                Intent login4 = new Intent(MainActivity.this, ChangePassActivity.class);

                Bundle enviarDatos4 = new Bundle();
                enviarDatos4.putSerializable("Cliente",info);

                login4.putExtras(enviarDatos4);

                startActivity(login4);
                return true;

            case R.id.action_settings5:
                Toast.makeText(getApplicationContext(),
                        "Promociones", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_settings6:
                Toast.makeText(getApplicationContext(),
                        "Configuracion", Toast.LENGTH_SHORT).show();

                Intent login6 = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(login6);
                return true;
            case R.id.action_settings7:
                Intent login7 = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(login7);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bienvenida = findViewById(R.id.bienvenida);
        btnSalirInicio = findViewById(R.id.btnSalirInicio);
        btnCambiarContraseña = findViewById(R.id.btnCambiarContraseña);
        btnTransferencias = findViewById(R.id.btnTransferencias);
        btnMovimientos = findViewById(R.id.btnMovimientos);
        btnPosicion = findViewById(R.id.btnPosicion);
        btnATM = findViewById(R.id.btnCajeros);

        bancoOperacional = MiBancoOperacional.getInstance(this);

        Bundle recibirrDatos = getIntent().getExtras();
        Cliente info = (Cliente) recibirrDatos.getSerializable("Cliente");

        Cliente cAux = bancoOperacional.login(info);

        bienvenida.setText(bienvenida.getText()+" "+info.getNombre());

        btnSalirInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(login);


            }

        });


        btnCambiarContraseña.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, ChangePassActivity.class);

                Bundle enviarDatos = new Bundle();
                enviarDatos.putSerializable("Cliente",info);

                login.putExtras(enviarDatos);

                startActivity(login);
            }

        });

        btnTransferencias.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, TransferActivity.class);
                Bundle enviarDatos = new Bundle();
                enviarDatos.putSerializable("Cliente",cAux);

                login.putExtras(enviarDatos);
                startActivity(login);
            }

        });

        btnPosicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, GlobalPositionActivity.class);
                Bundle enviarDatos = new Bundle();
                enviarDatos.putSerializable("Cliente",cAux);

                login.putExtras(enviarDatos);
                startActivity(login);
            }
        });

        btnMovimientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, MovementsActivity.class);

                Bundle enviarDatos = new Bundle();
                enviarDatos.putSerializable("Cliente",cAux);
                login.putExtras(enviarDatos);

                startActivity(login);
            }
        });

        btnATM.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, AtmManagementActivity.class);
                startActivity(login);

            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the AppBar if it is present
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }



}