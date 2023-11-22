import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

public class Calculadora{

    private JFrame frame;
    private JTextField texto;

    static Compilador comp;
    static StringBuilder sb; 

    public static void main(String[] args) {
        sb = new StringBuilder();
        SwingUtilities.invokeLater(() -> {
            try {
                new Calculadora();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    //Método que crea una calculadora como interfaz gráfica,
    public Calculadora() {

        //Tamaño de la calculadora
        frame = new JFrame();
        frame.setTitle("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 450);
        frame.setLayout(new BorderLayout());

        //Forma de los caracteres qu van a interactuar en la aplicación
        texto = new JTextField();
        texto.setFont(new Font("Mistral", Font.PLAIN, 18));
        texto.setHorizontalAlignment(JTextField.RIGHT);
        frame.add(texto, BorderLayout.NORTH);

        //Arreglo de teclas usadas
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 5));
        panel.setBackground(Color.black);

        String[] botones = {
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "*", "cos", 
                "1", "2", "3", "-", "sen", 
                "0", ".", "=", "+", "tan",
                "C", "(", ")"
        };

        for (String cad : botones) {
            JButton boton = new JButton(cad);
            boton.addActionListener(new ButtonClickListener());
            boton.setFont(new Font("Arial", Font.PLAIN, 12));
            panel.add(boton);
        }

        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    //Clase anidada que les da el significado a cada una de las teclas
    public class ButtonClickListener implements ActionListener  {

        //Método que especifica como actuar a la calculadora
        public void actionPerformed(ActionEvent e) {

        JButton fuente = (JButton) e.getSource();
        String caracter = fuente.getText();

        switch(caracter){
        case "=" : 
            operar(sb.toString());
        break;
        case "C" : 
            texto.setText("");
            sb = new StringBuilder();
        break;
        default : sb.append(caracter);
            texto.setText(sb.toString());
            break;
            }
        }

        //Método auxiliar que toma las reglas de las otras clsaes y las aplica en la calculadora
        public void operar(String oper){
        try{
            comp = new Compilador();
            StringTokenizer lexemas = comp.analisisLexico(oper);
            CompositeEA nodo = comp.arbolDeAnalisisSintactico(lexemas);
            texto.setText(String.valueOf(nodo.evalua()));
            sb = new StringBuilder();
        }catch (ErrorDeSintaxisException w){
      }
    }
  }
}
