package actividad21;

public class Barco implements Movible, Sonoro {

    @Override
    public void mover() {
        System.out.println("El barco navega por el mar");
    }

    @Override
    public void emitirSonido() {
        System.out.println("El barco hace sonar la bocina: ¡Buuuu!");
    }
}
