package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Fenetres extends ObjetJeux{
    private Image fenetresBlanches;
    private Image fenetresVertes;
    private Image fenetresRouges;
    boolean estTouche;
    private Image imageCourante;

    public Fenetres (){
        this.fenetresBlanches = new Image("fenetre.png");
        this.fenetresVertes = new Image("fenetre-brisee-vert.png");
        this.fenetresRouges = new Image("fenetre-brisee-rouge.png");
        this.imageCourante = fenetresBlanches;
        this.estTouche = false;
    }
    public boolean isEstTouche() {
        return estTouche;
    }

    public void setEstTouche(boolean estTouche) {
        this.estTouche = estTouche;
    }
    @Override
    public void draw(GraphicsContext context, CameraJeu camera) {
        double posXImages = getX() - camera.getPositionX();
        double posYImages = getY() - camera.getPositionY();

        context.drawImage(imageCourante, posXImages, posYImages);
    }



    @Override
    public void update() {

    }

    public void touche(boolean estAbonne){

        if (estTouche ) {
            if(estAbonne) {
                imageCourante = fenetresRouges;
                // perd 2$ avec setter ou boolean
            }else{
                imageCourante = fenetresVertes;
                // gagne 2$ avec setter ou boolean
            }
        } else {
            imageCourante = fenetresBlanches; // revient à la normale
        }
    }
}
