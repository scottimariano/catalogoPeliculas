package peliculas.datos;
import excepciones.*;
import peliculas.domain.Pelicula;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;


public class AccesoDatosImpl implements AccesoDatos{

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        File tempFile = new File(nombreRecurso);
        return tempFile.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                peliculas.add(new Pelicula(linea));
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new LecturaDatosEx("No se pudo leer el archivo." + e.getMessage());
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws EscrituraDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            var salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.getNombre());
            salida.close();
            System.out.println("Se ha guardado la informacion correctamente en el archivo." + pelicula);
        } catch (Exception e) {
            throw new EscrituraDatosEx("No se puede escribir en el archivo." + e.getMessage());
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        var archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            var indice = 1;
            while (linea != null){
                if (buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado= "Pelicula " + linea + "encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
        } catch (IOException e) {
            throw new LecturaDatosEx("Error al buscar pelicula " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws EscrituraDatosEx {
        File archivo = new File(nombreRecurso);
        try{
            var salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo correctamente.");
        } catch (Exception e) {
            throw new EscrituraDatosEx("No se puede crear el archivo." + e.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        var archivo = new File(nombreRecurso);
        try {
            if (archivo.delete()) System.out.println("Se ha borrado el archivo " + nombreRecurso);
            else System.out.println("Ha ocurrido un error.");
        } catch (Exception e){
            throw new EscrituraDatosEx("No se puede borrar el archivo." + e.getMessage());
        }
    }
}
