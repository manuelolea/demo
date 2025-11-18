package sim.bdeb.qc.ca.demo;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;


public class Input {
    private static Set<KeyCode> touches = new HashSet<>();

    public static void initialiser(Scene scene) {

        scene.setOnKeyPressed(event -> {
            setKeyPressed(event.getCode(), true);
        });

        scene.setOnKeyReleased(event -> {
            setKeyPressed(event.getCode(), false);
        });
    }

    public static boolean isKeyPressed(KeyCode code){
     return touches.contains(code);
    }
     public static void setKeyPressed(KeyCode code, boolean appuie){
         if (appuie) {
             touches.add(code);
         } else {
             touches.remove(code);
         }
     }
}
