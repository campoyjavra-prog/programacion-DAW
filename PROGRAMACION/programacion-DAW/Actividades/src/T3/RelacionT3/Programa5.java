package RelacionT3;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa5 {
    public static void main(String[] args) {
        // Crear un ArrayList con los valores correctos de la bonoloto
       ArrayList<Integer> bonoloto = new ArrayList<>();
       bonoloto.add(3);
       bonoloto.add(8);
       bonoloto.add(14);
       bonoloto.add(21);
       bonoloto.add(28);
       bonoloto.add(33);


       // Crear un objeto Scanner para leer la entrada del usuario
       Scanner teclado = new Scanner(System.in);
      
       // Solicitar al usuario que ingrese su número
       System.out.print("Introduce tu número: ");
       int numeroUsuario = teclado.nextInt();


       // Verificar si el número está en el ArrayList de bonoloto
       if (bonoloto.contains(numeroUsuario)) {
           System.out.println("¡Número correcto! Has acertado.");
       } else {
           System.out.println("Número incorrecto.");
       }

    }
}
