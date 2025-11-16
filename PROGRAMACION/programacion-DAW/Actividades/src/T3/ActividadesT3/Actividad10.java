package ActividadesT3;

public class Actividad10 {
    
     static final int N = 8;  // Tamaño del tablero (8x8)
    static int[][] tablero = new int[N][N];  // Tablero de 8x8

    // Función para verificar si es seguro colocar una reina en fila, columna
    public static boolean esSeguro(int[][] tablero, int fila, int columna) {
        // Verificar columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] == 1) {
                return false;  // Hay una reina en la misma columna
            }
        }

        // Verificar diagonales
        for (int i = 0; i < fila; i++) {
            if (columna - i >= 0 && tablero[i][columna - i] == 1) {
                return false;  // Reina en la diagonal superior izquierda
            }
            if (columna + i < N && tablero[i][columna + i] == 1) {
                return false;  // Reina en la diagonal superior derecha
            }
        }

        return true;  // Si no hay conflictos, es seguro
    }

    // Función recursiva para resolver el problema de las 8 reinas
    public static boolean resolver(int[][] tablero, int fila) {
        if (fila == N) {
            return true;  // Todas las reinas han sido colocadas
        }

        // Intentar colocar la reina en cada columna de la fila
        for (int col = 0; col < N; col++) {
            if (esSeguro(tablero, fila, col)) {
                tablero[fila][col] = 1;  // Colocar la reina
                if (resolver(tablero, fila + 1)) {
                    return true;  // Si se coloca correctamente, continuar con la siguiente fila
                }
                tablero[fila][col] = 0;  // Si no, hacer backtrack
            }
        }
        return false;  // Si no se encuentra solución, hacer backtrack
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("R ");  // Colocar una reina
                } else {
                    System.out.print(". ");  // Espacios vacíos
                }
            }
            System.out.println();  // Nueva línea después de cada fila
        }
    }

    public static void main(String[] args) {
        // 1. Leer la posición de la primera reina (por ejemplo, en la columna 2)
        int primeraColumna = 2;
        tablero[0][primeraColumna] = 1;  // Colocar la reina en la primera fila y columna dada

        // 2. Llamar a la función resolver a partir de la segunda fila
        if (resolver(tablero, 1)) {
            // Si se encuentra solución, imprimir el tablero
            imprimirTablero(tablero);
        } else {
            // Si no se encuentra solución
            System.out.println("No hay solución con la reina en esa columna.");
        }
    }
}
