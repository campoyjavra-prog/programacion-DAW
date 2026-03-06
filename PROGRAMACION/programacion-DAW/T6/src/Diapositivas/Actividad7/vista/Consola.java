package Diapositivas.Actividad7.vista;

import java.util.Scanner;

public class Consola {
    private static Scanner scanner = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static String leerString(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public static void mostrarMensaje(String msg) {
        System.out.println(msg);
    }
}
