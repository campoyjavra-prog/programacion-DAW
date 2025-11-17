package T2.ActividadesT2;
public class ActividadesFuncionesDefinidas {
    public static void main(String[] args) {
       
        int min=1, max=100;
        int nuemro1=(int)(Math.random()*(max-min+1))+min;
        int numero2=(int)(Math.random()*(max-min+1))+min;
        // Hacer las cuentas
        int cociente=nuemro1/numero2;
        double media=(nuemro1+numero2)/2.0;
        double potencia=Math.pow(nuemro1, numero2);
        double raiz1=Math.sqrt(nuemro1);
        double raiz2=Math.sqrt(numero2);
        // Sacar resultados
        System.out.println("Los numeros generados son: " +nuemro1+" y "+numero2+"");
        System.out.println("El cociente es: " +cociente);
        System.out.println("La media es: " +media);
        System.out.println("La potencia es: "+potencia);
        System.out.println("La raiz cuadrada de numero1 es: "+raiz1);
        System.out.println("La raiz cuadrada de numero2 es: "+raiz2);

    }
}
