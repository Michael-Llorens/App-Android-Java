package com.example.bancomillba_v1.bd;

public class Constantes {

    /** Campo identificador de la tabla cajeros */
    public static final String FIELD_CAJEROS_ID = "_id";
    /** Campo que describe la dirección donde se encuentra */
    public static final String FIELD_DIRECCION = "direccion";
    /** Campo que almacena la latitud. */
    public static final String FIELD_LAT = "lat";
    /** Campo que almacena la longitud */
    public static final String FIELD_LNG = "lng";
    /** Campo que almacena el nivel del zoom del mapa */
    public static final String FIELD_ZOOM = "zom";
    /** Almacena el nombre de la tabla */
    public static final String CAJEROS_TABLE = "cajeros";
    /** Array de campos de tabla de cajeros */
    public static final String[] CAMPOS_CAJEROS = new String[]{ FIELD_CAJEROS_ID, FIELD_DIRECCION, FIELD_LAT, FIELD_LNG, FIELD_ZOOM };

}
