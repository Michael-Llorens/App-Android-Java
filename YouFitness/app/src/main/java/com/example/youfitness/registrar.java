package com.example.youfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registrar extends AppCompatActivity {

    private EditText email,pas1,pas2;
    private Button btnRegistrar;
    private DrawerLayout dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        btnRegistrar = findViewById(R.id.btnRegistrarse);

        email = (EditText) findViewById(R.id.correo);
        pas1 = (EditText) findViewById(R.id.pas1);
        pas2 = (EditText) findViewById(R.id.pass2);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = email.getText().toString().trim();
                String p = pas1.getText().toString().trim();
                String p2 = pas2.getText().toString().trim();

                if (p.isEmpty() && p2.isEmpty() && e.isEmpty()){
                    Toast.makeText(registrar.this, "No puede haber ningun caracter vacio", Toast.LENGTH_SHORT).show();
                }else{
                    if (p.equals(p2)){

                        FirebaseAuth.getInstance().createUserWithEmailAndPassword(e,p).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    finish();
                                    startActivity(new Intent(registrar.this, home.class));
                                    Toast.makeText(registrar.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(registrar.this, "Error los datos no estan registrados", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(registrar.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }else {
                        Toast.makeText(registrar.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }

                }


                FirebaseAuth.getInstance().signOut();
            }
        });
    }


}