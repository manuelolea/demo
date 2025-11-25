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
        double debutY = camelot.getPosition().getX() + ((camelot.getLargueurCamelot())/2) - (this.largueurJournal / 2);

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
    @Override
    public void draw(GraphicsContext context, CameraJeu camera) {

    }

    @Override
    public void update(){}
}
