package com.example.bancomillba_v1.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.pojo.Cliente;

import java.util.Objects;

public class ChangePassActivity extends AppCompatActivity {

    private Button btnGuardar;
    private EditText pasAct,pasNueva,pasRep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        btnGuardar = findViewById(R.id.btnGuardar);
        pasAct = findViewById(R.id.passwordActual);
        pasNueva = findViewById(R.id.passwordActual2);
        pasRep = findViewById(R.id.passwordActual3);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle recibirrDatos = getIntent().getExtras();
                Cliente info = (Cliente) recibirrDatos.getSerializable("Cliente");

                if (Objects.equals(info.getClaveSeguridad(), pasAct.getText().toString())){
                    if (pasNueva.getText().toString().equals(pasRep.getText().toString())){
                        info.setClaveSeguridad(pasNueva.getText().toString());
                        Intent inicio = new Intent(ChangePassActivity.this, MainActivity.class);
                        //onBackPressed();
                        startActivity(inicio);
                        Toast.makeText(getApplicationContext(),"Has gaurdado la contraseña", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(ChangePassActivity.this, "La contraseña nueva no coinciden entre ellas", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ChangePassActivity.this, "La contraseña no coincide con la actual", Toast.LENGTH_SHORT).show();
                }





            }
        });
    }
}