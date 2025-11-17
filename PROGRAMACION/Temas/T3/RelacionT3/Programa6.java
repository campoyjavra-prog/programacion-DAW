package RelacionT3;

public class Programa6 {
    public static void main(String[] args) {
        // Crear dos matrices de ejemplo
        int[][] matriz1 = {{1, 2}, {3, 4}, {5, 6}};
        int[][] matriz2 = {{6, 5}, {4, 3}, {2, 1}};

        // Llamada a la función que devuelve la matriz resultado
        int[][] resultado = calcularMatriz(matriz1, matriz2);

        // Mostrar la matriz resultado
        System.out.println("Matriz Resultado:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Función que calcula la suma, producto y media de las matrices
    public static int[][] calcularMatriz(int[][] matriz1, int[][] matriz2) {
        int filas = matriz1.length;
        int columnas = matriz1[0].length;
        int[][] resultado = new int[filas][3]; // Tres columnas: suma, producto, media

        for (int i = 0; i < filas; i++) {
            int suma = 0;
            int producto = 1;
            for (int j = 0; j < columnas; j++) {
                suma += matriz1[i][j] + matriz2[i][j];
                producto *= matriz1[i][j] * matriz2[i][j];
            }
            resultado[i][0] = suma;         // Primera columna: suma
            resultado[i][1] = producto;     // Segunda columna: producto
            resultado[i][2] = suma / columnas; // Tercera columna: media
        }

        return resultado;
    }
}
