package ActividadesT3;

public class Actividad9 {
    
    static final int N = 8;  // Tamaño del tablero (8x8)
    static int[] tablero = new int[N];  // Array para almacenar las posiciones de las reinas

    // Función para verificar si es seguro colocar una reina en fila, columna
    public static boolean esSeguro(int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            // Verificar si hay una reina en la misma columna o en las diagonales
            if (tablero[i] == columna || tablero[i] - i == columna - fila || tablero[i] + i == columna + fila) {
                return false; // Si hay conflicto
            }
        }
        return true; // Si no hay conflictos, es seguro
    }

    // Función recursiva para resolver el problema de las 8 reinas
    public static boolean resolver(int fila) {
        if (fila == N) {
            imprimirTablero();  // Si todas las reinas están colocadas, imprimir el tablero
            return true;
        }
        for (int col = 0; col < N; col++) {
            if (esSeguro(fila, col)) {  // Comprobar si se puede colocar la reina
                tablero[fila] = col;  // Colocar la reina en la fila y columna actuales
                if (resolver(fila + 1)) {  // Llamada recursiva para la siguiente fila
                    return true;  // Si se coloca correctamente, continuar
                }
            }
        }
        return false;  // Si no se encuentra una solución en esta fila, backtrack
    }

    // Función para imprimir el tablero con las reinas colocadas
    public static void imprimirTablero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tablero[i] == j) {
                    System.out.print("R ");  // Colocamos una reina en la posición
                } else {
                    System.out.print(". ");  // Los demás lugares son vacíos
                }
            }
            System.out.println();  // Nueva línea por cada fila
        }
        System.out.println();  // Espacio entre soluciones
    }

    public static void main(String[] args) {
        if (!resolver(0)) {  // Iniciar la búsqueda desde la fila 0
            System.out.println("No hay solución.");
        }
    }
}
