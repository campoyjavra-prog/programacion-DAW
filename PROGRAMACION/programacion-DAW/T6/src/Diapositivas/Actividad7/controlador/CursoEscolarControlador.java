package Diapositivas.Actividad7.controlador;

import Diapositivas.Actividad7.modelo.CursoEscolar;
import Diapositivas.Actividad7.modelo.CursoEscolarDAO;
import Diapositivas.Actividad7.vista.CursoEscolarVista;
import Diapositivas.Actividad7.vista.Consola;
import java.util.List;

public class CursoEscolarControlador {
    private CursoEscolarVista vista;
    private CursoEscolarDAO dao;

    public CursoEscolarControlador(CursoEscolarVista vista, CursoEscolarDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void iniciar() {
        int op;
        do {
            op = vista.mostrarMenuCRUD();
            switch (op) {
                case 1:
                    CursoEscolar c = vista.pedirDatosCurso();
                    dao.insertar(c);
                    break;
                case 2:
                    List<CursoEscolar> lista = dao.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    CursoEscolar cUpd = vista.pedirDatosCurso();
                    dao.actualizar(cUpd);
                    break;
                case 4:
                    int id = Consola.leerEntero("ID Curso a borrar: ");
                    dao.borrar(id);
                    break;
                case 0:
                    break;
                default:
                    Consola.mostrarMensaje("Opción no válida.");
            }
        } while (op != 0);
    }
}
