import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JWindow;

//Para importar eventos
import java.awt.event.*;

// 1) Creamos la clase ventana
public class App2 extends JFrame implements ActionListener {
    private JPanel panelDeContenido;
    private JLabel numero1, numero2, resultado;
    private JTextField campoDeTexto1, campoDeTexto2;
    private JButton botonSumar, botonRestar;
    private int numClicks;

    public App2() {
        initComponents();
    }

    private void initComponents() {
        // Configuramos los parámetros de la ventana
        setTitle("Ejemplo de ventana");
        setLocation(200, 500); // setLocationRelativeTo(null);
        setSize(300, 200);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 2) Crear los componentes
        numero1 = new JLabel("Número1");
        campoDeTexto1 = new JTextField(10);
        numero2 = new JLabel("Número2");
        campoDeTexto2 = new JTextField(10);
        botonSumar = new JButton("SUMAR");
        botonRestar = new JButton("RESTAR");
        resultado = new JLabel("El resultado es: ");
        botonSumar.addActionListener(this);
        botonRestar.addActionListener(this);
        // 3) Crear un contenedor
        panelDeContenido = new JPanel();
        // 4) Asociar los componentes al contenedor
        panelDeContenido.add(numero1);
        panelDeContenido.add(campoDeTexto1);
        panelDeContenido.add(numero2);
        panelDeContenido.add(campoDeTexto2);
        panelDeContenido.add(botonSumar);
        panelDeContenido.add(botonRestar);
        panelDeContenido.add(resultado);
        // 5) Asociar el contenedor a la ventana
        setContentPane(panelDeContenido);
        // 6) Hacer visible la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object origen = event.getSource();
        if (origen == botonSumar) {
            int numero1 = Integer.parseInt(campoDeTexto1.getText());
            int numero2 = Integer.parseInt(campoDeTexto2.getText());
            resultado.setText("El resultado es: " + (numero1 + numero2));
        } else {
            int numero1 = Integer.parseInt(campoDeTexto1.getText());
            int numero2 = Integer.parseInt(campoDeTexto2.getText());
            resultado.setText("El resultado es: " + (numero1 - numero2));
        }
    }

    public static void main(String[] args) {
        App2 ejemplo = new App2();
    }
}
