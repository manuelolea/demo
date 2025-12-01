package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class barreJeu {
    protected double hauteurBarre;
    protected double largeurEcran;

    private Image imageJournal;
    private Image imageArgent;
    private Image imageMaison;
    
    public BarreJeu(double largueurEcran) {
        this.largeurEcran = largueurEcran;
        this.hauteurBarre = 40;

        this.imageArgent = new Image("icone-dollar.png");
        this.imageJournal = new Image("icone-journal.png");
        this.imageMaison = new Image("icone-maison.png");
    }

    }


