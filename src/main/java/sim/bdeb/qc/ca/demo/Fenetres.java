package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fenetres extends ObjetJeux {
    private Image fenetresBlanches;
    private Image fenetresVertes;
    private Image fenetresRouges;
    boolean estTouche;
    private Image imageCourante;

    private double largeur = 159;
    private double hauteur = 130;

    private double posX;
    private double posY;

    public Fenetres(double x, double y) {
        this.posX = x;
        this.posY = y;
        this.fenetresBlanches = new Image("fenetre.png");
        this.fenetresVertes = new Image("fenetre-brisee-vert.png");
        this.fenetresRouges = new Image("fenetre-brisee-rouge.png");
        this.imageCourante = fenetresBlanches;
        this.estTouche = false;
    }

    public boolean isEstTouche() {
        return estTouche;
    }

    public void setEstTouche(boolean estTouche) {
        this.estTouche = estTouche;
    }

    public double getLargeur() {
        return largeur;
    }

    public double getHauteur() {
        return hauteur;
    }

    public double getX() {
        return posX;
    }

    public double getY() {
        return posY;
    }

    @Override
    public void draw(GraphicsContext context, CameraJeu camera) {
        double posXImages = posX - camera.getPositionX();
        double posYImages = posY;

        if (posX + largeur > 0 && posXImages < camera.getLongeureEcran()) {
            context.drawImage(imageCourante, posXImages, posYImages);
        }
    }

    @Override
    public void update(double dt) {
    }

    public int touche(boolean estAbonne) {

        if (estTouche) {
            return 0;
        }
        this.estTouche = true;

        if (estAbonne) {
            imageCourante = fenetresRouges;
            return -2;
            // perd 2$ avec setter ou boolean
        } else {
            imageCourante = fenetresVertes;
            // gagne 2$ avec setter ou boolean
            return 2;
        }
    }
}
