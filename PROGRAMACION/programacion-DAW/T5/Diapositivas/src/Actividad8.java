import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Actividad8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rutaArchivo = "/Users/rafacamjv/Desktop/CICLOS/1DAW/GitHub/PROGRAMACION/programacion-DAW/T5/alumnos.csv";
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n--- MENÚ ALUMNOS 2 ---");
            System.out.println("1. Ver alumnos");
            System.out.println("2. Insertar alumno");
            System.out.println("3. Modificar nombre alumno");
            System.out.println("4. Salir");
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
                // Ver alumnos
                verAlumnos(rutaArchivo);

            } else if (opcion == 2) {
                // Insertar alumno
                insertarAlumno(rutaArchivo, scanner);

            } else if (opcion == 3) {
                // Modificar alumno
                modificarAlumno(rutaArchivo, scanner);

            } else if (opcion == 4) {
                // Salir
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
            if (!existe) {
                cabecera = "id,nombre,curso";
                FileWriter escritor = new FileWriter(archivo);
                escritor.write(cabecera + "\n");
                escritor.close();
                System.out.println("Archivo creado con cabeceras: " + cabecera);
            } else {
                Scanner lector = new Scanner(archivo);
                if (lector.hasNextLine()) {
                    cabecera = lector.nextLine();
                }
                lector.close();
            }

            String[] columnas = cabecera.split(",");
            StringBuilder nuevaLinea = new StringBuilder();

            System.out.println("Introduce los datos para el nuevo alumno:");

            for (int i = 0; i < columnas.length; i++) {
                System.out.print(columnas[i] + ": ");
                String dato = consola.nextLine();
                nuevaLinea.append(dato);

                if (i < columnas.length - 1) {
                    nuevaLinea.append(",");
                }
            }

            FileWriter escritor = new FileWriter(ruta, true);
            escritor.write(nuevaLinea.toString() + "\n");
            escritor.close();

            System.out.println("Alumno guardado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al intentar guardar el alumno.");
            e.printStackTrace();
        }
    }

    public static void modificarAlumno(String ruta, Scanner consola) {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            System.out.println("El archivo de alumnos no existe.");
            return;
        }

        ArrayList<String> lineas = new ArrayList<>();
        boolean encontrado = false;

        System.out.print("Introduce el ID del alumno a modificar: ");
        String idBuscado = consola.nextLine();

        try {
            // 1. Leemos todo el fichero y lo guardamos en el ArrayList
            Scanner lector = new Scanner(archivo);
            while (lector.hasNextLine()) {
                String linea = lector.nextLine();
                lineas.add(linea);
            }
            lector.close();

            // 2. Recorremos el ArrayList para buscar y modificar
            // Empezamos en 1 para saltarnos la cabecera
            for (int i = 1; i < lineas.size(); i++) {
                String linea = lineas.get(i);
                String[] partes = linea.split(",");

                // Suponemos que el ID es la primera columna (índice 0)
                if (partes.length > 0 && partes[0].equals(idBuscado)) {
                    encontrado = true;
                    System.out.println("Alumno encontrado: " + linea);
                    System.out.print("Introduce el nuevo NOMBRE: ");
                    String nuevoNombre = consola.nextLine();

                    // Reconstruimos la línea. Asumimos estructura id,nombre,curso
                    // partes[0] es id, partes[1] es nombre, partes[2] es curso (si existe)

                    // Para hacerlo genérico aquí lo haremos
                    // asumiendo que el nombre es la columna 1
                    if (partes.length >= 2) {
                        // Reemplazamos partes[1] por nuevoNombre
                        partes[1] = nuevoNombre;

                        // Volvemos a juntar con comas
                        StringBuilder lineaNueva = new StringBuilder();
                        for (int k = 0; k < partes.length; k++) {
                            lineaNueva.append(partes[k]);
                            if (k < partes.length - 1) {
                                lineaNueva.append(",");
                            }
                        }
                        lineas.set(i, lineaNueva.toString());
                        System.out.println("Nombre modificado en memoria.");
                    }
                    break; // Ya lo hemos encontrado y modificado, salimos del bucle
                }
            }

            if (encontrado) {
                // 3. Sobrescribimos el fichero con el contenido del ArrayList
                FileWriter escritor = new FileWriter(ruta);
                for (String l : lineas) {
                    escritor.write(l + "\n");
                }
                escritor.close();
                System.out.println("Archivo actualizado correctamente.");
            } else {
                System.out.println("No se ha encontrado ningún alumno con el ID: " + idBuscado);
            }

        } catch (IOException e) {
            System.out.println("Error al modificar el archivo.");
            e.printStackTrace();
        }
    }
}
