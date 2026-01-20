package actividad20;

public class Coche implements Movible, Sonoro {

    @Override
    public void mover() {
        System.out.println("El coche avanza por la carretera");
    }

    @Override
    public void emitirSonido() {
        System.out.println("El coche toca el claxon: ¡pi-pi!");
    }
}
