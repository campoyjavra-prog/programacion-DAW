public class Bucles2{
    public static void main(String[] args) {
        //Bucles anidados
       for(int i=1;i<=4;i++){ // aqui se introduce las filas del 1 al 4
            for(int j=1;j<=i;j++){ // los * que se van poniendo
                System.out.println("*");
            }
            System.out.println(""); // salto de linea
       }

       //Al reves y filas pares
       for(int i=1;i<=4;i++){
            if(i%2==0){
            for(int j=4;j>=i;j--){
                System.out.println("*");
            }
        }
            System.out.println("");
       }
    }
}
 