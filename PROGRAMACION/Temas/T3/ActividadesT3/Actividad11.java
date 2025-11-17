package ActividadesT3;

public class Actividad11 {
    
    static final int N = 8;  // Tamaño del tablero (8x8)
    static int[][] tablero = new int[N][N];  // Tablero de 8x8

    // Función para verificar si es seguro colocar una reina en fila, columna
    public static boolean esSeguro(int[][] tablero, int fila, int columna) {
        // Revisar la columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][columna] == 1) {
                return false;  // Hay una reina en la misma columna
            }
        }

        // Revisar diagonal superior izquierda
        int i = fila - 1;
        int j = columna - 1;
        while (i >= 0 && j >= 0) {
            if (tablero[i][j] == 1) {
                return false;  // Reina en la diagonal superior izquierda
            }
            i--;
            j--;
        }

        // Revisar diagonal superior derecha
        i = fila - 1;
        j = columna + 1;
        while (i >= 0 && j < N) {
            if (tablero[i][j] == 1) {
                return false;  // Reina en la diagonal superior derecha
            }
            i--;
            j++;
        }

        return true;  // Si no hay conflictos, es seguro
    }

    // Función recursiva para resolver el problema de las 8 reinas
    public static boolean resolver(int[][] tablero, int fila) {
        if (fila == N) {
            return true;  // Caso base: todas las reinas han sido colocadas
        }

        for (int col = 0; col < N; col++) {
            if (esSeguro(tablero, fila, col)) {
                tablero[fila][col] = 1;  // Colocar la reina
                if (resolver(tablero, fila + 1)) {  // Llamada recursiva para la siguiente fila
                    return true;  // Si se coloca correctamente, continuar
                }
                tablero[fila][col] = 0;  // Backtracking: quitar la reina y probar otra posición
            }
        }

        return false;  // Si no se puede colocar la reina en ninguna columna, hacer backtracking
    }

    // Función para imprimir el tablero
    public static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.print("R ");  // Colocamos una reina
                } else {
                    System.out.print(". ");  // Los demás lugares son vacíos
                }
            }
            System.out.println();  // Nueva línea después de cada fila
        }
        System.out.println();  // Espacio entre soluciones
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
