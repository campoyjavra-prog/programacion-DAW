package ActividadesT3;

import java.util.Arrays;
import java.util.Random;

public class Actividad8 {
    public static void main(String[] args) {
        // Estructuras de datos iniciales
        String[] alumnos = { "José", "Ana", "María", "Luis", "Domingo" };
        String[] modulos = { "Programación", "Entornos", "Bases Datos", "Sistemas" };
        double[][] notas = new double[5][4];  // 5 alumnos, 4 módulos

        // 1) Generar notas aleatorias
        Random rand = new Random();
        for (int i = 0; i < alumnos.length; i++) {
            for (int j = 0; j < modulos.length; j++) {
                notas[i][j] = 1 + rand.nextDouble() * (10 - 1);  // Nota aleatoria entre 1 y 10
            }
        }

        // Mostrar la tabla de notas
        System.out.println("Tabla de notas:");
        System.out.println("Alumno    Programación   Entornos   Bases Datos   Sistemas");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print(alumnos[i] + "    ");
            for (int j = 0; j < modulos.length; j++) {
                System.out.print(String.format("%.2f", notas[i][j]) + "    ");
            }
            System.out.println();
        }

        // 2) Calificación media, máxima y mínima de un alumno
        System.out.println("\nCalificaciones de cada alumno:");
        for (int i = 0; i < alumnos.length; i++) {
            double sumaNotas = 0;
            double maxNota = 0;
            double minNota = 10;
            for (int j = 0; j < modulos.length; j++) {
                sumaNotas += notas[i][j];
                if (notas[i][j] > maxNota) {
                    maxNota = notas[i][j];
                }
                if (notas[i][j] < minNota) {
                    minNota = notas[i][j];
                }
            }
            double media = sumaNotas / modulos.length;
            System.out.println(alumnos[i] + ": Media: " + String.format("%.2f", media) + ", Máxima: " + String.format("%.2f", maxNota) + ", Mínima: " + String.format("%.2f", minNota));
        }

        // 3) Cuántos alumnos han superado un módulo
        System.out.println("\nNúmero de alumnos que han superado cada módulo:");
        for (int j = 0; j < modulos.length; j++) {
            int aprobados = 0;
            for (int i = 0; i < alumnos.length; i++) {
                if (notas[i][j] >= 5) {  // Se considera aprobado si la nota es mayor o igual a 5
                    aprobados++;
                }
            }
            System.out.println(modulos[j] + ": " + aprobados + " alumnos");
        }

        // 4) Cuántos módulos aprueba un alumno
        System.out.println("\nNúmero de módulos aprobados por cada alumno:");
        for (int i = 0; i < alumnos.length; i++) {
            int aprobados = 0;
            for (int j = 0; j < modulos.length; j++) {
                if (notas[i][j] >= 5) {  // Se considera aprobado si la nota es mayor o igual a 5
                    aprobados++;
                }
            }
            System.out.println(alumnos[i] + ": " + aprobados + " módulos aprobados");
        }

        // 5) Usando memoria dinámica:
        // a) Añadir un nuevo alumno y sus calificaciones
        System.out.println("\nAñadiendo un nuevo alumno...");
        alumnos = Arrays.copyOf(alumnos, alumnos.length + 1);  // Ampliamos el array de alumnos
        alumnos[alumnos.length - 1] = "Carlos";  // Nuevo alumno
        double[] nuevasNotas = { 8.0, 6.5, 7.5, 9.0 };  // Notas para el nuevo alumno
        notas = Arrays.copyOf(notas, notas.length + 1);  // Ampliamos el array de notas
        notas[notas.length - 1] = nuevasNotas;  // Añadimos las notas

        // Mostrar la tabla actualizada de notas
        System.out.println("\nTabla de notas después de añadir el nuevo alumno:");
        System.out.println("Alumno    Programación   Entornos   Bases Datos   Sistemas");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print(alumnos[i] + "    ");
            for (int j = 0; j < modulos.length; j++) {
                System.out.print(String.format("%.2f", notas[i][j]) + "    ");
            }
            System.out.println();
        }

        // b) Eliminar la columna de "Programación" y sus notas
        System.out.println("\nEliminando la columna de Programación...");
        modulos = Arrays.copyOf(modulos, modulos.length - 1);  // Eliminamos el módulo "Programación"
        for (int i = 0; i < alumnos.length; i++) {
            // Eliminamos la primera columna de notas
            notas[i] = Arrays.copyOfRange(notas[i], 1, notas[i].length);
        }

        // Mostrar la tabla después de eliminar la columna de "Programación"
        System.out.println("\nTabla de notas después de eliminar el módulo 'Programación':");
        System.out.println("Alumno    Entornos   Bases Datos   Sistemas");
        for (int i = 0; i < alumnos.length; i++) {
            System.out.print(alumnos[i] + "    ");
            for (int j = 0; j < modulos.length; j++) {
                System.out.print(String.format("%.2f", notas[i][j]) + "    ");
            }
            System.out.println();
        }
    }
}
