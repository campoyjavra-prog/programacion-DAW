import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    private List<Carta> cartas;

    // Constructor que genera la baraja
    public Baraja() {
        this.cartas = new ArrayList<>();
        // Los palos vienen del enum Palo
        Palo[] palos = Palo.values(); // Esto obtiene todos los valores del enum Palo
        
        // Crear las cartas de la baraja
        for (int i = 0; i < palos.length; i++) {
            Palo palo = palos[i];  // Accede al palo usando el índice
            for (int j = 1; j <= 13; j++) {
                cartas.add(new Carta(palo, j));  // Crear cartas del 1 al 13 (A, 2-10, J, Q, K)
            }
        }
    }

    // Método para barajar las cartas
    public void barajar() {
        Collections.shuffle(cartas);  // Mezcla aleatoriamente las cartas
    }

    // Método para repartir una carta
    public Carta repartir() {
        if (cartas.isEmpty()) return null;  // Si ya no hay cartas, devuelve null
        return cartas.remove(0);  // Devuelve y elimina la primera carta
    }

    // Método para ver cuántas cartas quedan en la baraja
    public int cartasRestantes() {
        return cartas.size();
    }
}
