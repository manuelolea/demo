package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BoitesAuxLettres extends ObjetJeux {
    private Image boitesAuLettresBlanches;
    private Image boitesAuLettresVertes;
    private Image boitesAuLettresRouges;
    private Image imgResultante;

    private double largueurImg = 81;
    private double hauteurImg = 76;

    boolean estTouche;

    private double posX;
    private double posY;

    public BoitesAuxLettres(double x, double y){
        this.boitesAuLettresBlanches = new Image("boite-aux-lettres.png");
        this.boitesAuLettresRouges = new Image("boite-aux-lettres-rouge.png");
        this.boitesAuLettresVertes = new Image("boite-aux-lettres-vert.png");
        this.imgResultante = boitesAuLettresBlanches;

        this.estTouche = false;

        this.posX = x;
        this.posY = y;
    }

    public double getLargueurImg() {
        return largueurImg;
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
        double ecranX =  posX - camera.getPositionX();
        double ecranY = posY;

        if (posX + largueurImg > 0 && ecranX < camera.getLongeureEcran()) {
            context.drawImage(imgResultante, ecranX, ecranY);
        }
    }

    @Override
    public int update(double dt) {
    return 0;
    }

    public int touche(boolean estAbonne){
        if (estTouche) {
            return 0;
        }
        this.estTouche = true;

        if (estAbonne) {
            imgResultante = boitesAuLettresRouges;
            return 1;
            // perd 2$ avec setter ou boolean
        } else {
            imgResultante = boitesAuLettresVertes;
            // gagne 2$ avec setter ou boolean
            return 0;
        }

    }
}
