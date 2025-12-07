
class Persona {
    String nombre;
    String dni;
    String fechaNacimiento; // Simplificado a String
    String direccion;
    char genero;
    String estadoCivil;

    public Persona(String nombre, String dni, String fechaNacimiento, String direccion, char genero, String estadoCivil) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
    }

    @Override
    public String toString() {
        return nombre + " (DNI: " + dni + ")";
    }
}

class CuentaCorriente {
    private Persona titular;
    private String numeroCuenta;
    private double saldo;

    public CuentaCorriente(Persona titular, String numeroCuenta, double saldoInicial) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void ingresar(double cantidad) {
        saldo += cantidad;
        System.out.println("Ingresados: " + cantidad + ". Nuevo saldo: " + saldo);
    }

    public void retirar(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
            System.out.println("Retirados: " + cantidad + ". Nuevo saldo: " + saldo);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public void mostrarInformacion() {
        System.out.println("--- Cuenta Corriente ---");
        System.out.println("Titular: " + titular.toString()); // Llama al toString de Persona
        System.out.println("Cuenta: " + numeroCuenta);
        System.out.println("Saldo: " + saldo + " €");
    }
}

public class Actividad1 {
    public static void main(String[] args) {
        Persona p1 = new Persona("Juan Pérez", "12345678Z", "12/05/1990", "Calle Falsa 123", 'M', "Soltero");
        CuentaCorriente cuenta = new CuentaCorriente(p1, "ES99-1234-5678", 1000.50);

        cuenta.mostrarInformacion(); 
        cuenta.ingresar(200);
        cuenta.retirar(50);
    }
}
