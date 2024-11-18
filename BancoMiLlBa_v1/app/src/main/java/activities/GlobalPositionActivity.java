package activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.pojo.Cliente;
import com.example.bancomillba_v1.pojo.Cuenta;

import java.util.ArrayList;

import Adapter.AccounsAdapter;

public class GlobalPositionActivity extends AppCompatActivity {

    private RecyclerView myRecicleView;
    private AccounsAdapter mAdapter;
    private ArrayList <Cuenta> listaCuentas = new ArrayList<Cuenta>();

    MiBancoOperacional bancoOperacional;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_position);

        myRecicleView = findViewById(R.id.recyclerIdFragmentCuenta);
        bancoOperacional = MiBancoOperacional.getInstance(this);

        Bundle recibirrDatos = getIntent().getExtras();
        Cliente c = (Cliente) recibirrDatos.getSerializable("Cliente");

        listaCuentas = bancoOperacional.getCuentas(c);

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
        mAdapter = new AccounsAdapter(listaCuentas);

        myRecicleView.setAdapter(mAdapter);

    }
}