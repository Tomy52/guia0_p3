package Modelo.Implementaciones;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expansion extends Item {
    private LocalDate fechaLanzamiento;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Expansion(String genero, String creador, String titulo, String fechaLanzamiento) {
        super(genero, creador, titulo);
        this.fechaLanzamiento = LocalDate.parse(fechaLanzamiento,formatter);
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(String fechaLanzamiento) {
        this.fechaLanzamiento = LocalDate.parse(fechaLanzamiento,formatter);
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFecha de lanzamiento: " + this.fechaLanzamiento.format(formatter);
    }

}
