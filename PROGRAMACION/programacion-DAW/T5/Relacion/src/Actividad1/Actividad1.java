package Actividad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Actividad1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos las rutas
        System.out.println("Introduce la ruta del primer fichero:");
        String ruta1 = sc.nextLine();

        System.out.println("Introduce la ruta del segundo fichero:");
        String ruta2 = sc.nextLine();

        System.out.println("Introduce la ruta del directorio de destino:");
        String rutaDestino = sc.nextLine();

        // Creamos objetos File para sacar los nombres
        File f1 = new File(ruta1);
        File f2 = new File(ruta2);

        // Sacamos los nombres sin extension
        String nombre1 = f1.getName();
        String nombre2 = f2.getName();

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

        System.out.println("El fichero se guardará en: " + rutaFinal);

        // Hacemos el copiado
        try {
            // Preparamos para leer los dos ficheros
            BufferedReader br1 = new BufferedReader(new FileReader(f1));
            BufferedReader br2 = new BufferedReader(new FileReader(f2));

            // Preparamos para escribir en el nuevo
            BufferedWriter bw = new BufferedWriter(new FileWriter(rutaFinal));

            String linea = "";

            // Leemos el primero y escribimos
            while ((linea = br1.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            // Leemos el segundo y escribimos
            while ((linea = br2.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }

            // Cerramos todo
            br1.close();
            br2.close();
            bw.close();

            System.out.println("¡Copia realizada con éxito!");

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error leyendo o escribiendo ficheros.");
            e.printStackTrace();
        }

        sc.close();
    }
}
