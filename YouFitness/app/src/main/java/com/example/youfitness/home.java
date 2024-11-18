package com.example.youfitness;

import static androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.youfitness.fragments.ChatFragment;
import com.example.youfitness.fragments.FiltrosFragment;
import com.example.youfitness.fragments.HomeFragmen;
import com.example.youfitness.fragments.PerfilFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class home extends AppCompatActivity  {

    private RecyclerView mRecyclerView;
    private com.example.youfitness.adapters.ImagenesAdapter mAdapter;

    BottomNavigationView btnNavegation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        showSelectedFragment(new HomeFragmen());

        btnNavegation = (BottomNavigationView)  findViewById(R.id.btnNavegation);
        btnNavegation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.menu_home){
                    showSelectedFragment(new HomeFragmen());
                }
                if (item.getItemId() == R.id.menu_filtros){
                    showSelectedFragment(new FiltrosFragment());
                }
                if (item.getItemId() == R.id.menu_chat){
                    showSelectedFragment(new ChatFragment());
                }
                if (item.getItemId() == R.id.menu_perfil){
                    showSelectedFragment(new PerfilFragment());
                }

                return true;
            }
        });
    }

    private void iniciarRecyclerView() {
        mRecyclerView = findViewById(R.id.reciclerImagenes);
        // Esta línea mejora el rendimiento, si sabemos que el contenido
        // no va a afectar al tamaño del RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager --> VERTICAL
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        // Asociamos un adapter (ver más adelante cómo definirlo)
        //mAdapter = new Adapter(this,cursor);
    }


    private  void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).setTransition(TRANSIT_FRAGMENT_FADE).commit();
    }


}