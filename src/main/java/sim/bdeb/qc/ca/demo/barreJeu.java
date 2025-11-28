package sim.bdeb.qc.ca.demo;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class barreJeu {
    protected int barrePosX;
    protected int barrePosY;
    protected int hauteurBarre;
    protected int largeurBarre;
    protected Color couleurBarre;

    private int journeauxRestants;
    private int argent;
    private Image imageArgent;
    private Image imageMaison;
    private Image imageJournal;

    public barreJeu() {
        this.barrePosX = 0;
        this.barrePosY = 0;
        this.largeurBarre = 1300;
        this.couleurBarre = Color.rgb(0, 0, 0, 0.4);
        this.hauteurBarre = 30;
        this.journeauxRestants= 24;
        this.argent = 0;
        this.imageArgent = new Image("icone-dollar.png");
        this.imageJournal = new Image("icone-journal.png");
        this.imageMaison = new Image("icone-maison.png");

    }

    public void drawBarre(){

    }

}
