package Actividad6;

public class Mamifero extends Vertebrado {

    public Mamifero(String nombre) {
        // Asumimos huesos genéricos o los pasamos
        super(nombre, 200);
    }

    @Override
    public void accion() {
        System.out.println(nombre + " amamanta a sus crías.");
    }
}
