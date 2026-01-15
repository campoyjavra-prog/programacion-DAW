public class EjemploHerencia {
    public static void main(String[] args) {
        PersonaPadre p1 = new PersonaPadre();
        p1.setAltura(1.80);
        p1.setNombre("Luis");
        p1.setEdad(25);
        p1.imprimeDatos();

        Empleado e1 = new Empleado("Domingo", 40, 1.70, "Informático", 3000);
        Empleado e2 = new Empleado("Domingo", 40, 1.70, "Informático", 3000);
        System.out.println("Valor inicial de e2: " + e2.getValor());
        e1.setValor(7);
        System.out.println("Valor modificado de e1: " + e1.getValor());
        System.out.println("Valor de e2 (debe mantenerse igual): " + e2.getValor());

    }
}
