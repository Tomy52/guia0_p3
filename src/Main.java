import Excepciones.IdentificadorDuplicadoException;
import Excepciones.ItemInexistenteException;
import Modelo.Implementaciones.Expansion;
import Modelo.Implementaciones.Item;
import Modelo.Implementaciones.Juego;
import Repositorio.Implementaciones.RepositorioBiblioteca;

public class Main {
    public static void main(String[] args) throws IdentificadorDuplicadoException, ItemInexistenteException {
        RepositorioBiblioteca<Item> biblioteca = new RepositorioBiblioteca<Item>();

        Juego gtaV = new Juego("Crimen","Rockstar Games","Grand Theft Auto Five",1.06);
        Juego tlou = new Juego("Drama","Naughty Dog","The Last Of Us: Remastered",0.70);
//        System.out.println(gtaV);
//        System.out.println(tlou);

        Expansion heists = new Expansion("Crimen","Rockstar Games","Grand Theft Auto Five: Heists", "15/03/2015");
//        System.out.println(heists);

        biblioteca.agregar(gtaV);
        biblioteca.agregar(tlou);
        biblioteca.agregar(heists);
        //biblioteca.agregar(heists);

        System.out.println(biblioteca);

        //biblioteca.eliminar(1);

        System.out.println(biblioteca);

        //System.out.println(biblioteca.buscarItemPorID(0));
        System.out.println(biblioteca.filtrarPorGenero("Drama"));
    }
}