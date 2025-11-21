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
        //double positionCameraX = camera.getPositionX();

        //double decalageCameraX = positionCameraX % largueurBrique;
        int nbBriqueX = (int) Math.ceil(camera.getLongeureEcran()/largueurBrique) + 1;
        int nbBriqueY = (int) Math.ceil(camera.getHauteureEcran()/hauteurBrique) + 1;

        for (int i = 0; i < nbBriqueX ; i++) {
            for (int j = 0; j < nbBriqueY ; j++) {
                double x = i * largueurBrique; //- decalageCameraX;
                double y = j * hauteurBrique;

                context.drawImage(getBrique(), x, y);
            }
        }
    }

    @Override
    public void update(){}

}