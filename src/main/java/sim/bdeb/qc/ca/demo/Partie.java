package sim.bdeb.qc.ca.demo;

import javafx.geometry.Point2D;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class Partie {
    private Camelot camelot;
    private Decors decors;
    private CameraJeu camera;
    private BarreJeu barreJeu;

    private double hauteurEcran;
    private double largueurEcran;

    private int numeroNiveau = 1;
    private double finNiveauX;
    private boolean enChargement = true;
    private double tempsChargement = 3;
    private boolean finDePartie = false;
    private double tempsFinPartie = 3;

    private ArrayList<Maison> listeMaison;
    private ArrayList<ParticulesCharges> listeParticule;
    private ArrayList<Journaux> listeJournaux;

    private double masse;
    private double tempsRecharge;
    private int argent = 0;
    private int nbJournaux = 0;
    private String chaineAdresse = "";
    private boolean debogageEnCours = false;

    private boolean D = false;
    private boolean Q = false;
    private boolean K = false;
    private boolean L = false;
    private boolean F = false;
    private boolean I = false;
    private boolean afficherChamp = false;
    private boolean afficherDebug = false;

    public Partie(double largueur, double hauteur) {
        this.largueurEcran = largueur;
        this.hauteurEcran = hauteur;

        this.camera = new CameraJeu( 0, largueur, hauteur);
        this.decors = new Decors();
        this.camelot = new Camelot(180, 436);
        this.barreJeu = new BarreJeu(largueur);

        this.listeJournaux = new ArrayList<>();
        this.listeMaison = new ArrayList<>();
        this.listeParticule = new ArrayList<>();

        initialiserNiveau(1);
    }

    public void initialiserNiveau(int num) {
        this.numeroNiveau = num;
        this.enChargement = true;
        this.tempsChargement = 3;

        this.finDePartie = false;
        this.tempsFinPartie = 3;

        this.camelot.setPosition(180, 436);
        this.camelot.setVitesse(0, 0);
        this.camera.setX(0);

        this.nbJournaux += 12;
        this.masse = 1 + Math.random();

        listeMaison.clear();
        listeParticule.clear();

        genererMaison();
        genererParticules();
    }

    private void genererMaison() {
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

    private void genererParticules() {
        int nombreParticules = 0;

        if (numeroNiveau >= 2) {
            int calcul = (numeroNiveau - 1) * 30;
            nombreParticules = Math.min(calcul, 400);
        }

        if (nombreParticules <= 0) return;

        double largueurTotalNiv = this.finNiveauX;

        for (int i = 0; i < nombreParticules; i++) {
            double rndX = Math.random() * largueurTotalNiv;
            double rndY = Math.random() * hauteurEcran;
            listeParticule.add(new ParticulesCharges(rndX, rndY));
        }
    }

    public void update(double dt) {
            if (enChargement) {
                tempsChargement -= dt;
                if (tempsChargement <= 0) {
                    enChargement = false;
                }
                return;
            }

            if (finDePartie) {
                tempsFinPartie -= dt;
                if (tempsFinPartie <= 0) {
                    this.nbJournaux = 0;
                    this.argent = 0;
                    this.listeJournaux.clear();
                    initialiserNiveau(1);
                }
                return;
            }
            if(Input.debogage){
                if(debogageEnCours){
                    this.debogageEnCours = false;
                }else {
                    this.debogageEnCours = true;
                }
            }
            gestionJournaux();

            if (Input.debogage && !D) {
            afficherDebug = !afficherDebug;  // toggle
            D = true;
            }
            if (!Input.debogage) {
            D = false;
            }


            if (Input.ajoutJournaux && !Q) {
            nbJournaux += 10;
            Q = true;
            }
            if (!Input.ajoutJournaux) {
            Q = false;
            }

            if (Input.retraitJournaux && !K) {
            nbJournaux = 0;
            listeJournaux.clear();
            K = true;
            }
            if (!Input.retraitJournaux) {
            K = false;
            }
            if (Input.prochainNiveau && !L) {
            L = true;

            initialiserNiveau(numeroNiveau + 1);
            return; // on ne fait rien d'autre ce frame
            }
            if (!Input.prochainNiveau) {
            L = false;
            }

            if (Input.flechesChampElectrique && !F) {
            afficherChamp = !afficherChamp;  // toggle
            F = true;
            }
            if (!Input.flechesChampElectrique) {
            F = false;
            }

            if (Input.particuleTest && !I) {
            I = true;

            listeParticule.clear();

            double yHaut = 10;
            double yBas = hauteurEcran - 10;

            double cameraX = camera.getPositionX();
            double debutX = cameraX;
            double finX = cameraX + largueurEcran;


            for (double x = debutX; x <= finX; x += 50) {
                listeParticule.add(new ParticulesCharges(x, yHaut));
                listeParticule.add(new ParticulesCharges(x, yBas));
                }
            }
            if (!Input.particuleTest) {
            I = false;
            }

            camelot.update(dt);
            decors.update(dt);
            camera.update(camelot);


            if (camelot.getPosition().getX() > this.finNiveauX) {
                initialiserNiveau(numeroNiveau + 1);
                return;
            }

            gererLancerJournaux(dt);

            for (int i = listeJournaux.size() - 1; i >= 0; i--) {
                Journaux j = listeJournaux.get(i);

                if (numeroNiveau >= 2) {
                    Point2D centreJournal = new Point2D(
                            j.getX() + j.getLargueurJournal() / 2,
                            j.getY() + j.getHauteurJournal() / 2
                    );

                    Point2D forceElec = calculerChampsElectrique(centreJournal);
                    Point2D acceleration = forceElec.multiply(1.0 / j.getMasse());
                    j.ajouterAcceleration(acceleration);
                }

                j.update(dt);

                if (gererCollision(j) || j.estSorti(camera)) {
                    listeJournaux.remove(i);
                }
            }

            if (nbJournaux <= 0 && listeJournaux.isEmpty()) {
                finDePartie = true;
            }
        }

    private Point2D calculerChampsElectrique(Point2D posJournal) {
        double k = 90;
        double qJournal = 900;
        double forceTotalX = 0;
        double forceTotalY = 0;

        for (ParticulesCharges p : listeParticule) {
            Point2D posParticule = p.getPosition();
            double qParticule = p.getCharge();

            double dx = posJournal.getX() - posParticule.getX();
            double dy = posJournal.getY() - posParticule.getY();

            double distanceCarre = dx * dx + dy * dy;
            double distance = Math.sqrt(distanceCarre);

            if (distance < 1) distance = 1;
            if (distanceCarre < 1) distanceCarre = 1;

            double E = (k * Math.abs(qParticule)) / distanceCarre;

            double dirX = dx / distance;
            double dirY = dy / distance;

            double Ex = E * dirX;
            double Ey = E * dirY;

            forceTotalX += Ex * qJournal;
            forceTotalY += Ey * qJournal;
        }
        return new Point2D(forceTotalX, forceTotalY);
    }

    public boolean gererCollision(Journaux j) {
        for (Maison m : listeMaison) {
            boolean estAbonne = m.estAbonne();

            BoitesAuxLettres b = m.getBoitesAuxLettres();
            if (b != null) {
                if (intercepte(j, b.getX(), b.getY(), b.getLargueurImg(), b.getHauteurImg())) {
                    int gain = b.touche(estAbonne);
                    this.argent += gain;
                    return true;
                }
            }

            for (Fenetres f : m.getFenetres()) {
                if (intercepte(j, f.getX(), f.getY(), f.getLargeurImg(), f.getHauteurImg())) {
                    int gain = f.touche(estAbonne);
                    this.argent += gain;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean intercepte(Journaux j, double x, double y, double largueur, double hauteur) {
        return j.getX() < x + largueur &&
                j.getX() + j.getLargueurJournal() > x &&
                j.getY() < y + hauteur &&
                j.getY() + j.getHauteurJournal() > y;
    }

    public void draw(GraphicsContext context) {
        context.setFill(Color.BLACK);
        context.fillRect(0, 0, largueurEcran, hauteurEcran);

        if (enChargement) {
            context.setFill(Color.GREEN);
            context.setFont(new Font("Arial", 50));
            context.setTextAlign(TextAlignment.CENTER);
            context.setTextBaseline(VPos.CENTER);
            context.fillText("Niveau " + numeroNiveau, largueurEcran / 2, hauteurEcran / 2);
            return;
        }

        if (finDePartie) {
            context.setTextAlign(TextAlignment.CENTER);
            context.setTextBaseline(VPos.CENTER);
            context.setFont(new Font("Arial", 40));

            context.setFill(Color.RED);
            context.fillText("Rupture de stocks", largueurEcran / 2, hauteurEcran / 2 - 40);

            context.setFill(Color.GREEN);
            context.fillText("Argent collecté : " + argent + "$", largueurEcran / 2, hauteurEcran / 2 + 40);
            return;
        }

        decors.draw(context, camera);

        for (Maison m : listeMaison) {
            m.draw(context, camera);
        }

        for (ParticulesCharges p : listeParticule) {
            p.draw(context, camera);
        }

        if (afficherChamp && numeroNiveau >= 2){
            dessinerChampElectrique(context);
        }

        for (Journaux j : listeJournaux) {
            j.draw(context, camera);
        }

        camelot.draw(context, camera);
        barreJeu.draw(context, nbJournaux, argent, chaineAdresse);

        if (afficherDebug){
            dessinerDebug(context);
        }
    }

    private void dessinerDebug(GraphicsContext context) {
        context.setStroke(Color.YELLOW);
        context.setLineWidth(2);


        for (Maison m : listeMaison) {
            BoitesAuxLettres b = m.getBoitesAuxLettres();
            if (b != null) {
                double xEcran = b.getX() - camera.getPositionX();
                double yEcran = b.getY();
                context.strokeRect(xEcran, yEcran, b.getLargueurImg(), b.getHauteurImg());
            }

            for (Fenetres f : m.getFenetres()) {
                double xEcran = f.getX() - camera.getPositionX();
                double yEcran = f.getY();
                context.strokeRect(xEcran, yEcran, f.getLargeurImg(), f.getHauteurImg());
            }
        }

        for (Journaux j : listeJournaux) {
            double xEcran = j.getX() - camera.getPositionX();
            double yEcran = j.getY();
            context.strokeRect(xEcran, yEcran, j.getLargueurJournal(), j.getHauteurJournal());
        }

        double xLigne = largueurEcran * 0.2;
        context.strokeLine(xLigne, 0, xLigne, hauteurEcran);
    }

    private void dessinerChampElectrique(GraphicsContext context) {
        if (listeParticule.isEmpty()) return;

        double pas = 50;

        for (double xEcran = 0; xEcran < largueurEcran; xEcran += pas) {
            for (double yEcran = 0; yEcran < hauteurEcran; yEcran += pas) {

                double xMonde = xEcran + camera.getPositionX();
                double yMonde = yEcran;

                Point2D positionMonde = new Point2D(xMonde, yMonde);
                Point2D positionEcran = new Point2D(xEcran, yEcran);

                Point2D force = calculerChampsElectrique(positionMonde);
                UtilitairesDessins.dessinerVecteurForce(positionEcran, force, context);
            }
        }
    }
    private void gererLancerJournaux(double dt) {
        if (tempsRecharge > 0) {
            tempsRecharge -= dt;
        }
        if ((Input.lancerHaut || Input.lancerDroit) && tempsRecharge <= 0 && nbJournaux > 0) {
            Journaux journal = new Journaux(camelot, masse, Input.lancerHaut, Input.lancerDroit, Input.force);
            listeJournaux.add(journal);

            nbJournaux--;
            tempsRecharge = 0.5;
        }
    }

