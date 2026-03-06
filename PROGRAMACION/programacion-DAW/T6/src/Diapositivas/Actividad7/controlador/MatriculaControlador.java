package Diapositivas.Actividad7.controlador;

import Diapositivas.Actividad7.modelo.Matricula;
import Diapositivas.Actividad7.modelo.MatriculaDAO;
import Diapositivas.Actividad7.vista.MatriculaVista;
import Diapositivas.Actividad7.vista.Consola;
import java.util.List;

public class MatriculaControlador {
    private MatriculaVista vista;
    private MatriculaDAO dao;

    public MatriculaControlador(MatriculaVista vista, MatriculaDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void iniciar() {
        int op;
        do {
            op = vista.mostrarMenuCRUD();
            switch (op) {
                case 1:
                    Matricula m = vista.pedirDatosMatricula();
                    dao.insertar(m);
                    break;
                case 2:
                    List<Matricula> lista = dao.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    Consola.mostrarMensaje("Para actualizar, introduzca los VALORES ANTIGUOS:");
                    Matricula oldM = vista.pedirDatosMatricula();
                    Consola.mostrarMensaje("Ahora introduzca los VALORES NUEVOS:");
                    Matricula newM = vista.pedirDatosMatricula();
                    dao.actualizar(oldM, newM);
                    break;
                case 4:
                    Matricula mDel = vista.pedirDatosMatricula();
                    dao.borrar(mDel);
                    break;
                case 0:
                    break;
                default:
                    Consola.mostrarMensaje("Opción no válida.");
            }
        } while (op != 0);
    }
}
