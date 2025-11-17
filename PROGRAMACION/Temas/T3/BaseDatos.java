import java.util.Scanner;

public class BaseDatos {
    public static void main(String[] args){
        //Declarar variables
        String[] alumnos={"Antonio","María","Marggio","Adrián","Nicolás"};
        String[] materias={"Programación","Entornos","Bases Datos","LMSGI"};
        double[][] notas=new double[alumnos.length][materias.length];

        //1- Generar notas aleatorias y función para imprimir la tabla
        generaNotas(notas);
        imprimeNotas(alumnos,materias,notas);

        //2- Quiero hacer la media, máximo y mínimo de un alumno
        // obterDatosALumno(alumnos, notas);

        //3- ¿Cuánto han superado una materia
        // obtenerSuperadosMaterias(materias,notas);
        
        //4- Número de módulos aprobados por el alumno
        obterAprobadosALumno(alumnos,notas);
    }

    public static void imprimeNotas(String[] alumnos, String[] materias, double[][] notas){
        System.out.print("      | ");
        for(int i=0;i<materias.length;i++){//Materias
            System.out.print(materias[i]+" | ");
        }
        System.out.println();
        //Imprimir las notas
        for(int i=0;i<notas.length;i++){
            System.out.print(alumnos[i]+" | ");
            for(int j=0;j<notas[0].length;j++){
                System.out.printf("%2.1f | ",notas[i][j]);
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void generaNotas(double[][] notas){
        for(int i=0;i<notas.length;i++){
            for(int j=0;j<notas[0].length;j++){
                notas[i][j]=(Math.random()*(10));
            }
        }
    }
    public static void obterDatosALumno(String[] alumnos, double[][] notas){
        System.out.print("Introduce el alumno: ");
        Scanner teclado=new Scanner(System.in);
        String nombre=teclado.nextLine();
        int indice=-1;
        //Buscamos el alumno con ese nombre
        for(int i=0;i<alumnos.length;i++){
            if(alumnos[i].equals(nombre)) indice=i;
        }
        if(indice==-1) System.out.println("NO hay notas del alumno "+nombre);
        else{
            //Si está recorro sus notas y calculo
            double[] notasAlumno=notas[indice];
            double maximo=notasAlumno[0];
            double minimo=notasAlumno[0];
            double media=0;
            for(int i=0;i<notasAlumno.length;i++){
                media+=notasAlumno[i];
                if(maximo<notasAlumno[i]) maximo=notasAlumno[i];
                if(minimo>notasAlumno[i]) minimo=notasAlumno[i];
            }
            System.out.println("Nota media del alumno "+nombre+": "+media/notasAlumno.length);
            System.out.println("Nota máxima del alumno "+nombre+": "+maximo);
            System.out.println("Nota mínima del alumno "+nombre+": "+minimo);
        }
    }
    public static void obtenerSuperadosMaterias(String[] materias,double[][]notas){
        System.out.print("Introduce la materia: ");
        Scanner teclado=new Scanner(System.in);
        String nombre=teclado.nextLine();
        int indice=-1;
        //Buscamos el alumno con ese nombre
        for(int i=0;i<materias.length;i++){
            if(materias[i].equals(nombre)) indice=i;
        }
        if(indice==-1) System.out.println("NO existen datos de la materia "+nombre);
        else{
            int aprobadas=0;
            //Si está recorro sus notas y calculo
            for(int i=0;i<notas.length;i++){
                if(notas[i][indice]>=5) aprobadas++;
            }
            System.out.println("Han aprobado la materia "+nombre+": "+aprobadas);
        }
    
    }
    public static void obterAprobadosALumno(String[] alumnos, double[][] notas){
        System.out.print("Introduce el alumno: ");
        Scanner teclado=new Scanner(System.in);
        String nombre=teclado.nextLine();
        int indice=-1;
        //Buscamos el alumno con ese nombre
        for(int i=0;i<alumnos.length;i++){
            if(alumnos[i].equals(nombre)) indice=i;
        }
        if(indice==-1) System.out.println("NO hay notas del alumno "+nombre);
        else{
            //Si está recorro sus notas y calculo
            int aprobadas=0;
            for(int i=0;i<notas[0].length;i++){
                if(notas[indice][i]>=5) aprobadas++;
            }
            System.out.println("El alumno "+nombre+" aprueba "+aprobadas+" módulos");
        }
    }
}
