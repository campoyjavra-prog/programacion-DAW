package Diapositivas.Actividad7.controlador;

import Diapositivas.Actividad7.vista.*;
import Diapositivas.Actividad7.modelo.*;

public class MainControlador {

    private MainVista mainVista;

    // Controladores específicos
    private ProfesorControlador profesorControlador;
    private AlumnoControlador alumnoControlador;
    private AsignaturaControlador asignaturaControlador;
    private CursoEscolarControlador cursoControlador;
    private MatriculaControlador matriculaControlador;

    public MainControlador(MainVista mainVista) {
        this.mainVista = mainVista;

        // Inicializamos hijos con sus vistas y DAOs correspondientes
        this.profesorControlador = new ProfesorControlador(new ProfesorVista(), new ProfesorDAO());
        this.alumnoControlador = new AlumnoControlador(new AlumnoVista(), new AlumnoDAO());
        this.asignaturaControlador = new AsignaturaControlador(new AsignaturaVista(), new AsignaturaDAO());
        this.cursoControlador = new CursoEscolarControlador(new CursoEscolarVista(), new CursoEscolarDAO());
        this.matriculaControlador = new MatriculaControlador(new MatriculaVista(), new MatriculaDAO());
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = mainVista.mostrarMenuPrincipal();
            switch (opcion) {
                case 1:
                    profesorControlador.iniciar();
                    break;
                case 2:
                    alumnoControlador.iniciar();
                    break;
                case 3:
                    asignaturaControlador.iniciar();
                    break;
                case 4:
                    cursoControlador.iniciar();
                    break;
                case 5:
                    matriculaControlador.iniciar();
                    break;
                case 0:
                    Consola.mostrarMensaje("Saliendo de Gestión Escolar...");
                    break;
                default:
                    Consola.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
