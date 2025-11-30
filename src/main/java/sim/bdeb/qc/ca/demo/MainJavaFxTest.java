package sim.bdeb.qc.ca.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainJavaFxTest extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        double largueurScene = 900.00;
        double hauteurScene = 580.00;

        HBox root = new HBox(largueurScene);
        Scene scene = new Scene(root, largueurScene, hauteurScene);
        Canvas canvas = new Canvas(largueurScene,hauteurScene);
        root.getChildren().add(canvas);
        var context = canvas.getGraphicsContext2D();

        stage.setTitle("Camelot à vélo");
        stage.setScene(scene);
        stage.show();
    }
}
