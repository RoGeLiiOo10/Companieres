package clases;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Lienzo extends JPanel implements MouseListener, MouseMotionListener{
    private Vector <Nodo> vectorNodos;
    private Vector <Enlace> vectorEnlaces;
    private Point p1, p2;
    private Nodo nodoMover;
    private int indice;
    
    public Lienzo() {
        this.vectorNodos = new Vector<>();
        this.vectorEnlaces = new Vector<>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        for (Nodo nodos : vectorNodos){
            nodos.pintar(g);
        }
        
        for (Enlace enlace : vectorEnlaces){
            enlace.pintar(g);
        }
    }    
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getButton() == MouseEvent.BUTTON1){
            String nombre = JOptionPane.showInputDialog("Ingresa el nombre del nodo: ");
            this.vectorNodos.add(new Nodo(me.getX(), me.getY(), nombre));
            repaint();
        }
        
        if (me.getButton() == MouseEvent.BUTTON3){
            for (Nodo nodo : vectorNodos){
                if(new Rectangle(nodo.getX() - Nodo.d/2, nodo.getY() - Nodo.d/2, Nodo.d, Nodo.d).contains(me.getPoint())){
                    if (p1 == null){
                        p1 = new Point(nodo.getX(), nodo.getY());   
                    }else{
                        p2 = new Point(nodo.getX(), nodo.getY());
                        String nombre = JOptionPane.showInputDialog("Ingresa el nombre del nodo: ");
                        this.vectorEnlaces.add(new Enlace(p1.x, p1.y, p2.x, p2.y, nombre));
                        repaint();
                        p1 = null;
                        p2 = null;
                    }                
                }
            }   
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        int i = 0;
        for (Nodo nodo : vectorNodos){
            if(new Rectangle(nodo.getX() - Nodo.d/2, nodo.getY() - Nodo.d/2, Nodo.d, Nodo.d).contains(me.getPoint())){
                nodoMover = nodo;
                indice = i;
                break;
            }
            i++;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        nodoMover = null;
        indice = -1;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        
    }

    @Override
    public void mouseExited(MouseEvent me) {
 
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if(nodoMover != null){
            this.vectorNodos.set(indice, new Nodo(me.getX(), me.getY(), nodoMover.getNombre()));
            int i = 0;
            for (Enlace enlace : vectorEnlaces) {
                if(new Rectangle(enlace.getX1() - Nodo.d/2, enlace.getY1() - Nodo.d/2, Nodo.d, Nodo.d).contains(me.getPoint())){
                    this.vectorEnlaces.set(i, new Enlace(me.getX(), me.getY(), enlace.getX2(), enlace.getY2(), enlace.getNombre()));
                }
                
                if(new Rectangle(enlace.getX2() - Nodo.d/2, enlace.getY2() - Nodo.d/2, Nodo.d, Nodo.d).contains(me.getPoint())){
                    this.vectorEnlaces.set(i, new Enlace(enlace.getX1(), enlace.getY1(), me.getX(), me.getY(), enlace.getNombre()));
                }
                i++;
                repaint();
            }
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        
    }

    

    
    
    
}
