package com.example.bancomillba_v1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancomillba_v1.Adapter.MovementsAdapter;
import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.dialogs.MovementDialog;
import com.example.bancomillba_v1.pojo.Cuenta;
import com.example.bancomillba_v1.pojo.Movimiento;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccounsMovementsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccounsMovementsFragment extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecycleView;
    private MovementsAdapter mAdapter;
    //botons
    private BottomNavigationView btnNavegation;

    private ArrayList<Movimiento> datos;
    private Cuenta cuentaSeleccionada = null;

    private Cuenta cuenta;
    private  View view;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_Cuenta = "cliente";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AccounsMovementsFragment() {
        // Required empty public constructor
    }

    public AccounsMovementsFragment(ArrayList<Movimiento> datos) {
        this.datos = datos;
    }

    public AccounsMovementsFragment(Cuenta cuentaSeleccionada) {
        this.cuentaSeleccionada = cuentaSeleccionada;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment AccounsMovementsFragment.
     */

    //en este metodoo lo que hacemos es eviarlo entre el activiti y el fragment
    // TODO: Rename and change types and number of parameters
    public static AccounsMovementsFragment newInstance(Cuenta c) {
        AccounsMovementsFragment fragment = new AccounsMovementsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_Cuenta, c);
        fragment.setArguments(args);
        return fragment;
    }

    //Aqui recuperamos el cliente
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cuenta = (Cuenta) getArguments().getSerializable(ARG_Cuenta);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        MiBancoOperacional bancoOperacional = MiBancoOperacional.getInstance(getContext());

        view = inflater.inflate(R.layout.fragment_accouns_movements, container, false);

        // conectem
        btnNavegation = (BottomNavigationView)view.findViewById(R.id.menu_nav);
        btnNavegation.setOnNavigationItemSelectedListener(this);

        //Aqui recueramos el cliente y los datos
        datos = bancoOperacional.getMovimientos(cuenta);


        // Inflate the layout for this fragment

        if (cuentaSeleccionada == null){
            //falta implementar que si es null que fguarde la posicion 0
        }else{
            datos = cuentaSeleccionada.getListaMovimientos();
        }



        if (datos.size() > 0){
            TextView avisoNoMovimientos = (TextView) view.findViewById(R.id.noMovimientos);
            avisoNoMovimientos.setVisibility(View.GONE);

            mRecycleView = view.findViewById(R.id.recyclerMovimientos);

            mRecycleView.setHasFixedSize(true);

            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            mRecycleView.setLayoutManager(layoutManager);

            mostrarLista(datos);

        }

        return view;
    }

    //metodos

    private void remplazeFragment(Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contenedorFragmentGlobalPosition,fragment);
        fragmentTransaction.commit();
    }

    public void mostrarLista(ArrayList<Movimiento> datos){

        TextView avisoNoMovimientos = (TextView) view.findViewById(R.id.noMovimientos);

        if (datos == null || datos.size() == 0){
            avisoNoMovimientos.setVisibility(View.VISIBLE);
        }else {
            avisoNoMovimientos.setVisibility(View.GONE);
        }

        mAdapter = new MovementsAdapter(datos);

        mAdapter.setOnclickListener(view -> {
            //Posicio del item seleccionado
            int posicion = mRecycleView.getChildAdapterPosition(view);

            //Notificacion del item eleccionado
            Toast.makeText(getContext(), "Seleccion: " + datos.get(posicion).getDescripcion(), Toast.LENGTH_SHORT).show();

            //Falta llamar aqui al otro fragment
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            MovementDialog mDialogo = new MovementDialog(datos.get(posicion));
            mDialogo.show(fragmentManager, "fragment Personalizado");

        });
        mRecycleView.setAdapter(mAdapter);
    }

//    @Override
//    public void onNavigationItemReselected(@NonNull MenuItem item) {
//
//        Fragment f =null;
//        switch (item.getItemId()){
//
//            case R.id.todos:
//                    mostrarLista(datos);
//                break;
//
//            case R.id.tipo_1:
//                mostrarLista(filtrarMovimientos(datos,0));
//                break;
//
//            case R.id.tipo_2:
//                mostrarLista(filtrarMovimientos(datos,1));
//                break;
//
//            case R.id.tipo_3:
//                mostrarLista(filtrarMovimientos(datos,2));
//                break;
//        }
//        if (f != null){
//
//        }
//    }



    private ArrayList<Movimiento> filtrarMovimientos(ArrayList<Movimiento> datos,int tipo){
        ArrayList<Movimiento> datosAux = new ArrayList<>();


        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).getTipo() == tipo){
                datosAux.add(datos.get(i));
            }
        }
        return  datosAux;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.todos:
                    mostrarLista(datos);
                break;

            case R.id.tipo_1:
                mostrarLista(filtrarMovimientos(datos,0));
                break;

            case R.id.tipo_2:
                mostrarLista(filtrarMovimientos(datos,1));
                break;

            case R.id.tipo_3:
                mostrarLista(filtrarMovimientos(datos,2));
                break;
        }
        return true;
    }

}