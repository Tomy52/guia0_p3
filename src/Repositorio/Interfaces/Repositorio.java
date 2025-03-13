package Repositorio.Interfaces;

import Excepciones.ElementoInexistenteException;
import Excepciones.IdentificadorDuplicadoException;

public interface Repositorio<T> {
    void agregar(T t) throws IdentificadorDuplicadoException;
    T buscarPorId(int id) throws ElementoInexistenteException;
    void eliminar(int id);
    String ordenarAlfabeticamente();
    String filtrarPorGenero(String genero);
}
