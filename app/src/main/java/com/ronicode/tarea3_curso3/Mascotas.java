package com.ronicode.tarea3_curso3;

/**
 * Created by Roni on 1/05/2017.
 */

public class Mascotas {

    private String nombre;
    private int foto;
    private int favorito;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getFavorito() {
        return favorito;
    }

    public void setFavorito(int favorito) {
        this.favorito = favorito;
    }

    public Mascotas(int foto,String nombre, int favorito) {
        this.nombre = nombre;
        this.foto = foto;
        this.favorito = favorito;
    }
}
