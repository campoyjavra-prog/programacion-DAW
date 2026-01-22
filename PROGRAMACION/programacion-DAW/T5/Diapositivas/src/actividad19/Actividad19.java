package actividad19;

import java.util.ArrayList;

public class Actividad19 {

    public static void main(String[] args) {
        // Creamos dos equipos usando ArrayList
        ArrayList<Personaje> equipo1 = new ArrayList<>();
        ArrayList<Personaje> equipo2 = new ArrayList<>();

        // Añadimos personajes al Equipo 1
        equipo1.add(new Guerrero("Guerrero1", 100));
        equipo1.add(new Mago("MAgo1", 80));

        // Añadimos personajes al Equipo 2
        equipo2.add(new Guerrero("Guerrero2", 90));
        equipo2.add(new Mago("Mago2", 85));

        System.out.println("--- ¡COMIENZA LA BATALLA! ---");

        // El bucle sigue mientras ambos equipos tengan al menos un personaje vivo
        while (!equipo1.isEmpty() && !equipo2.isEmpty()) {

            System.out.println("\n--- Nueva Ronda ---");

            // Cogemos al primero de cada equipo para luchar
            Personaje p1 = equipo1.get(0);
            Personaje p2 = equipo2.get(0);

            // Turno del Equipo 1 ataca al Equipo 2
            int daño1 = p1.atacar();
            p2.recibirDaño(daño1);
            System.out.println(p2.getNombre() + " se queda con " + p2.getVida() + " vida.");

            if (!p2.estaVivo()) {
                System.out.println(p2.getNombre() + " ha sido derrotado!");
                equipo2.remove(0); // Lo eliminamos del equipo
            } else {
                // Si p2 sigue vivo, contrataca
                int daño2 = p2.atacar();
                p1.recibirDaño(daño2);
                System.out.println(p1.getNombre() + " se queda con " + p1.getVida() + " vida.");

                if (!p1.estaVivo()) {
                    System.out.println(p1.getNombre() + " ha sido derrotado!");
                    equipo1.remove(0); // Lo eliminamos del equipo
                }
            }
        }

        System.out.println("\n--- FIN DE LA BATALLA ---");
        if (equipo1.isEmpty()) {
            System.out.println("El Equipo 2 ha ganado!");
        } else {
            System.out.println("El Equipo 1 ha ganado!");
        }
    }
}
