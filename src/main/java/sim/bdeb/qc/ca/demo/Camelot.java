package sim.bdeb.qc.ca.demo;

import javafx.geometry.HPos;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Camelot extends ObjetJeux{
    private Image camelot1 = new Image("camelot1");
    private Image camelot2 = new Image("camelot2");

    private static double vitesseInitial = 400;
    private static double accel = 300;
    private static double vitesseMin = 200;
    private static double vitesseMax = 600;
    private static double gravite = 1500;

    private static double largueurCamelot = 172;
    private static double hauteurCamelot = 144;

    private Point2D position;
    private Point2D vitesse;

    private double temps= 0.0;
    private double dt = 0.0;

    private Input input= new Input();

    public Camelot(double x, double y){
        this.position = new Point2D(x,y);
        this.vitesse = new Point2D(vitesseInitial,0 );
    }

    public void setDt(double dt) {
        this.dt = dt;
    }

    public void setInput(Input input) {
        if(input != null){
            this.input = input;
        }
    }

    @Override
    public void draw(GraphicsContext context,  CameraJeu camera) {

    }

    @Override
    public void update(){}
}
