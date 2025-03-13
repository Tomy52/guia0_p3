package Modelo.Implementaciones;

public class Juego extends Item {
    private double nroVersion;

    public Juego(String genero, String creador, String titulo, double nroVersion) {
        super(genero, creador, titulo);
        this.nroVersion = nroVersion;
    }

    public double getNroVersion() {
        return nroVersion;
    }

    public void setNroVersion(double nroVersion) {
        this.nroVersion = nroVersion;
    }

    @Override
    public String toString() {
        return super.toString() + "\nNumero de version: " + this.nroVersion;
    }
}
