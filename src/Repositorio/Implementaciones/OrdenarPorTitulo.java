package Repositorio.Implementaciones;

import Modelo.Implementaciones.Item;

import java.util.Comparator;

public class OrdenarPorTitulo implements Comparator<Item> {

    @Override
    public int compare(Item i1, Item i2) {
        return i1.getTitulo().compareTo(i2.getTitulo());
    }
}
