package actividad19;

public class Guerrero extends Personaje {

    public Guerrero(String nombre, int vida) {
        super(nombre, vida);
    }

    @Override
    public int atacar() {
        // daño entre 15 y 25
        int daño = (int) (Math.random() * 11) + 15;
        System.out.println(this.nombre + " ataca con su espada e inflige " + daño + " de daño");
        return daño;
    }
}
