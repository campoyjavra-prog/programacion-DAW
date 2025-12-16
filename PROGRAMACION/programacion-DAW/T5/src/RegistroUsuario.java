// Definición de la excepción propia
class EdadInvalidaException extends Exception {
    public EdadInvalidaException(String mensaje) {
        super(mensaje);
    }
}

// Clase que usa la excepción
public class RegistroUsuario {
    public static void registrarUsuario(String nombre, int edad) throws EdadInvalidaException {
        if (edad < 18) {
            throw new EdadInvalidaException("La edad mínima para registrarse es 18.");
        }
        System.out.println("Usuario " + nombre + " registrado con éxito.");
    }

    public static void main(String[] args) {
        RegistroUsuario registro = new RegistroUsuario();
        try {
            RegistroUsuario.registrarUsuario("Ana", 16); // lanza excepción
        } catch (EdadInvalidaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}