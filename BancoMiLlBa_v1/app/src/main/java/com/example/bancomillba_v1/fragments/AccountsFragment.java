package com.example.bancomillba_v1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.bancomillba_v1.Adapter.AccounsAdapter;
import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.pojo.Cliente;
import com.example.bancomillba_v1.pojo.Cuenta;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountsFragment extends Fragment {

    private RecyclerView mReciclerView;
    private AccounsAdapter mAdapter;

    private ArrayList <Cuenta> datos;
    private CuentaListener listener;

    private Cliente cliente;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_Cliente = "cliente";


    // TODO: Rename and change types of parameters


    public AccountsFragment() {
        // Required empty public constructor
    }

    //en este metodoo lo que hacemos es eviarlo entre el activiti y el fragment
    // TODO: Rename and change types and number of parameters
    public static AccountsFragment newInstance(Cliente c) {
        AccountsFragment fragment = new AccountsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_Cliente, c);
        fragment.setArguments(args);
        return fragment;
    }

    //Aqui recuperamos el cliente
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cliente = (Cliente)getArguments().getSerializable(ARG_Cliente);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MiBancoOperacional bancoOperacional = MiBancoOperacional.getInstance(getContext());

        //Aqui recueramos el cliente y los datos
        cliente = bancoOperacional.login(cliente);
        datos = bancoOperacional.getCuentas(cliente);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_accounts, container, false);
        mReciclerView = view.findViewById(R.id.recyclerIdFragmentCuenta);

        mReciclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mReciclerView.setLayoutManager(layoutManager);
        mAdapter = new AccounsAdapter(datos);

        mAdapter.setOnclickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //Posicio del item seleccionado
                int posicion = mReciclerView.getChildAdapterPosition(view);

                //Notificacion del item eleccionado
                Toast.makeText(getContext(), "Seleccion: " + datos.get(posicion).getNumeroCuenta(), Toast.LENGTH_SHORT).show();

                if (listener != null){
                    listener.onCuentaSeleccionada((Cuenta) datos.get(posicion));
                }
            }
        });

        mReciclerView.setAdapter(mAdapter);
        return view;
    }

    public void setDatosListener(CuentaListener listener){
        this.listener = listener;
    }

}