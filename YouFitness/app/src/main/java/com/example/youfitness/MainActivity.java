package com.example.youfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.youfitness.api.UsuariosDAO;
import com.example.youfitness.api.UsuariosSQLiterHelper;
import com.example.youfitness.dialogo.Dialogo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText email,password;
    private Button btnIniciar,btnIniciarGoogle,btnRegistrarse;
    FirebaseAuth fireBD;
    private UsuariosDAO usuariosDAO;
    private Cursor cursor;

    //Creamos las variables para el Navegation Drawer
    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout settings, exit;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ajustes:
                Toast.makeText(getApplicationContext(),
                        "Ajustes", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(i);
                return true;
            case R.id.salir: ;
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnEntrar);
        btnIniciarGoogle = findViewById(R.id.btnEntrarG);
        btnRegistrarse = findViewById(R.id.btnRegistrarse);

        // Variables del Navegation Drawer
        drawerLayout = findViewById(R.id.drawerLayout);
        menu = findViewById(R.id.menu_settings);
        settings = findViewById(R.id.settings);
        exit = findViewById(R.id.salir);

        // Metodo para el clic del menu que es la imagen del Navegation Drawer
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        // Metodo para el clic de el boton del menu de los ajustes de entro del Navegation Drawer
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActiviti(MainActivity.this, SettingsActivity.class);
            }
        });

        // Metodo para el clic de el boton del menu de la salida de entro del Navegation Drawer
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // Write a message to the database
        fireBD = FirebaseAuth.getInstance();

        // Declaramos el controlador de la BBDD y accedemos en modo escritura
        UsuariosSQLiterHelper dbHelper = new UsuariosSQLiterHelper(getBaseContext());
        SQLiteDatabase db = dbHelper.getWritableDatabase();
//        Toast.makeText(getBaseContext(), "Base de datos preparada",Toast.LENGTH_LONG).show();


        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(MainActivity.this, registrar.class);

                password = (EditText)findViewById(R.id.password);
                email = (EditText)findViewById(R.id.email);

                startActivity(login);
            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = (EditText)findViewById(R.id.password);
                email = (EditText)findViewById(R.id.email);

                String e = email.getText().toString().trim();
                String p = password.getText().toString().trim();

                if (e.isEmpty() && p.isEmpty()){
                    Toast.makeText(MainActivity.this,"Ingrese datos", Toast.LENGTH_SHORT).show();
                }else {
                    FragmentManager fm = getSupportFragmentManager();
                    Dialogo mDialogo = new Dialogo(e);
                    mDialogo.show(fm, "fragment Personalizado");
                    loginUsers(e,p);
                }
            }
        });

        btnIniciarGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password = (EditText)findViewById(R.id.password);
                email = (EditText)findViewById(R.id.email);

                String e = email.getText().toString().trim();
                String p = password.getText().toString().trim();

                if (e.isEmpty() && p.isEmpty()){
                    Toast.makeText(MainActivity.this,"Ingrese datos", Toast.LENGTH_SHORT).show();
                }else {
                    //Falta llamar aqui al otro fragment
                    FragmentManager fm = getSupportFragmentManager();
                    Dialogo mDialogo = new Dialogo(e);
                    mDialogo.show(fm, "fragment Personalizado");

                    loginUsers(e,p);
                }
            }
        });
    }

    // Los dos meetodos para abrir el Navegation Drawer y cerrar
    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }

    public static void closeDrawer(DrawerLayout drawerLayout){
        if(drawerLayout.isDrawerOpen((GravityCompat.START))){
            drawerLayout.closeDrawer((GravityCompat.START));
        }
    }

    public static void redirectActiviti(Activity activity, Class secondActivity){
        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause(){
        super.onPause();
        closeDrawer(drawerLayout);
    }

    private void showAletr() {

        AlertDialog.Builder al = new AlertDialog.Builder(this);
        al.setTitle("Error");
        al.setMessage("Se ha producido un error autenticando al usuario");
        al.setPositiveButton("Aceptar",null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    private void loginUsers(String email, String pas){

        if(email.toString() != null && password.toString() != null){
            fireBD.signInWithEmailAndPassword(email, pas).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    SystemClock.sleep(1000);
                    if (task.isSuccessful()){
                        finish();
                        startActivity(new Intent(MainActivity.this, home.class));
//                        Toast.makeText(MainActivity.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(MainActivity.this, "Error los datos no estan registrados", Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
                }
            });

        }else{
            showAletr();
        }

    }
}