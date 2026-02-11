package Diapositivas.Actividad6.vista;

import java.sql.Date;
import java.util.Scanner;

import Diapositivas.Actividad6.modelo.*;

import java.util.List;

public class Vista {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPrincipal() {
        System.out.println("\n--- GESTIÓN ESCOLAR (MVC) ---");
        System.out.println("1. Gestionar Profesores");
        System.out.println("2. Gestionar Alumnos");
        System.out.println("3. Gestionar Asignaturas");
        System.out.println("4. Gestionar Cursos Escolares");
        System.out.println("5. Gestionar Matrículas");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return leerEntero();
    }

    public int mostrarMenuCRUD(String entidad) {
        System.out.println("\n--- GESTIÓN DE " + entidad.toUpperCase() + " ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Borrar");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opción: ");
        return leerEntero();
    }

    // --- LEER DATOS ---

    public Profesor pedirDatosProfesor() {
        System.out.println("Introduzca datos del Profesor:");
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido1: ");
        String ape1 = scanner.nextLine();
        System.out.print("Apellido2: ");
        String ape2 = scanner.nextLine();
        System.out.print("Especialidad: ");
        String esp = scanner.nextLine();
        System.out.print("Teléfono: ");
        String tlf = scanner.nextLine();
        return new Profesor(id, nombre, ape1, ape2, esp, tlf);
    }

    public Alumno pedirDatosAlumno() {
        System.out.println("Introduzca datos del Alumno:");
        System.out.print("Matrícula: ");
        String mat = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido1: ");
        String ape1 = scanner.nextLine();
        System.out.print("Apellido2: ");
        String ape2 = scanner.nextLine();
        System.out.print("Fecha Nacimiento (YYYY-MM-DD): ");
        Date fecha = Date.valueOf(scanner.nextLine());
        System.out.print("Teléfono: ");
        String tlf = scanner.nextLine();
        return new Alumno(mat, nombre, ape1, ape2, fecha, tlf);
    }

    public Asignatura pedirDatosAsignatura() {
        System.out.println("Introduzca datos de la Asignatura:");
        System.out.print("Código: ");
        String cod = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Horas: ");
        int horas = leerEntero();
        System.out.print("ID Profesor: ");
        int idProf = leerEntero();
        return new Asignatura(cod, nombre, horas, idProf);
    }

    public CursoEscolar pedirDatosCurso() {
        System.out.println("Introduzca datos del Curso Escolar:");
        System.out.print("ID: ");
        int id = leerEntero();
        System.out.print("Año Inicio: ");
        int ini = leerEntero();
        System.out.print("Año Fin: ");
        int fin = leerEntero();
        return new CursoEscolar(id, ini, fin);
    }

    public Matricula pedirDatosMatricula() {
        System.out.println("Introduzca datos de la Matrícula:");
        System.out.print("Ref Alumno (Matrícula): ");
        String ref = scanner.nextLine();
        System.out.print("ID Curso: ");
        int curso = leerEntero();
        System.out.print("Cód Asignatura: ");
        String asig = scanner.nextLine();
        return new Matricula(ref, curso, asig);
    }

    // --- PIDs ---

    public int pedirInt(String mensaje) {
        System.out.print(mensaje);
        return leerEntero();
    }

    public String pedirString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // --- MOSTRAR DATOS ---

    public <T> void mostrarLista(List<T> lista) {
        System.out.println("\n--- LISTADO ---");
        if (lista.isEmpty())
            System.out.println("No hay registros.");
        for (T item : lista) {
            System.out.println(item);
        }
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    // --- UTILIDADES ---

    private int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
