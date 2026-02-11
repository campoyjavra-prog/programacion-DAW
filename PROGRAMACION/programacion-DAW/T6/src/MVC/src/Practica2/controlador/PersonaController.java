package MVC.src.Practica2.controlador;

import MVC.src.Practica2.modelo.PersonaDAO;
import MVC.src.Practica2.vista.PersonaView;

public class PersonaController {
    private PersonaDAO dao;
    private PersonaView view;

    public PersonaController() {
        dao = new PersonaDAO();
        view = new PersonaView();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = view.mostrarMenu();
            switch (opcion) {
                case 1:
                    view.mostrarPersonas(dao.listar());
                    break;
                case 2: {
                    dao.insertar(view.pedirNuevaPersona());
                    view.mostrarMensaje("Persona insertada");
                    break;
                }
                case 3: {
                    dao.actualizar(view.pedirPersonaActualizar());
                    view.mostrarMensaje("Persona actualizada");
                    break;
                }
                case 4: {
                    dao.eliminar(view.pedirIdEliminar());
                    view.mostrarMensaje("Persona eliminada");
                }
                case 0:
                    view.mostrarMensaje("Saliendo...");
                    break;
                default:
                    view.mostrarMensaje("Opción incorrecta");
                    break;
            }
        } while (opcion != 0);
    }
}