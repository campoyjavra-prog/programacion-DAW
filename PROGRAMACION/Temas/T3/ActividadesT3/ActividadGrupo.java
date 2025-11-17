package ActividadesT3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class ActividadGrupo {
     public static void main(String[] args) {
        // Array de palabras posibles
        String[] palabras = {"avion", "clase", "domingo", "programacion", "adios"};
        
        // Seleccionamos una palabra al azar
        Random random = new Random();
        String palabra = palabras[random.nextInt(palabras.length)];
        
        // Creamos un array de asteriscos para mostrar las letras
        char[] palabraOculta = new char[palabra.length()];
        Arrays.fill(palabraOculta, '*');  // Llenamos con asteriscos
        
        int intentosRestantes = 7;  // El número de intentos disponibles
        Set<Character> letrasIncorrectas = new HashSet<>();  // Para almacenar las letras incorrectas

        // Bucle principal del juego
        Scanner scanner = new Scanner(System.in);
        
        while (intentosRestantes > 0) {
            // Mostramos la palabra oculta y las letras incorrectas
            System.out.println("Palabra: " + new String(palabraOculta));
            System.out.println("Letras incorrectas: " + letrasIncorrectas);
            System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
            
            // Pedimos al jugador que ingrese una letra
            System.out.print("Introduce una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);
            
            // Verificamos si la letra ya fue intentada
            if (letrasIncorrectas.contains(letra) || new String(palabraOculta).contains(String.valueOf(letra))) {
                System.out.println("Ya has intentado esa letra. Intenta con otra.");
                continue;
            }
            
            // Si la letra está en la palabra, la revelamos
            if (palabra.indexOf(letra) >= 0) {
                for (int i = 0; i < palabra.length(); i++) {
                    if (palabra.charAt(i) == letra) {
                        palabraOculta[i] = letra;  // Reemplazamos el * por la letra correcta
                    }
                }
            } else {
                // Si la letra no está en la palabra, decrementamos los intentos
                letrasIncorrectas.add(letra);  // Añadimos la letra incorrecta al conjunto
                intentosRestantes--;
            }
            
            // Verificamos si el jugador ha ganado
            if (new String(palabraOculta).equals(palabra)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabra);
                break;
            }
        }
        
        // Si se han agotado los intentos, el jugador pierde
        if (intentosRestantes == 0) {
            System.out.println("¡Has perdido! La palabra era: " + palabra);
        }
        
        scanner.close();
    }
}
