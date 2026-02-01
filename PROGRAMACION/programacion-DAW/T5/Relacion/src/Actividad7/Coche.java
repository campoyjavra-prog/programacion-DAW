package Actividad7;

public class Coche extends Vehiculo {

    public Coche(String marca) {
        // Llamada obligatoria al constructor del padre
        super(marca);
    }

    @Override
    public void arrancar() {
        System.out.println("El coche " + marca + " arranca girando la llave.");
    }
}
