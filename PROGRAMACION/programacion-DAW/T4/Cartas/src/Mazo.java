import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo() {
        cartas = new ArrayList<>();
        String[] palos = {"Espadas", "Copas", "Bastos", "Oros"};//Alternativa baraja española
        for (String palo : palos) {
            for (int i = 1; i <= 13; i++) {
                cartas.add(new Carta(i, palo));
            }
        }
        barajar();
    }

    public void barajar() {
        Collections.shuffle(cartas);//La alternativa es hacer selección aleatoria
        // for(int i=0;i<20;i++){//Hay que intercambiar cartas aleatorias
        //     int posicion1=(int)(Math.random()*(cartas.size()));
        //     int posicion2=(int)(Math.random()*(cartas.size()));
        //     Carta aux=cartas.get(posicion1);
        //     cartas.set(posicion1,cartas.get(posicion2));
        //     cartas.set(posicion2,aux);
        // }
    }

    public Carta sacarCarta() {
        if (cartas.isEmpty()) return null;
        return cartas.remove(0);//Devuelve la primera del mazo
    }

    public boolean estaVacio() {
        return cartas.isEmpty();
    }
}

