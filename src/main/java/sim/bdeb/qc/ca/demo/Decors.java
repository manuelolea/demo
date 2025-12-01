package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Decors extends ObjetJeux {
    //attribut
    private Image imgBrique;


    // constructeur sans attributs
    public Decors() {
        this.imgBrique = new Image("brique.png");
    }

    //surcharge methode draw() et update() de la classe ObjetJeux
    @Override
    public void draw(GraphicsContext context, CameraJeu camera){
        //couleure arrière-plan est noire
        context.setFill(Color.BLACK);
        context.fillRect(0,0,camera.getLongeureEcran(), camera.getHauteureEcran());

        // hauteur et l'argeur de l'image brique
        double largueurBrique = imgBrique.getWidth();
        double hauteurBrique = imgBrique.getHeight();

        //remplissage des brique seulement vissible par la camméra
        // (int) sert a tronquer vers la bas car un nombre de collonnes peut juste etre un Interger
        int colonneDebut = (int) (camera.getPositionX()/ largueurBrique);
        int colonneFin = (int) ((camera.getPositionX() + camera.getLongeureEcran())/largueurBrique) + 2;
        int nbBriqueY = (int) Math.ceil(camera.getHauteureEcran()/hauteurBrique) + 1;
        for (int i = colonneDebut; i < colonneFin ; i++) {
            for (int j = 0; j < nbBriqueY ; j++) {
                double mondeX = i * largueurBrique;
                double mondeY = j * hauteurBrique;
                double xEcran = mondeX - camera.getPositionX();

                context.drawImage(imgBrique, xEcran, mondeY);
            }
        }
    }

    @Override
    public int update(double dt){
        return 0;
    }

}