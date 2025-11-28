package sim.bdeb.qc.ca.demo;

import sim.bdeb.qc.ca.demo.CameraJeu;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Decors extends ObjetJeux {

    private Image brique;



    public Decors() {
        this.brique = new Image("brique.png");

    }


    public Image getBrique() {
        return brique;
    }
    @Override
    public void draw(GraphicsContext context, CameraJeu camera){
        context.setFill(Color.BLACK);
        context.fillRect(0,0,camera.getLongeureEcran(), camera.getHauteureEcran());

        double largueurBrique = brique.getWidth();
        double hauteurBrique = brique.getHeight();

        int colonneDebut = (int) (camera.getPositionX()/ largueurBrique);
        int colonneFin = (int) ((camera.getPositionX() + camera.getLongeureEcran())/largueurBrique) + 2;

        int nbBriqueY = (int) Math.ceil(camera.getHauteureEcran()/hauteurBrique) + 1;

        for (int i = colonneDebut; i < colonneFin ; i++) {
            for (int j = 0; j < nbBriqueY ; j++) {
                double mondeX = i * largueurBrique;
                double mondeY = j * hauteurBrique;
                double xEcran = mondeX - camera.getPositionX();

                context.drawImage(brique, xEcran, mondeY);
            }
        }
    }

    @Override
    public void update(double dt){}

}