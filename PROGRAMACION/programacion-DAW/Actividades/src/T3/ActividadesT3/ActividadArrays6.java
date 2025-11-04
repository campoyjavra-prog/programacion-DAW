package ActividadesT3;

import java.util.ArrayList;
import java.util.Scanner;

public class ActividadArrays6 {
    public static void main(String[] args) {
        
        ArrayList<String> lista = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String palabra;
        boolean salida = false;
        do{
            System.out.println("Introduzca una palabra o una fila para terminar: ");
            palabra = teclado.nextLine();
            if(!palabra.equals("fin") && !lista.contains(palabra)){
                lista.add(palabra);
            }
            if(palabra.equals("fin")){salida=true;}

        }while(!salida);

        System.out.println("Contenido de la lista: ");
        for(int i = 0; i < lista.size(); i++){
            System.out.print(lista.get(i)+" ");
        }
        System.out.println();

       // lista.sort(String.CASE_INSENSITIVE_ORDER);
        lista.sort((a,b)->{return a.compareTo(b);});

        System.out.println("Contenido de la lista ordenada: ");
        for(int i = 0; i < lista.size(); i++){
            System.out.print(lista.get(i)+" ");
        }

        teclado.close();

    }
}
