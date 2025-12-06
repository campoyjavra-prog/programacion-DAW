public class Partida {
    private Jugador jugador;
    private Crupier crupier;
    private Baraja baraja;
    private int dineroJugador;
    private int apuesta;

    // Constructor
    public Partida(String nombreJugador) {
        this.jugador = new Jugador(nombreJugador);
        this.crupier = new Crupier();
        this.baraja = new Baraja();
        this.dineroJugador = 100; // Saldo inicial
    }

    // Método para iniciar una nueva ronda
    public void iniciarRonda() {
        baraja.barajar();
        jugador.getMano().clear();
        crupier.getMano().clear();

        // Repartir las cartas
        jugador.recibirCarta(baraja.repartir());
        crupier.recibirCarta(baraja.repartir());
        jugador.recibirCarta(baraja.repartir());
        crupier.recibirCarta(baraja.repartir());

        // Mostrar la mano del jugador y una carta del crupier
        jugador.mostrarMano();
        System.out.println("Mano del Crupier: " + crupier.getMano().get(0));
    }

    // Método para hacer una apuesta
    public boolean apostar(int cantidad) {
        if (cantidad > dineroJugador) {
            System.out.println("No tienes suficiente dinero para apostar esa cantidad.");
            return false;
        }
        apuesta = cantidad;
        dineroJugador -= apuesta; // Deduce la apuesta del dinero disponible
        return true;
    }

    // Método para obtener el dinero del jugador
    public int getDineroJugador() {
        return dineroJugador;
    }

    // Método para obtener el jugador
    public Jugador getJugador() {
        return jugador;
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
        crupier.mostrarMano(); // Mostrar la mano del crupier después de su jugada

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
            dineroJugador += apuesta * 2;  // El jugador gana el doble de lo apostado
        } else if (puntuacionJugador < puntuacionCrupier) {
            System.out.println("El crupier gana la partida.");
        } else {
            System.out.println("Es un empate.");
            dineroJugador += apuesta;  // Se devuelve lo apostado
        }
    }

    // Mostrar el dinero restante del jugador
    public void mostrarDinero() {
        System.out.println("Dinero restante: " + dineroJugador + "€");
    }

    // Obtener el crupier
    public Crupier getCrupier() {
        return crupier;  // Devuelve el crupier
    }

    // Establecer el dinero del jugador
    public void setDineroJugador(int dinero) {
        this.dineroJugador = dinero;  // Establece el dinero del jugador
    }
}