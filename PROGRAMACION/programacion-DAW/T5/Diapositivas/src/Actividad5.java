
// 1) Implementa una clase que lee el contenido de un fichero, solicita una
// palabra por teclado y dice cuántas veces aparece en el texto. Utiliza
// split("\\s+") para separar por uno o varios espacios.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Actividad5 {
    public static void main(String[] args) {

        String nombreFichero = "prueba.txt";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la palabra a buscar: ");
        String palabraBuscada = scanner.next();

        int contador = 0;

        try (BufferedReader buffer = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            while ((linea = buffer.readLine()) != null) {
                // Separamos por uno o varios espacios
                String[] palabras = linea.toLowerCase().split("\\s+");

                for (String palabra : palabras) {
                    if (palabra.equals(palabraBuscada)) {
                        contador++;
                    }
                }
            }

            System.out.println("La palabra '" + palabraBuscada + "' aparece " + contador + " veces en el texto.");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
            System.out.println("Asegúrate de que el archivo '" + nombreFichero + "' existe.");
        } finally {
            scanner.close();
        }
    }
}