package RelacionT3;

import java.util.ArrayList;
import java.util.Scanner;

public class Programa9 {
    
    public static void main(String[] args) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        int opcion;
        
        do {
            // Mostrar el menú
            System.out.println("1. Agregar un número");
            System.out.println("2. Eliminar un número");
            System.out.println("3. Mostrar todos los números");
            System.out.println("4. Comprobar si un número está en la lista");
            System.out.println("5. Eliminar todos los números");
            System.out.println("6. Consultar el tamaño de la lista");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");
            
            opcion = teclado.nextInt();
            
            switch (opcion) {
                case 1:
                    agregarNumero(listaNumeros, teclado);
                    break;
                case 2:
                    eliminarNumero(listaNumeros, teclado);
                    break;
                case 3:
                    mostrarNumeros(listaNumeros);
                    break;
                case 4:
                    comprobarNumero(listaNumeros, teclado);
                    break;
                case 5:
                    listaNumeros.clear();
                    System.out.println("Todos los números han sido eliminados.");
                    break;
                case 6:
                    System.out.println("El tamaño de la lista es: " + listaNumeros.size());
                    break;
               
                default:
                    System.out.println("Opción no válida, por favor elige de nuevo.");
            }
        } while (opcion != 7);
        
        teclado.close();
    }

    // Función para agregar un número
    public static void agregarNumero(ArrayList<Integer> lista, Scanner scanner) {
        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();
        
        while (numero < 0) {
            System.out.println("El número no puede ser negativo. Inténtalo de nuevo.");
            System.out.print("Introduce un número: ");
            numero = scanner.nextInt();
        }
        
        lista.add(numero);
        System.out.println("Número agregado.");
    }

    // Función para eliminar un número
    public static void eliminarNumero(ArrayList<Integer> lista, Scanner teclado) {
        System.out.print("Introduce el número que deseas eliminar: ");
        int numero = teclado.nextInt();
        
        // Eliminar todos los números iguales
        lista.removeIf(n -> n == numero);
        System.out.println("Número(s) eliminado(s).");
    }

    // Función para mostrar todos los números
    public static void mostrarNumeros(ArrayList<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.println("Números en la lista:");
            for (int numero : lista) {
                System.out.print(numero + " ");
            }
            System.out.println();
        }
    }

    // Función para comprobar si un número está en la lista
    public static void comprobarNumero(ArrayList<Integer> lista, Scanner teclado) {
        System.out.print("Introduce el número que deseas comprobar: ");
        int numero = teclado.nextInt();
        
        if (lista.contains(numero)) {
            System.out.println("El número " + numero + " está en la lista.");
        } else {
            System.out.println("El número " + numero + " no está en la lista.");
        }
    }
}
