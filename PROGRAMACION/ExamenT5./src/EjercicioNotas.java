import java.io.File;
import java.util.Scanner;

public class EjercicioNotas {
    public static void main(String[] args) {

        // REGLA 3: Rutas relativas explícitas y objeto File
        // Apuntamos a la carpeta Tema5 dentro de src (donde estamos ejecutando)
        File archivo = new File("./Tema5/notas.txt");

        // REGLA 2: Try-catch simple con getMessage()
        try {
            // ESTRATEGIA CASO 2: Ficheros CSV con Scanner
            Scanner sc = new Scanner(archivo);

            // Configuramos el delimitador.
            // Configuramos el delimitador.
            sc.useDelimiter(";");

            System.out.println("--- NOTAS DE ALUMNOS ---");

            // Iteramos mientras haya más datos (tokens)
            while (sc.hasNext()) {
                String nombre = sc.next(); // Leemos el nombre

                // Verificamos si hay siguiente token para la nota (seguridad básica)
                if (sc.hasNext()) {
                    String nota = sc.next(); // Leemos la nota
                    System.out.println("Alumno: " + nombre + " | Nota: " + nota);
                }
            }

            // REGLA 1: Cerrar manualmente al final del try (NO usamos try-with-resources)
            sc.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
