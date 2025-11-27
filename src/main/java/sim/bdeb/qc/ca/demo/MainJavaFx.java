package sim.bdeb.qc.ca.demo;

import javafx.animation.AnimationTimer;
import sim.bdeb.qc.ca.demo.Decors;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MainJavaFx extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        double largueurScene = 900.00;
        double hauteurScene = 580.00;

        HBox root = new HBox(largueurScene);
        Scene scene = new Scene(root, largueurScene, hauteurScene);
        Canvas canvas = new Canvas(largueurScene,hauteurScene);
        root.getChildren().add(canvas);
        var context = canvas.getGraphicsContext2D();

        //Test classe input
        Input.initialiser(scene);

        Partie partie = new Partie(largueurScene, hauteurScene);

        AnimationTimer animationJeux = new AnimationTimer() {
            private long dernierTemps = 0;
            @Override
            public void handle(long now) {
                if (dernierTemps == 0){
                    dernierTemps = now;
                    return;
                }
                double dt = (now - dernierTemps) * 1e-9;
                dernierTemps = now;

                partie.update(dt);
                partie.draw(context);
            }
        };

        animationJeux.start();
        try {
            Image iconFenetre = new Image("journal.png");
            stage.getIcons().add(iconFenetre);
        }catch (Exception e){
            System.out.println("Image d'icône introuvable");
        }

        stage.setTitle("Camelot à vélo");
        stage.setScene(scene);
        stage.show();
    }
}
