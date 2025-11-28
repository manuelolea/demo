package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fenetres extends ObjetJeux {
    private Image fenetresBlanches;
    private Image fenetresVertes;
    private Image fenetresRouges;
    boolean estTouche;
    private Image imageResultante;

    private double largeurImg = 159;
    private double hauteurImg = 130;

    private double posX;
    private double posY;

    public Fenetres(double x, double y) {
        this.posX = x;
        this.posY = y;
        this.fenetresBlanches = new Image("fenetre.png");
        this.fenetresVertes = new Image("fenetre-brisee-vert.png");
        this.fenetresRouges = new Image("fenetre-brisee-rouge.png");
        this.imageResultante = fenetresBlanches;
        this.estTouche = false;
    }

    public boolean isEstTouche() {
        return estTouche;
    }

    public void setEstTouche(boolean estTouche) {
        this.estTouche = estTouche;
    }

    public double getLargeurImg() {
        return largeurImg;
    }

    public double getHauteurImg() {
        return hauteurImg;
    }

    public double getX() {
        return posX;
    }

    public double getY() {
        return posY;
    }

    @Override
    public void draw(GraphicsContext context, CameraJeu camera) {
        double ecranX = posX - camera.getPositionX();
        double ecranY = posY;


       
        if (posX + largeurImg > 0 && ecranX < camera.getLongeureEcran()) {
            context.drawImage(imageResultante, ecranX, ecranY);
        }
    }

    @Override
    public int update(double dt) {
        return 0;
    }

    public int touche(boolean estAbonne) {

        if (estTouche) {
            return 0;
        }
        this.estTouche = true;

        if (estAbonne) {
            imageResultante = fenetresRouges;
            return -2;
            // perd 2$ avec setter ou boolean
        } else {
            imageResultante = fenetresVertes;
            // gagne 2$ avec setter ou boolean
            return 2;
        }
    }
}
