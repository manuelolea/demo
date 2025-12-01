package sim.bdeb.qc.ca.demo;

import java.util.ArrayList;

public class Niveau {
    private final int nombreParticules;
    private final int objectifTouches;
    private final int nombreMaisons = 12;

    private ArrayList <ParticulesCharges> listeParticules;
    private ArrayList <Maison> listeMaison;

    private double finNiveauX;
// modification manu
    public Niveau(int numNiveau, double largueurEcran, double hauteurEcran) {

        // 1. CALCUL DU NOMBRE DE PARTICULES
        if (numNiveau >= 2) {
            // Règle : min((niveau - 1) * 30, 400)
            int nbrParticules = (numNiveau - 1) * 30;
            this.nombreParticules = Math.min(nbrParticules, 400);
        } else {
            this.nombreParticules = 0; // Niveau 1 sans particules
        }

        // 2. DÉFINITION DE L'OBJECTIF
        // L'objectif augmente avec la difficulté (Exemple: 8 pour le niveau 1, puis augmente)
        if (numNiveau == 1) {
            this.objectifTouches = 8;
        } else if (numNiveau <= 3) {
            this.objectifTouches = 10;
        } else {
            this.objectifTouches = 12;
        }

        this.listeParticules = new ArrayList<>();
        this.listeMaison = new ArrayList<>();
    }
    //modification manu

    public void niveauChargement(boolean niveauCharge){}

    public void niveauFinit(boolean niveauFinit){}

}
