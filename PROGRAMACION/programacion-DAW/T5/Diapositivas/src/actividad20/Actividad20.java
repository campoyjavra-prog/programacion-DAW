package actividad20;

public class Actividad20 {

    public static void main(String[] args) {

        // Creamos objetos de los vehiculos
        Coche miCoche = new Coche();
        Barco miBarco = new Barco();
        Avion miAvion = new Avion();

        // 1. Array de Movible
        Movible[] movibles = new Movible[3];
        movibles[0] = miCoche;
        movibles[1] = miBarco;
        movibles[2] = miAvion;

        System.out.println("--- MOVIENDO VEHICULOS ---");
        for (int i = 0; i < movibles.length; i++) {
            movibles[i].mover();
        }

        System.out.println(); // Salto de linea

        // 2. Array de Sonoro
        Sonoro[] sonoros = new Sonoro[3];
        sonoros[0] = miCoche;
        sonoros[1] = miBarco;
        sonoros[2] = miAvion;

        System.out.println("--- EMITIENDO SONIDOS ---");
        for (int i = 0; i < sonoros.length; i++) {
            sonoros[i].emitirSonido();
        }
    }
}
