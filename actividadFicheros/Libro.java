package actividadFicheros;

import java.util.Objects;

public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private double precio;

    public Libro(String titulo, String autor, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return titulo + ";" + autor + ";" + precio;
    }

    @Override
    public int compareTo(Libro otro) {

        return otro.getTitulo().compareToIgnoreCase(this.titulo);
    }
}