package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
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

    // a ajouter dans la classse partie pour afficher dans la barre de jeu de type ( 208 400 573 679 399)
    private String listeMaison;

    public barreJeu(String listeMaison) {
        this.barrePosX = 0;
        this.barrePosY = 0;
        this.largeurBarre = 1300;
        this.couleurBarre = Color.rgb(0, 0, 0, 0.4);
        this.hauteurBarre = 40;
        this.journeauxRestants= 24;
        this.argent = 0;
        this.imageArgent = new Image("icone-dollar.png");
        this.imageJournal = new Image("icone-journal.png");
        this.imageMaison = new Image("icone-maison.png");
        this.listeMaison = listeMaison;

    }
// a ajouter dans la classe partie quand un journeau touche boite aux lettre ou casse fenetre
    public void setJourneauxRestants(int journeauxRestants) {
        this.journeauxRestants = journeauxRestants;
    }
// a ajouter dans classe partie quand un journeau est utiliser
    public void setArgent(int argent) {
        this.argent = argent;
    }

    public void drawBarre(GraphicsContext context){
        context.setFill(couleurBarre);
        context.fillRect(barrePosX, barrePosY, largeurBarre, hauteurBarre);
        context.drawImage(imageJournal, barrePosX+2, barrePosY+2);
       context.fillText(String.valueOf(journeauxRestants),barrePosX+43,barrePosY+2);
        context.drawImage(imageArgent, barrePosX+55, barrePosY+2);
        context.fillText(String.valueOf(argent),barrePosX+100, barrePosY+2);
        context.drawImage(imageMaison, barrePosX+120, barrePosY+2);
        context.fillText(listeMaison,barrePosX+200, barrePosY+2);
    }

}
