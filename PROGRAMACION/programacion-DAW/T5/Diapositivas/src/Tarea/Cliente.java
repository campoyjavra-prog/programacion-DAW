package Tarea;

import java.util.ArrayList;

public class Cliente extends Persona {

    private String telefono;
    private ArrayList<Vehiculo> vehiculos;

    public Cliente() {
        super();
        this.vehiculos = new ArrayList<>();
    }

    public Cliente(String DNI, String nombre, String pape, String telefono) {
        super(DNI, nombre, pape);
        this.telefono = telefono;
        this.vehiculos = new ArrayList<>();
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculo(Vehiculo v) {
        this.vehiculos.add(v);
    }
}
