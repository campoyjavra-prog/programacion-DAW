package T4.Apuntes;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Persona {

    String nombre;
    LocalDate fechaNacimiento;
    double estatura;
    final String DNI;
    static int hijos;
    Persona pareja;

    public Persona(String DNI,String fecha){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.fechaNacimiento=LocalDate.parse(fecha,fmt);
            this.DNI=DNI;
            this.hijos=2;
            this.pareja=null;
    }

    public void obtenerEdad(){
        Period periodo=Period.between(fechaNacimiento, LocalDate.now());
            System.out.println("Tienes "+periodo.getYears()+" años");
    }

    public void asignaPareja(Persona p){
        this.pareja=p; //Hará referencia a la ya existente
    }

    public static void main(String[] args) {
        Persona p=new Persona("12345678A","15/08/1985");
        p.obtenerEdad();
        System.out.println("Tienes "+p.hijos+" hijos");

        Persona p2=new Persona("12345678B","01/07/1987");
        p.hijos=3;
        System.out.println("Tienes "+p2.hijos+" hijos");

        

    }

}
