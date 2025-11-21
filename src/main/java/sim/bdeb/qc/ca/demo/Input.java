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

        scene.setOnKeyPressed(e -> {
            KeyCode code = e.getCode();
            switch (code){
                case LEFT -> gauche = true;
                case RIGHT -> droite =true;
                case SPACE,UP -> saut = true;

                case Z -> lancerHaut = true;
                case X -> lancerDroit = true;

                case SHIFT -> force = true;
            }
        });

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
