package RelacionT3;

import java.text.Normalizer;

public class Programa8 {
    
    public static void main(String[] args) {
        // Ejemplo de frases a comprobar
        String frase = "Dábale arroz a la zorra el abad";
        
        // Verificar si es un palíndromo
        if (esPalindromo(frase)) {
            System.out.println("La frase es un palíndromo.");
        } else {
            System.out.println("La frase no es un palíndromo.");
        }
    }

    // Función que verifica si una frase es un palíndromo
    public static boolean esPalindromo(String frase) {
        // Eliminar espacios, convertir a minúsculas y quitar tildes
        String limpia = frase.replaceAll("\\s", "").toLowerCase();
        limpia = quitarTildes(limpia);
        
        // Invertir la cadena
        String invertida = new StringBuilder(limpia).reverse().toString();
        
        // Comparar la frase original con la invertida
        return limpia.equals(invertida);
    }

    // Función para quitar tildes
    public static String quitarTildes(String texto) {
        // Normalizar el texto eliminando las tildes
        String normalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return normalizado.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}
