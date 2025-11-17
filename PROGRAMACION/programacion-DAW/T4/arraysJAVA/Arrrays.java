import java.util.Arrays;
import java.util.Scanner;

public class Arrrays {
    public static void imprimeArray(double[] array){
        System.out.println(array[1]);
    }
    public static void imprimeArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    public static double[] devolverArray(double[] a){
        a[1]=a[1]*3;
        return a;
    }
    public static void main(String[] args) {
        // // String nombre1;
        // // String Apellidos1; 
        // // int edad1;
        // // double notaBD1;
        // // double notaPROG1;
        // // double notaED1;

        // // double calificaciones[]={7,8,2,4,8,9};
        // // System.out.println(calificaciones[5]);

        // // //Array dinámico
        // // double[] calificaciones2;
        // // System.out.println("Indica el tamaño del array calificaciones2: ");
        // // Scanner teclado=new Scanner(System.in);
        // // calificaciones2=new double[teclado.nextInt()];
        // // System.out.println(calificaciones2);


        // // //Arrays que apuntan al mismo sitio
        // // double[] calificacionesOtro;
        // // calificacionesOtro=calificaciones;
        // // System.out.println(calificaciones[1]);
        // // System.out.println(calificacionesOtro[1]);
        // // // calificaciones=null;
        // // // calificacionesOtro=null;
        // // // System.out.println(calificacionesOtro[3]);

        // // //Imprime la posición 1
        // // imprimeArray(calificaciones);
        // // double[] resultado=devolverArray(calificaciones);
        // // System.out.println(resultado[1]);
        // // System.out.println(calificaciones[1]);


        // // //matrices
        // // String[][] comidas={{"arroz","manzana","conejo","celiaco"},{"verdura","pollo","fresa","domingo"},{"patatas","naranja","cerdo","fiesta"}};
        // // System.out.println(comidas[2][3]);
        // // String[] aux=comidas[1];
        // // System.out.println("Matriz: "+comidas[1][2]);
        // // System.out.println("Vector: "+aux[2]);


        // // //Usar la memoria dinámica reservada
        // // calificaciones2[3]=5;
        // // System.out.println(calificaciones2[3]);
        // // System.out.println(calificaciones2[1]);


        // // //acceso a args del main
        // // // System.out.println(args[0]);

        // //RECORRER UN VECTOR
        // int[] vector={7,5,3,4};
        // for(int i=vector.length-1;i>=0;i--){
        //     System.out.print(vector[i]+" ");
        // }
        // System.out.println();

        // //PRÁCTICA RECORRER MATRICES
        // // int[][] matriz2={{1,2,3,4,5},{1,2,3,4},{1,2,3},{1,2},{1}};
        // int[][] matriz2={{3,7,1},{4,-4,2},{5,0,5}};
        // for(int i=0;i<matriz2.length;i++){//Recorre las filas
        //     for(int j=0;j<matriz2[i].length;j++){
        //         System.out.print(matriz2[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        
        
        // int[] vector2={1,2,3,4,5,6,7,6};
        // if(buscarVector(vector2,10)!=-1){
        //     System.out.println("Se ha encontrado el número 6 en el vector");
        // }
        // else{
        //     System.out.println("No está el número en el vector");
        // }
        // System.out.println(buscarVector(vector2,6));

        // // for (int dato : vector2) {
        // //     System.out.println(dato);
        // // }

        // //REalizar una copia de un array
        // int[] vector={3,6,8,11,33};
        // int[] copiaVector=new int[vector.length];
        // for(int i=0;i<vector.length;i++){
        //     copiaVector[i]=vector[i];
        // }
        // vector[4]=23;
        // //Vector original
        // for(int i=0;i<vector.length;i++){
        //     System.out.print(vector[i]+ " ");
        // }
        // System.out.println();
        
        // //Vector copia
        // for(int i=0;i<copiaVector.length;i++){
        //     System.out.print(copiaVector[i]+ " ");
        // }
        // System.out.println();


        // //Insertar uno elemento más
        // int[] vectorPrueba={1,2,3};
        // int[] vectorFinal;
        // System.out.println(vectorPrueba.length);
        // //Primero: Reserva memoria para 1 elmento más
        // vectorFinal=new int[vectorPrueba.length+1];
        // for(int i=0;i<vectorPrueba.length;i++){
        //     vectorFinal[i]=vectorPrueba[i];
        // }
        // vectorFinal[vectorPrueba.length]=40;
        // for(int i=0;i<vectorFinal.length;i++){
        //     System.out.print(vectorFinal[i]+" ");
        // }
        // System.out.println();


        // //Borrar uno elemento más
        // int[] vectorPrueba2={1,2,3};
        // int[] vectorFinal2;
        // System.out.println(vectorPrueba.length);
        // //Primero: Reserva memoria para 1 elmento más
        // vectorFinal2=new int[vectorPrueba2.length-1];
        // for(int i=0;i<vectorFinal2.length;i++){
        //     vectorFinal2[i]=vectorPrueba2[i];
        // }
        // for(int i=0;i<vectorFinal2.length;i++){
        //     System.out.print(vectorFinal2[i]+" ");
        // }
        // System.out.println();



        // int[] vectorNumeros={2,4,22,11,7,9,1};
        // imprimeArray(vectorNumeros);
        // int[] vectorOrdenado,vectorOrdenado2;
        // vectorOrdenado=ordenacionClasica(vectorNumeros);
        // imprimeArray(vectorOrdenado);
        // vectorOrdenado2=ordenacionBurbuja(vectorNumeros);
        // imprimeArray(vectorOrdenado2);
        // quickSort(vectorNumeros,0, vectorNumeros.length-1);
        // imprimeArray(vectorNumeros);


        // int[] vectorNumeros2={2,4,22,11,7,9,1};
        // Arrays.sort(vectorNumeros2);
        // imprimeArray(vectorNumeros2);


    //     //Ordenar una matriz
    //     int[][] matriz={{3,7,1},{4,-4,2},{5,0,5}};
    //     imprimeMatiz(matriz);
    //     // int[][] resultado=ordenarMatriz(matriz, matriz.length,matriz[0].length);
    //     // imprimeMatiz(resultado);

    //     //Actividad pasar de matriz a vector
    //     int[] vector= new int[matriz.length*matriz[0].length];
    //     for(int r=0;r<matriz.length;r++){
    //         for(int c=0;c<matriz[0].length;c++){
    //             int valor=matriz[r][c];
    //             vector[r*matriz[0].length+c]=valor;
    //         }
    //     }
    //     imprimeArray(vector);

    // //Ordenar el vector
    //     int[] resultado=ordenacionBurbuja(vector);
    //     for(int r=0;r<matriz.length;r++){
    //         for(int c=0;c<matriz[0].length;c++){
    //             int valor=resultado[r*matriz[0].length+c];
    //             matriz[r][c]=valor;
    //         }
    //     }
    //     imprimeMatiz(matriz);
    int[] vector={1,4,5,6,7,9,4};//tamaño 7
    // imprimeArray(vector);
    // int[] resultado=insertaEn(vector,4,5);
    // imprimeArray(resultado);

    // resultado=insertaEn(vector,9,5);
    // imprimeArray(resultado);
    

    //Actividad que elimina un elemento
    //Vamos a quitar el 1
    //Recorrer el vector para conocer cuántos 1 hay
    imprimeArray(vector);
    int contador=0;
    for (int i=0;i<vector.length;i++){
        if(vector[i]==9){
            contador++;
        }
    }
    //Genero el vector con el tamaño final (total-contador)
    int[] finalV=new int[vector.length-1];
    int pos=0;
    for(int i=0;i<vector.length;i++){
        if(vector[i]!=9){
            finalV[pos]=vector[i];
            pos++;
        }
    }
    imprimeArray(finalV);
    }

    public static int[] insertaEn(int[] vector,int pos, int valor){
        if (pos>=vector.length){
            int[] salida=new int[pos+1];  
            for(int i=0;i<vector.length;i++){
                salida[i]=vector[i];
            }  
            for(int i=vector.length;i<pos;i++){
                salida[i]=0;
            }
            salida[pos]=valor;
            return salida;
        }
        else{
            int[] salida=new int[vector.length+1];

            for(int i=0;i<pos;i++){
                salida[i]=vector[i];
            }
            salida[pos]=valor;
            for(int i =pos+1;i<salida.length;i++) {
                salida[i]=vector[i-1];
            }
            return salida;
        }
    }
    public static void imprimeMatiz(int[][] matriz){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

     public static int[] ordenacionClasica(int vec[]){
                final int N=vec.length;
                for(int i=0;i<N;i++){
                        for(int j=i+1;j<N;j++){
                                if(vec[i]<vec[j]){
                                        int temp=vec[i];
                                        vec[i]=vec[j];
                                        vec[j]=temp;
                                }
                        }
                }
                
                return vec;
        }
     public static int[] ordenacionBurbuja(int vec[]){
                final int N=vec.length;
                for(int i=N-1;i>0;i--){
                        for(int j=0;j<i;j++){
                                if(vec[j]>vec[j+1]){
                                        int temp=vec[j];
                                        vec[j]=vec[j+1];
                                        vec[j+1]=temp;
                                }
                        }
                        
                }
                return vec;
        }
        public static void quickSort(int vec[], int inicio, int fin){
                if(inicio>=fin) return;
                int pivote=vec[inicio];
                int elemIzq=inicio+1;
                int elemDer=fin;
                while(elemIzq<=elemDer){
                        while(elemIzq<=fin && vec[elemIzq]<pivote){
                                elemIzq++;
                        }
                        while(elemDer>inicio && vec[elemDer]>=pivote){
                                elemDer--;
                        }
                        if(elemIzq<elemDer){
                                int temp=vec[elemIzq];
                                vec[elemIzq]=vec[elemDer];
                                vec[elemDer]=temp;
                        }
                }
                
                if(elemDer>inicio){
                        int temp=vec[inicio];
                        vec[inicio]=vec[elemDer];
                        vec[elemDer]=temp;
                }
                quickSort(vec, inicio, elemDer-1);
                quickSort(vec, elemDer+1, fin);
        }
    public static int buscarVector(int[] vector,int numero){
        int indice=-1;
        boolean encontrado=false;
        for(int i=0;i<vector.length && !encontrado;i++){
            if(vector[i]==numero){
                indice=i;
                encontrado=true;
            }
        }
        return indice;
    }
    public static int[][] ordenarMatriz(int[][] matriz,int filas,int columnas){
         for (int i = 0; i < filas * columnas - 1; i++) {
            for (int j = 0; j < filas * columnas - i - 1; j++) {
                // Obtener índices (fila, columna) del elemento actual y siguiente
                int fila1 = j / columnas;
                int col1 = j % columnas;
                int fila2 = (j + 1) / columnas;
                int col2 = (j + 1) % columnas;

                // Comparar y hacer swap si es necesario
                if (matriz[fila1][col1] > matriz[fila2][col2]) {
                    int temp = matriz[fila1][col1];
                    matriz[fila1][col1] = matriz[fila2][col2];
                    matriz[fila2][col2] = temp;
                }
            }
        }
        return matriz;
    }

}