
import java.util.Scanner;

public class TicTacToe {
        static char[][] tablero = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };
    static char turno = 'X';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean juegoActivo = true;

        while (juegoActivo) {
            imprimirTablero();
            System.out.println("Turno del jugador " + turno);
            int fila, columna;

            while (true) {
                System.out.print("Introduce fila (0-2): ");
                fila = sc.nextInt();
                System.out.print("Introduce columna (0-2): ");
                columna = sc.nextInt();

                if (fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2) {
                    if (tablero[fila][columna] == ' ') {
                        tablero[fila][columna] = turno;
                        break;
                    } else {
                        System.out.println("Esa casilla ya está ocupada.");
                    }
                } else {
                    System.out.println("Coordenadas inválidas. Intenta de nuevo.");
                }
            }

            if (comprobarGanador()) {
                imprimirTablero();
                System.out.println("¡Jugador " + turno + " ha ganado!");
                juegoActivo = false;
            } else if (tableroLleno()) {
                imprimirTablero();
                System.out.println("¡Empate!");
                juegoActivo = false;
            } else {
                turno = (turno == 'X') ? 'O' : 'X';
            }
        }

        sc.close();
    }

    static void imprimirTablero() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    static boolean comprobarGanador() {
        // Filas y columnas  
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == turno && tablero[i][1] == turno && tablero[i][2] == turno) return true;
            if (tablero[0][i] == turno && tablero[1][i] == turno && tablero[2][i] == turno) return true;
        }
        // Diagonales
        if (tablero[0][0] == turno && tablero[1][1] == turno && tablero[2][2] == turno) return true;
        if (tablero[0][2] == turno && tablero[1][1] == turno && tablero[2][0] == turno) return true;

        return false;
    }

    static boolean tableroLleno() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (tablero[i][j] == ' ') return false;
        return true;
    }
    
}
