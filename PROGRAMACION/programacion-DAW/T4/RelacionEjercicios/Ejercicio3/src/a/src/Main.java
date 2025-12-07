package a.src;

// ------------------- CLASE PRINCIPAL (MAIN) -------------------

public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE GESTIÓN COMERCIAL ===\n");

        // 1. Creación de una FÁBRICA
        Fabrica fabricaTech = new Fabrica("30-12345678-9", "TechWorld Industries", "Japón", 500, "Sr. Miyagi");
        System.out.println("Creada: " + fabricaTech.toString());

        // 2. Creación de PRODUCTOS (asociados a la fábrica)
        Producto prod1 = new Producto(101, "Laptop Gamer", "Negro", 800.00, fabricaTech);
        Producto prod2 = new Producto(102, "Mouse Inalámbrico", "Rojo", 20.00, fabricaTech);

        // 3. Creación de una SUCURSAL
        Sucursal sucursalCentro = new Sucursal(1, "Av. Siempre Viva 123", "Madrid");

        // 4. Agregamos productos a la sucursal (Relación 'vende')
        sucursalCentro.agregarProductoStock(prod1);
        sucursalCentro.agregarProductoStock(prod2);

        // 5. Creación de un EMPLEADO con Domicilio compuesto
        Domicilio domEmpleado = new Domicilio("Calle Falsa", 123, "Madrid");
        Empleado emp1 = new Empleado(555, "12345678X", "Juan Pérez", domEmpleado);
        emp1.agregarTelefono("600111222"); // Teléfono multivaluado

        // 6. Asignar Empleado a Sucursal (Relación 'trabaja' con atributos día y horario)
        sucursalCentro.contratarEmpleado(emp1, "09:00 a 18:00", "Lunes a Viernes");

        System.out.println("\n------------------------------------------------");

        // 7. Creación de un CLIENTE
        Cliente cliente1 = new Cliente(99, "Ana García", "Madrid", "87654321Z", "15/05/1990");

        // 8. Creación de TARJETA y asignación al cliente (Relación 'utiliza')
        Tarjeta tarjeta1 = new Tarjeta("4000-1234-5678-9010", "Ana García", 123, "12/28");
        cliente1.agregarTarjeta(tarjeta1);
        
        System.out.println("Cliente registrado: " + cliente1.getNombre());
        System.out.println("Medio de pago: " + cliente1.getMisTarjetas().get(0).toString());

        System.out.println("------------------------------------------------\n");

        // 9. Realizar la operación de COMPRA (Cliente compra en Sucursal un Producto)
        cliente1.comprar(sucursalCentro, prod1, 50.00);
        
        System.out.println("\n=== FIN DE LA EJECUCIÓN ===");
    }
}