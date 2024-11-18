package com.example.youfitness.fragments;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.youfitness.R;
import com.example.youfitness.adapters.ImagenesAdapter;
import com.example.youfitness.api.Usuarios;
import com.example.youfitness.api.UsuariosDAO;
import com.example.youfitness.utils.Constantes;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragmen#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmen extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView mRecyclerView;
    private ArrayList <Usuarios> listaUsuarios;
    private Cursor cursor;
    private ImagenesAdapter mAdapter;
    private UsuariosDAO usuariosDAO;

    public HomeFragmen() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragmen.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragmen newInstance(String param1, String param2) {
        HomeFragmen fragment = new HomeFragmen();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //  iniciar el RecyclerView
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        // Creamos la clase que nos permitira acceder a las operaciones de la db
        usuariosDAO = new UsuariosDAO(getActivity());
        try {
            // Abrimos la base de datos
            usuariosDAO.abrir();
            // Obtenemos el cursor
            cursor = usuariosDAO.getCursor();
            // Se indica a la Actividad principal que controle los recursos del cursor
            // Es decir, si se termina la Actividad, se elimina este cursor de memoria
            getActivity().startManagingCursor(cursor);

            mRecyclerView = view.findViewById(R.id.reciclerImagenes);

            mRecyclerView.setHasFixedSize(true);

            // Nuestro RecyclerView usará un linear layout manager --> VERTICAL
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            mRecyclerView.setLayoutManager(layoutManager);

            // Para poner un separador entre los diferente ítems de la lista
            DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(), layoutManager.getOrientation());
            mRecyclerView.addItemDecoration(dividerItemDecoration);

            listaUsuarios = new ArrayList<>();

           // listaUsuarios.add(new Usuarios("pepe","https://www.latercera.com/resizer/tUip4PQ8QPzr_fR0OizNj3zi4fw=/900x600/smart/arc-anglerfish-arc2-prod-copesa.s3.amazonaws.com/public/C5GXVAAYWZGHHPTO2XHARXSMIE.jpg"));
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String imagen = cursor.getString(1);
                @SuppressLint("Range") String nombre = cursor.getString(4);

                listaUsuarios.add(new Usuarios(nombre,imagen));
            }




            // Asociamos un adapter (ver más adelante cómo definirlo)
            mAdapter = new ImagenesAdapter(getContext(), listaUsuarios);

            mRecyclerView.setAdapter(mAdapter);


        } catch (Exception e) {
            Toast.makeText(getActivity().getBaseContext(), "Se ha producido un error al abrir la base de datos.",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        //return super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // Nos aseguramos que es la petición que hemos realizado
        switch(requestCode) {
            case Constantes.C_CREAR:
                if (resultCode == RESULT_OK)
                    recargar_lista();

            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void recargar_lista() {
        UsuariosDAO bancoDAO = new UsuariosDAO(getActivity().getBaseContext());
        bancoDAO.abrir();
        //ImagenesAdapter usuariosAdapter = new ImagenesAdapter(getContext(), bancoDAO.getCursor());

        // Método para iniciar el RecyclerView

    }


}