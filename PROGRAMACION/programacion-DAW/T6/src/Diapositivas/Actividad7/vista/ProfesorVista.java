package Diapositivas.Actividad7.vista;

import Diapositivas.Actividad7.modelo.Profesor;
import java.util.List;

public class ProfesorVista {

    public int mostrarMenuCRUD() {
        System.out.println("\n--- GESTIÓN DE PROFESORES ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Borrar");
        System.out.println("0. Volver");
        return Consola.leerEntero("Seleccione una opción: ");
    }

    public Profesor pedirDatosProfesor() {
        System.out.println("Introduzca datos del Profesor:");
        int id = Consola.leerEntero("ID: ");
        String nombre = Consola.leerString("Nombre: ");
        String ape1 = Consola.leerString("Apellido1: ");
        String ape2 = Consola.leerString("Apellido2: ");
        String esp = Consola.leerString("Especialidad: ");
        String tlf = Consola.leerString("Teléfono: ");
        return new Profesor(id, nombre, ape1, ape2, esp, tlf);
    }

    public void mostrarLista(List<Profesor> lista) {
        System.out.println("\n--- LISTADO DE PROFESORES ---");
        if (lista.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        }
        for (Profesor p : lista) {
            System.out.println(p);
        }
    }
}
