package peliculas.negocio;

import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import peliculas.datos.AccesoDatos;
import peliculas.datos.AccesoDatosImpl;
import peliculas.domain.Pelicula;

import java.util.List;

public class CatalogoPeliculasImpl implements CatalogoPeliculas{
     private final AccesoDatos datos;

    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();

    }

    @Override
    public void agregarPelicula(String nombrePelicula){
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula,NOMBRE_RECURSO,anexar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error al crear la pelicula");
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (Pelicula pelicula : peliculas) {
                System.out.println("Pelicula = " + pelicula);
            }
        } catch (LecturaDatosEx e) {
            System.out.println("Error de lectura de datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPelicula(String buscar){
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (LecturaDatosEx e) {
            System.out.println("Error de acceso de datos");
        }
        System.out.println(resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas(){
        try {
            if (this.datos.existe(NOMBRE_RECURSO)){
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error al iniciar catalogo de peliculas");
            e.printStackTrace(System.out);
        }
    }
}
