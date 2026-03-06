package Diapositivas.Actividad7;

import Diapositivas.Actividad7.controlador.MainControlador;
import Diapositivas.Actividad7.vista.MainVista;

public class Main {
    public static void main(String[] args) {
        MainVista mainVista = new MainVista();
        MainControlador controlador = new MainControlador(mainVista);
        controlador.iniciar();
    }
}
