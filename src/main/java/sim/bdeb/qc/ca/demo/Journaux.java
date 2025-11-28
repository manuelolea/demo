package sim.bdeb.qc.ca.demo;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Journaux extends ObjetJeux{

    private Image journal = new Image("journal.png");

    private double largueurJournal = 52;
    private double hauteurJournal = 31;

    private Point2D position;
    private Point2D vitesse;
    private  double masse;

    private double gravite = 1500;
    private double vitesseMax = 1500;


    public Journaux(Camelot camelot, double masse, boolean lancerHaut, boolean lancerDroit, boolean force){
        this.masse = masse;

        double debutX = camelot.getPosition().getX() + ((camelot.getLargueurCamelot())/2) - (this.largueurJournal / 2);
        double debutY = camelot.getPosition().getY() + ((double) 144 /2) - (this.hauteurJournal / 2);

        this.position = new Point2D(debutX,debutY);
        Point2D pInitial;

        if (lancerHaut){
            pInitial = new Point2D(900,-900);
        }else {
            pInitial=new Point2D(150,-1100);
        }

        if (force){
            pInitial = pInitial.multiply(1.5);
        }

        Point2D vitesseCamelot = camelot.getVitesse();
        this.vitesse = vitesseCamelot.add(pInitial.multiply(1/this.masse));
    }

    public double getX() {
        return position.getX();
    }
    public double getY() {
        return position.getY();
    }

    public double getLargueurJournal() {
        return largueurJournal;
    }

    public double getHauteurJournal() {
        return hauteurJournal;
    }

    @Override
    public void draw(GraphicsContext context, CameraJeu camera) {
        double xEcran = position.getX() - camera.getPositionX();
        double yEcran = position.getY();

        if (xEcran + largueurJournal > 0 && xEcran < camera.getLongeureEcran()){
            context.drawImage(journal, xEcran, yEcran);
        }
    }

    @Override
    public int update(double dt){
        double vy = vitesse.getY() + (gravite * dt);
        double vx = vitesse.getX();

        this.vitesse = new Point2D(vx,vy);
        /*Limite la vitesse du journal
          Verifie que le module du vecteur journal ne depasse pas 1500px/s
          Si le vecteur est plus long que la vMax on le redimensionne à l'aide de
          .magnitude() pour que v = vMax */

        if (this.vitesse.magnitude() > vitesseMax){
            this.vitesse = this.vitesse.multiply(vitesseMax/this.vitesse.magnitude());
        }

        this.position = this.position.add(this.vitesse.multiply(dt));
        return 0;
    }

    public boolean estSorti(CameraJeu camera){
        double xEcran = position.getX() - camera.getPositionX();
        double yEcran = position.getY();

        if (yEcran > camera.getHauteureEcran()) {
            return true;
        } else if (xEcran + largueurJournal < 0) {
            return true;
        } else if (xEcran > camera.getLongeureEcran()) {
            return true;
        }
    return false;
    }
}
