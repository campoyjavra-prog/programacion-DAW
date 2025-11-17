package ActividadesT3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Actividad7 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Crear un scanner para leer la entrada del usuario
        ArrayList<String> nombres = new ArrayList<>(); // Crear un ArrayList para almacenar los nombres

        System.out.println("Introduce los nombres. Escribe 'fin' para terminar.");

        while (true) {
            String nombre = scanner.nextLine(); // Leer el nombre ingresado por el usuario

            if (nombre.equalsIgnoreCase("fin")) { // Si el usuario escribe 'fin', terminamos el bucle
                break;
            }

            // Si el nombre no está en la lista, lo agregamos
            if (!nombres.contains(nombre)) {
                nombres.add(nombre);
            } else {
                System.out.println("El nombre ya está en la lista.");
            }
        }

        // Ordenamos los nombres de forma alfabética, sin distinguir mayúsculas de minúsculas
        Collections.sort(nombres, String.CASE_INSENSITIVE_ORDER);

        // Mostramos los nombres ordenados
        System.out.println("Nombres ordenados:");
        for (String nombre : nombres) {
            System.out.println(nombre);
        }

        scanner.close(); // Cerramos el scanner
    }
}
