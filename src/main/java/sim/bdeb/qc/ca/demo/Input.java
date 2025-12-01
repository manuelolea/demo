package sim.bdeb.qc.ca.demo;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Input {
    public static boolean gauche = false;
    public static boolean droite = false;
    public static boolean saut = false;
    public static boolean lancerHaut = false;
    public static boolean lancerDroit = false;
    public static boolean force = false;

    public static void initialiser(Scene scene) {
        // gestion des touches pressed
        scene.setOnKeyPressed(e -> {
            KeyCode code = e.getCode();
            switch (code){
                case LEFT -> gauche = true; // rester vitesse statique du camelot
                case RIGHT -> droite =true; // acceleration du camelot
                case SPACE,UP -> saut = true; // saut du camelot
                case Z -> lancerHaut = true;// lancer journeau vers le haut
                case X -> lancerDroit = true; // lancer journeau vers l'avant

                case SHIFT -> force = true; // mode force
            }
        });

        // gestion des touches relachées
        scene.setOnKeyReleased(e -> {
            KeyCode code = e.getCode();
            switch (code){
                case LEFT -> gauche = false;
                case RIGHT -> droite = false;
                case SPACE,UP -> saut = false;

                case Z -> lancerHaut = false;
                case X -> lancerDroit = false;

                case SHIFT -> force = false;
            }
        });

     }
}
