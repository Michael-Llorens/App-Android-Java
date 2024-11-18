package com.example.youfitness.api;

import android.content.Context;

public class UsuarioOperacional {


    private UsuariosSQLiterHelper miBD;

    protected UsuarioOperacional(Context context){
        miBD = UsuariosSQLiterHelper.getInstance(context);
    }

    private static UsuarioOperacional instance = null;

    //***************************************
    // Interfaz publica de la API del banco
    //***************************************

    // Constructor del banco. Obtiene una instancia del mismo para operar
    public static UsuarioOperacional getInstance(Context context) {
        if(instance == null) {
            instance = new UsuarioOperacional(context);
        }
        return instance;
    }

    // Operacion getCuentas: Obtiene un ArrayList de las cuentas de un cliente que recibe como parámetro
    public UsuariosSQLiterHelper getCuentas(){

        return miBD;
    }

}
