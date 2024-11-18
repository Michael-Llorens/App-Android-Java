package com.example.youfitness.api;

public class Usuarios {

    private int id;
    private String name;
    private  String imagen;
    private String latitud;
    private String logitud;

    public Usuarios(int id, String name, String imagen, String latitud, String logitud) {
        this.id = id;
        this.name = name;
        this.imagen = imagen;
        this.latitud = latitud;
        this.logitud = logitud;
    }

    public Usuarios(String name, String imagen) {
        this.name = name;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLogitud() {
        return logitud;
    }

    public void setLogitud(String logitud) {
        this.logitud = logitud;
    }
}
