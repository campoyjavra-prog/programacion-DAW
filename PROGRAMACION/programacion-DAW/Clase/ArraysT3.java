

import java.util.ArrayList;

public class ArraysT3 {
    //Burbuja
     public static void main(String[] args) {
    //     int vec[]={6,8,3,5,4,9,0,2,1,7};
    //     System.out.print("Vector sin ordenar: ");
    //     for(int i=0;i<vec.length;i++){
    //         System.out.print(vec[i]+" ");
    //     }
    //     //Ordenamiento
    //     for(int i=0; i < vec.length-1; i++){
    //            for(int j=0; j < (vec.length-1-i); j++){  
    //                 if(vec[j] > vec[j+1]){  
    //                         int aux=vec[j];                 
    //                         vec[j]=vec[j+1];           
    //                         vec[j+1]=aux;
    //                  }    
    //            }
    //       }
    //     System.out.print("\nVector ordenado: ");
    //     for(int i=0;i<vec.length;i++){
    //         System.out.print(vec[i]+" ");
    //     }

    //     //Utilizando metodos que ya exixten
    //     int vector[]={6,8,3,5,4,9,0,2,1,7};

    //     //

    //     //Uso de ARRAYLIST
    //     ArrayList<Integer> array = new ArrayList<>();
    //     array.add(3);
    //     array.add(7);
    //     for(int i = 0; i<array.size();i++){
    //         System.out.println(array.get(i)+" ");
    //     }
    //     System.out.println();
    //     System.out.println("Quitar el ultimo");
    //     int valor=array.removeLast();
    //     for(int i = 0; i<array.size();i++){
    //         System.out.println(array.get(i)+" ");
    //     }
    //     System.out.println();

        
    //     if (array.contains(3)){
    //         System.out.println("El array contiene el 3");
    //     }

        //Uso de STRING
        String cadena = "viernes";
        System.out.println(cadena);
        if(cadena.equals("viernes")){
            System.out.println("HOY ES HALLOWEN");
        }
        System.out.println(cadena.charAt(3));

        String resultado=cadena.concat(" es festivo");
        System.out.println(resultado);

        String hallowen = "HOY ES HALLOWEN";
        System.out.println(hallowen.toLowerCase());

        System.out.println(hallowen.replace('L', 'Ñ')); 

        String texto = "hola domingo buenos dias";
        String[] salida=texto.split(",");
        for(int i = 0;i<salida.length;i++){
            System.out.println(salida[i]+" ");
        }
    }
}
