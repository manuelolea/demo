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
    public void creerMaison(GraphicsContext context){
        creerPorte(context);



    }
    public void creerFenetres(GraphicsContext context){}
    public void creerBoitesAuxLettres(GraphicsContext context){}
    public void creerPorte(GraphicsContext context){
        int posPorteX = positionMaisonX + 1260;
        int posPorteY = positionMaisonY + 430;
        Porte porte1 = new Porte(posPorteX,posPorteY,numAdresse);
    }
}
