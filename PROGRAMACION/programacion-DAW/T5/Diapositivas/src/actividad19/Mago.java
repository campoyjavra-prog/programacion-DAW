package actividad19;

public class Mago extends Personaje {

    public Mago(String nombre, int vida) {
        super(nombre, vida);
    }

    @Override
    public int atacar() {
        // daño entre 10 y 30 (más variable)
        int daño = (int) (Math.random() * 21) + 10;
        System.out.println(this.nombre + " lanza una bola de fuego e inflige " + daño + " de daño");
        return daño;
    }
}
