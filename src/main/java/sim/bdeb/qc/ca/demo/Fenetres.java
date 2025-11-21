package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fenetres extends ObjetJeux{
    private Image fenetresBlanches;
    private Image fenetresVertes;
    private Image fenetresRouges;

    public Fenetres (){
        this.fenetresBlanches = new Image("fenetre.png");
        this.fenetresVertes = new Image("fenetre-brisee-vert.png");
        this.fenetresRouges = new Image("fenetre-brisee-rouge.png");
    }

    @Override
    public void draw(GraphicsContext context, CameraJeu camera) {
        double posYImages= camera.getPositionY();
        double posXImages= camera.getPositionX();
        context.drawImage(fenetresBlanches,posXImages,posYImages);
    }

    @Override
    public void update(){}
}
