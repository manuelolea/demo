package sim.bdeb.qc.ca.demo;

import javafx.scene.paint.Color;

public class barreJeu {
    protected int barrePosX;
    protected int barrePosY;
    protected int hauteurBarre;
    protected int largeurBarre;
    protected Color couleurBarre;

    public barreJeu( int largeurBarre, int hauteurBarre) {
        this.barrePosX = 0;
        this.barrePosY = 0;
        this.largeurBarre = 1300;
        this.couleurBarre = Color.rgb(0, 0, 0, 0.4);
        this.hauteurBarre = 30;

    }
}
