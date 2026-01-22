package actividad18;

public class Actividad18 {

    public static void main(String[] args) {
        System.out.println("--- GESTIÓN DE VEHÍCULOS ---");

        // Guardamos las hijas en referencias del padre
        Vehiculo v1 = new Coche("1234-BBB");
        Vehiculo v2 = new Moto("5678-CZZ");
        Vehiculo v3 = new Camion("9012-DXX");

        // Mostramos la información usando el método común
        v1.mostrarInfo();
        v2.mostrarInfo();
        v3.mostrarInfo();

        // Comprobación extra tipo array
        System.out.println("\n--- Recorriendo Array de Vehículos ---");
        Vehiculo[] flota = { v1, v2, v3 };

        for (Vehiculo v : flota) {
            System.out.println("Matrícula: " + v.matricula + " es un " + v.getClass().getSimpleName());
        }
    }
}
