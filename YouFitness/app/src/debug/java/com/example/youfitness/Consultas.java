package com.example.youfitness;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Consultas extends AppCompatActivity {

    TextView txt_info;
    ImageView img1;
    Button btn_volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        txt_info= findViewById(R.id.txtInfo);
        img1 = findViewById(R.id.imgPokemon);
        btn_volver = findViewById(R.id.volverPok);

        Bundle extras = getIntent().getExtras();
        String inf =  extras.getString("informacion");
        String img = extras.getString("imagen");

        /*https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/2.png*/

        txt_info.setText(inf);
        Picasso.get().load(img).error(R.mipmap.img).into(img1);
        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consultas.this, home.class);
                startActivity(intent);
            }
        });
    }
}