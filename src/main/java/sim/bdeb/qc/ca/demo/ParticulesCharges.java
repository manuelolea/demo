package sim.bdeb.qc.ca.demo;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class ParticulesCharges {
    private static final double RAYON_GRAPHIQUE = 10.0;

    // --- Attributs ---
    private  Point2D position;
    private  double charge;
    private Color couleur;

    public ParticulesCharges(double x, double y, double charge) {
        this.position = new Point2D(x, y);
        this.charge = charge;

        // Initialisation de la couleur vive aléatoire (HSB)
        double teinte = Math.random() * 360.0;
        this.couleur = Color.hsb(teinte, 1.0, 1.0);
    }

}
