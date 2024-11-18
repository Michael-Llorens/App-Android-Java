package com.example.bancomillba_v1.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancomillba_v1.Adapter.AccounsAdapter;
import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.fragments.AccounsMovementsFragment;
import com.example.bancomillba_v1.fragments.AccountsFragment;
import com.example.bancomillba_v1.fragments.CuentaListener;
import com.example.bancomillba_v1.pojo.Cliente;
import com.example.bancomillba_v1.pojo.Cuenta;

import java.util.ArrayList;

public class GlobalPositionActivity extends AppCompatActivity implements CuentaListener {

    private RecyclerView myRecicleView;
    private AccounsAdapter mAdapter;
    private ArrayList <Cuenta> listaCuentas = new ArrayList<Cuenta>();


    MiBancoOperacional bancoOperacional;

    private  AccounsMovementsFragment fragmentMovimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_position);

        //myRecicleView = findViewById(R.id.recyclerId);

        //Recuperamos el cliente
        Bundle recibirrDatos = getIntent().getExtras();
        Cliente cliente = (Cliente) recibirrDatos.getSerializable("Cliente");

        //Aqui enviamos los datos del main al fragment que en este caso enviamos el ciente
        AccountsFragment fragmentAccouns = AccountsFragment.newInstance(cliente);
        fragmentAccouns.setDatosListener(this);

        // Esta línea mejora el rendimiento, si sabemos que el contenido
        // no va a afectar al tamaño del RecyclerView
        //myRecicleView.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager --> VERTICAL
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Nuestro RecyclerView usará un linear layout manager --> HORIZONTAL
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);

        // Nuestro RecyclerView usará un Grid layout manager --> TABULAR
        // GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        //myRecicleView.setLayoutManager(layoutManager);

        // Para poner un separador entre los diferentes ítems de la lista
        // DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(myRecicleView.getContext(), layoutManager.getOrientation());
        // myRecicleView.addItemDecoration(dividerItemDecoration);

        // Asociamos un adapter
        //mAdapter = new AccounsAdapter(listaCuentas);

        // myRecicleView.setAdapter(mAdapter);

        //Aqui cargamos el primer fragment de las cuentaas
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragmentGlobalPosition, fragmentAccouns).commit();


    }

    @Override
    public void onCuentaSeleccionada(Cuenta c) {

        //Comprivaremos si estamos en un movil o tablet
        Boolean hayMovimiento = (getSupportFragmentManager().findFragmentById(R.id.contenedorFragmentGlobalPosition2) != null);

        //Creamos un nuevo objeto del fragment con la cuenta seleccionada
        fragmentMovimiento = new AccounsMovementsFragment(c);

        //Creamos la transaccion para realizar los cambios en los fragments
        FragmentTransaction transaccion = getSupportFragmentManager().beginTransaction();

        //Aqui tenemos que enviar tambien el cliente al fragmentMovimientos
         if (hayMovimiento){ // Tablet
             transaccion.replace(R.id.contenedorFragmentGlobalPosition2, AccounsMovementsFragment.newInstance(c));
        }else{ // Movil
             transaccion.replace(R.id.contenedorFragmentGlobalPosition,  AccounsMovementsFragment.newInstance(c));
        }
        transaccion.commit();
    }
}