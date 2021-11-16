import java.awt.Graphics;

public class Enlace {
    private int x1,x2,y1,y2;
    private String nom;

    public Enlace(int x1, int x2, int y1, int y2, String nom) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void pintar (Graphics g){
        g.drawLine(x1,y1,x2,y2);
        if(x1 > x2 && y1 > y2){
            g.drawString(nom,x1 - Math.abs((x1-x2)/2),y1 - Math.abs((y1-y2)/2));
        }
         if(x1 < x2 && y1 < y2){
            g.drawString(nom,x2 - Math.abs((x1-x2)/2),y2 - Math.abs((y1-y2)/2));
        }
         if(x1 > x2 && y1 < y2){
            g.drawString(nom,x1 - Math.abs((x1-x2)/2),y2 - Math.abs((y1-y2)/2));
        }
         if(x1 < x2 && y1 > y2){
            g.drawString(nom,x2 - Math.abs((x1-x2)/2),y1 - Math.abs((y1-y2)/2));
        }
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    
    
}
