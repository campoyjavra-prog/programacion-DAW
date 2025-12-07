import java.util.ArrayList;

class Modulo {
    String nombre;
    String codigo;

    public Modulo(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    
    @Override
    public String toString() { return nombre + " (" + codigo + ")"; }
}

class Alumno {
    String nombre;
    String expediente;
    ArrayList<Modulo> modulosMatriculados = new ArrayList<>();

    public Alumno(String nombre, String expediente) {
        this.nombre = nombre;
        this.expediente = expediente;
    }

    public void matricular(Modulo m) {
        modulosMatriculados.add(m);
    }
    
    public void mostrarModulos() {
        System.out.println("El alumno " + nombre + " cursa:");
        for(Modulo m : modulosMatriculados) {
            System.out.println(" - " + m.toString());
        }
    }
}

class Profesor {
    String nombre;
    // Un profesor imparte varios módulos
    ArrayList<Modulo> modulosImparte = new ArrayList<>(); 
    
    public Profesor(String n) { this.nombre = n; }
    public void asignarModulo(Modulo m) { modulosImparte.add(m); }
}

public class Actividad5 {
    public static void main(String[] args) {
        // Objetos para 1º DAW
        Modulo prog = new Modulo("Programación", "PROG");
        Modulo bd = new Modulo("Bases de Datos", "BD");
        Modulo lm = new Modulo("Lenguajes de Marcas", "LM");

        Profesor profJava = new Profesor("Roberto");
        profJava.asignarModulo(prog);

        Alumno alumno = new Alumno("David", "EXP-2025");
        
        // Matriculamos al alumno (Relación N:M 'Cursa')
        alumno.matricular(prog);
        alumno.matricular(bd);
        alumno.matricular(lm);

        // Prueba solicitada: Obtener módulos
        alumno.mostrarModulos();
    }
}