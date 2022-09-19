package peliculas.domain;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String nombre;
    public Pelicula(){}
    public Pelicula(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
        System.out.println("Se ha modificado el nombre correctamente.");
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
