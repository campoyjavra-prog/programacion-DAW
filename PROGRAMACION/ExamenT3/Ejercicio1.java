package PROGRAMACION.ExamenT3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Ejercicio1 {
public static void main(String[] args) {
        // Variables temas opositor
        ArrayList<Integer> temasOpositor = new ArrayList<>();
        Collections.addAll(temasOpositor, 4, 11, 23, 34, 35, 36, 39, 50, 60, 65);

        // Vector aleatorio que no se repite
        ArrayList<Integer> vectorAleatorio = generarVectorAleatorio(5, 65);

        // Mostrar el vector aleatorio
        System.out.println("Vector aleatorio: "+vectorAleatorio);

        // Validar y mostrar los temas que coinciden
        ArrayList<Integer> coincidencias = validarVector(temasOpositor, vectorAleatorio);
        if (coincidencias.isEmpty()) {
            System.out.println("No coincide ningun tema.");
        } 
        else {
            System.out.println("Temas que coinciden: "+coincidencias+". Enhorabuena!");
        }
    }

      // genero un vector aleatorio que no se repite
    public static ArrayList<Integer> generarVectorAleatorio(int cantidad, int max) {
        ArrayList<Integer> lista = new ArrayList<>();
        Random aleatorio = new Random();

        while (lista.size() < cantidad) {
            int numero = aleatorio.nextInt(max) + 1; 
                if (!lista.contains(numero)) {
                lista.add(numero);
                }
            }
        return lista;
    }

    //  valido que temas coinciden
    public static ArrayList<Integer> validarVector(ArrayList<Integer> temasOpositor, ArrayList<Integer> vectorAleatorio) {
        ArrayList<Integer> coincidencias = new ArrayList<>();
        for (int tema : vectorAleatorio) {
                if (temasOpositor.contains(tema)) {
                coincidencias.add(tema);
                }
         }
        // ordeno las coincidencias
        Collections.sort(coincidencias);  
        return coincidencias;
    }
}
    

