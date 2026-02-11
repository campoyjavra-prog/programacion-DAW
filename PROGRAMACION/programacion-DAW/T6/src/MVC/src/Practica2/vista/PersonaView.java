package MVC.src.Practica2.vista;

import java.util.List;
import java.util.Scanner;

import MVC.src.Practica2.modelo.Persona;

public class PersonaView {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ PERSONAS ---");
        System.out.println("1. Listar personas");
        System.out.println("2. Insertar persona");
        System.out.println("3. Actualizar persona");
        System.out.println("4. Eliminar persona");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return sc.nextInt();
    }

    public void mostrarPersonas(List<Persona> personas) {
        System.out.println("\nLISTADO:");
        for (Persona p : personas) {
            System.out.println(p.getId() + " - " + p.getNombre() + " - " + p.getEmail());
        }
    }

    public Persona pedirNuevaPersona() {
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        return new Persona(0, nombre, email);
    }

    public Persona pedirPersonaActualizar() {
        System.out.print("ID a modificar: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Nuevo email: ");
        String email = sc.nextLine();
        return new Persona(id, nombre, email);
    }

    public int pedirIdEliminar() {
        System.out.print("ID a eliminar: ");
        return sc.nextInt();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
