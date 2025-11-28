import java.util.Scanner;

public class Juego {
    private Mazo mazo;
    private Jugador jugador;
    private int rondas;

    public Juego(Jugador jugador) {
        this.jugador = jugador;
        this.mazo = new Mazo();
        this.rondas=0;
    }
    public void rondas(){
        rondas++;
    }
    public int getRondas(){
        return this.rondas;
    }

    public void iniciar() {
        Scanner sc = new Scanner(System.in);
        Carta cartaActual = mazo.sacarCarta();
        System.out.println("¡Bienvenido, " + jugador.getNombre() + "!");
        System.out.println("Carta actual: " + cartaActual);
        String opcion;
        do{
            System.out.print("¿Será mayor o menor la próxima carta? (m/M = mayor, n/N = menor, s/S = salir): ");
            opcion = sc.nextLine().toLowerCase();

            if (!opcion.equals("s")){
                Carta siguiente = mazo.sacarCarta();
                System.out.println("Siguiente carta: " + siguiente);

                boolean acierto = compararCartas(cartaActual, siguiente, opcion);
                if (acierto) {
                    System.out.println("¡Correcto!");
                    jugador.sumarPunto();
                } else {
                    System.out.println("Incorrecto.");
                    jugador.restarPunto();
                }

                System.out.println("Puntuación actual: " + jugador.getPuntuacion());
                cartaActual = siguiente;
                System.out.println("-----------------------------");
                //PAsar a la ronda siguiente
            }
        }while(!mazo.estaVacio() && !opcion.equals("s"));

        System.out.println("Juego terminado. Puntuación final: " + jugador.getPuntuacion());
        System.out.println("HAS JUGADO UN TOTAL DE RONDAS: " + rondas);
    }

    private boolean compararCartas(Carta actual, Carta siguiente, String opcion) {
        if (opcion.equals("m")) return siguiente.getValor() > actual.getValor();
        if (opcion.equals("n")) return siguiente.getValor() < actual.getValor();
        return false;
    }
}