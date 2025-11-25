package PROGRAMACION.ExamenT3;

import java.util.ArrayList;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Variables
        int[] array = {10, 1, 5, 8, 9, 2};
        int num = 3;

        ArrayList<Integer> resultado = obtenerVector(array, num);
        System.out.println("El resultado es: "+resultado);
    }

    // Funcion para obtener la suma de los numeros
    public static ArrayList<Integer> obtenerVector(int[] array, int num) {
        // Ver si el numero es menor que el tamaño del array
        if (num > array.length) {
            throw new IllegalArgumentException("El numero no puede ser mayor que el array"); // lo encontré en la lista: IllegalArgumentException(String s) Constructs an IllegalArgumentException with the specified detail message.
        }

        ArrayList<Integer> resultado = new ArrayList<>();
        
        // Recorrer el array para calcular los numeros seguidos
        for (int i = 0;i < array.length - num; i++) {
            int suma = 0;
            // Sumar 
            for (int j = 0;j < num; j++) {
                suma = suma + array[i + j];
            }
            // Poner el resultado en el array
            resultado.add(suma);
        }
        return resultado;
    }
}
