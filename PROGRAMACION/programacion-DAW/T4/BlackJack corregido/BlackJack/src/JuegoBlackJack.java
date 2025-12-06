import java.util.Scanner;

public class JuegoBlackJack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitamos el nombre del jugador
        System.out.print("Ingresa el nombre del jugador: ");
        String nombreJugador = scanner.nextLine();

        // Creamos una nueva partida
        Partida partida = new Partida(nombreJugador);

        // Variable para verificar si es la primera ronda
        boolean esPrimeraRonda = true;

        // Bucle principal del juego
        while (true) {
            System.out.println("\nNueva Ronda:");
            partida.iniciarRonda();

            // Mostrar dinero actual del jugador
            System.out.println("Dinero actual: " + partida.getDineroJugador() + "€");

            // Apostar una cantidad entre 1 y el dinero disponible
            int apuesta = 0;

            // Si es la primera ronda, se puede apostar cualquier cantidad entre 1 y 100
            if (esPrimeraRonda) {
                System.out.println("Tienes 100€, puedes apostar cualquier cantidad entre 1 y 100€.");
                apuesta = Math.min(100, partida.getDineroJugador());  // Apostar el dinero disponible
                esPrimeraRonda = false;
            } else {
                // Preguntar cuánto quiere apostar
                while (true) {
                    System.out.print("Dinero que quieres apostar (mínimo 1€, tienes " + partida.getDineroJugador() + "€): ");
                    if (scanner.hasNextInt()) {
                        apuesta = scanner.nextInt();
                        // Validar que la apuesta esté entre 1 y el dinero disponible
                        if (apuesta >= 1 && apuesta <= partida.getDineroJugador()) {
                            break;  // Salir del bucle si la apuesta es válida
                        } else {
                            System.out.println("Apuesta no válida. Apuesta un valor entre 1 y " + partida.getDineroJugador() + "€.");
                        }
                    } else {
                        System.out.println("Por favor, ingresa un número válido.");
                        scanner.next();  // Limpiar la entrada incorrecta
                    }
                }
            }

            // Realiza la apuesta
            partida.apostar(apuesta);

            // Jugador pide cartas hasta plantarse o pasarse
            while (true) {
                System.out.print("¿Quieres pedir carta? (s/n): ");
                String decision = scanner.next();
                if (decision.equalsIgnoreCase("s")) {
                    partida.pedirCarta();
                    if (partida.getJugador().obtenerPuntuacion() > 21) break;  // Si se pasa, termina la ronda
                } else {
                    break;
                }
            }

            // Mostrar la mano y la puntuación total del crupier solo una vez
            partida.getCrupier().mostrarMano();  // Mostrar la mano del crupier solo una vez

            // Si el jugador no se pasó, el crupier juega
            if (partida.getJugador().obtenerPuntuacion() <= 21) {
                partida.jugarCrupier();
            }

            // Comparar las manos y mostrar el resultado
            partida.compararManos();

            // Mostrar dinero actual después de la ronda
            System.out.println("Dinero actual después de la ronda: " + partida.getDineroJugador() + "€");

            // Evitar que el dinero sea negativo al final de la ronda
            if (partida.getDineroJugador() < 0) {
                partida.setDineroJugador(0);  // Establece el dinero a 0 si es negativo
            }

            // Si el jugador se queda sin dinero, termina el juego
            if (partida.getDineroJugador() <= 0) {
                System.out.println("Te has quedado sin dinero. Fin del juego.");
                break;
            }

            // Preguntar si quiere jugar otra ronda
            System.out.print("¿Quieres jugar otra ronda? (s/n): ");
            String continuar = scanner.next();
            if (!continuar.equalsIgnoreCase("s")) {
                System.out.println("Gracias por jugar. Te has quedado con " + partida.getDineroJugador() + "€.");
                break;
            }
        }

        scanner.close();
    }
}

