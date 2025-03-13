package Repositorio.Implementaciones;

import Excepciones.IdentificadorDuplicadoException;
import Excepciones.ElementoInexistenteException;
import Modelo.Implementaciones.Item;
import Repositorio.Interfaces.Repositorio;

import java.util.ArrayList;
import java.util.HashMap;

public class RepositorioBiblioteca implements Repositorio<Item> {
    HashMap<Integer,Item> biblioteca = new HashMap<>();

    public void agregar(Item item) throws IdentificadorDuplicadoException {
        if (biblioteca.containsKey(item.getId())) throw new IdentificadorDuplicadoException();

        biblioteca.put(item.getId(),item);
    }

    public void eliminar(int id) {
        biblioteca.remove(id);
    }

    public Item buscarPorId(int id) throws ElementoInexistenteException {
        for (Item item: biblioteca.values()) {
            if (item.getId() == id) return item;
        }
        throw new ElementoInexistenteException("No existe el elemento con el ID especificado!");
    }

    public String filtrarPorGenero(String genero) {
        StringBuilder result = new StringBuilder("Filtrados por genero: " + genero + "\n\n");
        for (Item item: biblioteca.values()) {
            if (item.getGenero().equals(genero)) {
                result.append(item).append("\n\n");
            }
        }
        return result.toString();
    }

    public String ordenarAlfabeticamente() {
        ArrayList<Item> arr = new ArrayList<>(biblioteca.values());

        arr.sort(new OrdenarPorTitulo());

        return arr.toString();
    }

}
