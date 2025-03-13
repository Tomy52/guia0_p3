package Ui;

import Excepciones.FechaLanzamientoExpansionNula;
import Excepciones.IdentificadorDuplicadoException;
import Modelo.Implementaciones.Expansion;
import Modelo.Implementaciones.Item;
import Modelo.Implementaciones.Juego;
import Repositorio.Implementaciones.RepositorioBiblioteca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Menu {
    private int opcionElegida;
    private Scanner scanner = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    RepositorioBiblioteca biblioteca;

    public Menu(RepositorioBiblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void mostrarMenu() {
        System.out.println("Bienvenido al sistema de gestion\n");
        do {
            System.out.println("Elija una opcion:\n");
            System.out.println("1. Agregar item a la biblioteca");
            System.out.println("2. Eliminar item de la biblioteca por ID");
            System.out.println("3. Ver items de la biblioteca en orden alfabetico");
            System.out.println("4. Filtrar la biblioteca por genero");
            System.out.println("5. Modificar item por ID");
            System.out.println("0. Salir\n");
            System.out.println("\nOpcion elegida: ");
            opcionElegida = Integer.parseInt(scanner.nextLine());

            switch (opcionElegida) {
                case 1:
                    agregarItem();
                    break;
                case 3:
                    verBibliotecaAlfabeticamente();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        } while (opcionElegida != 0);
    }

    public void agregarItem() {
        int tipoItem;
        int id;
        String genero;
        String creador;
        String titulo;
        double nroVersion;
        LocalDate fechaLanzamiento;

        System.out.println("Elija el tipo de item a agregar:\n");
        System.out.println("1. Juego");
        System.out.println("2. Expansion");
        System.out.println("\nOpcion elegida: ");

        tipoItem = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese un id numerico:");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el genero:");
        genero = scanner.nextLine();

        System.out.println("Ingrese el creador:");
        creador = scanner.nextLine();

        System.out.println("Ingrese el titulo:");
        titulo = scanner.nextLine();

        try {
            switch(tipoItem) {
                case 1:
                    System.out.println("Ingrese el nro de version:");
                    try {
                        double nroVersionAgregar = Double.parseDouble(scanner.nextLine());
                        if (nroVersionAgregar >= 0) {
                            nroVersion = nroVersionAgregar;
                            biblioteca.agregar(new Juego(id,genero,creador,titulo,nroVersion));
                            System.out.println("Juego agregado!");
                        } else {
                            System.out.println("El numero de version no puede ser negativo!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ingrese un numero valido!");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese la fecha de lanzamiento (dia/mes/año):");
                    try {
                        String fechaLanzamientoAgregar = scanner.nextLine();
                        fechaLanzamiento = LocalDate.parse(fechaLanzamientoAgregar,formatter);
                        biblioteca.agregar(new Expansion(id,genero,creador,titulo,fechaLanzamiento));
                        System.out.println("Expansion agregada!");
                    } catch (DateTimeParseException e) {
                        System.out.println("Ingrese una fecha valida!");
                    }
                    break;
            }
        } catch (IdentificadorDuplicadoException e) {
            System.out.println(e.getMessage());
        }

    }

    public void verBibliotecaAlfabeticamente() {
        System.out.println("Items de la biblioteca:");
        System.out.println(biblioteca.ordenarAlfabeticamente());
    }

}
