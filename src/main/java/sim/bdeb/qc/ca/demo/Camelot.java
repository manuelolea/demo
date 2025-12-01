package sim.bdeb.qc.ca.demo;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Camelot extends ObjetJeux{
    private Image camelot1 = new Image("camelot1.png");
    private Image camelot2 = new Image("camelot2.png");

    private double vitesseInitial = 400;
    private double accel = 300;
    private double vitesseMin = 200;
    private double vitesseMax = 600;
    private double gravite = 1500;

    private double largueurCamelot = 172;
    private double hauteurCamelot = 144;

    public double getLargueurCamelot() {
        return largueurCamelot;
    }

    public Point2D getVitesse(){
        return vitesse;
    }

    private Point2D position;
    private Point2D vitesse;

    private double temps= 0.0;

    private Input input = new Input();

    public Camelot(double x, double y){
        this.position = new Point2D(x,y);
        this.vitesse = new Point2D(vitesseInitial,0 );
    }


    public void setInput(Input input) {
        if(input != null){
            this.input = input;
        }
    }
    public Point2D getPosition(){
        return position;
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
    public int update(double dt){
        if (dt <= 0){
            return 0;
    }
    temps += dt;

    double vx = vitesse.getX();
    double vy = vitesse.getY();

    boolean gauche = Input.gauche;
    boolean droite = Input.droite;
    boolean saut = Input.saut;

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

    boolean sol = (position.getY() >= 436 - 1);

    if(saut && sol){
        vy = -500;
    }
    vy += gravite * dt;

    vitesse = new Point2D(vx, vy);
    position = position.add(vitesse.multiply(dt));

    if (position.getY() > 436) {
        position = new Point2D(position.getX(), 436);
        vitesse = new Point2D(vitesse.getX(), 0);
    }
        return 0;
    }

    public void setPosition(int i, int i1) {
    }

    public void setVitesse(int i, int i1) {
    }

}
