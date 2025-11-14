package Clases;

import prueba.Matematicas;
import prueba.Persona;

public class Actividad1Clases {
    public static void main(String[] args) {
        Persona p = new Persona("Domingo",40);
        p.imprimePersona();

        double a=4;
        double b=5;

        System.out.println(Matematicas.suma(a,b));

        System.out.println(p.nom);
    }   
}
