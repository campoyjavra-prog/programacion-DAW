package Diapositivas.Actividad7.vista;

import Diapositivas.Actividad7.modelo.CursoEscolar;
import java.util.List;

public class CursoEscolarVista {

    public int mostrarMenuCRUD() {
        System.out.println("\n--- GESTIÓN DE CURSOS ESCOLARES ---");
        System.out.println("1. Insertar");
        System.out.println("2. Listar");
        System.out.println("3. Actualizar");
        System.out.println("4. Borrar");
        System.out.println("0. Volver");
        return Consola.leerEntero("Seleccione una opción: ");
    }

    public CursoEscolar pedirDatosCurso() {
        System.out.println("Introduzca datos del Curso Escolar:");
        int id = Consola.leerEntero("ID: ");
        int ini = Consola.leerEntero("Año Inicio: ");
        int fin = Consola.leerEntero("Año Fin: ");
        return new CursoEscolar(id, ini, fin);
    }

    public void mostrarLista(List<CursoEscolar> lista) {
        System.out.println("\n--- LISTADO DE CURSOS ESCOLARES ---");
        if (lista.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        }
        for (CursoEscolar c : lista) {
            System.out.println(c);
        }
    }
}
