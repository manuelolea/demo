package sim.bdeb.qc.ca.demo;

import java.util.ArrayList;

public class Niveau {
    private final int nombreParticules;
    public double finNiveauX;

    private ArrayList<ParticulesCharges> listeParticules;
    private ArrayList<Maison> listeMaison;

    private String chaineAdresse = "";

    public Niveau(int numNiveau, double largueurEcran, double hauteurEcran) {
        this.listeMaison = new ArrayList<>();
        this.listeParticules = new ArrayList<>();

        if (numNiveau >= 2) {
            int nbrParticules = (numNiveau - 1) * 30;
            this.nombreParticules = Math.min(nbrParticules, 400);
        } else {
            this.nombreParticules = 0;
        }
        genererMaison(largueurEcran);
        genererParticules(largueurEcran, hauteurEcran);
    }

    public void genererMaison(double largueurEcran) {
        int adresse = 100 + (int) (Math.random() * 850);
        StringBuilder listetemporaire = new StringBuilder();
        double derniereMaisonX = 0;

        for (int i = 0; i < 12; i++) {
            double maisonX = (i + 1) * 1300;
            boolean estAbonne = Math.random() < 0.5;

            Maison m = new Maison(maisonX, adresse, estAbonne);
            listeMaison.add(m);

            if (estAbonne) {
                listetemporaire.append(adresse).append("  ");
            }
            adresse += 2;
            derniereMaisonX = maisonX;
        }
        this.chaineAdresse = listetemporaire.toString();
        this.finNiveauX = derniereMaisonX + (1.5 * largueurEcran);
    }

    private void genererParticules(double largueurEcran, double hauteurEcran) {
        if (nombreParticules <= 0) return;

        double largueurTotalNiv = this.finNiveauX;

        for (int i = 0; i < nombreParticules; i++) {
            double rndX = Math.random() * largueurTotalNiv;
            double rndY = Math.random() * hauteurEcran;
            listeParticules.add(new ParticulesCharges(rndX, rndY));
        }
    }


    public ArrayList<ParticulesCharges> getListeParticules() {
        return listeParticules;
    }

    public double getFinNiveauX() {
        return finNiveauX;
    }

    public ArrayList<Maison> getListeMaison() {
        return listeMaison;
    }

    public String getChaineAdresse() {
        return chaineAdresse;
    }


}