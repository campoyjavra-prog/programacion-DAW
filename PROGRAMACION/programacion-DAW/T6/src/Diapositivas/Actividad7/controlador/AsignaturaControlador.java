package Diapositivas.Actividad7.controlador;

import Diapositivas.Actividad7.modelo.Asignatura;
import Diapositivas.Actividad7.modelo.AsignaturaDAO;
import Diapositivas.Actividad7.vista.AsignaturaVista;
import Diapositivas.Actividad7.vista.Consola;
import java.util.List;

public class AsignaturaControlador {
    private AsignaturaVista vista;
    private AsignaturaDAO dao;

    public AsignaturaControlador(AsignaturaVista vista, AsignaturaDAO dao) {
        this.vista = vista;
        this.dao = dao;
    }

    public void iniciar() {
        int op;
        do {
            op = vista.mostrarMenuCRUD();
            switch (op) {
                case 1:
                    Asignatura a = vista.pedirDatosAsignatura();
                    dao.insertar(a);
                    break;
                case 2:
                    List<Asignatura> lista = dao.listar();
                    vista.mostrarLista(lista);
                    break;
                case 3:
                    Asignatura aUpd = vista.pedirDatosAsignatura();
                    dao.actualizar(aUpd);
                    break;
                case 4:
                    String cod = Consola.leerString("Código a borrar: ");
                    dao.borrar(cod);
                    break;
                case 0:
                    break;
                default:
                    Consola.mostrarMensaje("Opción no válida.");
            }
        } while (op != 0);
    }
}
