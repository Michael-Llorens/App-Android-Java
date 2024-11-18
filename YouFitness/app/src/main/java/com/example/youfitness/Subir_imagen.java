package com.example.youfitness;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.youfitness.api.UsuariosDAO;
import com.example.youfitness.fragments.ChatFragment;
import com.example.youfitness.fragments.FiltrosFragment;
import com.example.youfitness.fragments.HomeFragmen;
import com.example.youfitness.fragments.PerfilFragment;
import com.google.android.material.navigation.NavigationView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class Subir_imagen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    // Variables par la galeria
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    ImageView foto_gallery;
    Button btnImg,  btnGuardar;
    UsuariosDAO usuariosDAO;
    private DrawerLayout drawerLayout;

    private EditText url;
    private EditText latitutd;
    private EditText longitud;
    private EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subir_imagen);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtenemos los elementos de la vista
        url = (EditText) findViewById(R.id.url);
        latitutd = (EditText) findViewById(R.id.latitud);
        longitud = (EditText) findViewById(R.id.longitud);
        nombre = (EditText) findViewById(R.id.nombreImg);

        foto_gallery = (ImageView)findViewById(R.id.imageView3);
        btnImg = findViewById(R.id.selecImg);
        btnGuardar = findViewById(R.id.publicar);

        usuariosDAO = new UsuariosDAO(this);
        usuariosDAO.abrir();

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();

            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar();
            }
        });
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
//            Log.i("consolaa habla", foto_gallery.toString());
        }
    }


    public String getStringImagen(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte [] imageBytes = baos.toByteArray();
        String encodedimage = Base64.encodeToString(imageBytes,Base64.DEFAULT);
        return encodedimage;
    }

    public void uploadImagen() {
        usuariosDAO.abrir();
        final ProgressDialog loading = ProgressDialog.show(this,"Subiendo...","Espere porfavpr...");

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new HomeFragmen());
                break;

            case R.id.menu_filtros:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new FiltrosFragment());
                break;

            case R.id.menu_chat:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new ChatFragment());
                break;

            case R.id.menu_perfil:
                getSupportFragmentManager().beginTransaction().replace(R.id.container,new PerfilFragment());
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }

    private void guardar(){
        // Obtenemos los datos del formulario
        ContentValues reg = new ContentValues();

        reg.put(UsuariosDAO.C_COLUMNA_IMAGEN, url.getText().toString());
        reg.put(UsuariosDAO.C_COLUMNA_LATITUD, latitutd.getText().toString());
        reg.put(UsuariosDAO.C_COLUMNA_LONGITUD, longitud.getText().toString());
        reg.put(UsuariosDAO.C_COLUMNA_NOMBRE, nombre.getText().toString());

        usuariosDAO.insert(reg);
        Toast.makeText(Subir_imagen.this, "Publicacion nueva publicada", Toast.LENGTH_SHORT).show();


        // Devolvemos el control
        setResult(RESULT_OK);
        finish();
    }
}

