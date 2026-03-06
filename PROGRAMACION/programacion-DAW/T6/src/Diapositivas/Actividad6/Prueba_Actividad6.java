package Diapositivas.Actividad6;

import java.sql.Date;

public class Prueba_Actividad6 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("    INICIO DE LA DEMOSTRACIÓN ACTIVIDAD 6");
        System.out.println("=========================================");

        // Instanciar DAOs
        SucursalDAO sucursalDao = new SucursalDAO();
        EmpleadoDAO empDao = new EmpleadoDAO();
        PeriodistaDAO periodistaDao = new PeriodistaDAO();
        RevistaDAO revistaDao = new RevistaDAO();
        SeccionDAO seccionDao = new SeccionDAO();
        EjemplarDAO ejemplarDao = new EjemplarDAO();
        PublicaSucursalRevistaDAO publicaDao = new PublicaSucursalRevistaDAO();
        EscribePeriodistaRevistaDAO escribeDao = new EscribePeriodistaRevistaDAO();

        // 1. INSERCIONES BASE
        System.out.println("\n--- 1. INSERCIÓN DE DATOS BASE ---");

        System.out.println("[INSERT] Sucursal: Sevilla...");
        sucursalDao.insertar(10, "Calle Sierpes", "954123456", "Sevilla", "Sevilla");

        System.out.println("[INSERT] Empleado en Sucursal Sevilla...");
        empDao.insertar(100, "12345678A", "Ana", "García", "López", "600111222", 10);

        System.out.println("[INSERT] Periodista: Carlos Ruiz...");
        periodistaDao.insertar(200, "Carlos", "Ruiz", "Gómez", "611223344", "Deportes");

        System.out.println("[INSERT] Revista: Marca...");
        revistaDao.insertar(300, "Marca", "Deportiva", "Diario");

        // 2. INSERCIONES DE ENTIDADES DEPENDIENTES (SECCIÓN Y EJEMPLAR)
        System.out.println("\n--- 2. INSERCIÓN DE DEPENDENCIAS (SECCIÓN Y EJEMPLAR) ---");

        System.out.println("[INSERT] Sección: Fútbol Español...");
        seccionDao.insertar("Fútbol Español", "10 páginas", 300);

        System.out.println("[INSERT] Ejemplar de hoy...");
        ejemplarDao.insertar(Date.valueOf("2024-02-06"), 32, 50000, 300);

        // 3. RELACIONES N:M
        System.out.println("\n--- 3. CREACIÓN DE RELACIONES N:N ---");

        System.out.println("[INSERT] Sucursal pública Revista...");
        publicaDao.insertar(10, 300);

        System.out.println("[INSERT] Periodista escribe Revista...");
        escribeDao.insertar(200, 300);

        // 4. LISTADOS
        System.out.println("\n--- 4. COMPROBACIÓN (LISTAR) ---");
        System.out.println(">>> Sucursales:");
        sucursalDao.listar();
        System.out.println(">>> Empleados:");
        empDao.listar();
        System.out.println(">>> Revistas:");
        revistaDao.listar();
        System.out.println(">>> Secciones:");
        seccionDao.listar();

        // 5. LIMPIEZA
        // El orden de borrado debe ser inverso a la creación (respetando Foreign Keys)
        System.out.println("\n--- 5. LIMPIEZA (DELETE) ---");

        System.out.println("[DELETE] Relaciones...");
        escribeDao.borrar(200, 300);
        publicaDao.borrar(10, 300);

        System.out.println("[DELETE] Entidades dependientes...");
        ejemplarDao.borrar(Date.valueOf("2024-02-06"), 300);
        seccionDao.borrar("Fútbol Español", 300);

        System.out.println("[DELETE] Entidades base...");
        revistaDao.borrar(300);
        periodistaDao.borrar(200);
        empDao.borrar(100);
        sucursalDao.borrar(10);

        System.out.println("\n=========================================");
        System.out.println("       FIN DE LA DEMOSTRACIÓN");
        System.out.println("=========================================");
    }
}
