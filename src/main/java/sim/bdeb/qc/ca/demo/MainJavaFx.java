package sim.bdeb.qc.ca.demo;

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
        Canvas canvas = new Canvas();
        var context = canvas.getGraphicsContext2D();
       // Camera
     //   Decors decorsMain = new Decors(largueurScene,hauteurScene,camera)


        Image iconFenetre = new Image("journal.png");
        stage.getIcons().add(iconFenetre);
        stage.setTitle("Camelot à vélo");
        stage.setScene(scene);
        stage.show();
    }
}
