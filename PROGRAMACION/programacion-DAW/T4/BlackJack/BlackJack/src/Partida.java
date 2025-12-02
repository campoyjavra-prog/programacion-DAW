import java.util.Scanner;

public class Partida {
    private Jugador jugador;
    private Crupier crupier;
    private Baraja baraja;
    private int dineroJugador;

    // Constructor
    public Partida(String nombreJugador) {
        this.jugador = new Jugador(nombreJugador);
        this.crupier = new Crupier();
        this.baraja = new Baraja();
        this.dineroJugador = 100;  // Dinero inicial del jugador
    }

    // Método para iniciar una nueva ronda
    public void iniciarRonda() {
        baraja.barajar();
        jugador.getMano().clear();  // Limpiar la mano del jugador
        crupier.getMano().clear();  // Limpiar la mano del crupier

        // Repartir dos cartas a cada uno
        jugador.recibirCarta(baraja.repartir());
        crupier.recibirCarta(baraja.repartir());
        jugador.recibirCarta(baraja.repartir());
        crupier.recibirCarta(baraja.repartir());

        // Mostrar la mano del jugador y la del crupier (solo una carta visible)
        jugador.mostrarMano();
        System.out.println("Mano del Crupier: " + crupier.getMano().get(0));  // Solo se muestra la primera carta
    }

    // Método para que el jugador pida una carta
    public void pedirCarta() {
        jugador.recibirCarta(baraja.repartir());
        jugador.mostrarMano();

        if (jugador.obtenerPuntuacion() > 21) {
            System.out.println(jugador.getNombre() + " se ha pasado de 21 puntos. ¡Ha perdido!");
        }
    }

    // Método para que el crupier juegue
    public void jugarCrupier() {
        while (crupier.obtenerPuntuacion() < 17) {
            crupier.recibirCarta(baraja.repartir());
        }
        crupier.mostrarMano();

        if (crupier.obtenerPuntuacion() > 21) {
            System.out.println("El crupier se ha pasado de 21 puntos. ¡" + jugador.getNombre() + " gana!");
        }
    }

    // Método para comparar las manos del jugador y el crupier
    public void compararManos() {
        int puntuacionJugador = jugador.obtenerPuntuacion();
        int puntuacionCrupier = crupier.obtenerPuntuacion();

        if (puntuacionJugador > 21) {
            System.out.println(jugador.getNombre() + " se ha pasado de 21 puntos. ¡Ha perdido!");
        } else if (puntuacionCrupier > 21 || puntuacionJugador > puntuacionCrupier) {
            System.out.println(jugador.getNombre() + " gana la partida!");
            dineroJugador += 10;  // El jugador gana una cantidad (ejemplo 10€)
        } else if (puntuacionJugador < puntuacionCrupier) {
            System.out.println("El crupier gana la partida.");
            dineroJugador -= 10;  // El jugador pierde una cantidad (ejemplo 10€)
        } else {
            System.out.println("Es un empate.");
        }
    }

    // Mostrar el dinero restante del jugador
    public void mostrarDinero() {
        System.out.println("Dinero restante: " + dineroJugador + "€");
    }

    // Método para apostar
    public boolean apostar(int cantidad) {
        if (cantidad > dineroJugador) {
            System.out.println("No tienes suficiente dinero para apostar esa cantidad.");
            return false;
        }
        dineroJugador -= cantidad;  // Se deduce la cantidad apostada
        return true;
    }
}
