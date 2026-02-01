package Actividad6;

public class Ave extends Vertebrado {

    public Ave(String nombre) {
        super(nombre, 100);
    }

    @Override
    public void accion() {
        System.out.println(nombre + " pone huevos y vuela.");
    }
}
