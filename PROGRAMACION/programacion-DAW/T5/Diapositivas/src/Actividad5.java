
// 2) Implementa una clase que lee el contenido de un fichero, cuya ruta le
// indicas por teclado, y lo escribe en otro fichero con el mismo nombre y
// añadiendo copia y fecha. Ejemplo: fichero→fichero_copia_yyyy_mm_dd.txt.
// Recuerda usar LocalDate.now() y que para sacar el nombre sin la extensión puedes usar nombre.substring(0,nombre.lastIndexOf('.'));

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Actividad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del fichero: ");
        String rutaFichero = scanner.nextLine();
        scanner.close();

        String nombreFichero = rutaFichero.substring(rutaFichero.lastIndexOf('/') + 1);
        String nombreSinExtension = nombreFichero.substring(0, nombreFichero.lastIndexOf('.'));
        String fecha = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd"));
        String nombreCopia = nombreSinExtension + "_copia_" + fecha + ".txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaFichero));
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreCopia));
            String linea;
            while ((linea = reader.readLine()) != null) {
                writer.write(linea);
                writer.newLine();
            }
            reader.close();
            writer.close();
            System.out.println("Fichero copiado correctamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
