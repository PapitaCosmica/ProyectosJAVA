package Modelo;


public class Libro implements Comparable<Libro> {
    private String titulo;
    private String id;
    private String autor;
    private String sinopsis;

    public Libro(String titulo, String id, String autor, String sinopsis) {
        this.titulo = titulo;
        this.id = id;
        this.autor = autor;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getId() {
        return id;
    }

    public String getAutor() {
        return autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    @Override
    public String toString() {
        return "Pelicula [titulo=" + titulo + ", id=" + id + ", autor = " + autor + ", sinopsis = " + sinopsis + "]";
    }

    @Override
    public int compareTo(Libro otroLibro) {
        return this.id.compareTo(otroLibro.id);
    }
}
