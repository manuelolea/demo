package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;import javafx.scene.image.Image;
import javafx.scene.text.TextAlignment;


public class Porte extends ObjetJeux{
    private double hauteurPorte= 195;
    private double largeurPorte = 143;

    private Image porte;

    private  Color couleurNumero = Color.GOLD;

    private double posPorteX;
    private double posPorteY;
    private int numAdresse;

    public Porte(double posPorteX, double posPorteY, int numAdresse) {
        this.posPorteX = posPorteX;
        this.posPorteY = posPorteY;
        this.numAdresse = numAdresse;

        this.porte = new Image("porte.png");
    }

    public double getX() {return posPorteX;}
    public double getY() {return posPorteY;}

    @Override
    public void draw(GraphicsContext context, CameraJeu camera) {
        double ecranX = posPorteX - camera.getPositionX();
        double ecranY = posPorteY;

        if (ecranX + largeurPorte > 20 && ecranX < camera.getLongeureEcran()){
            context.drawImage(porte, ecranX, ecranY, largeurPorte, hauteurPorte);

            context.setFill(couleurNumero);
            context.setFont(Font.font("Arial",40));
            context.setTextAlign(TextAlignment.CENTER);
            context.fillText(Integer.toString(numAdresse), ecranX +(largeurPorte/2), ecranY + 60);
            context.setTextAlign(TextAlignment.LEFT);

    }
    }

    @Override
    public int update(double dt) {
        return 0;
    }
}
