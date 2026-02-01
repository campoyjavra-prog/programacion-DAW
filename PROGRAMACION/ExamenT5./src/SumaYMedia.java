import java.io.*;

public class SumaYMedia {
    public static void main(String[] args) {
        try {
            // Instanciamos el BufferedReader anidando FileReader y File
            BufferedReader buffer = new BufferedReader(
                    new FileReader(new File("/Users/rafacamjv/Desktop/CICLOS/1DAW/GitHub/numeros.txt")));

            // Declaramos las variables, double para contadores y acumuladores.
            double contador = 0, suma = 0, numero;
            double media = 0;
            String linea;

            // Vamos a leer el fichero de principio a fin
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);

                // Convierte la cadena de texto en un número
                numero = Integer.parseInt(linea);

                suma = suma + numero;
                contador++;
            }

            // Calculamos la media
            media = suma / contador;

            // Sacar resultados
            System.out.println("Hay " + contador + " números y la suma es " + suma + " y la media es " + media);

            // Vamos a cerrar el descriptor de archivo (opcional en el snippet del profe,
            // pero buena práctica incluirlo o dejarlo comentado como él)
            buffer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
