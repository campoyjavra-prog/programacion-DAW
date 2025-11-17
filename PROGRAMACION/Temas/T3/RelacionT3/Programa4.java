package RelacionT3;

import java.util.Scanner;

public class Programa4 {
    public static void main(String[] args) {
        // Array con los valores correctos de la bonoloto
        int[] bonoloto = {3, 8, 14, 21, 28, 33};

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner teclado = new Scanner(System.in);
        
        // Solicitar al usuario que ingrese su número
        System.out.print("Introduce tu número: ");
        int numeroUsuario = teclado.nextInt();

        // Verificar si el número está en el array de bonoloto
        boolean esValido = false;
        for (int i = 0; i < bonoloto.length; i++) {
            if (bonoloto[i] == numeroUsuario) {
                esValido = true;
                break;
            }
        }

        // Mostrar el resultado de la validación
        if (esValido) {
            System.out.println("¡Número correcto! Has acertado.");
        } else {
            System.out.println("Número incorrecto.");
        }
    }
}
