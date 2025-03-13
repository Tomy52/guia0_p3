package Repositorio.Implementaciones;

import Excepciones.IdentificadorDuplicadoException;
import Excepciones.ItemInexistenteException;
import Modelo.Implementaciones.Item;
import Modelo.Interfaces.Media;

import java.util.ArrayList;
import java.util.Comparator;

public class RepositorioBiblioteca <T extends Item> implements Media, Comparator {
    ArrayList<T> biblioteca = new ArrayList<>();

    public void agregar(T t) throws IdentificadorDuplicadoException {
        for (T item: biblioteca) {
            if (item.compareTo(t) == 0) {
                throw new IdentificadorDuplicadoException();
            }
        }
        biblioteca.add(t.getId(),t);
    }

    public void eliminar(int id) {
        biblioteca.remove(id);
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(T item: biblioteca) {
           result.append(item.toString()).append("\n\n");
        }
        return result.toString();
    }

    public T buscarItemPorID(int id) throws ItemInexistenteException {
        for (T item: biblioteca) {
            if (item.getId() == id) return item;
        }
        throw new ItemInexistenteException("No existe el elemento con el ID especificado!");
    }

    public String filtrarPorGenero(String genero) {
        StringBuilder result = new StringBuilder("Filtrados por genero: " + genero + "\n\n");
        for (T item : biblioteca) {
            if (item.getGenero().equals(genero)) {
                result.append(item).append("\n\n");
            }
        }
        return result.toString();
    }

    @Override
    public int compare(T i1, T i2) {
        return i1.getTitulo().compareTo(i2.getTitulo());
    }

    @Override
    public int compare(Item i1, Item i2) {
        return 0;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
