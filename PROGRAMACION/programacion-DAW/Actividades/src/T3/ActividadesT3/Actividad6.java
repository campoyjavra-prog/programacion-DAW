package ActividadesT3;

public class Actividad6 {
      public static void main(String[] args) {
        // Definimos la matriz 3x3
        int[][] matriz = {
            {3, 7, 1},
            {4, -4, 2},
            {5, 0, 5}
        };

        int filas = matriz.length;  // Número de filas de la matriz
        int columnas = matriz[0].length;  // Número de columnas de la matriz
        
        // Implementación del algoritmo de burbuja para ordenar la matriz
        for (int i = 0; i < filas * columnas - 1; i++) {
            for (int j = 0; j < filas * columnas - i - 1; j++) {
                // Convertimos el índice 1D (j) en índice 2D para la matriz
                int fila1 = j / columnas;
                int col1 = j % columnas;
                int fila2 = (j + 1) / columnas;
                int col2 = (j + 1) % columnas;

                // Comparamos los elementos actuales (matriz[fila1][col1]) y siguientes (matriz[fila2][col2])
                if (matriz[fila1][col1] > matriz[fila2][col2]) {
                    // Si el elemento actual es mayor que el siguiente, los intercambiamos
                    int temp = matriz[fila1][col1];
                    matriz[fila1][col1] = matriz[fila2][col2];
                    matriz[fila2][col2] = temp;
                }
            }
        }

        // Imprimimos la matriz ordenada
        System.out.println("Matriz ordenada:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " ");  // Imprimimos cada elemento de la matriz
            }
            System.out.println();  // Nueva línea después de cada fila
        }
    }
}
