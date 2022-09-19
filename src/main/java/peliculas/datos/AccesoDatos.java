package peliculas.datos;

import excepciones.*;
import peliculas.domain.Pelicula;

import java.util.List;

public interface AccesoDatos {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx;
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;
    void crear(String nombreRecurso) throws EscrituraDatosEx;
    void borrar(String nombreRecurso) throws AccesoDatosEx;
}
