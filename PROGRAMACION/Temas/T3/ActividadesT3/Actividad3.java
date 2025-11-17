package ActividadesT3;

public class Actividad3 {
     public static void main(String[] args) {
        int filas = 3, columnas = 3; // Definimos el tamaño de la matriz
        int[][] matriz = new int[filas][columnas]; // Creamos la matriz dinámica

        // Llenamos la matriz con valores aleatorios entre 0 y 9
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int)(Math.random() * 10); // Genera un valor aleatorio
            }
        }

        // Imprimir la matriz generada
        System.out.println("Matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j] + " "); // Imprime cada elemento
            }
            System.out.println();
        }

        // Sumar filas y mostrar los resultados
        System.out.println("\nSuma de las filas:");
        for (int i = 0; i < filas; i++) {
            int sumaFila = 0;
            for (int j = 0; j < columnas; j++) {
                sumaFila += matriz[i][j]; // Suma de los elementos de la fila
            }
            System.out.println("Fila " + i + ": " + sumaFila); // Imprime la suma de la fila
        }

        // Sumar columnas y mostrar los resultados
        System.out.println("\nSuma de las columnas:");
        for (int j = 0; j < columnas; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < filas; i++) {
                sumaColumna += matriz[i][j]; // Suma de los elementos de la columna
            }
            System.out.println("Columna " + j + ": " + sumaColumna); // Imprime la suma de la columna
        }
    }
}
