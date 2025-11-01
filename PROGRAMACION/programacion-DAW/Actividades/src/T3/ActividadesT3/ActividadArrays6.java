package ActividadesT3;

import java.util.ArrayList;
import java.util.Scanner;

public class ActividadArrays6 {
    public static void main(String[] args) {
        
        // Scanner teclado = new Scanner(System.in);

        // System.out.println("Introduce un nombre");
        // ArrayList<String> array = new ArrayList<>();

        ArrayList<Integer> array = new ArrayList<>();
           array.add(3);
           array.add(7);
           for(int i = 0; i<array.size();i++){
               System.out.println(array.get(i)+" ");
           }
           System.out.println();
           System.out.println("Quitar el ultimo");
           int valor=array.removeLast();
           for(int i = 0; i<array.size();i++){
               System.out.println(array.get(i)+" ");
           }
           System.out.println();

        
           if (array.contains(3)){
               System.out.println("El array contiene el 3");
            }
    }
}
