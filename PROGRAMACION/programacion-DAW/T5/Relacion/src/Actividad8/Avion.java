package Actividad8;

import Actividad7.Vehiculo;

public class Avion extends Vehiculo implements Volador {

    public Avion(String marca) {
        super(marca);
    }

    @Override
    public void arrancar() {
        System.out.println("El avión " + marca + " enciende turbinas.");
    }

    @Override
    public void volar() {
        System.out.println("El avión " + marca + " despega y vuela alto.");
    }
}