package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Maison {
    private Random randfenetres = new Random();
    private int nombreFenetres = randfenetres.nextInt(3);
    private int positionMaisonX;
    private int positionMaisonY;
    private int LongeureMaison;
    private int HauteureMaison;

    public Maison(int positionMaisonX,int positionMaisonY) {
        this.LongeureMaison =1300;
        this.LongeureMaison=580;
        this.positionMaisonX =positionMaisonX;
        this.positionMaisonY = positionMaisonY;

    }
    public void drawHouse(GraphicsContext context){


    }
}
