public class Main {
    public static void main(String[] args) {
        Jugador jugador = new Jugador("Jugador 1");
        Juego juego = new Juego(jugador);
        juego.iniciar();
    }
}
