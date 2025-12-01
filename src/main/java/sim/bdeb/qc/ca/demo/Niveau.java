package sim.bdeb.qc.ca.demo;

import java.util.ArrayList;

public class Niveau {
    private final int nombreParticules;
    private ArrayList <ParticulesCharges> listeParticules;
    private ArrayList <Maison> listeMaison;

    private double finNiveauX;

    public Niveau(int numNiveau, double largueurEcran, double hauteurEcran) {
        if (numNiveau >= 2) {
            int nbrParticules = (numNiveau - 1) * 30;
            this.nombreParticules = Math.min(nbrParticules, 400);
        } else {
            this.nombreParticules = 0;
        }
        this.listeMaison = new ArrayList<>();
        this.listeParticules = new ArrayList<>();
    }


    public void genererElements(double largeurEcran, double hauteurEcran) {
        int adresse = 100 + (int)(Math.random() * 850);

        for (int i = 0; i < 12; i++) {
            double maisonX = (i + 1) * 1300;
            boolean estAbonne = Math.random() < 0.5;

            Maison m = new Maison(maisonX, adresse, estAbonne);
            listeMaison.add(m);

            adresse += 2;

            if (i == 11){
                this.finNiveauX = maisonX + (1.5 * largeurEcran);
        }
        }
    }
    private void genererPArticules(double largueurEcran, double hauteurEcran){
        double largueurTotalNiveau = this.finNiveauX;

        for (int i = 0; i < nombreParticules; i++) {
            double rndX = Math.random() * largueurTotalNiveau;
            double rndY = Math.random() * hauteurEcran;

            listeParticules.add(new ParticulesCharges(rndX,rndY));
        }
    }
    // ... getListeMaison(), getObjectifTouches() ...


    public void niveauChargement(){}
    public void niveauEnCours(){}
    public void niveauFinit(){}
}

    public ArrayList<Maison> getListeMaison() {return listeMaison;}

    public ArrayList<ParticulesCharges> getListeParticules() {return listeParticules;}

    public double getFinNiveauX() {return finNiveauX;}
}
