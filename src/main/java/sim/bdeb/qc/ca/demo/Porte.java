package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Porte extends ObjetJeux{
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

    public int getHauteurPorte() {
        return hauteurPorte;
    }

    public int getLargeurPorte() {
        return largeurPorte;
    }

    public int getPosPorteX() {
        return posPorteX;
    }

    public int getPosPorteY() {
        return posPorteY;
    }

    @Override
    public void draw(GraphicsContext context, CameraJeu camera) {
        double ecranX = posPorteX - camera.getPositionX();
        double ecranY = posPorteY;

        if (ecranX + largeurPorte > 0 && ecranX < camera.getLongeureEcran()){

        context.setFill(couleurPorte);
        context.fillRect(posPorteX,posPorteY,largeurPorte,hauteurPorte);
        context.setFill(couleurNumero);
        context.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        context.fillText(Integer.toString(numAdresse),posPorteX + 10,posPorteX + 40);
    }
    }

    @Override
    public int update(double dt) {
        return 0;
    }
}
