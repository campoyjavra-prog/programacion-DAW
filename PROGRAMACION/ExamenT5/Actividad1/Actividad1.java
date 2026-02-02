package PROGRAMACION.ExamenT5.Actividad1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Actividad1 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce la ruta del fichero java:");
        String ruta = teclado.nextLine();

        File fichero = new File(ruta);

        if (fichero.exists()) {

            ArrayList<String> lineas = new ArrayList<String>();

            try {
                // 1. LECTURA
                FileReader fr = new FileReader(fichero);
                BufferedReader buffer = new BufferedReader(fr);

                String linea = "";

                // Leemos linea a linea
                while ((linea = buffer.readLine()) != null) {
                    // Comprobamos si la linea es un comentario de linea completa con trim()
                    if (!linea.trim().startsWith("//")) {
                        lineas.add(linea);
                    }
                }

                // Cerramos flujos de lectura antesde abrir escritura
                buffer.close();
                fr.close();

                // 2. ESCRITURA
                FileWriter fw = new FileWriter(fichero);
                BufferedWriter bufferescritura = new BufferedWriter(fw);

                for (int i = 0; i < lineas.size(); i++) {
                    String l = lineas.get(i);
                    bufferescritura.write(l);
                    bufferescritura.newLine(); // Añadimos salto de linea
                }

                // Cerramos flujos
                bufferescritura.close();
                fw.close();

                System.out.println("Fichero procesado correctamente.");

            } catch (IOException e) {
                System.out.println("Error procesando el fichero: " + e.getMessage());
            }
        } else {
            System.out.println("El fichero no existe.");
        }

        teclado.close();
    }
}
