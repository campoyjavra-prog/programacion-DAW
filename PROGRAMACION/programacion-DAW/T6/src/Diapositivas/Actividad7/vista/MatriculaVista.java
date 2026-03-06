package Diapositivas.Actividad7.vista;

import Diapositivas.Actividad7.modelo.Matricula;
import java.util.List;

public class MatriculaVista {

    public int mostrarMenuCRUD() {
        System.out.println("\n--- GESTIÓN DE MATRÍCULAS ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Borrar");
        System.out.println("0. Volver");
        return Consola.leerEntero("Seleccione una opción: ");
    }

    public Matricula pedirDatosMatricula() {
        System.out.println("Introduzca datos de la Matrícula:");
        String ref = Consola.leerString("Ref Alumno (Matrícula): ");
        int curso = Consola.leerEntero("ID Curso: ");
        String asig = Consola.leerString("Cód Asignatura: ");
        return new Matricula(ref, curso, asig);
    }

    public void mostrarLista(List<Matricula> lista) {
        System.out.println("\n--- LISTADO DE MATRÍCULAS ---");
        if (lista.isEmpty()) {
            System.out.println("No hay matrículas registradas.");
        }
        for (Matricula m : lista) {
            System.out.println(m);
        }
    }
}
