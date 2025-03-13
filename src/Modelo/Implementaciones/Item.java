package Modelo.Implementaciones;

import Modelo.Interfaces.Media;

import java.util.Objects;

public abstract class Item implements Media,Comparable<Item> {
    private String titulo;
    private String creador;
    private String genero;
    private final int id;

    public Item(int id, String genero, String creador, String titulo) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Titulo: " + titulo + "\n" +
                "Creador: " + creador + "\n" +
                "Genero: " + genero;
    }

    @Override
    public int compareTo(Item item) {
        return this.titulo.compareTo(item.getTitulo());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item item)) return false;
        return id == item.id && Objects.equals(titulo, item.titulo) && Objects.equals(creador, item.creador) && Objects.equals(genero, item.genero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, creador, genero, id);
    }
}
