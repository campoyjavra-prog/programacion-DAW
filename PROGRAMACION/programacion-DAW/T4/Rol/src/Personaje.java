
public class Personaje {

    String nombre;
    int vida;
    int ataque;
    int defensa;

    public Personaje() {}

    public Personaje(String nombre, int vida, int ataque, int defensa) {

        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void atacar(Personaje personaje) {
        int daño = this.ataque - personaje.getDefensa();
        if (daño > 0) {
            personaje.recibirDaño(daño);
        }
    }

    public void recibirDaño(int daño) {
        this.vida -= daño;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }

    @Override
    public String toString() {
        return "Personaje [nombre=" + nombre + ", vida=" + vida + ", ataque=" + ataque + ", defensa=" + defensa + "]";
    }
}