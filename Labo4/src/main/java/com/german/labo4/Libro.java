package com.german.labo4;

public class Libro implements IReferenciable {

    private String titulo;
    private String autor;
    private String editorial;
    private String imageURL;

    public Libro() {}

    public Libro(String titulo, String autor, String editorial, String imageURL) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.imageURL = imageURL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public String getImageURL() {
        return imageURL;
    }

    @Override
    public String generarReferenciaAPA() {
        return autor + ". (s.f.). " + titulo + ". " + editorial + ".";
    }
}
