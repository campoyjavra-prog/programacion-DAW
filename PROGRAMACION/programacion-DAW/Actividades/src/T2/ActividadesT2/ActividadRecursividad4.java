package T2.ActividadesT2;

public class ActividadRecursividad4 {
   public static String pasarBinario(int n){
        String cadena = "";

        if (n<0){
            return "El número debe ser positivo";
        }
        
        if (n==0||n==1){
            cadena=Integer.toString(n);
            return cadena;
        }
        else{ 
            cadena=pasarBinario(n/2)+(n%2);
            return cadena;
        }
    }
    public static void main(String[] args) {
        int numero =-9;
        System.out.println("El número "+numero+" en binario es: " +pasarBinario(numero));
    }

}
