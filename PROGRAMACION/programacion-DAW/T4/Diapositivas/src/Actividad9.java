import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Carta {
    int valor; // 1 al 12
    String palo;

    public Carta(int valor, String palo) {
        this.valor = valor;
        this.palo = palo;
    }

    @Override
    public String toString() { return valor + " de " + palo; }
}

class Mazo {
    List<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
        // Crear las 48 cartas (12x4)
        for (String p : palos) {
            for (int i = 1; i <= 12; i++) {
                cartas.add(new Carta(i, p));
            }
        }
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public Carta sacarCarta() {
        if (!estaVacio()) {
            return cartas.remove(0); // Saca la de arriba
        }
        return null;
    }

    public boolean estaVacio() { return cartas.isEmpty(); }
}

class Jugador {
    String nombre;
    int puntuacion;

    public Jugador(String n) {
        this.nombre = n;
        this.puntuacion = 10; // Comienza con 10
    }
}

public class Actividad9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mazo mazo = new Mazo();
        mazo.barajar();
        
        Jugador jugador = new Jugador("Estudiante");
        
        System.out.println("--- JUEGO DEL ADIVINO ---");
        
        Carta cartaActual = mazo.sacarCarta();
        System.out.println("Carta actual: " + cartaActual);

        while (!mazo.estaVacio() && jugador.puntuacion > 0) {
            System.out.print("¿La siguiente será MAYOR (+) o MENOR (-)? (o 'salir'): ");
            String apuesta = scanner.next();
            
            if (apuesta.equals("salir")) break;

            Carta siguienteCarta = mazo.sacarCarta();
            System.out.println("Ha salido: " + siguienteCarta);

            boolean acerto = false;
            if (apuesta.equals("+") && siguienteCarta.valor > cartaActual.valor) acerto = true;
            if (apuesta.equals("-") && siguienteCarta.valor < cartaActual.valor) acerto = true;

            if (acerto) {
                System.out.println("¡Correcto! Ganas 1 punto.");
                jugador.puntuacion++;
            } else {
                System.out.println("Fallaste. Pierdes 1 punto.");
                jugador.puntuacion--;
            }
            
            System.out.println("Puntuación actual: " + jugador.puntuacion);
            cartaActual = siguienteCarta; // La nueva pasa a ser la actual
        }

        System.out.println("Fin del juego. Puntuación final: " + jugador.puntuacion);
        scanner.close();
    }
}