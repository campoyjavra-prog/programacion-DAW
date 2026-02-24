import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField pantalla;
    private String operador = "";
    private double num1 = 0;

    public Calculadora() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Calculadora Grid");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        // Pantalla
        pantalla = new JTextField();
        pantalla.setEditable(false);
        add(pantalla, BorderLayout.NORTH);
        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5));
        String[] botones = { "7", "8", "9", "/", "2ˆx", "4", "5", "6", "*", "3ˆx", "1", "2", "3", "-", "4ˆx", "C", "0",
                "=", "+", "5ˆx" };
        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            boton.addActionListener(this);
            panelBotones.add(boton);
        }
        add(panelBotones, BorderLayout.CENTER);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        // Si es número
        if (comando.matches("[0-9]")) {
            pantalla.setText(pantalla.getText() + comando);
        }
        // Si es operación
        else if (comando.matches("[+\\-*/]")) {
            num1 = Double.parseDouble(pantalla.getText());
            operador = comando;
            pantalla.setText("");
        }
        // Si es = tomará el valor num1 y num2 para operar
        else if (comando.equals("=")) {
            double num2 = Double.parseDouble(pantalla.getText());
            double resultado = 0;
            switch (operador) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "No se puede dividir entre 0");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
            }
            pantalla.setText(String.valueOf(resultado));
        }
        // Si es C
        else if (comando.equals("C")) {
            pantalla.setText("");
            operador = "";
            num1 = 0;
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
