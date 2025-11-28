package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

public class Maison {
    private Random randfenetres = new Random();
    private int nombreFenetres = randfenetres.nextInt(3);
    private int positionMaisonX;
    private int positionMaisonY;
    private int LongeureMaison;
    private int numAdresse;
    private int HauteureMaison;
    boolean estAbonne;

    public Maison(int positionMaisonX,int positionMaisonY,int numAdresse, boolean estAbonne) {
        this.LongeureMaison =1300;
        this.HauteureMaison=580;
        this.positionMaisonX =positionMaisonX;
        this.positionMaisonY = positionMaisonY;
        this.numAdresse = numAdresse;
        this.estAbonne = estAbonne;
    }
    public void creerMaison(GraphicsContext context, CameraJeu camera){
        creerPorte(context);
        creerFenetres(context,camera);



    }
    public void creerFenetres(GraphicsContext context, CameraJeu camera){
        int hauteurFenetre = positionMaisonY + 50;
        Fenetres fenetre1 = new Fenetres(positionMaisonX+300,hauteurFenetre);
        Fenetres fenetre2 = new Fenetres(positionMaisonX+600,hauteurFenetre);
        switch (nombreFenetres){
            case 1 :
                fenetre1.draw(context,camera);
            break;
            case 2 :
                fenetre1.draw(context,camera);
                fenetre2.draw(context,camera);
                break;
            default:
                break;
        }
    }
    public void creerBoitesAuxLettres(GraphicsContext context, CameraJeu camera){}

    public void creerPorte(GraphicsContext context){
        int posPorteX = positionMaisonX + 1260;
        int posPorteY = positionMaisonY + 430;
        Porte porte1 = new Porte(posPorteX,posPorteY,numAdresse);
        porte1.drawDoor(context);
    }
}
