package trabajoFinal;

import peliculas.datos.AccesoDatosImpl;
import peliculas.datos.AccesoDatosImpl.*;
import peliculas.negocio.CatalogoPeliculas;
import peliculas.negocio.CatalogoPeliculasImpl;

import java.util.Scanner;

public class TrabajoFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion=-1;
        String nombreArchivo;
        CatalogoPeliculas catalogo = new CatalogoPeliculasImpl();

        while (opcion!=0){
            System.out.println("Elija la opcion deseada:\n"
                    +"1.- Iniciar catalogo de peliculas\n"
                    +"2.- Agregar pelicula\n"
                    +"3.- Listar pelicula\n"
                    +"4.- Buscar pelicula\n"
                    +"0.- Salir");
            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingrese la pelicula: ");
                    catalogo.agregarPelicula(scanner.nextLine());
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Ingrese el nombre de la pelicula a buscar: ");
                    catalogo.buscarPelicula(scanner.nextLine());
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no reconocida...");
            }
        }

    }
}
