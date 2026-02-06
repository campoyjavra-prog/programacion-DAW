package Actividad4;

import java.sql.Date;

public class Prueba_Actividad4 {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("    INICIO DE LA DEMOSTRACIÓN ACTIVIDAD 4");
        System.out.println("=========================================");

        // 1. GESTIÓN DE CURSOS
        System.out.println("\n--- 1. GESTIÓN DE CURSOS ---");
        CursoDAO cursoDao = new CursoDAO();
        // Insertar
        System.out.println("[INSERT] Insertando Curso 1: Java Básico...");
        cursoDao.insertar(100, "Java Básico", "Introducción a Java", 40, 150.00);
        System.out.println("[INSERT] Insertando Curso 2: Java Avanzado...");
        cursoDao.insertar(101, "Java Avanzado", "Streams, Lambdas y JDBC", 60, 250.00);
        // Listar
        System.out.println("[SELECT] Listando cursos:");
        cursoDao.listar();

        // 2. GESTIÓN DE PRERREQUISITOS (Relación Recursiva)
        System.out.println("\n--- 2. GESTIÓN DE PRERREQUISITOS ---");
        PrerrequisitoDAO preDao = new PrerrequisitoDAO();
        // Java Avanzado (101) requiere Java Básico (100)
        System.out.println("[INSERT] Estableciendo prerrequisito: Java Avanzado requiere Java Básico...");
        preDao.insertar(101, 100, true);
        // Listar
        System.out.println("[SELECT] Listando prerrequisitos:");
        preDao.listar();

        // 3. GESTIÓN DE EMPLEADOS
        System.out.println("\n--- 3. GESTIÓN DE EMPLEADOS ---");
        EmpleadoDAO empDao = new EmpleadoDAO();
        // Insertar Capacitado (Profesor)
        System.out.println("[INSERT] Insertando empleado capacitado (ID 500)...");
        empDao.insertar(500, "James", "Gosling", "Star", "Sun Microsystems", "555-JAVA", "Capacitado");
        // Insertar No Capacitado (Alumno)
        System.out.println("[INSERT] Insertando empleado alumno (ID 501)...");
        empDao.insertar(501, "Junior", "Dev", "Lopez", "Calle Falsa 123", "666-0000", "No Capacitado");
        // Listar
        System.out.println("[SELECT] Listando empleados:");
        empDao.listar();

        // 4. GESTIÓN DE EDICIONES
        System.out.println("\n--- 4. GESTIÓN DE EDICIONES ---");
        EdicionDAO edicionDao = new EdicionDAO();
        // Insertar Edición del Curso 100, impartida por el empleado 500
        System.out.println("[INSERT] Insertando edición del curso Java Básico...");
        Date fechaInicio = Date.valueOf("2024-03-01");
        Date fechaFin = Date.valueOf("2024-03-31");
        edicionDao.insertar(10, fechaInicio, fechaFin, "Mañanas", "Aula 1", 100, 500);
        // Listar
        System.out.println("[SELECT] Listando ediciones:");
        edicionDao.listar();

        // 5. GESTIÓN DE RELACIÓN RECIBE (Empleado recibe Edición)
        System.out.println("\n--- 5. GESTIÓN DE ASISTENCIA (RECIBE) ---");
        RecibeDAO recibeDao = new RecibeDAO();
        // El empleado 501 asiste a la edición 10
        System.out.println("[INSERT] Empleado 501 recibe edición 10...");
        recibeDao.insertar(501, 10);
        // Listar
        System.out.println("[SELECT] Listando relación recibe:");
        recibeDao.listar();

        // 6. LIMPIEZA DE DATOS (Orden inverso)
        System.out.println("\n--- 6. LIMPIEZA DE DATOS (DELETE) ---");

        System.out.println("[DELETE] Borrando relación recibe...");
        recibeDao.borrar(501, 10);

        System.out.println("[DELETE] Borrando edición 10...");
        edicionDao.borrar(10);

        System.out.println("[DELETE] Borrando empleados...");
        empDao.borrar(501);
        empDao.borrar(500);

        System.out.println("[DELETE] Borrando prerrequisito...");
        preDao.borrar(101, 100);

        System.out.println("[DELETE] Borrando cursos...");
        cursoDao.borrar(101);
        cursoDao.borrar(100);

        System.out.println("\n=========================================");
        System.out.println("       FIN DE LA DEMOSTRACIÓN");
        System.out.println("=========================================");
    }
}
