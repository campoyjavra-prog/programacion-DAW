import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Actividad3 {
    public static void main(String[] args) {
        String contenido = "Este es un ejemplo de uso de BufferedWriter en Java.";
        try {
            FileWriter archivo = new FileWriter("ejemplo.txt");
            BufferedWriter escritor = new BufferedWriter(archivo);

            escritor.write(contenido); // Escribimos la cadena en el archivo
            escritor.newLine(); // Añadimos una nueva línea
            escritor.flush(); // Aseguramos que se escriban los datos

            escritor.close(); // Cerramos el BufferedWriter
            System.out.println("¡Archivo escrito con éxito!");
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
