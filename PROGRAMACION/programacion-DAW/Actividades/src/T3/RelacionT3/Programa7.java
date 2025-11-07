package RelacionT3;

import java.util.Random;

public class Programa7 {
    public static void main(String[] args) {
        int n = 5; // Tamaño de la matriz (5x5)
        int[][] matriz = new int[n][n];
        
        // Llenar la matriz con números aleatorios entre 0 y 100
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = rand.nextInt(101); // Números entre 0 y 100
            }
        }

        // Mostrar la matriz original
        System.out.println("Matriz original:");
        mostrarMatriz(matriz);

        // Rotar la matriz en sentido de las agujas del reloj
        int[][] matrizRotada = rotarMatriz(matriz);

        // Mostrar la matriz rotada
        System.out.println("Matriz rotada:");
        mostrarMatriz(matrizRotada);
    }

    // Función para mostrar una matriz
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Función para rotar la matriz en sentido de las agujas del reloj
    public static int[][] rotarMatriz(int[][] matriz) {
        int n = matriz.length;
        int[][] matrizRotada = new int[n][n];
        
        // Rotar la matriz 90 grados
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrizRotada[j][n - 1 - i] = matriz[i][j];
            }
        }
        return matrizRotada;
    }
}