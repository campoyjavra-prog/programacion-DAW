package MVC.src.Practica1.controlador;

import java.util.List;

import MVC.src.Practica1.modelo.Persona;
import MVC.src.Practica1.modelo.PersonaDAO;
import MVC.src.Practica1.vista.PersonaView;

public class PersonaController {
    private PersonaDAO personaDAO;
    private PersonaView personaView;

    public PersonaController() {
        personaDAO = new PersonaDAO();
        personaView = new PersonaView();
    }

    public void listarPersonas() {
        List<Persona> personas = personaDAO.listarPersonas();
        personaView.mostrarPersonas(personas);
    }
}
