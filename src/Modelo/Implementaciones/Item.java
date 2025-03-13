package Modelo.Implementaciones;

public abstract class Item implements Comparable<Item>{
    private String titulo;
    private String creador;
    private String genero;
    private static int count = 0;
    private final int id;

    public Item(String genero, String creador, String titulo) {
        this.id = count++;
        this.genero = genero;
        this.creador = creador;
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Item o) {
        return this.id - o.id;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Titulo: " + titulo + "\n" +
                "Creador: " + creador + "\n" +
                "Genero: " + genero;
    }
}
