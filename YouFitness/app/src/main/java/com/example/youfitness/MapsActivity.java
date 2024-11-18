package com.example.youfitness;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;

import com.example.youfitness.api.UsuariosDAO;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.youfitness.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private UsuariosDAO usuariosDAO;

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         binding = ActivityMapsBinding.inflate(getLayoutInflater());
         setContentView(binding.getRoot());

        usuariosDAO = new UsuariosDAO(this);
        usuariosDAO.abrir();

        cursor = usuariosDAO.getCursor();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        while (cursor.moveToNext()) {

           // @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex("_id")+1);
            @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex(UsuariosDAO.C_COLUMNA_NOMBRE));

            @SuppressLint("Range") double latitud = Double.parseDouble(cursor.getString(cursor.getColumnIndex(UsuariosDAO.C_COLUMNA_LATITUD)));
            @SuppressLint("Range") double longitud = Double.parseDouble(cursor.getString(cursor.getColumnIndex(UsuariosDAO.C_COLUMNA_LONGITUD)));


            LatLng cordenadas = new LatLng(latitud, longitud);

            setMarker(cordenadas, nombre);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cordenadas,10));
        }
    }

    // Método que nos permite crear marcadores
    private void setMarker(LatLng position, String titulo) {
        // Agregamos marcadores para indicar sitios de interés
        Marker myMaker = mMap.addMarker(new MarkerOptions()
                .position(position)
                .title(titulo) // Agrega un título al marcador
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET)));
        //Color del marcador
    }
}