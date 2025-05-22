package com.german.labo4;

public class Libro implements IReferenciable {

    private String titulo;
    private String autor;
    private String editorial;

    public Libro() {}

    public Libro(String titulo, String autor, String editorial) {
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
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

    @Override
    public String generarReferenciaAPA() {
        return autor + ". (s.f.). " + titulo + ". " + editorial + ".";
    }
}
