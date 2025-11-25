package PROGRAMACION.ExamenT3;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {

        int [][] matriz = new int [5][5];
        Scanner teclado = new Scanner(System.in);

        // rellenar la matriz
        for (int i = 0;i < 5; i++){
            System.out.print(matriz[i]+ " ");
        }
        System.out.println();

        // imprimir la matriz
        System.out.println("Esta es la matriz: ");
        mostrarMatriz(matriz);

    }


    // Funcion para sumar filas
    public static void sumaFila(int fila){

    }

    // Funcion para sumar columnas
    public static void sumaColumna(int columna){

    }

    // Funcion para sumar filas
    public static void maximoMinimo (int filas, int columna){

    }


    // Función para mostrar la matriz
    public static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}
