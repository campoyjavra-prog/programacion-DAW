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
public class App3 extends JFrame implements ActionListener {
    private JPanel panelDeContenido;
    private JLabel numero1, numero2, resultado;
    private JTextField campoDeTexto1, campoDeTexto2;
    private JButton botonExit, botonNada;
    private int numClicks;

    public App3() {
        initComponents();
    }

    private void initComponents() {
        // Configuramos los parámetros de la ventana
        setTitle("Ejemplo de ventana");
        setLocation(200, 500); // setLocationRelativeTo(null);
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 2) Crear los componentes
        botonExit = new JButton("CERRAR");
        botonNada = new JButton("NO HACER NADA");
        botonExit.addActionListener(this);
        botonNada.addActionListener(this);
        // 3) Crear un contenedor
        panelDeContenido = new JPanel();
        // 4) Asociar los componentes al contenedor

        panelDeContenido.add(botonExit);
        panelDeContenido.add(botonNada);

        // 5) Asociar el contenedor a la ventana
        setContentPane(panelDeContenido);
        // 6) Hacer visible la ventana
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        Object origen = event.getSource();
        if (origen == botonExit) {
            new App4();
        } else {

        }
    }

    public static void main(String[] args) {
        App3 ejemplo = new App3();
    }
}