import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rutaArchivo = "/Users/rafacamjv/Desktop/CICLOS/1DAW/GitHub/PROGRAMACION/programacion-DAW/T5/alumnos.csv";
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("\n--- MENÚ ALUMNOS ---");
            System.out.println("1. Ver alumnos");
            System.out.println("2. Insertar alumno");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            // Controlamos que meta un número
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del enter
            } else {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextLine(); // Limpiar lo que haya escrito mal
                continue;
            }

            if (opcion == 1) {
                // VER ALUMNOS
                verAlumnos(rutaArchivo);

            } else if (opcion == 2) {
                // INSERTAR ALUMNO
                insertarAlumno(rutaArchivo, scanner);

            } else if (opcion == 3) {
                System.out.println("¡Adiós!");
            } else {
                System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }

    public static void verAlumnos(String ruta) {
        File archivo = new File(ruta);

        if (!archivo.exists()) {
            System.out.println("No hay alumnos guardados todavía (el archivo no existe).");
            return;
        }

        try {
            Scanner lector = new Scanner(archivo);
            System.out.println("\n--- LISTADO DE ALUMNOS ---");
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                // Mostramos la línea tal cual o un poco formateada si queremos
                System.out.println(linea);
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();
        }
    }

    public static void insertarAlumno(String ruta, Scanner consola) {
        File archivo = new File(ruta);
        boolean existe = archivo.exists();
        String cabecera = "";

        try {
            // Si no existe, creamos la cabecera por defecto
            if (!existe) {
                cabecera = "id,nombre,curso";
                // La guardamos de paso para que el archivo exista ya
                FileWriter escritor = new FileWriter(archivo);
                escritor.write(cabecera + "\n");
                escritor.close();
                System.out.println("Archivo creado con cabeceras: " + cabecera);
            } else {
                // Si existe, leemos la primera línea para saber qué columnas hay
                Scanner lector = new Scanner(archivo);
                if (lector.hasNextLine()) {
                    cabecera = lector.nextLine();
                }
                lector.close();
            }

            // Ahora pedimos los datos según las columnas de la cabecera
            // Separamos por comas
            String[] columnas = cabecera.split(",");
            StringBuilder nuevaLinea = new StringBuilder();

            System.out.println("Introduce los datos para el nuevo alumno:");

            for (int i = 0; i < columnas.length; i++) {
                System.out.print(columnas[i] + ": ");
                String dato = consola.nextLine();
                nuevaLinea.append(dato);

                // Añadimos coma si no es el último
                if (i < columnas.length - 1) {
                    nuevaLinea.append(",");
                }
            }

            // Guardamos en el archivo añadiendo al final (append = true)
            FileWriter escritor = new FileWriter(ruta, true);
            escritor.write(nuevaLinea.toString() + "\n");
            escritor.close();

            System.out.println("Alumno guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al intentar guardar el alumno.");
            e.printStackTrace();
        }
    }
}
