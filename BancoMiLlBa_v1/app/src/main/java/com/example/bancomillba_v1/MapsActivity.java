package com.example.bancomillba_v1;

import androidx.fragment.app.FragmentActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import com.example.bancomillba_v1.api.BancoDAO;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.bancomillba_v1.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private BancoDAO cajerosDAO;

    private LatLng cajeros [][];

    private Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cajerosDAO = new BancoDAO(this);
        cajerosDAO.abrir();

        cursor = cajerosDAO.getCursor();



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void CajerosMaps(Context context, Cursor cursor) {
        this.cajerosDAO = new BancoDAO(context);
        this.cajerosDAO.abrir();
        this.cursor = cursor;

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
        double i = 38.986;
        double c = -0.532944;

        while (cursor.moveToNext()) {
            @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("_id")+1);
            @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex("address")+1);

            @SuppressLint("Range") double latitud = Double.parseDouble((cursor.getString(cursor.getColumnIndex(BancoDAO.C_COLUMNA_LATITUD)+3)));
            @SuppressLint("Range") double longitud = Double.parseDouble((cursor.getString(cursor.getColumnIndex(BancoDAO.C_COLUMNA_LONGITUD)+4)));
           // @SuppressLint("Range") double longitud = Double.parseDouble(cursor.getString(cursor.getColumnIndex("longitud"))+1);

            LatLng cordenadas = new LatLng(latitud, c);
            i = i - 2.000;
            c = c - 0.200;

            setMarker(cordenadas, nombre, address);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cordenadas,10));
        }

        // Movemos la cámara hacia las coordenadas indicadas
        // CameraUpdateFactory contiene métodos que cambian la cámara de un mapa


    }

    // Método que nos permite crear marcadores
    private void setMarker(LatLng position, String titulo, String info) {
        // Agregamos marcadores para indicar sitios de interés
        Marker myMaker = mMap.addMarker(new MarkerOptions()
                .position(position)
                .title(titulo) // Agrega un título al marcador
                .snippet(info) // Agrega información detalle relacionada
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        //Color del marcador
    }

}