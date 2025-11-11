package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Decors extends ObjetJeux {

    private Image brique;
    private double hauteurInterface;
    private double largueurInterface;
    private Camera camera;

    public Decors() {
        this.brique = new Image("brique.png");
        this.hauteurInterface = hauteurInterface;
        this.largueurInterface = largueurInterface;
        this.camera = camera;


    }

    public static void afficherDecor(GraphicsContext context, double largeurInterface, double hauteurInterface){
    context.setFill(Color.BLACK);
    context.fillRect(0,0,largeurInterface,hauteurInterface);

    }
}