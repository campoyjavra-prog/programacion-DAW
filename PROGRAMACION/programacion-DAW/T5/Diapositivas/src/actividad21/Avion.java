package actividad21;

public class Avion implements Movible, Sonoro {

    @Override
    public void mover() {
        System.out.println("El avión vuela por el cielo");
    }

    @Override
    public void emitirSonido() {
        System.out.println("El avión hace ruido de motores: ¡Vroooom!");
    }
}
