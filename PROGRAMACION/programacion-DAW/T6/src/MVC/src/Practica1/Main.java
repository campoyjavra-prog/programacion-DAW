package MVC.src.Practica1;

import MVC.src.Practica1.controlador.PersonaController;

public class Main {
    public static void main(String[] args) {
        PersonaController controller = new PersonaController();
        controller.listarPersonas();
    }
}
