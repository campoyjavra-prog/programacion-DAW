package Diapositivas.Actividad7.vista;

import Diapositivas.Actividad7.modelo.Asignatura;
import java.util.List;

public class AsignaturaVista {

    public int mostrarMenuCRUD() {
        System.out.println("\n--- GESTIÓN DE ASIGNATURAS ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Borrar");
        System.out.println("0. Volver");
        return Consola.leerEntero("Seleccione una opción: ");
    }

    public Asignatura pedirDatosAsignatura() {
        System.out.println("Introduzca datos de la Asignatura:");
        String cod = Consola.leerString("Código: ");
        String nombre = Consola.leerString("Nombre: ");
        int horas = Consola.leerEntero("Horas: ");
        int idProf = Consola.leerEntero("ID Profesor: ");
        return new Asignatura(cod, nombre, horas, idProf);
    }

    public void mostrarLista(List<Asignatura> lista) {
        System.out.println("\n--- LISTADO DE ASIGNATURAS ---");
        if (lista.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
        }
        for (Asignatura a : lista) {
            System.out.println(a);
        }
    }
}
