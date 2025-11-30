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

    // a ajouter dans la classse partie pour afficher dans la barre de jeu de type ( 208 400 573 679 399)
    private String listeMaison;

    public barreJeu(double largueurEcran) {
        this.largeurEcran = largueurEcran;
        this.hauteurBarre = 40;

        this.imageArgent = new Image("icone-dollar.png");
        this.imageJournal = new Image("icone-journal.png");
        this.imageMaison = new Image("icone-maison.png");
    }

    }


