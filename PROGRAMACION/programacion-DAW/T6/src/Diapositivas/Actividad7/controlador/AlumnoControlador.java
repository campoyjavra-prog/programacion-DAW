package Diapositivas.Actividad7.controlador;

import Diapositivas.Actividad7.modelo.Alumno;
import Diapositivas.Actividad7.modelo.AlumnoDAO;
import Diapositivas.Actividad7.vista.AlumnoVista;
import Diapositivas.Actividad7.vista.Consola;
import java.util.List;

public class AlumnoControlador {
    private AlumnoVista vista;
    private AlumnoDAO dao;

    public AlumnoControlador(AlumnoVista vista, AlumnoDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void iniciar() {
        int op;
        do {
            op = vista.mostrarMenuCRUD();
            switch (op) {
                case 1:
                    Alumno a = vista.pedirDatosAlumno();
                    dao.insertar(a);
                    break;
                case 2:
                    List<Alumno> lista = dao.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    Alumno aUpd = vista.pedirDatosAlumno();
                    dao.actualizar(aUpd);
                    break;
                case 4:
                    String mat = Consola.leerString("Matrícula a borrar: ");
                    dao.borrar(mat);
                    break;
                case 0:
                    break;
                default:
                    Consola.mostrarMensaje("Opción no válida.");
            }
        } while (op != 0);
    }
}
