package Actividad5;

import java.util.ArrayList;

public class Ejercicio5 {

    public static void main(String[] args) {

        // Creamos la lista del tipo PADRE
        ArrayList<Producto> listaProductos = new ArrayList<>();

        // Añadimos hijos mezclados (Polimorfismo)
        listaProductos.add(new Perecedero("Yogur", 1.20, 1));
        listaProductos.add(new NoPerecedero("Arroz", 2.50, "Grano"));
        listaProductos.add(new Perecedero("Leche", 1.50, 3));

        System.out.println("--- LISTA DE PRODUCTOS ---");

        // Recorremos la lista
        for (Producto p : listaProductos) {
            System.out.println(p.toString());

            // Calculamos precio para 5 unidades
            double total = p.calcular(5);
            System.out.println("Precio total por 5 unidades: " + total + "€");
            System.out.println("--------------------");
        }
    }
}