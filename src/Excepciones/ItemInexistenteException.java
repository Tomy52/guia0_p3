package Excepciones;

public class ItemInexistenteException extends Exception {
    public ItemInexistenteException(String message) {
        super("No existe el item con el ID especificado!");
    }
}
