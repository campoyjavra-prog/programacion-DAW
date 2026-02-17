package Diapositivas.Tarea1.vista;

import java.util.List;
import java.util.Scanner;
import Diapositivas.Tarea1.modelo.*;

public class Vista {
    private Scanner sc = new Scanner(System.in);

    // --- MENÚS ---
    public int mostrarMenuPrincipal() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Gestionar Alumnos");
        System.out.println("2. Gestionar Profesores");
        System.out.println("3. Gestionar Prácticas");
        System.out.println("4. Gestionar Exámenes Teóricos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public int mostrarMenuCRUD(String entidad) {
        System.out.println("\n--- GESTIÓN DE " + entidad.toUpperCase() + " ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Borrar");
        System.out.println("0. Volver");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public Alumno pedirDatosAlumno() {
        System.out.println("Datos del Alumno:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Grupo: ");
        String grupo = sc.nextLine();
        System.out.print("NIF: ");
        int nif = sc.nextInt();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido1: ");
        String ape1 = sc.nextLine();
        System.out.print("Apellido2: ");
        String ape2 = sc.nextLine();
        return new Alumno(id, grupo, nif, nombre, ape1, ape2);
    }

    public Profesor pedirDatosProfesor() {
        System.out.println("Datos del Profesor:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("NIF: ");
        int nif = sc.nextInt();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido1: ");
        String ape1 = sc.nextLine();
        System.out.print("Apellido2: ");
        String ape2 = sc.nextLine();
        return new Profesor(id, nif, nombre, ape1, ape2);
    }

    public Practica pedirDatosPractica() {
        System.out.println("Datos de la Práctica:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Dificultad: ");
        String dificultad = sc.nextLine();
        return new Practica(id, titulo, dificultad);
    }

    public Examen_Teorico pedirDatosExamenTeorico() {
        System.out.println("Datos del Examen Teórico:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Título: ");
        String titulo = sc.nextLine();
        System.out.print("Fecha: ");
        String fecha = sc.nextLine();
        System.out.print("Num. Preguntas: ");
        int num = sc.nextInt();
        return new Examen_Teorico(id, titulo, fecha, num);
    }

    public int pedirInt(String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    // --- MOSTRAR LISTAS ---

    public void mostrarAlumnos(List<Alumno> lista) {
        System.out.println("\n--- LISTA DE ALUMNOS ---");
        if (lista.isEmpty())
            System.out.println("No hay alumnos.");
        for (Alumno a : lista) {
            System.out.println(a);
        }
    }

    public void mostrarProfesores(List<Profesor> lista) {
        System.out.println("\n--- LISTA DE PROFESORES ---");
        if (lista.isEmpty())
            System.out.println("No hay profesores.");
        for (Profesor p : lista) {
            System.out.println(p);
        }
    }

    public void mostrarPracticas(List<Practica> lista) {
        System.out.println("\n--- LISTA DE PRÁCTICAS ---");
        if (lista.isEmpty())
            System.out.println("No hay prácticas.");
        for (Practica p : lista) {
            System.out.println(p);
        }
    }

    public void mostrarExamenes(List<Examen_Teorico> lista) {
        System.out.println("\n--- LISTA DE EXÁMENES TEÓRICOS ---");
        if (lista.isEmpty())
            System.out.println("No hay exámenes.");
        for (Examen_Teorico e : lista) {
            System.out.println(e);
        }
    }

    public int pedirIdEliminar(String entidad) {
        System.out.print("Introduzca ID de " + entidad + " a eliminar: ");
        return sc.nextInt();
    }
}
