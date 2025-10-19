package T2.RelacionT2;

import java.util.Scanner;

public class Ejercicio6 {
    public static void main(String[] args) {
        
        Scanner teclado=new Scanner(System.in); // Para leer del teclado

        // Pedimos el cargo
        System.out.println("Introduzca el cargo del empleado (1- Prog. junior, 2- Prog. senior, 3-Jefe de proyecto): ");
        int cargo=teclado.nextInt();

        //días de viaje 
        System.out.println("Cuantos dias ha estado de viaje visitando clientes? ");
        int diasViaje=teclado.nextInt();

        //estado civil
        System.out.println("Introduzca su estado civil (1- Soltero, 2- Casado): ");
        int estadoCivil=teclado.nextInt();

        //sueldo base 
        double sueldoBase=0; 

        if (cargo==1) {
            sueldoBase=950;
        }
         else if (cargo==2) {
            sueldoBase=1200;
        }
         else if (cargo==3) {
            sueldoBase=1600;
        }
         else {
            System.out.println("Cargo no valido, se asumira sueldo base 0.");
        }

        //calculo dieta
        double dietas=diasViaje*30.0;

        //sueldo bruto = base + dietas
        double sueldoBruto=sueldoBase+dietas;

        //calculo IRPF
        double porcentajeIRPF;
        if (estadoCivil==1) { //soltero
            porcentajeIRPF=25.0;
        }
         else {
            porcentajeIRPF=20.0; //casado 
        }

        //cantidad paraa retener
        double retencion=sueldoBruto*(porcentajeIRPF/100.0);

        //sueldo neto
        double sueldoNeto=sueldoBruto-retencion;

        //nomina en formato
        System.out.println("----------------------------------------------");
        System.out.printf("| Sueldo base %7.2f €              |\n", sueldoBase);
        System.out.printf("| Dietas (%2d viajes) %10.2f €      |\n", diasViaje, dietas);
        System.out.println("|---------------------------------------------|");
        System.out.printf("| Sueldo bruto %7.2f €             |\n", sueldoBruto);
        System.out.printf("| Retención IRPF (%.0f%%) %8.2f €     |\n", porcentajeIRPF, retencion);
        System.out.println("|---------------------------------------------|");
        System.out.printf("| Sueldo neto %9.2f €             |\n", sueldoNeto);
        System.out.println("----------------------------------------------");

        teclado.close();
    }
}
