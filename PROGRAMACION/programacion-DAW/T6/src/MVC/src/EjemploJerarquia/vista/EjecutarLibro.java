package MVC.src.EjemploJerarquia.vista;

import MVC.src.EjemploJerarquia.controlador.LibroControlador;

public class EjecutarLibro {

    public static void main(String[] args) {
        LIbroVista vista = new LIbroVista();
        LibroControlador controlador = new LibroControlador(vista);
        controlador.iniciar();
    }
}
