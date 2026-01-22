import java.io.FileWriter;
import java.io.IOException;

public class Actividad4 {
    public static void main(String[] args) {
        // Definimos el array con la combinación de la Bonoloto
        int[] bonoloto = { 3, 15, 22, 33, 40, 45 };

        try {
            // Creamos el FileWriter para escribir en el archivo bonoloto.txt
            // Se guardará en la carpeta T5 del proyecto
            FileWriter escritor = new FileWriter(
                    "/Users/rafacamjv/Desktop/CICLOS/1DAW/GitHub/PROGRAMACION/programacion-DAW/T5/bonoloto.txt");

            // Recorremos el array y escribimos cada número
            for (int i = 0; i < bonoloto.length; i++) {
                // Escribimos el número y una coma para separar
                escritor.write(bonoloto[i] + ",");
            }

            // Cerramos el escritor para asegurar que se guardan los datos
            escritor.close();

            System.out.println("Se ha guardado la combinación de la Bonoloto en bonoloto.txt");

        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir el archivo.");
            e.printStackTrace();
        }
    }
}
