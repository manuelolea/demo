package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class BarreJeu {
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
//dessine la barre de jeu en haut de l'ecran sans tenir compte de la camera de jeu
    public void draw(GraphicsContext context, int nbJournaux, int argent, String listeAdresse){
        context.setFill(Color.rgb(0,0,0,0.5));
        context.fillRect(0,0,largeurEcran,hauteurBarre);

        context.setFill(Color.WHITE);
        context.setFont(Font.font("Arial", FontWeight.BOLD,20));
        context.setTextAlign(TextAlignment.LEFT);

        context.drawImage(imageJournal,10,5,30,30);
        context.fillText(String.valueOf(nbJournaux), 45, 28);

        context.drawImage(imageArgent,100,5,40,30);
        context.fillText(String.valueOf(argent),145,28);

        context.drawImage(imageMaison,220,5,30,30);

        context.setFill(Color.LIGHTGRAY);
        context.setFont(Font.font("Arial",FontWeight.BOLD,18));
        context.fillText(listeAdresse,260,28);
    }

}
