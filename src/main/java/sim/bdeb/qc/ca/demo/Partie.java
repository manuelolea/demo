package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
public class Partie {
    private Camelot camelot;
    private Decors decors;
    private CameraJeu camera;
    private BarreJeu barreJeu;

    private double hauteurEcran;
    private double largueurEcran;

    private ArrayList<Journaux> listeJournaux;
    private double masse;
    private double tempsRecharge;

    private ArrayList<Maison> listeMaison;

    private int argent = 0;
    private int nbJournaux = 24;
    private String chaineAdresse = "";

    public Partie(double largueur, double hauteur){
        this.largueurEcran = largueur;
        this.hauteurEcran = hauteur;

        this.camera = new CameraJeu(0,0,largueur,hauteur);
        this.decors = new Decors();
        this.camelot = new Camelot(180,436);
        this.barreJeu = new BarreJeu(largueur);

        this.masse = 1 + Math.random();
        this.listeJournaux = new ArrayList<>();

        this.listeMaison = new ArrayList<>();

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

            for (Maison m : listeMaison){
                boolean maisonAbonnee = m.estAbonne();

                BoitesAuxLettres b = m.getBoitesAuxLettres();
                if (b != null){
                    if (intercepte(j, b.getX(),b.getY(),b.getLargueurImg(),b.getHauteurImg())){
                        int gain = b.touche(maisonAbonnee);
                        this.argent += gain;
                        journalDetruit = true;
                    }
                }
                if (!journalDetruit){
                    for (Fenetres f : m.getFenetres())
                    if (intercepte(j, f.getX(), f.getY(), f.getLargeurImg(), f.getHauteurImg())){
                        int gain = f.touche(maisonAbonnee);
                        this.argent += gain;
                        journalDetruit = true;
                        break;
                    }
                }
            }
            if (journalDetruit || j.estSorti(camera)){
                listeJournaux.remove(i);
            }
        }
    }

    public boolean intercepte(Journaux j, double x, double y, double largueur, double hauteur){
        return j.getX() < x + largueur && j.getX() + j.getLargueurJournal() > x && j.getY() < y + hauteur && j.getY() + j.getHauteurJournal() > y;
    }

    public void draw(GraphicsContext context){
        context.clearRect(0,0,largueurEcran,hauteurEcran);

        decors.draw(context,camera);

        for (int i = 0; i < listeMaison.size(); i++) {
            Maison m = listeMaison.get(i);
            m.draw(context,camera);
        }

        for (int i = 0; i < listeJournaux.size(); i++) {
            Journaux j = listeJournaux.get(i);
            j.draw(context, camera);
        }
        camelot.draw(context,camera);
        barreJeu.draw(context, nbJournaux, argent, chaineAdresse);
    }
    private void gererLancerJournaux(double dt){
        if (tempsRecharge > 0){
            tempsRecharge -= dt;
        }
        if ((Input.lancerHaut || Input.lancerDroit) && tempsRecharge <= 0){
            Journaux journal = new Journaux(camelot, masse, Input.lancerHaut, Input.lancerDroit, Input.force);
            listeJournaux.add(journal);

            nbJournaux--;
            tempsRecharge = 0.5;
        }

    }
    private void genererNiveau(){
        int adresse = 100 + (int)(Math.random() * 850);
        StringBuilder listetemporaire = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            double maisonX = (i + 1) * 1300;
            boolean estAbonne = Math.random() < 0.5;

            Maison m = new Maison(maisonX, adresse, estAbonne);
            listeMaison.add(m);

            if (estAbonne){
                listetemporaire.append(adresse).append("  ");
            }

            adresse += 2;
        }
        this.chaineAdresse = listetemporaire.toString();
    }
}
