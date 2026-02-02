package PROGRAMACION.ExamenT5.Actividad3;

import java.util.HashMap;
import java.util.Scanner;

public class Actividad3 {

    public static void main(String[] args) {

        // 1. Declaración del HashMap (Diccionario)
        // Clave: Palabra en español (String)
        // Valor: Traducción en inglés (String)
        HashMap<String, String> diccionario = new HashMap<>();

        // 2. Contenido básico
        diccionario.put("caliente", "hot");
        diccionario.put("rojo", "red");
        diccionario.put("ardiente", "hot");
        diccionario.put("verde", "green");
        diccionario.put("agujetas", "stiff");
        diccionario.put("abrasador", "hot");
        diccionario.put("hierro", "iron");
        diccionario.put("grande", "big");

        Scanner teclado = new Scanner(System.in);
        String palabra = "";

        try {
            // 3. Bucle principal
            do {
                System.out.print("Introduce palabra en español: ");
                palabra = teclado.nextLine();

                if (!palabra.equalsIgnoreCase("Salir")) {

                    // Buscamos la palabra en el diccionario
                    if (diccionario.containsKey(palabra)) {
                        String traduccion = diccionario.get(palabra);
                        System.out.println("En inglés la palabra es " + traduccion);
                    } else {
                        System.out.println("Palabra no encontrada en el diccionario");
                    }
                }

            } while (!palabra.equalsIgnoreCase("Salir"));

        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            // 4. Cierre de recursos
            teclado.close();
        }
    }
}
