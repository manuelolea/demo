package sim.bdeb.qc.ca.demo;

import javafx.geometry.HPos;
import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Camelot extends ObjetJeux{
    private Image camelot1 = new Image("camelot1.png");
    private Image camelot2 = new Image("camelot2.png");

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
    int index = (int) ((temps * 4) % 2);

    Image img;
    if (index == 0){
        img = camelot1;
    }else {
        img = camelot2;
    }
    double ecranX = position.getX() - camera.getPositionX();
    double ecranY = position.getY();
    context.drawImage(img, ecranX, ecranY);
    }

    @Override
    public void update(){
        if (dt <= 0){
            return;
    }
    temps += dt;

    double vx = vitesse.getX();
    double vy = vitesse.getY();

    boolean gauche = input.gauche;
    boolean droite = input.droite;
    boolean saut = input.saut;

    if(gauche){
        vx -= accel * dt;

    } else if (droite){
        vx += accel * dt;

    }else{
        if (vx < vitesseInitial){
            vx += accel * dt;

        } else if (vx > vitesseInitial) {
            vx -= accel * dt;
            
        }
    }

    if (vx < vitesseMin){
        vx = vitesseMin;
    }

    if (vx >  vitesseMax){
        vx = vitesseMax;
    }
    boolean sol = (position.getX() >= 400);

    if(saut && sol){
        vy = -500;
    }
    vy += gravite * dt;

    vitesse = new Point2D(vx, vy);
    position = position.add(vitesse.multiply(dt));

    if (position.getX() > 400) {
        position = new Point2D(position.getX(), 400);
        vitesse = new Point2D(vitesse.getX(), 0);
    }
    }
}
