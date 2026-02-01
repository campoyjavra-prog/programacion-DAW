package Actividad7;

public class Ejercicio7 {

    public static void main(String[] args) {

        System.out.println("--- PRUEBA DE VEHÍCULOS ---");

        // Creamos los objetos
        // Podemos usar polimorfismo (Vehiculo v = new Coche...) o directo
        Coche c = new Coche("Toyota");
        Moto m = new Moto("Yamaha");

        // 1. Probamos arrancar (Cada uno lo hace a su manera -> Polimorfismo)
        c.arrancar();
        m.arrancar();

        // 2. Probamos frenar (Usan el código compartido del padre)
        c.frenar();
        m.frenar();
    }
}