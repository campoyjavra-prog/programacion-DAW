package MVC.src.Practica1.vista;

import java.util.List;

import MVC.src.Practica1.modelo.Persona;

public class PersonaView {
    public void mostrarPersonas(List<Persona> personas) {
        System.out.println("LISTADO DE PERSONAS");
        System.out.println("-------------------");
        for (Persona p : personas) {
            System.out.println(
                    p.getId() + " - " +
                            p.getNombre() + " (" +
                            p.getEmail() + ")");
        }
    }
}
