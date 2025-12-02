package sim.bdeb.qc.ca.demo;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Classe utilitaire qui fournit une méthode pour dessiner une flèche sur
 * un GraphicsContext2D dans un Canvas JavaFX
 */
public class UtilitairesDessins {
    // Classe de méthodes static seulement, pas d'instances autorisées
    private UtilitairesDessins() {}

    // Clamp maison (0 ≤ valeur ≤ max)
    private static double clamp(double value, double min, double max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    /**
     * Dessine le vecteur fourni à partir d'un certain point sur l'écran.
     * Si le vecteur est trop long, on le tronque à une longueur max.
     */
    public static void dessinerVecteurForce(Point2D origineEcran, Point2D vecteur, GraphicsContext context) {
        if (Double.isNaN(vecteur.getX()) || Double.isNaN(vecteur.getY())) {
            // Maths foireuses (genre division par 0) -> on skip
            return;
        }

        double longueurMax = 80;
        double forceMax = 80;

        double magnitude = vecteur.magnitude();
        if (magnitude == 0) return;

        double pourcentage = clamp(magnitude, 0, forceMax) / forceMax;

        Point2D vecteurAffiche = vecteur.normalize().multiply(pourcentage * longueurMax);

        dessinerVecteur(origineEcran, vecteurAffiche, context);
    }

    private static void dessinerVecteur(Point2D origineEcran, Point2D vecteur, GraphicsContext context) {
        final double rayon = 1.5;
        var finEcran = origineEcran.add(vecteur);

        context.save();
        context.setStroke(Color.CORAL);
        context.setFill(Color.CORAL);
        context.setLineWidth(2);

        // Base du vecteur
        context.fillOval(
                origineEcran.getX() - rayon, origineEcran.getY() - rayon,
                rayon * 2, rayon * 2);

        // Magnitude proche de zéro : pas de tête de flèche
        if (vecteur.dotProduct(vecteur) < rayon * rayon) {
            context.restore();
            return;
        }

        // Corps de la flèche
        context.strokeLine(
                origineEcran.getX(), origineEcran.getY(),
                finEcran.getX(), finEcran.getY()
        );

        // Tête de la flèche
        context.translate(finEcran.getX(), finEcran.getY());
        context.rotate(Math.toDegrees(Math.atan2(vecteur.getY(), vecteur.getX())));
        context.fillPolygon(
                new double[]{0, 10, 0},
                new double[]{-10, 0, 10},
                3
        );

        context.restore();
    }
}