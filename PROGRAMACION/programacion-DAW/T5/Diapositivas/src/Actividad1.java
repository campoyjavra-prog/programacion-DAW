import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Actividad1 {
    public static void main(String[] args) {
        File archivo = new File(
                "/Users/rafacamjv/Desktop/CICLOS/1DAW/GitHub/PROGRAMACION/programacion-DAW/T5/numeros.txt");

        double suma = 0;
        int contador = 0;
        double media = 0;
        int numero = 0;

        try {
            Scanner scanner = new Scanner(archivo);
            System.out.println("Leyendo archivo: " + archivo.getAbsolutePath());

            while (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                System.out.println("Número leído: " + numero);
                suma += numero;
                contador++;
            }
            scanner.close();

            if (contador > 0) {
                media = suma / contador;
                System.out.println("--------------------------------------------------");
                System.out.println("Resultados:");
                System.out.println("Cantidad de números: " + contador);
                System.out.println("Suma total: " + suma);
                System.out.println("Media: " + media);
            } else {
                System.out.println("El archivo está vacío o no contiene números.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: No se ha encontrado el archivo.");
            e.printStackTrace();
        }
    }
}
