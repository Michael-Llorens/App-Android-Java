package com.example.bancomillba_v1.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancomillba_v1.Adapter.MovementsAdapter;
import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.pojo.Cliente;
import com.example.bancomillba_v1.pojo.Cuenta;
import com.example.bancomillba_v1.pojo.Movimiento;

import java.util.ArrayList;

public class MovementsActivity extends AppCompatActivity {

    private MovementsAdapter mAdapter;
    private RecyclerView myRecicleView;
    private Spinner sp;
    private ArrayList<Cuenta> listaCuentas = new ArrayList<Cuenta>();
    private String [] cuentas;
    public int posicionSelec = 0;
    private Cliente c;
    private ArrayList<Movimiento> listaMovimentos = new ArrayList<Movimiento>();

    MiBancoOperacional bancoOperacional;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movements);

        bancoOperacional = MiBancoOperacional.getInstance(this);

        Bundle recibirrDatos = getIntent().getExtras();
        c = (Cliente) recibirrDatos.getSerializable("Cliente");

        listaCuentas = bancoOperacional.getCuentas(c);

        sp = findViewById(R.id.opcionCuentaMoviments);
        myRecicleView = findViewById(R.id.recyclerMovimientos);

        // vamos a pasar las cuentas de un objeto a un vector de cuentas para enviarlo al spinner
        cuentas = new String [listaCuentas.size()];

        for (int i = 0; i < listaCuentas.size(); i++) {
            Cuenta cuenta = listaCuentas.get(i);
            cuentas[i] = cuenta.getBanco() + "-" + cuenta.getSucursal() + "-" + cuenta.getDc() + "-" + cuenta.getNumeroCuenta();
        }

        ArrayAdapter<Movimiento> adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,cuentas);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(adaptador);

        sp.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        posicionSelec = position;
                        llenarMoviementos(bancoOperacional, parent.getContext());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );
        llenarMoviementos(bancoOperacional, this);
    }

    private void llenarMoviementos(MiBancoOperacional bancoOperacional, Context context) {

        listaMovimentos = bancoOperacional.getMovimientos(bancoOperacional.getCuentas(c).get(posicionSelec));

        // Esta línea mejora el rendimiento, si sabemos que el contenido
        // no va a afectar al tamaño del RecyclerView
        myRecicleView.setHasFixedSize(true);

        // Nuestro RecyclerView usará un linear layout manager --> VERTICAL
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // Nuestro RecyclerView usará un linear layout manager --> HORIZONTAL
        // LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);

        // Nuestro RecyclerView usará un Grid layout manager --> TABULAR
        // GridLayoutManager layoutManager = new GridLayoutManager(this, 3);

        myRecicleView.setLayoutManager(layoutManager);

        // Para poner un separador entre los diferentes ítems de la lista
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(myRecicleView.getContext(), layoutManager.getOrientation());
        myRecicleView.addItemDecoration(dividerItemDecoration);

        // Asociamos un adapter
        mAdapter = new MovementsAdapter(listaMovimentos);

        myRecicleView.setAdapter(mAdapter);
    }

}