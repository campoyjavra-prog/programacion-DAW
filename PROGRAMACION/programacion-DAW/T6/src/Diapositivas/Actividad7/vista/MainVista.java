package Diapositivas.Actividad7.vista;

public class MainVista {

    public int mostrarMenuPrincipal() {
        System.out.println("\n--- GESTIÓN ESCOLAR (MVC SEPARADO) ---");
        System.out.println("1. Gestionar Profesores");
        System.out.println("2. Gestionar Alumnos");
        System.out.println("3. Gestionar Asignaturas");
        System.out.println("4. Gestionar Cursos Escolares");
        System.out.println("5. Gestionar Matrículas");
        System.out.println("0. Salir");
        return Consola.leerEntero("Seleccione una opción: ");
    }
}
