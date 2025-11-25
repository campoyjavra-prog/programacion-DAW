package PROGRAMACION.ExamenT3;

import java.util.Arrays;

public class Ejercicio4 {
    public static void main(String[] args) {

        // Palabras
        String palabra1 = "roma";
        String palabra2 = "amor";


        // imprimir y ver si las palabras son o no lo son
         if (verificaAnagrama(palabra1, palabra2)) {
            System.out.println(palabra1+" y "+palabra2+" son anagramas.");
        } 
        else {
            System.out.println(palabra1+" y "+palabra2+" no son anagramas.");
        }
    }

    

    // Funcion para verificar si son anagramas
    public static boolean verificaAnagrama(String palabra1, String palabra2) {
        // ponerlas en minuscula
        palabra1 = palabra1.toLowerCase();
        palabra2 = palabra2.toLowerCase();

          // ver si tienen el mismo tamaño
        if (palabra1.length() != palabra2.length()) {
            return false;
        }

        // convertirlas en arrays de caracteres y ordenarlos
        char[] array1 = palabra1.toCharArray();
        char[] array2 = palabra2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        // Comparar los arrays
        return Arrays.equals(array1, array2);
    }
}
