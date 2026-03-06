package Diapositivas.Actividad7.controlador;

import Diapositivas.Actividad7.modelo.Profesor;
import Diapositivas.Actividad7.modelo.ProfesorDAO;
import Diapositivas.Actividad7.vista.ProfesorVista;
import Diapositivas.Actividad7.vista.Consola;
import java.util.List;

public class ProfesorControlador {
    private ProfesorVista vista;
    private ProfesorDAO dao;

    public ProfesorControlador(ProfesorVista vista, ProfesorDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void iniciar() {
        int op;
        do {
            op = vista.mostrarMenuCRUD();
            switch (op) {
                case 1:
                    Profesor p = vista.pedirDatosProfesor();
                    dao.insertar(p);
                    break;
                case 2:
                    List<Profesor> lista = dao.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    Profesor pUpd = vista.pedirDatosProfesor();
                    dao.actualizar(pUpd);
                    break;
                case 4:
                    int idBorrar = Consola.leerEntero("ID Profesor a borrar: ");
                    dao.borrar(idBorrar);
                    break;
                case 0:
                    break;
                default:
                    Consola.mostrarMensaje("Opción no válida.");
            }
        } while (op != 0);
    }
}
