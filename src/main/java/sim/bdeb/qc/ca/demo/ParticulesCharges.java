package sim.bdeb.qc.ca.demo;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ParticulesCharges  extends ObjetJeux{
    private  double rayon = 10.0;

    private  Point2D position;
    private  double charge;
    private Color couleur;

    public ParticulesCharges(double x, double y) {
        this.position = new Point2D(x, y);
        this.charge = 900;
        this.couleur = Color.hsb(Math.random() * 360, 1.0, 1.0);
    }

    public Point2D getPosition() {return position;}

    public double getCharge() {return charge;}

    @Override
    public void draw(GraphicsContext context, CameraJeu cameraJeu){
        double ecranX = position.getX() - cameraJeu.getPositionX();
        double ecranY = position.getY();

        if (ecranX + rayon > 0 && ecranX - rayon < cameraJeu.getLongeureEcran()){
            context.setFill(couleur);
            context.fillOval(ecranX - rayon, ecranY - rayon, rayon * 2, rayon * 2);
        }
    }
    @Override
    public int update(double dt){
        return 0;
    }
}
