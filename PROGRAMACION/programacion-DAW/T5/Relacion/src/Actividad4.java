import java.util.HashMap;
import java.util.Scanner;

public class Actividad4 {

    public static void main(String[] args) {
        // Usamos HashMap como pide el ejercicio
        HashMap<String, String> diccionario = new HashMap<>();
        Scanner teclado = new Scanner(System.in);
        String palabra = "";

        // Cargamos algunas palabras iniciales
        diccionario.put("cat", "gato");
        diccionario.put("dog", "perro");
        diccionario.put("table", "mesa");
        diccionario.put("computer", "ordenador");

        try {
            System.out.println("--- TRADUCTOR (Escribe 'fin' para salir) ---");

            // Bucle infinito hasta que usuario quiera
            while (true) {
                System.out.print("Dime una palabra en inglés: ");
                palabra = teclado.next();

                // Condición de salida
                if (palabra.equalsIgnoreCase("fin")) {
                    break;
                }

                // Lógica principal: containsKey
                if (diccionario.containsKey(palabra)) {
                    // Si existe, recuperamos valor con get()
                    String traduccion = diccionario.get(palabra);
                    System.out.println("Traducción: " + traduccion);
                } else {
                    // Si no existe, pedimos traducción y guardamos
                    System.out.print("No la conozco. ¿Cómo se dice en español?: ");
                    String nueva = teclado.next();

                    diccionario.put(palabra, nueva);
                    System.out.println("Palabra guardada correctamente.");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Cierre manual
            teclado.close();
        }
    }
}
