package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BoitesAuxLettres extends ObjetJeux {
    private final Image boitesAuLettresBlanches;
    private final Image boitesAuLettresVertes;
    private final Image boitesAuLettresRouges;
    private Image imgResultante;
    private final double largueurImg = 81;
    private final double hauteurImg = 76;
    boolean estTouche;
    private final double posX;
    private final double  posY;

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
    // dessine la boite aux letre selon la position de la camera
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

// cette methode fait que la boite aux lettre est toucheée et determine le gain selon le boolean estAbonne
    public int touche(boolean estAbonne){
        this.estTouche = true;
        if (estAbonne) {
            imgResultante = boitesAuLettresVertes;
            return 1;
        } else {
            imgResultante = boitesAuLettresRouges;
            return 0;
        }
    }
}
