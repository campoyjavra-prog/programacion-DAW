package PROGRAMACION.ExamenT5.Actividad2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Actividad2 {

    public static void main(String[] args) {

        File fichero = new File("/Users/rafacamjv/Desktop/CICLOS/1DAW/GitHub/PROGRAMACION/ExamenT5/Actividad2/BD.json");

        JSONParser parser = new JSONParser();
        FileReader fr = null;

        Scanner teclado = new Scanner(System.in);

        try {
            fr = new FileReader(fichero);
            Object objParseado = parser.parse(fr); // Parseamos el fichero
            JSONObject jsonRaiz = (JSONObject) objParseado; // Casteo

            int opcion = 0;
            do {
                System.out.println("\n--- MENÚ EMPRESA ---");
                System.out.println("1. Empleados activos");
                System.out.println("2. Empleados administradores");
                System.out.println("3. Datos de la empresa");
                System.out.println("4. Buscar empleado");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");

                // Validación entrada numérica
                if (teclado.hasNextInt()) {
                    opcion = teclado.nextInt();
                    teclado.nextLine(); // Limpiar buffer
                } else {
                    teclado.nextLine(); // Limpiar buffer
                    opcion = -1;
                }

                if (opcion == 1) {

                    // 1- Número de empleados activos y cómo se llaman
                    JSONArray empleados = (JSONArray) jsonRaiz.get("empleados");
                    int contadorActivos = 0;

                    System.out.println("\nTrabajando actualmente:");
                    for (int i = 0; i < empleados.size(); i++) {
                        JSONObject emple = (JSONObject) empleados.get(i);
                        boolean activo = (Boolean) emple.get("activo");

                        if (activo) {
                            contadorActivos++;
                            String nombre = (String) emple.get("nombre");
                            System.out.println("- " + nombre);
                        }
                    }
                    System.out.println("Total activos: " + contadorActivos);

                } else if (opcion == 2) {

                    // 2- Número de empleados que tienen rol administrador
                    JSONArray empleados = (JSONArray) jsonRaiz.get("empleados");
                    int contAdmin = 0;

                    for (int i = 0; i < empleados.size(); i++) {
                        JSONObject emple = (JSONObject) empleados.get(i);
                        JSONArray roles = (JSONArray) emple.get("roles");

                        // Recorremos roles buscando "admin"
                        boolean isAdmin = false;
                        for (int j = 0; j < roles.size(); j++) {
                            String rol = (String) roles.get(j);
                            if (rol.equals("admin")) {
                                isAdmin = true;
                            }
                        }

                        if (isAdmin) {
                            contAdmin++;
                        }
                    }
                    System.out.println("\nTotal de administradores: " + contAdmin);

                } else if (opcion == 3) {

                    // 3- Imprime los datos de la empresa (Nombre y dirección)
                    String nombreEmpresa = (String) jsonRaiz.get("empresa");
                    JSONObject dir = (JSONObject) jsonRaiz.get("direccion");
                    String ciudad = (String) dir.get("ciudad");
                    String pais = (String) dir.get("pais");

                    System.out.println("\nEmpresa: " + nombreEmpresa);
                    System.out.println("Dirección: " + ciudad + ", " + pais);

                } else if (opcion == 4) {

                    // 4- Pregunte por un empleado y diga sus datos o muestre que no es empleado
                    System.out.print("Introduce el nombre del empleado: ");
                    String nombreBusq = teclado.nextLine();
                    boolean encontrado = false;

                    JSONArray empleados = (JSONArray) jsonRaiz.get("empleados");
                    for (int i = 0; i < empleados.size(); i++) {
                        JSONObject emp = (JSONObject) empleados.get(i);
                        String nombre = (String) emp.get("nombre");

                        if (nombre.equalsIgnoreCase(nombreBusq)) {
                            // Mostrar datos
                            long id = (Long) emp.get("id"); // Números son Long
                            JSONArray roles = (JSONArray) emp.get("roles");
                            boolean activo = (Boolean) emp.get("activo");

                            System.out.println("\n--- DATOS DEL EMPLEADO ---");
                            System.out.println("ID: " + id);
                            System.out.println("Nombre: " + nombre);
                            System.out.print("Roles: ");
                            for (int j = 0; j < roles.size(); j++) {
                                System.out.print(roles.get(j) + " ");
                            }
                            System.out.println();
                            System.out.println("Activo: " + activo);

                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No es empleado de la empresa.");
                    }

                } else if (opcion == 5) {
                    System.out.println("Saliendo...");
                } else {
                    System.out.println("Opción incorrecta.");
                }

            } while (opcion != 5);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // CIERRE MANUAL
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Error cerrando el fichero: " + e.getMessage());
            }
            teclado.close();
        }
    }

}
