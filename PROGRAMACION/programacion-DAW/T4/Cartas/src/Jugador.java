public class Jugador {
    private String nombre;
    private int puntuacion;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 10;//Comienza con 10
    }

    public void sumarPunto() {
        this.puntuacion++;
    }
    public void restarPunto() {
        this.puntuacion--;
        if(this.puntuacion <=0) this.puntuacion=0;
    }


    public int getPuntuacion() {
        return this.puntuacion;
    }

    public String getNombre() {
        return this.nombre;
    }
}