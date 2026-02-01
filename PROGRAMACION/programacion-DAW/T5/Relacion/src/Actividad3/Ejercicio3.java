package Actividad3;

import java.io.File;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        // Declaramos variables fuera del try
        File fichero = null;
        Scanner teclado = null;

        try {
            // 1. Ruta relativa
            fichero = new File("./agenda.txt");

            // 2. Creamos el Scanner
            teclado = new Scanner(fichero);

            // 3. Configuramos el separador (coma)
            teclado.useDelimiter(",");

            System.out.println("--- LEYENDO AGENDA ---");

            // 4. Mientras haya datos que leer
            while (teclado.hasNext()) {
                // Leemos dato a dato
                String nombre = teclado.next();
                String telefono = teclado.next();

                // Creamos el objeto
                Contacto c = new Contacto(nombre, telefono);

                System.out.println(c.toString());
            }

        } catch (Exception e) {
            // Gestión de errores simple
            System.out.println("Error leyendo el fichero: " + e.getMessage());
        } finally {
            // 5. Cerrar recursos manualmente
            if (teclado != null) {
                teclado.close();
            }
        }
    }
}