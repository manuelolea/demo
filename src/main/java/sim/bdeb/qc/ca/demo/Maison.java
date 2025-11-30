package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.Random;

public class Maison {
    private Porte porte;
    private BoitesAuxLettres boitesAuxLettres;
    private ArrayList<Fenetres> fenetres;
    private double x;
    private double largueurMaison = 1300;
    private int numAdresse;
    private double hauteureMaison = 580;
    boolean estAbonne;

    private Random rnd = new Random();

    public Maison(double x,int numAdresse, boolean estAbonne) {
        this.x = x;
        this.fenetres = new ArrayList<>();
        this.numAdresse = numAdresse;
        this.estAbonne = estAbonne;

        creerComposantes();
    }

    public BoitesAuxLettres getBoitesAuxLettres() {
        return boitesAuxLettres;
    }

    public ArrayList<Fenetres> getFenetres() {
        return fenetres;
    }

    public double getLargueurMaison() {
        return largueurMaison;
    }

    public void creerComposantes(){
        double hauteurImagePorte = 195;
        double porteY = hauteureMaison - hauteurImagePorte;

        this.porte = new Porte(x,porteY,numAdresse);

        double boiteX = x + 200;

        double minBoiteY = hauteureMaison * 0.20;
        double maxBoiteY = hauteureMaison * 0.70;
        double boiteY = minBoiteY + (rnd.nextDouble() * (maxBoiteY - minBoiteY));

        this.boitesAuxLettres = new BoitesAuxLettres(boiteX, boiteY);

        genererFentres();
    }
    public void genererFentres(){
        int nombreFenetres = rnd.nextInt(3);
        double fenetreY = 50;

        if (nombreFenetres >= 1){
            fenetres.add(new Fenetres(x + 300,fenetreY));
        }
        if (nombreFenetres == 2){
         fenetres.add(new Fenetres(x + 600, fenetreY));
        }
    }

    public int getNumAdresse() {
        return numAdresse;
    }

    public void draw(GraphicsContext context, CameraJeu camera){
        porte.draw(context,camera);
        boitesAuxLettres.draw(context,camera);

        for (int i = 0; i < fenetres.size(); i++) {
            Fenetres f = fenetres.get(i);
            f.draw(context,camera);
        }
    }
}
