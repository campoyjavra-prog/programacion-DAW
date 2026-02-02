package PROGRAMACION.ExamenT5.Actividad4;

public abstract class Vehiculo implements Parkeable {

    // Atributos
    protected String matricula;
    protected static int plazasOcupadas = 0;

    // Constructor
    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    // Métodos
    @Override
    public void entrar() {
        System.out.println("El vehículo con matrícula " + this.matricula + " ha entrado del parking");
        plazasOcupadas++;
    }

    @Override
    public void salir() {
        System.out.println("El vehículo con matrícula " + this.matricula + " ha salido del parking");
        plazasOcupadas--;
    }

    // Método abstracto
    @Override
    public abstract double calcularPrecio(int horas);

    // Método propio
    public int getPlazasLibres() {
        return plazas - plazasOcupadas;
    }
}
