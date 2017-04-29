package com.example.joni.musicalstructureapp;

/**
 * Created by flkpgm on 27/04/2017.
 */

public class Song {

    /* Autor de la canción. */
    private String autor;
    /* Título de la canción. */
    private String titulo;
    /* Imagen de la caratula de la canción. */
    private int caratula;
    /* Estado para el icono del like en la canción, marcado o desmarcado mediante un boolean */
    private boolean estadoLike;

    public Song(String autor, String titulo, int caratula, boolean estado) {
        this.autor = autor;
        this.titulo = titulo;
        this.caratula = caratula;
        this.estadoLike = estado;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCaratula() {
        return caratula;
    }

    public void setEstadoLike(boolean estadoLike) {
        this.estadoLike = estadoLike;
    }

    public boolean isEstadoLike() {
        return estadoLike;
    }
}
