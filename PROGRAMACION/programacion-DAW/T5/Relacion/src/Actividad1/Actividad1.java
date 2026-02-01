package Actividad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Actividad1 {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Pedimos las rutas
        System.out.println("Introduce la ruta del primer fichero:");
        String ruta1 = teclado.nextLine();

        System.out.println("Introduce la ruta del segundo fichero:");
        String ruta2 = teclado.nextLine();

        System.out.println("Introduce la ruta del directorio de destino:");
        String rutaDestino = teclado.nextLine();

        // Creamos objetos File para sacar los nombres
        File fichero1 = new File(ruta1);
        File fichero2 = new File(ruta2);

        // Sacamos los nombres sin extension
        String nombre1 = fichero1.getName();
        String nombre2 = fichero2.getName();

        // Quitamos la extensión suponiendo que tienen (buscamos el último punto)
        if (nombre1.contains(".")) {
            nombre1 = nombre1.substring(0, nombre1.lastIndexOf("."));
        }
        if (nombre2.contains(".")) {
            nombre2 = nombre2.substring(0, nombre2.lastIndexOf("."));
        }

        // Creamos el nombre nuevo
        String nombreNuevo = nombre1 + "_" + nombre2 + ".txt";

        // Creamos la ruta completa del destino
        // Añadimos la barra si no la tiene
        String separador = File.separator;
        if (!rutaDestino.endsWith(separador)) {
            rutaDestino = rutaDestino + separador;
        }

        String rutaFinal = rutaDestino + nombreNuevo;

        System.out.println("El fichero se guardara en: " + rutaFinal);

        // Hacemos el copiado
        try {
            // Preparamos para leer los dos ficheros
            BufferedReader buffer1 = new BufferedReader(new FileReader(fichero1));
            BufferedReader buffer2 = new BufferedReader(new FileReader(fichero2));

            // Preparamos para escribir en el nuevo
            BufferedWriter buffer = new BufferedWriter(new FileWriter(rutaFinal));

            String linea = "";

            // Leemos el primero y escribimos
            while ((linea = buffer1.readLine()) != null) {
                buffer.write(linea);
                buffer.newLine();
            }

            // Leemos el segundo y escribimos
            while ((linea = buffer2.readLine()) != null) {
                buffer.write(linea);
                buffer.newLine();
            }

            // Cerramos todo
            buffer1.close();
            buffer2.close();
            buffer.close();

            System.out.println("Copia realizada");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }

        teclado.close();
    }
}
