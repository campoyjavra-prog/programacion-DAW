package actividad19;

public abstract class Personaje {
    protected String nombre;
    protected int vida;

    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = vida;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    // Devuelve true si la vida es mayor que 0
    public boolean estaVivo() {
        return vida > 0;
    }

    // Resta vida al personaje
    public void recibirDaño(int daño) {
        this.vida -= daño;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    // Método abstracto: cada tipo de personaje ataca de forma diferente
    // Devuelve la cantidad de daño que hace
    public abstract int atacar();

    @Override
    public String toString() {
        return nombre + " (Vida: " + vida + ")";
    }
}
