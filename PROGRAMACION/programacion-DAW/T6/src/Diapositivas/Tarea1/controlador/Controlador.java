package Diapositivas.Tarea1.controlador;

import Diapositivas.Tarea1.modelo.*;
import Diapositivas.Tarea1.vista.Vista;

public class Controlador {
    private Vista vista;
    private AlumnoDAO alumnoDAO;
    private ProfesorDAO profesorDAO;
    private PracticaDAO practicaDAO;
    private Examen_TeoricoDAO examenDAO;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.alumnoDAO = new AlumnoDAO();
        this.profesorDAO = new ProfesorDAO();
        this.practicaDAO = new PracticaDAO();
        this.examenDAO = new Examen_TeoricoDAO();
    }

    public void iniciar() {
        int opcion;
        try {
            do {
                opcion = vista.mostrarMenuPrincipal();
                switch (opcion) {
                    case 1:
                        gestionarAlumnos();
                        break;
                    case 2:
                        gestionarProfesores();
                        break;
                    case 3:
                        gestionarPracticas();
                        break;
                    case 4:
                        gestionarExamenes();
                        break;
                    case 0:
                        vista.mostrarMensaje("Saliendo...");
                        break;
                    default:
                        vista.mostrarMensaje("Opción incorrecta");
                        break;
                }
            } while (opcion != 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void gestionarAlumnos() {
        int op = vista.mostrarMenuCRUD("Alumnos");
        switch (op) {
            case 1: // Insertar
                alumnoDAO.insertar(vista.pedirDatosAlumno());
                vista.mostrarMensaje("Alumno insertado");
                break;
            case 2: // Listar
                vista.mostrarAlumnos(alumnoDAO.listar());
                vista.mostrarMensaje("Listar el contenido de Alumnos...");
                break;
            case 3: // Actualizar
                vista.mostrarMensaje("Introduzca los nuevos datos:");
                alumnoDAO.actualizar(vista.pedirDatosAlumno());
                vista.mostrarMensaje("Alumno actualizado");
                break;
            case 4: // Borrar
                alumnoDAO.borrar(vista.pedirIdEliminar("Alumno"));
                vista.mostrarMensaje("Alumno eliminado");
                break;
            case 0:
                break;
            default:
                vista.mostrarMensaje("Opción incorrecta");
                break;
        }
    }

    private void gestionarProfesores() {
        int op = vista.mostrarMenuCRUD("Profesores");
        switch (op) {
            case 1: // Insertar
                profesorDAO.insertar(vista.pedirDatosProfesor());
                vista.mostrarMensaje("Profesor insertado");
                break;
            case 2: // Listar
                vista.mostrarProfesores(profesorDAO.listar());
                vista.mostrarMensaje("Listar el contenido de Profesores...");
                break;
            case 3: // Actualizar
                vista.mostrarMensaje("Introduzca los nuevos datos:");
                profesorDAO.actualizar(vista.pedirDatosProfesor());
                vista.mostrarMensaje("Profesor actualizado");
                break;
            case 4: // Borrar
                profesorDAO.borrar(vista.pedirIdEliminar("Profesor"));
                vista.mostrarMensaje("Profesor eliminado");
                break;
            case 0:
                break;
            default:
                vista.mostrarMensaje("Opción incorrecta");
                break;
        }
    }

    private void gestionarPracticas() {
        int op = vista.mostrarMenuCRUD("Prácticas");
        switch (op) {
            case 1: // Insertar
                practicaDAO.insertar(vista.pedirDatosPractica());
                vista.mostrarMensaje("Práctica insertada");
                break;
            case 2: // Listar
                vista.mostrarPracticas(practicaDAO.listar());
                vista.mostrarMensaje("Listar el contenido de Prácticas...");
                break;
            case 3: // Actualizar
                vista.mostrarMensaje("Introduzca los nuevos datos:");
                practicaDAO.actualizar(vista.pedirDatosPractica());
                vista.mostrarMensaje("Práctica actualizada");
                break;
            case 4: // Borrar
                practicaDAO.borrar(vista.pedirIdEliminar("Práctica"));
                vista.mostrarMensaje("Práctica eliminada");
                break;
            case 0:
                break;
            default:
                vista.mostrarMensaje("Opción incorrecta");
                break;
        }
    }

    private void gestionarExamenes() {
        int op = vista.mostrarMenuCRUD("Exámenes Teóricos");
        switch (op) {
            case 1: // Insertar
                examenDAO.insertar(vista.pedirDatosExamenTeorico());
                vista.mostrarMensaje("Examen insertado");
                break;
            case 2: // Listar
                vista.mostrarExamenes(examenDAO.listar());
                vista.mostrarMensaje("Listar el contenido de Exámenes...");
                break;
            case 3: // Actualizar
                vista.mostrarMensaje("Introduzca los nuevos datos:");
                examenDAO.actualizar(vista.pedirDatosExamenTeorico());
                vista.mostrarMensaje("Examen actualizado");
                break;
            case 4: // Borrar
                examenDAO.borrar(vista.pedirIdEliminar("Examen"));
                vista.mostrarMensaje("Examen eliminado");
                break;
            case 0:
                break;
            default:
                vista.mostrarMensaje("Opción incorrecta");
                break;
        }
    }
}
