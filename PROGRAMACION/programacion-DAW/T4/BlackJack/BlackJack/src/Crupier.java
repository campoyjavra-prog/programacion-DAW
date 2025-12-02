import java.util.List;
import java.util.ArrayList;

public class Crupier {
    private List<Carta> mano;  // Lista para las cartas del crupier

    // Constructor
    public Crupier() {
        this.mano = new ArrayList<>();
    }

    // Método para añadir una carta a la mano
    public void recibirCarta(Carta carta) {
        mano.add(carta);
    }

    // Método para obtener la mano del crupier
    public List<Carta> getMano() {
        return mano;  // Devuelve la lista de cartas en la mano del crupier
    }

    // Método para obtener la puntuación del crupier
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
            } else if (valor >= 11 && valor <= 13) {
                puntuacion += 10;  // J, Q, K valen 10 puntos
            } else {
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

    // Método para mostrar la mano del crupier
    public void mostrarMano() {
        System.out.println("Mano del Crupier: ");
        for (int i = 0; i < mano.size(); i++) {
            Carta carta = mano.get(i);
            System.out.println(carta);  // Se usa el método toString() de la clase Carta
        }
    }
}