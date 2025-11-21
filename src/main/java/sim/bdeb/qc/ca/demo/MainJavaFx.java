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

         //creation camera jex et decors a mettre plus tard dans la classe partie
        CameraJeu camera1 = new CameraJeu(0,0,largueurScene,hauteurScene);
        Decors decors1 = new Decors();

        decors1.draw(context,camera1);
        AnimationTimer animationJeux = new AnimationTimer() {
            @Override
            public void handle(long now) {
                decors1.update();
            }
        };

        Image iconFenetre = new Image("journal.png");
        stage.getIcons().add(iconFenetre);
        stage.setTitle("Camelot à vélo");
        stage.setScene(scene);
        stage.show();
    }
}
