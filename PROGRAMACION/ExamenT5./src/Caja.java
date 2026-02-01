/**
 * REGLA GENÉRICOS 2: Clase genérica con <T>
 * Puede guardar cualquier tipo de dato.
 */
public class Caja<T> {

    private T contenido;

    public Caja(T contenido) {
        this.contenido = contenido;
    }

    public T getContenido() {
        return contenido;
    }

    public void setContenido(T contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "Caja contiene: " + contenido.toString();
    }
}
