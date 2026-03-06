package Diapositivas.Actividad7.vista;

import java.sql.Date;
import java.util.List;
import Diapositivas.Actividad7.modelo.Alumno;

public class AlumnoVista {

    public int mostrarMenuCRUD() {
        System.out.println("\n--- GESTIÓN DE ALUMNOS ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Borrar");
        System.out.println("0. Volver");
        return Consola.leerEntero("Seleccione una opción: ");
    }

    public Alumno pedirDatosAlumno() {
        System.out.println("Introduzca datos del Alumno:");
        String mat = Consola.leerString("Matrícula: ");
        String nombre = Consola.leerString("Nombre: ");
        String ape1 = Consola.leerString("Apellido1: ");
        String ape2 = Consola.leerString("Apellido2: ");
        String fechaStr = Consola.leerString("Fecha Nacimiento (YYYY-MM-DD): ");
        Date fecha = null;
        try {
            fecha = Date.valueOf(fechaStr);
        } catch (IllegalArgumentException e) {
            Consola.mostrarMensaje("Formato de fecha inválido. Se usará la fecha actual por defecto.");
            fecha = new Date(System.currentTimeMillis());
        }
        String tlf = Consola.leerString("Teléfono: ");
        return new Alumno(mat, nombre, ape1, ape2, fecha, tlf);
    }

    public void mostrarLista(List<Alumno> lista) {
        System.out.println("\n--- LISTADO DE ALUMNOS ---");
        if (lista.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        }
        for (Alumno a : lista) {
            System.out.println(a);
        }
    }
}
