package sim.bdeb.qc.ca.demo;
public class Niveau {
    private final int nombreParticules;
    private ParticulesCharges[] listeParticules;

    public Niveau(int numNiveau) {
        if (numNiveau >= 2) {
            int Nparticules = (numNiveau - 1) * 30;
            this.nombreParticules = Math.min(Nparticules, 400);
        } else {
            this.nombreParticules = 0;
        }
    }


    public void genererElements(double largeurEcran, double hauteurEcran) {
        // ... (génération des Maisons) ...

        this.listeParticules = new ParticulesCharges[nombreParticules];
        for (int i = 0; i < nombreParticules; i++) {
            // Positionnées au hasard dans toute la largeur et la hauteur du niveau
            // Assurez-vous d'avoir la largeur totale du niveau pour le x aléatoire
            double xMaxNiveau = 15600; // Une méthode pour obtenir la fin du parcours
            double randX = Math.random() * xMaxNiveau;
            double randY = Math.random() * hauteurEcran;

            // Il vous faudra une classe ParticuleChargee et un attribut 'charge'
            this.listeParticules[i] = new ParticulesCharges(randX, randY, Math.random() < 0.5 ? 1.0 : -1.0);
        }
    }

    // NOUVEAU: Getters pour que Partie accède aux listes
    public ParticulesCharges[] getListeParticules() {
        return listeParticules;
    }
    // ... getListeMaison(), getObjectifTouches() ...
}