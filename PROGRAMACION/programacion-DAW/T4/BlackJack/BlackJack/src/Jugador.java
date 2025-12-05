
import java.util.List;
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private List<Carta> mano;

    // Constructor
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.mano = new ArrayList<>();
    }

    // Método para añadir una carta a la mano
    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    // Método para obtener la puntuación del jugador
    public int obtenerPuntuacion() {
        int puntuacion = 0;
        int ases = 0;

        // Calcular la puntuación
        for (int i = 0; i < mano.size(); i++) {
            Carta carta = mano.get(i);
            int valor = carta.getValor();
            if (valor == 1) {
                puntuacion += 11;  // El As inicialmente cuenta como 11
                ases++;
            } 
            else if (valor >= 11 && valor <= 13) {
                puntuacion += 10;  // J, Q, K valen 10 puntos
            } 
            else {
                puntuacion += valor;  // Cartas del 2 al 10 valen su valor
            }
        }

        // Ajustar la puntuación si hay Ases (si la puntuación es mayor a 21, un As se convierte en 1)
        while (puntuacion > 21 && ases > 0) {
            puntuacion -= 10;  // Convertir un As de 11 a 1
            ases--;
        }

        return puntuacion;
    }

    // Método para ver la mano del jugador
    public List<Carta> getMano() {
        return mano;
    }

    // Método para mostrar la mano del jugador usando un bucle for tradicional
    public void mostrarMano() {
        System.out.println("Mano de " + nombre + ": ");
        
        // Usamos un bucle for tradicional para recorrer la lista 'mano'
        for (int i = 0; i < mano.size(); i++) {
            Carta carta = mano.get(i);  // Accedemos a cada carta usando el índice 'i'
            System.out.println(carta);  // Se usa el método toString() de la clase Carta
        }
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }
}