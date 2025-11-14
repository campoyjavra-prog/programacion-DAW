package Clases;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

enum ESTUDIOS{
    ESO,BACHILLERATO,UNIVERSIDAD,DOCTORADO;
}

public class Persona2 {
    String nombre;
    LocalDate fechaNacimiento;
    double estatura;
    final String DNI;
    int hijos;
    Persona2 pareja;
    ESTUDIOS educacion;

    public Persona2(String DNI,String fecha){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento=LocalDate.parse(fecha,fmt); 
        this.DNI=DNI;
        this.hijos=2;
        this.pareja=null;
        educacion=ESTUDIOS.ESO;
    }
    public Persona2(String nombre,String fecha, double estatura, String DNI, int hijos,Persona2 pareja,ESTUDIOS tipo){
        this.nombre=nombre;
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fechaNacimiento=LocalDate.parse(fecha,fmt); 
        this.estatura=estatura;
        this.DNI=DNI;
        this.pareja=pareja;
        educacion=tipo;
    }

    public void setEducacion(ESTUDIOS educacion){
        this.educacion=educacion;
    }
    public ESTUDIOS getEducacion(){
        return this.educacion;
    }
    public void obtenerEdad(){
        Period periodo=Period.between(fechaNacimiento, LocalDate.now());
        System.out.println("Tienes "+periodo.getYears()+" años");
    }
    public void asignaPareja(Persona2 p){
        this.pareja=p; //Hará referencia a la ya existente
    }
    public void imprimePersona(){
        System.out.println("Te llamas "+this.nombre+" y tu DNI es "+this.DNI);
        System.out.println("Tus estudios son: "+this.educacion);
        System.out.println("Tu pareja se llama "+pareja.nombre);

    }
    public static void main(String[] args) {
        Persona2 p=new Persona2("12345678A","15/08/1985");
        p.obtenerEdad();
        System.out.println("Tienes "+p.hijos+" hijos");
        Persona2 p2=new Persona2("María","01/07/1987",1.80,"12345678B",3,null,ESTUDIOS.BACHILLERATO);
        p.hijos=3;
        p.asignaPareja(p2);
        p2.asignaPareja(p2);
        System.out.println(p2.toString());
        p2.imprimePersona();
        System.out.println(p2.nombre);
    }
}
