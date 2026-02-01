package Actividad6;

public class Artropodo extends Invertebrado {

    public Artropodo(String nombre) {
        super(nombre, false); // No suelen tener concha (tienen exoesqueleto)
    }

    @Override
    public void accion() {
        System.out.println(nombre + " camina con sus patas articuladas.");
    }
}
