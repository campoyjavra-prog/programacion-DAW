package RelacionT3;

public class Programa1 {
    public static void main(String[] args) {
        //Crear el vector dinamico
        int[] vector=null;
        //Inserta un valor
        vector=push(vector, 3);
        //Inserta un valor
        vector=push(vector, 5);
        for (int i=0; i<vector.length;i++){
            System.out.println(vector[i]+ " ");
        }
        //Elimina el ultimo
        
    }
    public static int[] push(int[] array, int valor){
        int longitud;
        if (array==null) longitud=0;
        else longitud=array.length;
        //Crear el array con +1 de tamano
        int[] salida=new int[array.length+1];
        //Copiar lo que haya en ese momento
        for(int i=0;i<array.length;i++){
            salida[i]=array[i];
        }
        salida[array.length+1]=valor;
        return salida;

    }
     public static int pop(int[] array){
        if (array==null) return -1;
        int valor=array[array.length-1];
        int []nuevo=new int[array.length-1];
        for(int i=0;i<nuevo.length;i++){
            nuevo[i]=array[i];
        }
        return valor;
    }
}
