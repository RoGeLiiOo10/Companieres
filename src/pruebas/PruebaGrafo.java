package pruebas;

import clases.Lienzo;
import javax.swing.JFrame; 

public class PruebaGrafo{
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Grafo");
        ventana.add(new Lienzo());
        ventana.setSize(600, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
