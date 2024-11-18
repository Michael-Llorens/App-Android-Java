package com.example.bancomillba_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.example.bancomillba_v1.activities.ChangePassActivity;
import com.example.bancomillba_v1.activities.MainActivity;
import com.example.bancomillba_v1.utils.Constantes;

public class AtmManagementActivity extends AppCompatActivity {

    private Button btnAtmList, btnAtmAdd,btnMaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atm_management);

        btnAtmList = findViewById(R.id.btnAtmList);
        btnAtmAdd = findViewById(R.id.btnAtmAdd);
        btnMaps = findViewById(R.id.btnAtmMaps);

        btnAtmList.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(AtmManagementActivity.this, AtmListActivity.class);
                startActivity(login);
            }

        });

        btnAtmAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),AtmFormActivity.class);
                i.putExtra(Constantes.C_MODO, Constantes.C_CREAR);
                startActivityForResult(i, Constantes.C_CREAR);
            }

        });

        btnMaps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(AtmManagementActivity.this, MapsActivity.class);
                startActivity(i);
            }

        });
    }
}

