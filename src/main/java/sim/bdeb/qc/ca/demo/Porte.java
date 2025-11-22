package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Porte {
    private int hauteurPorte=150;
    private int largeurPorte = 80;
    private Color couleurPorte = Color.BROWN;
    private Color couleurNumero = Color.YELLOW;
    private int posPorteX;
    private int posPorteY;
    private int numAdresse;

    public Porte(int posPorteX, int posPorteY, int numAdresse) {
        this.posPorteX = posPorteX;
        this.posPorteY = posPorteY;
        this.numAdresse = numAdresse;
    }
    public void drawDoor(GraphicsContext context){
        context.setFill(couleurPorte);
        context.fillRect(posPorteX,posPorteY,largeurPorte,hauteurPorte);
        context.setFill(couleurNumero);
        context.fillText(Integer.toString(numAdresse),posPorteX+5,posPorteX+10);
    }

}
