
public class Racional {

    //a (numerador) y b (denominador)
    private int a; 
    private int b;

    // Constructor
    //validar que el denominador no sea 0 
    public Racional(int a, int b) {
        this.a = a;
        if (b != 0) {
            this.b = b;
        } else {
            System.out.println("Error: El denominador no puede ser 0. Se asignará 1 por defecto.");
            this.b = 1;
        }
    }

    // Métodos específicos 
    public void asignaNumerador(int x) {
        this.a = x;
    }

    public void asignaDenominador(int y) {
        if (y != 0) {
            this.b = y;
        } else {
            System.out.println("Error: No se puede asignar 0 al denominador.");
        }
    }

    public void imprimirRacional() {
        System.out.println("El número racional es: " + this.a + "/" + this.b);
    }

    // --- OPERACIONES ---
    // Suma: (a/b) + (c/d) = (ad + bc) / bd
    public Racional suma(Racional otro) {
        int nuevoNumerador = (this.a * otro.b) + (otro.a * this.b);
        int nuevoDenominador = this.b * otro.b;
        
        Racional resultado = new Racional(nuevoNumerador, nuevoDenominador);
        return resultado;
    }

    // Resta: (a/b) - (c/d) = (ad - bc) / bd
    public Racional resta(Racional otro) {
        int nuevoNumerador = (this.a * otro.b) - (otro.a * this.b);
        int nuevoDenominador = this.b * otro.b;
        
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Producto (Multiplicación): (a/b) * (c/d) = (ac) / (bd)
    public Racional producto(Racional otro) {
        int nuevoNumerador = this.a * otro.a;
        int nuevoDenominador = this.b * otro.b;
        
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // División: (a/b) / (c/d) = (ad) / (bc)  -> Multiplicación en cruz
    public Racional division(Racional otro) {
        int nuevoNumerador = this.a * otro.b;
        int nuevoDenominador = this.b * otro.a;
        
        return new Racional(nuevoNumerador, nuevoDenominador);
    }

    // Para saber si a/b == c/d, verificamos si a*d == c*b
    public boolean esIgual(Racional otro) {
        int ladoIzquierdo = this.a * otro.b;
        int ladoDerecho = otro.a * this.b;
        
        if (ladoIzquierdo == ladoDerecho) {
            return true;
        } else {
            return false;
        }
    }

    // --- CLASE MAIN PARA PROBAR EL CÓDIGO ---
    public static void main(String[] args) {
        System.out.println("--- PRUEBAS CON NÚMEROS RACIONALES ---");

        // Creamos dos racionales
        Racional r1 = new Racional(1, 2);
        Racional r2 = new Racional(3, 4);

        System.out.print("Racional 1: ");
        r1.imprimirRacional();
        
        System.out.print("Racional 2: ");
        r2.imprimirRacional();

        System.out.println("--------------------------------");

        // Prueba de Suma
        Racional resSuma = r1.suma(r2);
        System.out.print("Suma (1/2 + 3/4): ");
        resSuma.imprimirRacional(); // Debería ser 10/8

        // Prueba de Resta
        Racional resResta = r1.resta(r2);
        System.out.print("Resta (1/2 - 3/4): ");
        resResta.imprimirRacional(); // Debería ser -2/8

        // Prueba de Producto
        Racional resProd = r1.producto(r2);
        System.out.print("Producto (1/2 * 3/4): ");
        resProd.imprimirRacional(); // Debería ser 3/8

        // Prueba de División
        Racional resDiv = r1.division(r2);
        System.out.print("División (1/2 / 3/4): ");
        resDiv.imprimirRacional(); // Debería ser 4/6

        System.out.println("--------------------------------");

        // Prueba de esIgual
        Racional r3 = new Racional(2, 4); // 1/2
        System.out.print("Comparando 1/2 con 2/4: ");

        if (r1.esIgual(r3)) {
            System.out.println("Son iguales.");
        }
         else {
            System.out.println("Son distintos.");
        }
        
        System.out.print("Comparando 1/2 con 3/4: ");
        if (r1.esIgual(r2)) {
            System.out.println("Son iguales.");
        }
         else {
            System.out.println("Son distintos.");
        }
    }
}
