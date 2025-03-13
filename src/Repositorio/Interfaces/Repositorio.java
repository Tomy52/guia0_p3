package Repositorio.Interfaces;

public interface Repositorio<T> {
    void agregar(T t);
    boolean eliminar(int id);
    String mostrarRepositorioPorTitulo();
    String filtrarPorGenero(String genero);
}
