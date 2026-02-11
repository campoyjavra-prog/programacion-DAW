package Diapositivas.Actividad6.controlador;

import java.util.List;

import Diapositivas.Actividad6.modelo.*;
import Diapositivas.Actividad6.vista.Vista;

public class Controlador {
    private Vista vista;
    private ProfesorDAO profesorDAO;
    private AlumnoDAO alumnoDAO;
    private AsignaturaDAO asignaturaDAO;
    private CursoEscolarDAO cursoDAO;
    private MatriculaDAO matriculaDAO;

    public Controlador(Vista vista) {
        this.vista = vista;
        this.profesorDAO = new ProfesorDAO();
        this.alumnoDAO = new AlumnoDAO();
        this.asignaturaDAO = new AsignaturaDAO();
        this.cursoDAO = new CursoEscolarDAO();
        this.matriculaDAO = new MatriculaDAO();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    gestionarProfesores();
                    break;
                case 2:
                    gestionarAlumnos();
                    break;
                case 3:
                    gestionarAsignaturas();
                    break;
                case 4:
                    gestionarCursos();
                    break;
                case 5:
                    gestionarMatriculas();
                    break;
                case 0:
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }

    // --- PROFESORES ---
    private void gestionarProfesores() {
        int op;
        do {
            op = vista.mostrarMenuCRUD("Profesores");
            switch (op) {
                case 1:
                    Profesor p = vista.pedirDatosProfesor();
                    profesorDAO.insertar(p);
                    break;
                case 2:
                    List<Profesor> lista = profesorDAO.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    // Para actualizar pedimos datos nuevos (incluyendo ID existente)
                    Profesor pUpd = vista.pedirDatosProfesor();
                    profesorDAO.actualizar(pUpd);
                    break;
                case 4:
                    int idBorrar = vista.pedirInt("ID Profesor a borrar: ");
                    profesorDAO.borrar(idBorrar);
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }

    // --- ALUMNOS ---
    private void gestionarAlumnos() {
        int op;
        do {
            op = vista.mostrarMenuCRUD("Alumnos");
            switch (op) {
                case 1:
                    Alumno a = vista.pedirDatosAlumno();
                    alumnoDAO.insertar(a);
                    break;
                case 2:
                    List<Alumno> lista = alumnoDAO.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    Alumno aUpd = vista.pedirDatosAlumno();
                    alumnoDAO.actualizar(aUpd);
                    break;
                case 4:
                    String mat = vista.pedirString("Matrícula a borrar: ");
                    alumnoDAO.borrar(mat);
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }

    // --- ASIGNATURAS ---
    private void gestionarAsignaturas() {
        int op;
        do {
            op = vista.mostrarMenuCRUD("Asignaturas");
            switch (op) {
                case 1:
                    Asignatura a = vista.pedirDatosAsignatura();
                    asignaturaDAO.insertar(a);
                    break;
                case 2:
                    List<Asignatura> lista = asignaturaDAO.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    Asignatura aUpd = vista.pedirDatosAsignatura();
                    asignaturaDAO.actualizar(aUpd);
                    break;
                case 4:
                    String cod = vista.pedirString("Código a borrar: ");
                    asignaturaDAO.borrar(cod);
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }

    // --- CURSOS ---
    private void gestionarCursos() {
        int op;
        do {
            op = vista.mostrarMenuCRUD("Cursos Escolares");
            switch (op) {
                case 1:
                    CursoEscolar c = vista.pedirDatosCurso();
                    cursoDAO.insertar(c);
                    break;
                case 2:
                    List<CursoEscolar> lista = cursoDAO.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    CursoEscolar cUpd = vista.pedirDatosCurso();
                    cursoDAO.actualizar(cUpd);
                    break;
                case 4:
                    int id = vista.pedirInt("ID Curso a borrar: ");
                    cursoDAO.borrar(id);
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }

    // --- MATRICULAS ---
    private void gestionarMatriculas() {
        int op;
        do {
            op = vista.mostrarMenuCRUD("Matrículas");
            switch (op) {
                case 1:
                    Matricula m = vista.pedirDatosMatricula();
                    matriculaDAO.insertar(m);
                    break;
                case 2:
                    List<Matricula> lista = matriculaDAO.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    vista.mostrarMensaje("Para actualizar, introduzca los VALORES ANTIGUOS:");
                    Matricula oldM = vista.pedirDatosMatricula();
                    vista.mostrarMensaje("Ahora introduzca los VALORES NUEVOS:");
                    Matricula newM = vista.pedirDatosMatricula();
                    matriculaDAO.actualizar(oldM, newM);
                    break;
                case 4:
                    Matricula mDel = vista.pedirDatosMatricula();
                    matriculaDAO.borrar(mDel);
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }
}
