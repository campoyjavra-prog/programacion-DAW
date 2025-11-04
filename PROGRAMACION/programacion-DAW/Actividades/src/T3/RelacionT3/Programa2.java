package RelacionT3;

import java.util.Scanner;
import java.util.Arrays;

public class Programa2 {

    public static void main(String[] args) {
        // Crear el objeto Scanner para leer datos del usuario
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar al usuario cuántos números desea introducir
        System.out.print("¿Cuántos números deseas introducir? ");
        int cantidad = scanner.nextInt();
        
        // Crear un array dinámico para almacenar los números
        int[] numeros = new int[cantidad];
        
        // Solicitar los números al usuario
        for (int i = 0; i < cantidad; i++) {
            System.out.print("Introduce el número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();  // Guardar el número en el array
        }

        // Mostrar el vector original
        System.out.println("\nVector original:");
        mostrarArray(numeros);  // Llamada a la función para mostrar el array
        
        // Ordenar el array de mayor a menor
        Arrays.sort(numeros);  // Ordenar el array en orden ascendente
        
        // Invertir el array para obtener el orden de mayor a menor
        invertirArray(numeros);
        
        // Mostrar el array ordenado de mayor a menor
        System.out.println("\nVector ordenado de mayor a menor:");
        mostrarArray(numeros);  // Llamada a la función para mostrar el array ordenado
    }

    // Función para mostrar los elementos de un array
    public static void mostrarArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");  // Imprimir cada número
        }
        System.out.println();  // Salto de línea al final
    }

    // Función para invertir el array (para ordenarlo de mayor a menor)
    public static void invertirArray(int[] array) {
        int temp;
        int i = 0;
        int j = array.length - 1;
        
        // Intercambiar los elementos para invertir el array
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}