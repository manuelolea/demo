package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Partie {
    private Camelot camelot;
    private Decors decors;
    private CameraJeu camera;

    private double hauteurEcran;
    private double largueurEcran;

    private ArrayList<Journaux> listeJournaux;
    private double masse;
    private double tempsRecharge;

    private ArrayList<Fenetres> listeFenetres;
    private int argent = 0;

    public Partie(double largueur, double hauteur){
        this.largueurEcran = largueur;
        this.hauteurEcran = hauteur;

        this.camera = new CameraJeu(0,0,largueur,hauteur);
        this.decors = new Decors();
        this.camelot = new Camelot(180,436);

        this.masse = 1 + Math.random();
        this.listeJournaux = new ArrayList<>();

        this.listeFenetres = new ArrayList<>();
        genererNiveau();
    }
    public void update(double dt){
        camelot.update(dt);
        decors.update(dt);
        camera.update(camelot);

        gererLancerJournaux(dt);

        for (int i = listeJournaux.size() - 1; i >= 0 ; i--) {
            Journaux j = listeJournaux.get(i);
            j.update(dt);

            boolean journalDetruit = false;

            for (int k = 0; k < listeFenetres.size() ; k++) {
                Fenetres f = listeFenetres.get(k);
                if (j.getX() < f.getX() + f.getLargeur() && j.getX() + j.getLargueurJournal() > f.getX() && j.getY() < f.getY() + f.getHauteur() && j.getY() + j.getHauteurJournal() > f.getY()){
                    boolean maisonAbonnee = Math.random() < 0.5;
                    int gain = f.touche(maisonAbonnee);

                    this.argent += gain;

                    journalDetruit = true;
                }
            }
            
            if (journalDetruit || j.estSorti(camera)){
                listeJournaux.remove(i);
            }
        }
    }
    
    public void draw(GraphicsContext context){
        context.clearRect(0,0,largueurEcran,hauteurEcran);
        
        decors.draw(context,camera);

        for (int i = 0; i < listeFenetres.size(); i++) {
            Fenetres f = listeFenetres.get(i);
            f.draw(context,camera);
        }

        for (int i = 0; i < listeJournaux.size(); i++) {
            Journaux j = listeJournaux.get(i);
            j.draw(context, camera);
        }
        camelot.draw(context,camera);
    }
    private void gererLancerJournaux(double dt){
        if (tempsRecharge > 0){
            tempsRecharge -= dt;
        }
        if ((Input.lancerHaut || Input.lancerDroit) && tempsRecharge <= 0){
            Journaux journal = new Journaux(camelot, masse, Input.lancerHaut, Input.lancerDroit, Input.force);
            listeJournaux.add(journal);
            tempsRecharge = 0.5;
        }

    }
    private void genererNiveau(){
        for (int i = 0; i < 12; i++) {
            double xMaison = i * 1300;
            double yFenetre = 50;

            Fenetres f1 = new Fenetres(xMaison + 300, yFenetre);
            listeFenetres.add(f1);

            if (Math.random() > 0.5){
                Fenetres f2 = new Fenetres(xMaison + 600, yFenetre);
                listeFenetres.add(f2);
            }
        }
    }
}
